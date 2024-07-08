package com.dao;

import com.entity.KouzhaoyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KouzhaoyuyueView;

/**
 * 口罩预订 Dao 接口
 *
 * @author 
 */
public interface KouzhaoyuyueDao extends BaseMapper<KouzhaoyuyueEntity> {

   List<KouzhaoyuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
