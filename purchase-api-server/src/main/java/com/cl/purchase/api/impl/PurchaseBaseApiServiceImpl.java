package com.cl.purchase.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.purchase.api.IPurchaseBaseApiService;
import com.cl.purchase.mapper.base.SupplierMapper;
import com.cl.purchase.model.base.Supplier;

@Service
public class PurchaseBaseApiServiceImpl implements IPurchaseBaseApiService {

	@Autowired
	private SupplierMapper supplierMapper;
	
	@Override
	public Supplier getSupplierById(Integer id) {
		return supplierMapper.selectByPrimaryKey(id);
	}

}
