package com.cl.purchase.mapper.base;

import com.cl.purchase.model.base.SupplierBrandRef;

public interface SupplierBrandRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupplierBrandRef record);

    int insertSelective(SupplierBrandRef record);

    SupplierBrandRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierBrandRef record);

    int updateByPrimaryKey(SupplierBrandRef record);
}