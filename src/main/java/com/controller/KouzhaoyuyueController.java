












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
 * 口罩预订
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kouzhaoyuyue")
public class KouzhaoyuyueController {
    private static final Logger logger = LoggerFactory.getLogger(KouzhaoyuyueController.class);

    @Autowired
    private KouzhaoyuyueService kouzhaoyuyueService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private KouzhaoService kouzhaoService;
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
        PageUtils page = kouzhaoyuyueService.queryPage(params);

        //字典表数据转换
        List<KouzhaoyuyueView> list =(List<KouzhaoyuyueView>)page.getList();
        for(KouzhaoyuyueView c:list){
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
        KouzhaoyuyueEntity kouzhaoyuyue = kouzhaoyuyueService.selectById(id);
        if(kouzhaoyuyue !=null){
            //entity转view
            KouzhaoyuyueView view = new KouzhaoyuyueView();
            BeanUtils.copyProperties( kouzhaoyuyue , view );//把实体数据重构到view中

                //级联表
                KouzhaoEntity kouzhao = kouzhaoService.selectById(kouzhaoyuyue.getKouzhaoId());
                if(kouzhao != null){
                    BeanUtils.copyProperties( kouzhao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKouzhaoId(kouzhao.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(kouzhaoyuyue.getYonghuId());
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
    public R save(@RequestBody KouzhaoyuyueEntity kouzhaoyuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kouzhaoyuyue:{}",this.getClass().getName(),kouzhaoyuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            kouzhaoyuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));


        Integer kouzhaoId = kouzhaoyuyue.getKouzhaoId();
        KouzhaoEntity kouzhaoEntity = kouzhaoService.selectById(kouzhaoId);
        if(kouzhaoEntity == null){
            return R.error(511,"查不到口罩");
        }else if((kouzhaoEntity.getKouzhaoNumber() -kouzhaoyuyue.getYuedingNumber() )<0){
            return R.error(511,"预约口罩大于总数量");
        }
        kouzhaoyuyue.setInsertTime(new Date());
        kouzhaoyuyue.setKouzhaoyuyueTypes(1);
        kouzhaoyuyue.setCreateTime(new Date());
        kouzhaoyuyueService.insert(kouzhaoyuyue);

        kouzhaoEntity.setKouzhaoNumber(kouzhaoEntity.getKouzhaoNumber() -kouzhaoyuyue.getYuedingNumber());
        kouzhaoService.updateById(kouzhaoEntity);
        return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KouzhaoyuyueEntity kouzhaoyuyue, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kouzhaoyuyue:{}",this.getClass().getName(),kouzhaoyuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("用户".equals(role))
//            kouzhaoyuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
            kouzhaoyuyueService.updateById(kouzhaoyuyue);//根据id更新
            return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kouzhaoyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<KouzhaoyuyueEntity> kouzhaoyuyueList = new ArrayList<>();//上传的东西
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
                            KouzhaoyuyueEntity kouzhaoyuyueEntity = new KouzhaoyuyueEntity();
//                            kouzhaoyuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //预订人 要改的
//                            kouzhaoyuyueEntity.setKouzhaoId(Integer.valueOf(data.get(0)));   //口罩 要改的
//                            kouzhaoyuyueEntity.setYuedingNumber(Integer.valueOf(data.get(0)));   //预定数量 要改的
//                            kouzhaoyuyueEntity.setKouzhaoyuyueTypes(Integer.valueOf(data.get(0)));   //状态 要改的
//                            kouzhaoyuyueEntity.setInsertTime(date);//时间
//                            kouzhaoyuyueEntity.setCreateTime(date);//时间
                            kouzhaoyuyueList.add(kouzhaoyuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        kouzhaoyuyueService.insertBatch(kouzhaoyuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
