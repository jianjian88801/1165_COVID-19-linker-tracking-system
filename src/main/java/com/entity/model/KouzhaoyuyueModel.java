package com.entity.model;

import com.entity.KouzhaoyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 口罩预订
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KouzhaoyuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预订人
     */
    private Integer yonghuId;


    /**
     * 口罩
     */
    private Integer kouzhaoId;


    /**
     * 预定数量
     */
    private Integer yuedingNumber;


    /**
     * 状态
     */
    private Integer kouzhaoyuyueTypes;


    /**
     * 预订时间
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
	 * 获取：预订人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：预订人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：口罩
	 */
    public Integer getKouzhaoId() {
        return kouzhaoId;
    }


    /**
	 * 设置：口罩
	 */
    public void setKouzhaoId(Integer kouzhaoId) {
        this.kouzhaoId = kouzhaoId;
    }
    /**
	 * 获取：预定数量
	 */
    public Integer getYuedingNumber() {
        return yuedingNumber;
    }


    /**
	 * 设置：预定数量
	 */
    public void setYuedingNumber(Integer yuedingNumber) {
        this.yuedingNumber = yuedingNumber;
    }
    /**
	 * 获取：状态
	 */
    public Integer getKouzhaoyuyueTypes() {
        return kouzhaoyuyueTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setKouzhaoyuyueTypes(Integer kouzhaoyuyueTypes) {
        this.kouzhaoyuyueTypes = kouzhaoyuyueTypes;
    }
    /**
	 * 获取：预订时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：预订时间
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
