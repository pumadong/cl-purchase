package com.cl.purchase.mapper.purchase;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.cl.purchase.model.purchase.DeliverForm;
import com.cl.purchase.model.purchase.DeliverFormSearchModel;

public interface DeliverFormMapper {
    int deleteByPrimaryKey(String no);

    int insert(DeliverForm record);

    int insertSelective(DeliverForm record);

    DeliverForm selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(DeliverForm record);

    int updateByPrimaryKey(DeliverForm record);
    
    // 以上是为了节约开发时间，使用MyBatisGenerator生成的代码
    // 以下是针对不足功能，添加的代码
    
	/**
	 * 根据条件查询发货单列表总数
	 * @param searchModel
	 * @return
	 */
	Integer getDeliverFormTotalBySearch(DeliverFormSearchModel searchModel);
	
	/**
	 * 根据条件查询发货单List
	 * @param searchModel
	 * @return
	 */
	List<DeliverForm> getDeliverFormListBySearch(DeliverFormSearchModel searchModel,RowBounds rowBounds);

	
	/**
	 * 所有发货单列表
	 * @return
	 */
	List<DeliverForm> getDeliverFormList();   
}