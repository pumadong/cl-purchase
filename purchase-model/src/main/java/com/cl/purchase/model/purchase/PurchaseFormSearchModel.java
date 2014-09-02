package com.cl.purchase.model.purchase;

import java.io.Serializable;

import com.cl.purchase.model.PurchaseModelConstant;


/**
 * 采购单查询SearchModel
 */
public class PurchaseFormSearchModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer pageNo = 1;
	private Integer pageSize = PurchaseModelConstant.PageSize;	
	//采购单号
	private String no;
	
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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}

}
