package com.cl.purchase.mapper.base;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.cl.purchase.model.base.Supplier;
import com.cl.purchase.model.base.SupplierSearchModel;

public interface SupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
    
    // 以上是为了节约开发时间，使用MyBatisGenerator生成的代码
    // 以下是针对不足功能，添加的代码
    
	/**
	 * 根据条件查询供应商列表总数
	 * @param searchModel
	 * @return
	 */
	Integer getSupplierTotalBySearch(SupplierSearchModel searchModel);
	
	/**
	 * 根据条件查询供应商List
	 * @param searchModel
	 * @return
	 */
	List<Supplier> getSupplierListBySearch(SupplierSearchModel searchModel,RowBounds rowBounds);

	
	/**
	 * 所有供应商列表
	 * @return
	 */
	List<Supplier> getSupplierList();    
}