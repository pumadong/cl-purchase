package com.cl.purchase.biz.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.purchase.utils.StringUtil;
import com.cl.privilege.model.User;
import com.cl.purchase.biz.IPurchaseFormService;
import com.cl.purchase.mapper.purchase.PurchaseFormMapper;
import com.cl.purchase.model.purchase.PurchaseForm;
import com.cl.purchase.model.purchase.PurchaseFormSearchModel;

@Service
public class PurchaseFormServiceImpl implements IPurchaseFormService {
	
	@Autowired
	private PurchaseFormMapper purchaseFormMapper;
	
	private void setPersonInsert(PurchaseForm purchaseForm,User user)
	{
		Date d = new Date();
		purchaseForm.setCreatePerson(user.getUsername());
		purchaseForm.setUpdatePerson(user.getUsername());
		purchaseForm.setCreateDate(d);
		purchaseForm.setUpdateDate(d);
	}
	private void setPersonUpdate(PurchaseForm purchaseForm,User user)
	{
		Date d = new Date();
		purchaseForm.setUpdatePerson(user.getUsername());
		purchaseForm.setUpdateDate(d);
	}

	@Override
	public PurchaseForm getPurchaseFormByNo(String no) {
		return purchaseFormMapper.selectByPrimaryKey(no);
	}

	@Override
	public Integer createPurchaseForm(PurchaseForm purchaseForm,User user) {
		setPersonInsert(purchaseForm,user);
		return purchaseFormMapper.insertSelective(purchaseForm);
	}

	@Override
	public Integer updatePurchaseFormById(PurchaseForm purchaseForm,User user) {
		setPersonUpdate(purchaseForm,user);
		return purchaseFormMapper.updateByPrimaryKeySelective(purchaseForm);
	}
	
	@Override
	public Integer getPurchaseFormTotalBySearch(PurchaseFormSearchModel searchModel)
	{
		return purchaseFormMapper.getPurchaseFormTotalBySearch(searchModel);
	}

	@Override
	public List<PurchaseForm> getPurchaseFormListBySearch(PurchaseFormSearchModel searchModel)
	{
		return purchaseFormMapper.getPurchaseFormListBySearch(searchModel, 
				new RowBounds((searchModel.getPageNo() - 1) * searchModel.getPageSize(), searchModel.getPageSize()));
	}
	
	@Override
	public List<PurchaseForm> getPurchaseFormList()
	{
		return purchaseFormMapper.getPurchaseFormList();
	}
	
	@Override
	public String getPurchaseFormDataTables(PurchaseFormSearchModel searchModel)
	{
		Integer total = getPurchaseFormTotalBySearch(searchModel);
		List<PurchaseForm> purchaseFormList = getPurchaseFormListBySearch(searchModel);		
		if(purchaseFormList==null || purchaseFormList.size()==0)
		{
			return "{\"iTotalRecords\":0,\"iTotalDisplayRecords\":0,\"aaData\":[]}";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("{\"iTotalRecords\":%d,\"iTotalDisplayRecords\":%d,\"aaData\":[",total,total));
		int i= 0;
		for(PurchaseForm r:purchaseFormList)
		{
			if(i != 0) sb.append(",");
			addDataRow(sb,r);
			i++;
		}
		sb.append("]}");
		return sb.toString();
	}
	
	@Override
	public String getPurchaseFormDataRow(String no)
	{
		PurchaseForm r = getPurchaseFormByNo(no);
		StringBuilder sb = new StringBuilder();
		addDataRow(sb,r);
		return sb.toString();
	}

	private void addDataRow(StringBuilder sb,PurchaseForm r)
	{
		sb.append("[");
		sb.append("\"<input type=\\\"checkbox\\\" name=\\\"id[]\\\" value=\\\"").append(r.getNo()).append("\\\">\"");
		sb.append(",").append(r.getNo());
		sb.append(",\"").append(r.getSupplierId()).append("\"");
		sb.append(",\"").append(r.getContractNo()).append("\"");
		sb.append(",\"").append(r.getUpdatePerson()).append("\"");
		sb.append(",\"").append(StringUtil.formatDate(r.getUpdateDate(),"yyyy-MM-dd HH:mm:ss")).append("\"");
		sb.append(",\"")
		.append("<a href=\\\"javascript:PurchaseForm.update_click('").append(r.getNo()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-edit\\\"></i> 修改</a>")
		.append("&nbsp;&nbsp;<a href=\\\"javascript:PurchaseForm.remove('").append(r.getNo()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-times\\\"></i> 删除</a>")
		.append("\"");
		sb.append("]");
	}

}
