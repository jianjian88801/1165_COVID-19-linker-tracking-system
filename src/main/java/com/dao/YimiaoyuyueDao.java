package com.dao;

import com.entity.YimiaoyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YimiaoyuyueView;

/**
 * 疫苗预约 Dao 接口
 *
 * @author 
 */
public interface YimiaoyuyueDao extends BaseMapper<YimiaoyuyueEntity> {

   List<YimiaoyuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
