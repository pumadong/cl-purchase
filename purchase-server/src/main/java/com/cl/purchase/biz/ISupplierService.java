package com.cl.purchase.biz;

import java.util.List;

import com.cl.privilege.model.User;
import com.cl.purchase.model.base.Supplier;
import com.cl.purchase.model.base.SupplierSearchModel;

/**
 * 供应商表相关操作
 */
public interface ISupplierService {
	/**
	 * 根据id获取Supplier对象
	 * @param id
	 * @return
	 */
	Supplier getSupplierById(Integer id);
	
	/**
	 * 新增记录
	 * @param supplier
	 * @param user
	 * @return
	 */
	Integer createSupplier(Supplier supplier,User user);

	/**
	 * 根据id修改一条记录
	 * @param supplier
	 * @return
	 */
	Integer updateSupplierById(Supplier supplier,User user);
	
	/**
	 * 根据条件查询供应商列表总数
	 * @return
	 */
	Integer getSupplierTotalBySearch(SupplierSearchModel searchModel);
	
	/**
	 * 根据条件查询供应商列表
	 * @return
	 */
	List<Supplier> getSupplierListBySearch(SupplierSearchModel searchModel);
	
	
	/**
	 * 所有供应商列表
	 * @return
	 */
	List<Supplier> getSupplierList();
	
	/**
	 * 根据查询条件，返回DataTables控件需要的Json数据格式
	 * @param searchModel
	 * @return
	 */
	String getSupplierDataTables(SupplierSearchModel searchModel);
	
	/**
	 * 返回DataTables控件需要的一行Json数据格式
	 * @param id
	 * @return
	 */
	String getSupplierDataRow(Integer id);
	
}
