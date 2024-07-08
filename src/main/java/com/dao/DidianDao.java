package com.dao;

import com.entity.DidianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DidianView;

/**
 * 地点 Dao 接口
 *
 * @author 
 */
public interface DidianDao extends BaseMapper<DidianEntity> {

   List<DidianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
