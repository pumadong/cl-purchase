package com.cl.purchase.api;

import com.cl.purchase.model.base.Supplier;

public interface IPurchaseBaseApiService {

	Supplier getSupplierById(Integer id);
}
