package com.cl.purchase.mapper.base;

import com.cl.purchase.model.base.SupplierCategoryRef;

public interface SupplierCategoryRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupplierCategoryRef record);

    int insertSelective(SupplierCategoryRef record);

    SupplierCategoryRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierCategoryRef record);

    int updateByPrimaryKey(SupplierCategoryRef record);
}