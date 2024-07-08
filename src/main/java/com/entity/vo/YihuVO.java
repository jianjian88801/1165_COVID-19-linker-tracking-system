package com.entity.vo;

import com.entity.YihuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医护人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yihu")
public class YihuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
