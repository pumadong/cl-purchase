package com.cl.purchase.model.base;

import java.io.Serializable;

import com.cl.purchase.model.PurchaseModelConstant;


/**
 * 供应商查询SearchModel
 */
public class SupplierSearchModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer pageNo = 1;
	private Integer pageSize = PurchaseModelConstant.PageSize;	
	//供应商名称
	private String name;
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
