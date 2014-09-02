package com.cl.purchase.mapper.purchase;

import com.cl.purchase.model.purchase.DeliverDetail;

public interface DeliverDetailMapper {
    int deleteByPrimaryKey(String productNo);

    int insert(DeliverDetail record);

    int insertSelective(DeliverDetail record);

    DeliverDetail selectByPrimaryKey(String productNo);

    int updateByPrimaryKeySelective(DeliverDetail record);

    int updateByPrimaryKey(DeliverDetail record);
}