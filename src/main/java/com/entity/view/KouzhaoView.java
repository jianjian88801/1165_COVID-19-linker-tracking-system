package com.entity.view;

import com.entity.KouzhaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 口罩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kouzhao")
public class KouzhaoView extends KouzhaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 口罩类型的值
		*/
		private String kouzhaoValue;



	public KouzhaoView() {

	}

	public KouzhaoView(KouzhaoEntity kouzhaoEntity) {
		try {
			BeanUtils.copyProperties(this, kouzhaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 口罩类型的值
			*/
			public String getKouzhaoValue() {
				return kouzhaoValue;
			}
			/**
			* 设置： 口罩类型的值
			*/
			public void setKouzhaoValue(String kouzhaoValue) {
				this.kouzhaoValue = kouzhaoValue;
			}














}
