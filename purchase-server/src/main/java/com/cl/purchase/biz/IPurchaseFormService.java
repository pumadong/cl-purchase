package com.cl.purchase.biz;

import java.util.List;

import com.cl.privilege.model.User;
import com.cl.purchase.model.purchase.PurchaseForm;
import com.cl.purchase.model.purchase.PurchaseFormSearchModel;

/**
 * 采购单表相关操作
 */
public interface IPurchaseFormService {
	/**
	 * 根据no获取PurchaseForm对象
	 * @param no
	 * @return
	 */
	PurchaseForm getPurchaseFormByNo(String no);
	
	/**
	 * 新增记录
	 * @param purchaseForm
	 * @param user
	 * @return
	 */
	Integer createPurchaseForm(PurchaseForm purchaseForm,User user);

	/**
	 * 根据id修改一条记录
	 * @param purchaseForm
	 * @return
	 */
	Integer updatePurchaseFormById(PurchaseForm purchaseForm,User user);
	
	/**
	 * 根据条件查询采购单列表总数
	 * @return
	 */
	Integer getPurchaseFormTotalBySearch(PurchaseFormSearchModel searchModel);
	
	/**
	 * 根据条件查询采购单列表
	 * @return
	 */
	List<PurchaseForm> getPurchaseFormListBySearch(PurchaseFormSearchModel searchModel);
	
	
	/**
	 * 所有采购单列表
	 * @return
	 */
	List<PurchaseForm> getPurchaseFormList();
	
	/**
	 * 根据查询条件，返回DataTables控件需要的Json数据格式
	 * @param searchModel
	 * @return
	 */
	String getPurchaseFormDataTables(PurchaseFormSearchModel searchModel);
	
	/**
	 * 返回DataTables控件需要的一行Json数据格式
	 * @param no
	 * @return
	 */
	String getPurchaseFormDataRow(String no);
	
}
