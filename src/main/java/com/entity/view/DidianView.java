package com.entity.view;

import com.entity.DidianEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 地点
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("didian")
public class DidianView extends DidianEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 地点状态的值
		*/
		private String didianValue;



	public DidianView() {

	}

	public DidianView(DidianEntity didianEntity) {
		try {
			BeanUtils.copyProperties(this, didianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














}
