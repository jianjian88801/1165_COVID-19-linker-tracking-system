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
 * 口罩预订
 *
 * @author 
 * @email
 */
@TableName("kouzhaoyuyue")
public class KouzhaoyuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KouzhaoyuyueEntity() {

	}

	public KouzhaoyuyueEntity(T t) {
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
     * 预订人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 口罩
     */
    @TableField(value = "kouzhao_id")

    private Integer kouzhaoId;


    /**
     * 预定数量
     */
    @TableField(value = "yueding_number")

    private Integer yuedingNumber;


    /**
     * 状态
     */
    @TableField(value = "kouzhaoyuyue_types")

    private Integer kouzhaoyuyueTypes;


    /**
     * 预订时间
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
	 * 设置：预订人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：预订人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：口罩
	 */
    public Integer getKouzhaoId() {
        return kouzhaoId;
    }


    /**
	 * 获取：口罩
	 */

    public void setKouzhaoId(Integer kouzhaoId) {
        this.kouzhaoId = kouzhaoId;
    }
    /**
	 * 设置：预定数量
	 */
    public Integer getYuedingNumber() {
        return yuedingNumber;
    }


    /**
	 * 获取：预定数量
	 */

    public void setYuedingNumber(Integer yuedingNumber) {
        this.yuedingNumber = yuedingNumber;
    }
    /**
	 * 设置：状态
	 */
    public Integer getKouzhaoyuyueTypes() {
        return kouzhaoyuyueTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setKouzhaoyuyueTypes(Integer kouzhaoyuyueTypes) {
        this.kouzhaoyuyueTypes = kouzhaoyuyueTypes;
    }
    /**
	 * 设置：预订时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：预订时间
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
        return "Kouzhaoyuyue{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", kouzhaoId=" + kouzhaoId +
            ", yuedingNumber=" + yuedingNumber +
            ", kouzhaoyuyueTypes=" + kouzhaoyuyueTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
