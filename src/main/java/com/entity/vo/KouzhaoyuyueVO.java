package com.entity.vo;

import com.entity.KouzhaoyuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 口罩预订
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kouzhaoyuyue")
public class KouzhaoyuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
