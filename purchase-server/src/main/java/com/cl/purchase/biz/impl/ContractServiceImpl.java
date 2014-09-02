package com.cl.purchase.biz.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.purchase.utils.StringUtil;
import com.cl.privilege.model.User;
import com.cl.purchase.biz.IContractService;
import com.cl.purchase.mapper.purchase.ContractMapper;
import com.cl.purchase.model.purchase.Contract;
import com.cl.purchase.model.purchase.ContractSearchModel;

@Service
public class ContractServiceImpl implements IContractService {
	
	@Autowired
	private ContractMapper contractMapper;
	
	private void setPersonInsert(Contract contract,User user)
	{
		Date d = new Date();
		contract.setCreatePerson(user.getUsername());
		contract.setUpdatePerson(user.getUsername());
		contract.setCreateDate(d);
		contract.setUpdateDate(d);
	}
	private void setPersonUpdate(Contract contract,User user)
	{
		Date d = new Date();
		contract.setUpdatePerson(user.getUsername());
		contract.setUpdateDate(d);
	}

	@Override
	public Contract getContractByNo(String no) {
		return contractMapper.selectByPrimaryKey(no);
	}

	@Override
	public Integer createContract(Contract contract,User user) {
		setPersonInsert(contract,user);
		return contractMapper.insertSelective(contract);
	}

	@Override
	public Integer updateContractById(Contract contract,User user) {
		setPersonUpdate(contract,user);
		return contractMapper.updateByPrimaryKeySelective(contract);
	}
	
	@Override
	public Integer getContractTotalBySearch(ContractSearchModel searchModel)
	{
		return contractMapper.getContractTotalBySearch(searchModel);
	}

	@Override
	public List<Contract> getContractListBySearch(ContractSearchModel searchModel)
	{
		return contractMapper.getContractListBySearch(searchModel, 
				new RowBounds((searchModel.getPageNo() - 1) * searchModel.getPageSize(), searchModel.getPageSize()));
	}
	
	@Override
	public List<Contract> getContractList()
	{
		return contractMapper.getContractList();
	}
	
	@Override
	public String getContractDataTables(ContractSearchModel searchModel)
	{
		Integer total = getContractTotalBySearch(searchModel);
		List<Contract> contractList = getContractListBySearch(searchModel);		
		if(contractList==null || contractList.size()==0)
		{
			return "{\"iTotalRecords\":0,\"iTotalDisplayRecords\":0,\"aaData\":[]}";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("{\"iTotalRecords\":%d,\"iTotalDisplayRecords\":%d,\"aaData\":[",total,total));
		int i= 0;
		for(Contract r:contractList)
		{
			if(i != 0) sb.append(",");
			addDataRow(sb,r);
			i++;
		}
		sb.append("]}");
		return sb.toString();
	}
	
	@Override
	public String getContractDataRow(String no)
	{
		Contract r = getContractByNo(no);
		StringBuilder sb = new StringBuilder();
		addDataRow(sb,r);
		return sb.toString();
	}

	private void addDataRow(StringBuilder sb,Contract r)
	{
		sb.append("[");
		sb.append("\"<input type=\\\"checkbox\\\" name=\\\"id[]\\\" value=\\\"").append(r.getNo()).append("\\\">\"");
		sb.append(",").append(r.getNo());
		sb.append(",\"").append(r.getSupplierId()).append("\"");
		sb.append(",\"").append(r.getStatus()).append("\"");
		sb.append(",\"").append(r.getUpdatePerson()).append("\"");
		sb.append(",\"").append(StringUtil.formatDate(r.getUpdateDate(),"yyyy-MM-dd HH:mm:ss")).append("\"");
		sb.append(",\"")
		.append("<a href=\\\"javascript:Contract.update_click('").append(r.getNo()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-edit\\\"></i> 修改</a>")
		.append("&nbsp;&nbsp;<a href=\\\"javascript:Contract.remove('").append(r.getNo()).append("');\\\" class=\\\"btn btn-xs default btn-editable\\\"><i class=\\\"fa fa-times\\\"></i> 删除</a>")
		.append("\"");
		sb.append("]");
	}

}
