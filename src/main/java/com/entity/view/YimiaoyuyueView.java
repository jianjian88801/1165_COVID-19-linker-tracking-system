package com.entity.view;

import com.entity.YimiaoyuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 疫苗预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yimiaoyuyue")
public class YimiaoyuyueView extends YimiaoyuyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 状态的值
		*/
		private String yimiaoyuyueValue;



		//级联表 yimiao
			/**
			* 疫苗名称
			*/
			private String yimiaoName;
			/**
			* 疫苗类型
			*/
			private Integer yimiaoTypes;
				/**
				* 疫苗类型的值
				*/
				private String yimiaoValue;
			/**
			* 疫苗数量
			*/
			private Integer yimiaoNumber;
			/**
			* 备注
			*/
			private String yimiaoContent;

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

	public YimiaoyuyueView() {

	}

	public YimiaoyuyueView(YimiaoyuyueEntity yimiaoyuyueEntity) {
		try {
			BeanUtils.copyProperties(this, yimiaoyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 状态的值
			*/
			public String getYimiaoyuyueValue() {
				return yimiaoyuyueValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setYimiaoyuyueValue(String yimiaoyuyueValue) {
				this.yimiaoyuyueValue = yimiaoyuyueValue;
			}





























				//级联表的get和set yimiao
					/**
					* 获取： 疫苗名称
					*/
					public String getYimiaoName() {
						return yimiaoName;
					}
					/**
					* 设置： 疫苗名称
					*/
					public void setYimiaoName(String yimiaoName) {
						this.yimiaoName = yimiaoName;
					}
					/**
					* 获取： 疫苗类型
					*/
					public Integer getYimiaoTypes() {
						return yimiaoTypes;
					}
					/**
					* 设置： 疫苗类型
					*/
					public void setYimiaoTypes(Integer yimiaoTypes) {
						this.yimiaoTypes = yimiaoTypes;
					}


						/**
						* 获取： 疫苗类型的值
						*/
						public String getYimiaoValue() {
							return yimiaoValue;
						}
						/**
						* 设置： 疫苗类型的值
						*/
						public void setYimiaoValue(String yimiaoValue) {
							this.yimiaoValue = yimiaoValue;
						}
					/**
					* 获取： 疫苗数量
					*/
					public Integer getYimiaoNumber() {
						return yimiaoNumber;
					}
					/**
					* 设置： 疫苗数量
					*/
					public void setYimiaoNumber(Integer yimiaoNumber) {
						this.yimiaoNumber = yimiaoNumber;
					}
					/**
					* 获取： 备注
					*/
					public String getYimiaoContent() {
						return yimiaoContent;
					}
					/**
					* 设置： 备注
					*/
					public void setYimiaoContent(String yimiaoContent) {
						this.yimiaoContent = yimiaoContent;
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
