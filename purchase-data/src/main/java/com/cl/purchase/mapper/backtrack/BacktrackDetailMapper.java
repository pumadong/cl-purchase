package com.cl.purchase.mapper.backtrack;

import com.cl.purchase.model.backtrack.BacktrackDetail;

public interface BacktrackDetailMapper {
    int deleteByPrimaryKey(String productNo);

    int insert(BacktrackDetail record);

    int insertSelective(BacktrackDetail record);

    BacktrackDetail selectByPrimaryKey(String productNo);

    int updateByPrimaryKeySelective(BacktrackDetail record);

    int updateByPrimaryKey(BacktrackDetail record);
}