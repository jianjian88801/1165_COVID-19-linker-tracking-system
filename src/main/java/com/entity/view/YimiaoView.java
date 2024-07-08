package com.entity.view;

import com.entity.YimiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 疫苗
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yimiao")
public class YimiaoView extends YimiaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 疫苗类型的值
		*/
		private String yimiaoValue;



	public YimiaoView() {

	}

	public YimiaoView(YimiaoEntity yimiaoEntity) {
		try {
			BeanUtils.copyProperties(this, yimiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














}
