package com.dao;

import com.entity.JiankangdanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangdanganView;

/**
 * 档案信息 Dao 接口
 *
 * @author 
 */
public interface JiankangdanganDao extends BaseMapper<JiankangdanganEntity> {

   List<JiankangdanganView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
