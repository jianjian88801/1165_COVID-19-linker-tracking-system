












package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 疫苗预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yimiaoyuyue")
public class YimiaoyuyueController {
    private static final Logger logger = LoggerFactory.getLogger(YimiaoyuyueController.class);

    @Autowired
    private YimiaoyuyueService yimiaoyuyueService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YimiaoService yimiaoService;
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private YihuService yihuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("医护人员".equals(role))
            params.put("yihuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yimiaoyuyueService.queryPage(params);

        //字典表数据转换
        List<YimiaoyuyueView> list =(List<YimiaoyuyueView>)page.getList();
        for(YimiaoyuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YimiaoyuyueEntity yimiaoyuyue = yimiaoyuyueService.selectById(id);
        if(yimiaoyuyue !=null){
            //entity转view
            YimiaoyuyueView view = new YimiaoyuyueView();
            BeanUtils.copyProperties( yimiaoyuyue , view );//把实体数据重构到view中

                //级联表
                YimiaoEntity yimiao = yimiaoService.selectById(yimiaoyuyue.getYimiaoId());
                if(yimiao != null){
                    BeanUtils.copyProperties( yimiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYimiaoId(yimiao.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(yimiaoyuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YimiaoyuyueEntity yimiaoyuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yimiaoyuyue:{}",this.getClass().getName(),yimiaoyuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            yimiaoyuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YimiaoyuyueEntity> queryWrapper = new EntityWrapper<YimiaoyuyueEntity>()
            .eq("yonghu_id", yimiaoyuyue.getYonghuId())
            .eq("yimiao_id", yimiaoyuyue.getYimiaoId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YimiaoyuyueEntity yimiaoyuyueEntity = yimiaoyuyueService.selectOne(queryWrapper);
        if(yimiaoyuyueEntity==null){

            YimiaoEntity yimiaoEntity = yimiaoService.selectById(yimiaoyuyue.getYimiaoId());

            if(yimiaoEntity == null){
                return R.error(511,"查不到疫苗");
            }else if((yimiaoEntity.getYimiaoNumber() -1 )<0){
                return R.error(511,"疫苗已经不够预约");
            }
            yimiaoEntity.setYimiaoNumber(yimiaoEntity.getYimiaoNumber()-1);
            yimiaoService.updateById(yimiaoEntity);


            yimiaoyuyue.setInsertTime(new Date());
            yimiaoyuyue.setCreateTime(new Date());
            yimiaoyuyue.setYimiaoyuyueTypes(1);
            yimiaoyuyueService.insert(yimiaoyuyue);
            return R.ok();
        }else {
            return R.error(511,"该用户已经预约过该疫苗");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YimiaoyuyueEntity yimiaoyuyue, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yimiaoyuyue:{}",this.getClass().getName(),yimiaoyuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("用户".equals(role))
//            yimiaoyuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YimiaoyuyueEntity> queryWrapper = new EntityWrapper<YimiaoyuyueEntity>()
            .notIn("id",yimiaoyuyue.getId())
            .andNew()
            .eq("yonghu_id", yimiaoyuyue.getYonghuId())
            .eq("yimiao_id", yimiaoyuyue.getYimiaoId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YimiaoyuyueEntity yimiaoyuyueEntity = yimiaoyuyueService.selectOne(queryWrapper);
        if(yimiaoyuyueEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yimiaoyuyue.set
            //  }
            yimiaoyuyueService.updateById(yimiaoyuyue);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该用户已经预约过该疫苗");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yimiaoyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<YimiaoyuyueEntity> yimiaoyuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YimiaoyuyueEntity yimiaoyuyueEntity = new YimiaoyuyueEntity();
//                            yimiaoyuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //预约人 要改的
//                            yimiaoyuyueEntity.setYimiaoId(Integer.valueOf(data.get(0)));   //疫苗 要改的
//                            yimiaoyuyueEntity.setYimiaoyuyueTypes(Integer.valueOf(data.get(0)));   //状态 要改的
//                            yimiaoyuyueEntity.setInsertTime(date);//时间
//                            yimiaoyuyueEntity.setCreateTime(date);//时间
                            yimiaoyuyueList.add(yimiaoyuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yimiaoyuyueService.insertBatch(yimiaoyuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
