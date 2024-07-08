package com.entity.view;

import com.entity.GuijiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户轨迹
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("guiji")
public class GuijiView extends GuijiEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 didian
			/**
			* 地点名称
			*/
			private String didianName;
			/**
			* 地点状态
			*/
			private Integer didianTypes;
				/**
				* 地点状态的值
				*/
				private String didianValue;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 健康状态
			*/
			private Integer jiankangTypes;
				/**
				* 健康状态的值
				*/
				private String jiankangValue;

	public GuijiView() {

	}

	public GuijiView(GuijiEntity guijiEntity) {
		try {
			BeanUtils.copyProperties(this, guijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}











				//级联表的get和set didian
					/**
					* 获取： 地点名称
					*/
					public String getDidianName() {
						return didianName;
					}
					/**
					* 设置： 地点名称
					*/
					public void setDidianName(String didianName) {
						this.didianName = didianName;
					}
					/**
					* 获取： 地点状态
					*/
					public Integer getDidianTypes() {
						return didianTypes;
					}
					/**
					* 设置： 地点状态
					*/
					public void setDidianTypes(Integer didianTypes) {
						this.didianTypes = didianTypes;
					}


						/**
						* 获取： 地点状态的值
						*/
						public String getDidianValue() {
							return didianValue;
						}
						/**
						* 设置： 地点状态的值
						*/
						public void setDidianValue(String didianValue) {
							this.didianValue = didianValue;
						}


























				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 健康状态
					*/
					public Integer getJiankangTypes() {
						return jiankangTypes;
					}
					/**
					* 设置： 健康状态
					*/
					public void setJiankangTypes(Integer jiankangTypes) {
						this.jiankangTypes = jiankangTypes;
					}


						/**
						* 获取： 健康状态的值
						*/
						public String getJiankangValue() {
							return jiankangValue;
						}
						/**
						* 设置： 健康状态的值
						*/
						public void setJiankangValue(String jiankangValue) {
							this.jiankangValue = jiankangValue;
						}




}
