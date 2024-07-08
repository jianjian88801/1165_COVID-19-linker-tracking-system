package com.dao;

import com.entity.HesuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HesuanView;

/**
 * 核算检测 Dao 接口
 *
 * @author 
 */
public interface HesuanDao extends BaseMapper<HesuanEntity> {

   List<HesuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
