












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
 * 医护人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yihu")
public class YihuController {
    private static final Logger logger = LoggerFactory.getLogger(YihuController.class);

    @Autowired
    private YihuService yihuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = yihuService.queryPage(params);

        //字典表数据转换
        List<YihuView> list =(List<YihuView>)page.getList();
        for(YihuView c:list){
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
        YihuEntity yihu = yihuService.selectById(id);
        if(yihu !=null){
            //entity转view
            YihuView view = new YihuView();
            BeanUtils.copyProperties( yihu , view );//把实体数据重构到view中

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
    public R save(@RequestBody YihuEntity yihu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yihu:{}",this.getClass().getName(),yihu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<YihuEntity> queryWrapper = new EntityWrapper<YihuEntity>()
            .eq("username", yihu.getUsername())
            .or()
            .eq("yihu_phone", yihu.getYihuPhone())
            .or()
            .eq("yihu_id_number", yihu.getYihuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YihuEntity yihuEntity = yihuService.selectOne(queryWrapper);
        if(yihuEntity==null){
            yihu.setCreateTime(new Date());
            yihu.setPassword("123456");
            yihuService.insert(yihu);
            return R.ok();
        }else {
            return R.error(511,"账户或者医护人员手机号或者医护人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YihuEntity yihu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yihu:{}",this.getClass().getName(),yihu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<YihuEntity> queryWrapper = new EntityWrapper<YihuEntity>()
            .notIn("id",yihu.getId())
            .andNew()
            .eq("username", yihu.getUsername())
            .or()
            .eq("yihu_phone", yihu.getYihuPhone())
            .or()
            .eq("yihu_id_number", yihu.getYihuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YihuEntity yihuEntity = yihuService.selectOne(queryWrapper);
        if("".equals(yihu.getYihuPhoto()) || "null".equals(yihu.getYihuPhoto())){
                yihu.setYihuPhoto(null);
        }
        if(yihuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yihu.set
            //  }
            yihuService.updateById(yihu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者医护人员手机号或者医护人员身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yihuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<YihuEntity> yihuList = new ArrayList<>();//上传的东西
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
                            YihuEntity yihuEntity = new YihuEntity();
//                            yihuEntity.setUsername(data.get(0));                    //账户 要改的
//                            //yihuEntity.setPassword("123456");//密码
//                            yihuEntity.setYihuName(data.get(0));                    //医护人员姓名 要改的
//                            yihuEntity.setYihuPhone(data.get(0));                    //医护人员手机号 要改的
//                            yihuEntity.setYihuIdNumber(data.get(0));                    //医护人员身份证号 要改的
//                            yihuEntity.setYihuPhoto("");//照片
//                            yihuEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            yihuEntity.setCreateTime(date);//时间
                            yihuList.add(yihuEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //医护人员手机号
                                if(seachFields.containsKey("yihuPhone")){
                                    List<String> yihuPhone = seachFields.get("yihuPhone");
                                    yihuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> yihuPhone = new ArrayList<>();
                                    yihuPhone.add(data.get(0));//要改的
                                    seachFields.put("yihuPhone",yihuPhone);
                                }
                                //医护人员身份证号
                                if(seachFields.containsKey("yihuIdNumber")){
                                    List<String> yihuIdNumber = seachFields.get("yihuIdNumber");
                                    yihuIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yihuIdNumber = new ArrayList<>();
                                    yihuIdNumber.add(data.get(0));//要改的
                                    seachFields.put("yihuIdNumber",yihuIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<YihuEntity> yihuEntities_username = yihuService.selectList(new EntityWrapper<YihuEntity>().in("username", seachFields.get("username")));
                        if(yihuEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YihuEntity s:yihuEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //医护人员手机号
                        List<YihuEntity> yihuEntities_yihuPhone = yihuService.selectList(new EntityWrapper<YihuEntity>().in("yihu_phone", seachFields.get("yihuPhone")));
                        if(yihuEntities_yihuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YihuEntity s:yihuEntities_yihuPhone){
                                repeatFields.add(s.getYihuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [医护人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //医护人员身份证号
                        List<YihuEntity> yihuEntities_yihuIdNumber = yihuService.selectList(new EntityWrapper<YihuEntity>().in("yihu_id_number", seachFields.get("yihuIdNumber")));
                        if(yihuEntities_yihuIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YihuEntity s:yihuEntities_yihuIdNumber){
                                repeatFields.add(s.getYihuIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [医护人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yihuService.insertBatch(yihuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YihuEntity yihu = yihuService.selectOne(new EntityWrapper<YihuEntity>().eq("username", username));
        if(yihu==null || !yihu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(yihu.getId(),username, "yihu", "医护人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","医护人员");
        r.put("username",yihu.getYihuName());
        r.put("tableName","yihu");
        r.put("userId",yihu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YihuEntity yihu){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<YihuEntity> queryWrapper = new EntityWrapper<YihuEntity>()
            .eq("username", yihu.getUsername())
            .or()
            .eq("yihu_phone", yihu.getYihuPhone())
            .or()
            .eq("yihu_id_number", yihu.getYihuIdNumber())
            ;
        YihuEntity yihuEntity = yihuService.selectOne(queryWrapper);
        if(yihuEntity != null)
            return R.error("账户或者医护人员手机号或者医护人员身份证号已经被使用");
        yihu.setCreateTime(new Date());
        yihuService.insert(yihu);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        YihuEntity yihu = new YihuEntity();
        yihu.setPassword("123456");
        yihu.setId(id);
        yihuService.updateById(yihu);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YihuEntity yihu = yihuService.selectOne(new EntityWrapper<YihuEntity>().eq("username", username));
        if(yihu!=null){
            yihu.setPassword("123456");
            boolean b = yihuService.updateById(yihu);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYihu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YihuEntity yihu = yihuService.selectById(id);
        if(yihu !=null){
            //entity转view
            YihuView view = new YihuView();
            BeanUtils.copyProperties( yihu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
