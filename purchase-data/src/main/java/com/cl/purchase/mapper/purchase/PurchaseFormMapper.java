package com.cl.purchase.mapper.purchase;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.cl.purchase.model.purchase.PurchaseForm;
import com.cl.purchase.model.purchase.PurchaseFormSearchModel;

public interface PurchaseFormMapper {
    int deleteByPrimaryKey(String no);

    int insert(PurchaseForm record);

    int insertSelective(PurchaseForm record);

    PurchaseForm selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(PurchaseForm record);

    int updateByPrimaryKey(PurchaseForm record);
    
    // 以上是为了节约开发时间，使用MyBatisGenerator生成的代码
    // 以下是针对不足功能，添加的代码
    
	/**
	 * 根据条件查询采购单列表总数
	 * @param searchModel
	 * @return
	 */
	Integer getPurchaseFormTotalBySearch(PurchaseFormSearchModel searchModel);
	
	/**
	 * 根据条件查询采购单List
	 * @param searchModel
	 * @return
	 */
	List<PurchaseForm> getPurchaseFormListBySearch(PurchaseFormSearchModel searchModel,RowBounds rowBounds);

	
	/**
	 * 所有采购单列表
	 * @return
	 */
	List<PurchaseForm> getPurchaseFormList();   
}