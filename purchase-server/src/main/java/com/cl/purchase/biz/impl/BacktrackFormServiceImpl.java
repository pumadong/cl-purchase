package com.cl.purchase.biz.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.purchase.utils.StringUtil;
import com.cl.privilege.model.User;
import com.cl.purchase.biz.IBacktrackFormService;
import com.cl.purchase.mapper.backtrack.BacktrackFormMapper;
import com.cl.purchase.model.backtrack.BacktrackForm;
import com.cl.purchase.model.backtrack.BacktrackFormSearchModel;

@Service
public class BacktrackFormServiceImpl implements IBacktrackFormService {
	
	@Autowired
	private BacktrackFormMapper backtrackFormMapper;
	
	private void setPersonInsert(BacktrackForm backtrackForm,User user)
	{
		Date d = new Date();
		backtrackForm.setCreatePerson(user.getUsername());
		backtrackForm.setUpdatePerson(user.getUsername());
		backtrackForm.setCreateDate(d);
		backtrackForm.setUpdateDate(d);
	}
	private void setPersonUpdate(BacktrackForm backtrackForm,User user)
	{
		Date d = new Date();
		backtrackForm.setUpdatePerson(user.getUsername());
		backtrackForm.setUpdateDate(d);
	}

	@Override
	public BacktrackForm getBacktrackFormByNo(String no) {
		return backtrackFormMapper.selectByPrimaryKey(no);
	}

	@Override
	public Integer createBacktrackForm(BacktrackForm backtrackForm,User user) {
		setPersonInsert(backtrackForm,user);
		return backtrackFormMapper.insertSelective(backtrackForm);
	}

	@Override
	public Integer updateBacktrackFormById(BacktrackForm backtrackForm,User user) {
		setPersonUpdate(backtrackForm,user);
		return backtrackFormMapper.updateByPrimaryKeySelective(backtrackForm);
	}
	
	@Override
	public Integer getBacktrackFormTotalBySearch(BacktrackFormSearchModel searchModel)
	{
		return backtrackFormMapper.getBacktrackFormTotalBySearch(searchModel);
	}

	@Override
	public List<BacktrackForm> getBacktrackFormListBySearch(BacktrackFormSearchModel searchModel)
	{
		return backtrackFormMapper.getBacktrackFormListBySearch(searchModel, 
				new RowBounds((searchModel.getPageNo() - 1) * searchModel.getPageSize(), searchModel.getPageSize()));
	}
	
	@Override
	public List<BacktrackForm> getBacktrackFormList()
	{
		return backtrackFormMapper.getBacktrackFormList();
	}
	
	@Override
	public String getBacktrackFormDataTables(BacktrackFormSearchModel searchModel)
	{
		Integer total = getBacktrackFormTotalBySearch(searchModel);
		List<BacktrackForm> backtrackFormList = getBacktrackFormListBySearch(searchModel);		
		if(backtrackFormList==null || backtrackFormList.size()==0)
		{
			return "{\"iTotalRecords\":0,\"iTotalDisplayRecords\":0,\"aaData\":[]}";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("{\"iTotalRecords\":%d,\"iTotalDisplayRecords\":%d,\"aaData\":[",total,total));
		int i= 0;
		for(BacktrackForm r:backtrackFormList)
		{
			if(i != 0) sb.append(",");
			addDataRow(sb,r);
			i++;
		}
		sb.append("]}");
		return sb.toString();
	}
	
	@Override
	public String getBacktrackFormDataRow(String no)
	{
		BacktrackForm r = getBacktrackFormByNo(no);
		StringBuilder sb = new StringBuilder();
		addDataRow(sb,r);
		return sb.toString();
	}

	private void addDataRow(StringBuilder sb,BacktrackForm r)
	{
		sb.append("[");
		sb.append("\"<input type=\\\"checkbox\\\" name=\\\"id[]\\\" value=\\\"").append(r.getNo()).append("\\\">\"");
		sb.append(",").append(r.getNo());
		sb.append(",\"").append(r.getSupplierId()).append("\"");
		sb.append(",\"").append(r.getWarehouseId()).append("\"");
		sb.append(",\"").append(r.getUpdatePerson()).append("\"");
		sb.append(",\"").append(StringUtil.formatDate(r.getUpdateDate(),"yyyy-MM-dd HH:mm:ss")).append("\"");
		sb.append(",\"")
		.append("<a href=\\\"javascript:BacktrackForm.update_click('").append(r.getNo()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-edit\\\"></i> 修改</a>")
		.append("&nbsp;&nbsp;<a href=\\\"javascript:BacktrackForm.remove('").append(r.getNo()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-times\\\"></i> 删除</a>")
		.append("\"");
		sb.append("]");
	}

}
