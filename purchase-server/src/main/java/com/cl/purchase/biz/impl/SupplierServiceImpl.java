package com.cl.purchase.biz.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.privilege.model.User;
import com.cl.purchase.biz.ISupplierService;
import com.cl.purchase.mapper.base.SupplierMapper;
import com.cl.purchase.model.base.Supplier;
import com.cl.purchase.model.base.SupplierSearchModel;


@Service
public class SupplierServiceImpl implements ISupplierService {
	
	@Autowired
	private SupplierMapper supplierMapper;
	
	private void setPersonInsert(Supplier supplier,User user)
	{
		Date d = new Date();
		supplier.setCreatePerson(user.getUsername());
		supplier.setUpdatePerson(user.getUsername());
		supplier.setCreateDate(d);
		supplier.setUpdateDate(d);
	}
	private void setPersonUpdate(Supplier supplier,User user)
	{
		Date d = new Date();
		supplier.setUpdatePerson(user.getUsername());
		supplier.setUpdateDate(d);
	}

	@Override
	public Supplier getSupplierById(Integer id) {
		return supplierMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer createSupplier(Supplier supplier,User user) {
		setPersonInsert(supplier,user);
		return supplierMapper.insertSelective(supplier);
	}

	@Override
	public Integer updateSupplierById(Supplier supplier,User user) {
		setPersonUpdate(supplier,user);
		return supplierMapper.updateByPrimaryKeySelective(supplier);
	}
	
	@Override
	public Integer getSupplierTotalBySearch(SupplierSearchModel searchModel)
	{
		return supplierMapper.getSupplierTotalBySearch(searchModel);
	}

	@Override
	public List<Supplier> getSupplierListBySearch(SupplierSearchModel searchModel)
	{
		return supplierMapper.getSupplierListBySearch(searchModel, 
				new RowBounds((searchModel.getPageNo() - 1) * searchModel.getPageSize(), searchModel.getPageSize()));
	}
	
	@Override
	public List<Supplier> getSupplierList()
	{
		return supplierMapper.getSupplierList();
	}
	
	@Override
	public String getSupplierDataTables(SupplierSearchModel searchModel)
	{
		Integer total = getSupplierTotalBySearch(searchModel);
		List<Supplier> supplierList = getSupplierListBySearch(searchModel);		
		if(supplierList==null || supplierList.size()==0)
		{
			return "{\"iTotalRecords\":0,\"iTotalDisplayRecords\":0,\"aaData\":[]}";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("{\"iTotalRecords\":%d,\"iTotalDisplayRecords\":%d,\"aaData\":[",total,total));
		int i= 0;
		for(Supplier r:supplierList)
		{
			if(i != 0) sb.append(",");
			addDataRow(sb,r);
			i++;
		}
		sb.append("]}");
		return sb.toString();
	}
	
	@Override
	public String getSupplierDataRow(Integer id)
	{
		Supplier r = getSupplierById(id);
		StringBuilder sb = new StringBuilder();
		addDataRow(sb,r);
		return sb.toString();
	}

	private void addDataRow(StringBuilder sb,Supplier r)
	{
		sb.append("[");
		sb.append("\"<input type=\\\"checkbox\\\" name=\\\"id[]\\\" value=\\\"").append(r.getId()).append("\\\">\"");
		sb.append(",").append(r.getId());
		sb.append(",\"").append(r.getName()).append("\"");
		sb.append(",\"").append(r.getProvince()).append("\"");
		sb.append(",\"").append(r.getCity()).append("\"");
		sb.append(",\"").append(r.getTelephone()).append("\"");
		sb.append(",\"")
		.append("<a href=\\\"javascript:Supplier.update_click('").append(r.getId()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-edit\\\"></i> 修改</a>")
		.append("&nbsp;&nbsp;<a href=\\\"javascript:Supplier.remove('").append(r.getId()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-times\\\"></i> 删除</a>")
		.append("\"");
		sb.append("]");
	}

}
