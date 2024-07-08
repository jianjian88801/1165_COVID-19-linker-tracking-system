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
 * 医护人员
 *
 * @author 
 * @email
 */
@TableName("yihu")
public class YihuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YihuEntity() {

	}

	public YihuEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 医护人员姓名
     */
    @TableField(value = "yihu_name")

    private String yihuName;


    /**
     * 医护人员手机号
     */
    @TableField(value = "yihu_phone")

    private String yihuPhone;


    /**
     * 医护人员身份证号
     */
    @TableField(value = "yihu_id_number")

    private String yihuIdNumber;


    /**
     * 医护人员头像
     */
    @TableField(value = "yihu_photo")

    private String yihuPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：医护人员姓名
	 */
    public String getYihuName() {
        return yihuName;
    }


    /**
	 * 获取：医护人员姓名
	 */

    public void setYihuName(String yihuName) {
        this.yihuName = yihuName;
    }
    /**
	 * 设置：医护人员手机号
	 */
    public String getYihuPhone() {
        return yihuPhone;
    }


    /**
	 * 获取：医护人员手机号
	 */

    public void setYihuPhone(String yihuPhone) {
        this.yihuPhone = yihuPhone;
    }
    /**
	 * 设置：医护人员身份证号
	 */
    public String getYihuIdNumber() {
        return yihuIdNumber;
    }


    /**
	 * 获取：医护人员身份证号
	 */

    public void setYihuIdNumber(String yihuIdNumber) {
        this.yihuIdNumber = yihuIdNumber;
    }
    /**
	 * 设置：医护人员头像
	 */
    public String getYihuPhoto() {
        return yihuPhoto;
    }


    /**
	 * 获取：医护人员头像
	 */

    public void setYihuPhoto(String yihuPhoto) {
        this.yihuPhoto = yihuPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
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
        return "Yihu{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", yihuName=" + yihuName +
            ", yihuPhone=" + yihuPhone +
            ", yihuIdNumber=" + yihuIdNumber +
            ", yihuPhoto=" + yihuPhoto +
            ", sexTypes=" + sexTypes +
            ", createTime=" + createTime +
        "}";
    }
}
