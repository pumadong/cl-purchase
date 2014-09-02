package com.cl.purchase.biz;

import java.util.List;

import com.cl.privilege.model.User;
import com.cl.purchase.model.purchase.DeliverForm;
import com.cl.purchase.model.purchase.DeliverFormSearchModel;

/**
 * 发货单表相关操作
 */
public interface IDeliverFormService {
	/**
	 * 根据no获取DeliverForm对象
	 * @param no
	 * @return
	 */
	DeliverForm getDeliverFormByNo(String no);
	
	/**
	 * 新增记录
	 * @param deliverForm
	 * @param user
	 * @return
	 */
	Integer createDeliverForm(DeliverForm deliverForm,User user);

	/**
	 * 根据id修改一条记录
	 * @param deliverForm
	 * @return
	 */
	Integer updateDeliverFormById(DeliverForm deliverForm,User user);
	
	/**
	 * 根据条件查询发货单列表总数
	 * @return
	 */
	Integer getDeliverFormTotalBySearch(DeliverFormSearchModel searchModel);
	
	/**
	 * 根据条件查询发货单列表
	 * @return
	 */
	List<DeliverForm> getDeliverFormListBySearch(DeliverFormSearchModel searchModel);
	
	
	/**
	 * 所有发货单列表
	 * @return
	 */
	List<DeliverForm> getDeliverFormList();
	
	/**
	 * 根据查询条件，返回DataTables控件需要的Json数据格式
	 * @param searchModel
	 * @return
	 */
	String getDeliverFormDataTables(DeliverFormSearchModel searchModel);
	
	/**
	 * 返回DataTables控件需要的一行Json数据格式
	 * @param no
	 * @return
	 */
	String getDeliverFormDataRow(String no);
	
}
