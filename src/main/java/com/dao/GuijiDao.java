package com.dao;

import com.entity.GuijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuijiView;

/**
 * 用户轨迹 Dao 接口
 *
 * @author 
 */
public interface GuijiDao extends BaseMapper<GuijiEntity> {

   List<GuijiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
