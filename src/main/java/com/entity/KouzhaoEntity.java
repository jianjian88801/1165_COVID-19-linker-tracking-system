package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 口罩
 *
 * @author 
 * @email
 */
@TableName("kouzhao")
public class KouzhaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KouzhaoEntity() {

	}

	public KouzhaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Kouzhao{" +
            "id=" + id +
            ", kouzhaoName=" + kouzhaoName +
            ", kouzhaoTypes=" + kouzhaoTypes +
            ", kouzhaoNumber=" + kouzhaoNumber +
            ", kouzhaoContent=" + kouzhaoContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
