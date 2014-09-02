package com.cl.purchase.biz.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.purchase.utils.StringUtil;
import com.cl.privilege.model.User;
import com.cl.purchase.biz.IDeliverFormService;
import com.cl.purchase.mapper.purchase.DeliverFormMapper;
import com.cl.purchase.model.purchase.DeliverForm;
import com.cl.purchase.model.purchase.DeliverFormSearchModel;

@Service
public class DeliverFormServiceImpl implements IDeliverFormService {
	
	@Autowired
	private DeliverFormMapper deliverFormMapper;
	
	private void setPersonInsert(DeliverForm deliverForm,User user)
	{
		Date d = new Date();
		deliverForm.setCreatePerson(user.getUsername());
		deliverForm.setUpdatePerson(user.getUsername());
		deliverForm.setCreateDate(d);
		deliverForm.setUpdateDate(d);
	}
	private void setPersonUpdate(DeliverForm deliverForm,User user)
	{
		Date d = new Date();
		deliverForm.setUpdatePerson(user.getUsername());
		deliverForm.setUpdateDate(d);
	}

	@Override
	public DeliverForm getDeliverFormByNo(String no) {
		return deliverFormMapper.selectByPrimaryKey(no);
	}

	@Override
	public Integer createDeliverForm(DeliverForm deliverForm,User user) {
		setPersonInsert(deliverForm,user);
		return deliverFormMapper.insertSelective(deliverForm);
	}

	@Override
	public Integer updateDeliverFormById(DeliverForm deliverForm,User user) {
		setPersonUpdate(deliverForm,user);
		return deliverFormMapper.updateByPrimaryKeySelective(deliverForm);
	}
	
	@Override
	public Integer getDeliverFormTotalBySearch(DeliverFormSearchModel searchModel)
	{
		return deliverFormMapper.getDeliverFormTotalBySearch(searchModel);
	}

	@Override
	public List<DeliverForm> getDeliverFormListBySearch(DeliverFormSearchModel searchModel)
	{
		return deliverFormMapper.getDeliverFormListBySearch(searchModel, 
				new RowBounds((searchModel.getPageNo() - 1) * searchModel.getPageSize(), searchModel.getPageSize()));
	}
	
	@Override
	public List<DeliverForm> getDeliverFormList()
	{
		return deliverFormMapper.getDeliverFormList();
	}
	
	@Override
	public String getDeliverFormDataTables(DeliverFormSearchModel searchModel)
	{
		Integer total = getDeliverFormTotalBySearch(searchModel);
		List<DeliverForm> deliverFormList = getDeliverFormListBySearch(searchModel);		
		if(deliverFormList==null || deliverFormList.size()==0)
		{
			return "{\"iTotalRecords\":0,\"iTotalDisplayRecords\":0,\"aaData\":[]}";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("{\"iTotalRecords\":%d,\"iTotalDisplayRecords\":%d,\"aaData\":[",total,total));
		int i= 0;
		for(DeliverForm r:deliverFormList)
		{
			if(i != 0) sb.append(",");
			addDataRow(sb,r);
			i++;
		}
		sb.append("]}");
		return sb.toString();
	}
	
	@Override
	public String getDeliverFormDataRow(String no)
	{
		DeliverForm r = getDeliverFormByNo(no);
		StringBuilder sb = new StringBuilder();
		addDataRow(sb,r);
		return sb.toString();
	}

	private void addDataRow(StringBuilder sb,DeliverForm r)
	{
		sb.append("[");
		sb.append("\"<input type=\\\"checkbox\\\" name=\\\"id[]\\\" value=\\\"").append(r.getNo()).append("\\\">\"");
		sb.append(",").append(r.getNo());
		sb.append(",\"").append(r.getPurchaseNo()).append("\"");
		sb.append(",\"").append(r.getWarehouseId()).append("\"");
		sb.append(",\"").append(r.getUpdatePerson()).append("\"");
		sb.append(",\"").append(StringUtil.formatDate(r.getUpdateDate(),"yyyy-MM-dd HH:mm:ss")).append("\"");
		sb.append(",\"")
		.append("<a href=\\\"javascript:DeliverForm.update_click('").append(r.getNo()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-edit\\\"></i> 修改</a>")
		.append("&nbsp;&nbsp;<a href=\\\"javascript:DeliverForm.remove('").append(r.getNo()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-times\\\"></i> 删除</a>")
		.append("\"");
		sb.append("]");
	}

}
