package com.entity.vo;

import com.entity.KouzhaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 口罩
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kouzhao")
public class KouzhaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 口罩名称
     */

    @TableField(value = "kouzhao_name")
    private String kouzhaoName;


    /**
     * 口罩类型
     */

    @TableField(value = "kouzhao_types")
    private Integer kouzhaoTypes;


    /**
     * 口罩数量
     */

    @TableField(value = "kouzhao_number")
    private Integer kouzhaoNumber;


    /**
     * 备注
     */

    @TableField(value = "kouzhao_content")
    private String kouzhaoContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：口罩名称
	 */
    public String getKouzhaoName() {
        return kouzhaoName;
    }


    /**
	 * 获取：口罩名称
	 */

    public void setKouzhaoName(String kouzhaoName) {
        this.kouzhaoName = kouzhaoName;
    }
    /**
	 * 设置：口罩类型
	 */
    public Integer getKouzhaoTypes() {
        return kouzhaoTypes;
    }


    /**
	 * 获取：口罩类型
	 */

    public void setKouzhaoTypes(Integer kouzhaoTypes) {
        this.kouzhaoTypes = kouzhaoTypes;
    }
    /**
	 * 设置：口罩数量
	 */
    public Integer getKouzhaoNumber() {
        return kouzhaoNumber;
    }


    /**
	 * 获取：口罩数量
	 */

    public void setKouzhaoNumber(Integer kouzhaoNumber) {
        this.kouzhaoNumber = kouzhaoNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getKouzhaoContent() {
        return kouzhaoContent;
    }


    /**
	 * 获取：备注
	 */

    public void setKouzhaoContent(String kouzhaoContent) {
        this.kouzhaoContent = kouzhaoContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
