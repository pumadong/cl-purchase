package com.cl.purchase.mapper.purchase;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.cl.purchase.model.purchase.Contract;
import com.cl.purchase.model.purchase.ContractSearchModel;

public interface ContractMapper {
    int deleteByPrimaryKey(String no);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
    
    // 以上是为了节约开发时间，使用MyBatisGenerator生成的代码
    // 以下是针对不足功能，添加的代码
    
	/**
	 * 根据条件查询合同列表总数
	 * @param searchModel
	 * @return
	 */
	Integer getContractTotalBySearch(ContractSearchModel searchModel);
	
	/**
	 * 根据条件查询合同List
	 * @param searchModel
	 * @return
	 */
	List<Contract> getContractListBySearch(ContractSearchModel searchModel,RowBounds rowBounds);

	
	/**
	 * 所有合同列表
	 * @return
	 */
	List<Contract> getContractList();   
}