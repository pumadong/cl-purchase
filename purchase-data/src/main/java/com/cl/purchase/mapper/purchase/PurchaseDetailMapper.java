package com.cl.purchase.mapper.purchase;

import com.cl.purchase.model.purchase.PurchaseDetail;

public interface PurchaseDetailMapper {
    int deleteByPrimaryKey(String productNo);

    int insert(PurchaseDetail record);

    int insertSelective(PurchaseDetail record);

    PurchaseDetail selectByPrimaryKey(String productNo);

    int updateByPrimaryKeySelective(PurchaseDetail record);

    int updateByPrimaryKey(PurchaseDetail record);
}