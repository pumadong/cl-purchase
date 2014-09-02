package com.cl.purchase.mapper.backtrack;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.cl.purchase.model.backtrack.BacktrackForm;
import com.cl.purchase.model.backtrack.BacktrackFormSearchModel;

public interface BacktrackFormMapper {
    int deleteByPrimaryKey(String no);

    int insert(BacktrackForm record);

    int insertSelective(BacktrackForm record);

    BacktrackForm selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(BacktrackForm record);

    int updateByPrimaryKey(BacktrackForm record);
    
    // 以上是为了节约开发时间，使用MyBatisGenerator生成的代码
    // 以下是针对不足功能，添加的代码
    
	/**
	 * 根据条件查询返厂单列表总数
	 * @param searchModel
	 * @return
	 */
	Integer getBacktrackFormTotalBySearch(BacktrackFormSearchModel searchModel);
	
	/**
	 * 根据条件查询返厂单List
	 * @param searchModel
	 * @return
	 */
	List<BacktrackForm> getBacktrackFormListBySearch(BacktrackFormSearchModel 返厂单,RowBounds rowBounds);

	
	/**
	 * 所有供应商列表
	 * @return
	 */
	List<BacktrackForm> getBacktrackFormList();    
}