package com.cl.purchase.biz;

import java.util.List;

import com.cl.privilege.model.User;
import com.cl.purchase.model.purchase.Contract;
import com.cl.purchase.model.purchase.ContractSearchModel;

/**
 * 合同表相关操作
 */
public interface IContractService {
	/**
	 * 根据no获取Contract对象
	 * @param no
	 * @return
	 */
	Contract getContractByNo(String no);
	
	/**
	 * 新增记录
	 * @param contract
	 * @param user
	 * @return
	 */
	Integer createContract(Contract contract,User user);

	/**
	 * 根据id修改一条记录
	 * @param contract
	 * @return
	 */
	Integer updateContractById(Contract contract,User user);
	
	/**
	 * 根据条件查询合同列表总数
	 * @return
	 */
	Integer getContractTotalBySearch(ContractSearchModel searchModel);
	
	/**
	 * 根据条件查询合同列表
	 * @return
	 */
	List<Contract> getContractListBySearch(ContractSearchModel searchModel);
	
	
	/**
	 * 所有合同列表
	 * @return
	 */
	List<Contract> getContractList();
	
	/**
	 * 根据查询条件，返回DataTables控件需要的Json数据格式
	 * @param searchModel
	 * @return
	 */
	String getContractDataTables(ContractSearchModel searchModel);
	
	/**
	 * 返回DataTables控件需要的一行Json数据格式
	 * @param no
	 * @return
	 */
	String getContractDataRow(String no);
	
}
