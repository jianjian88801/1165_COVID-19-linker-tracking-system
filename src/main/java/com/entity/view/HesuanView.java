package com.entity.view;

import com.entity.HesuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 核算检测
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("hesuan")
public class HesuanView extends HesuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 检测结果的值
		*/
		private String jianceValue;



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

	public HesuanView() {

	}

	public HesuanView(HesuanEntity hesuanEntity) {
		try {
			BeanUtils.copyProperties(this, hesuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 检测结果的值
			*/
			public String getJianceValue() {
				return jianceValue;
			}
			/**
			* 设置： 检测结果的值
			*/
			public void setJianceValue(String jianceValue) {
				this.jianceValue = jianceValue;
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
