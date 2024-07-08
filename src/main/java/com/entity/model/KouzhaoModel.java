package com.entity.model;

import com.entity.KouzhaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 口罩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KouzhaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 口罩名称
     */
    private String kouzhaoName;


    /**
     * 口罩类型
     */
    private Integer kouzhaoTypes;


    /**
     * 口罩数量
     */
    private Integer kouzhaoNumber;


    /**
     * 备注
     */
    private String kouzhaoContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：口罩名称
	 */
    public String getKouzhaoName() {
        return kouzhaoName;
    }


    /**
	 * 设置：口罩名称
	 */
    public void setKouzhaoName(String kouzhaoName) {
        this.kouzhaoName = kouzhaoName;
    }
    /**
	 * 获取：口罩类型
	 */
    public Integer getKouzhaoTypes() {
        return kouzhaoTypes;
    }


    /**
	 * 设置：口罩类型
	 */
    public void setKouzhaoTypes(Integer kouzhaoTypes) {
        this.kouzhaoTypes = kouzhaoTypes;
    }
    /**
	 * 获取：口罩数量
	 */
    public Integer getKouzhaoNumber() {
        return kouzhaoNumber;
    }


    /**
	 * 设置：口罩数量
	 */
    public void setKouzhaoNumber(Integer kouzhaoNumber) {
        this.kouzhaoNumber = kouzhaoNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getKouzhaoContent() {
        return kouzhaoContent;
    }


    /**
	 * 设置：备注
	 */
    public void setKouzhaoContent(String kouzhaoContent) {
        this.kouzhaoContent = kouzhaoContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
