package com.cl.purchase.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cl.privilege.api.IPrivilegeBaseApiService;
import com.cl.privilege.model.User;
import com.cl.purchase.biz.IDeliverFormService;
import com.cl.purchase.model.purchase.DeliverFormSearchModel;
import com.cl.purchase.utils.ConfigUtil;
import com.cl.purchase.utils.SessionUtil;




/**
 *发货单管理相关的控制器 
 */

@Controller
@RequestMapping("/controller/deliver")
public class DeliverController {

	@Autowired
	private IPrivilegeBaseApiService privilegeBaseApiService;
	@Autowired
	private ConfigUtil configUtil;
	@Autowired
	private IDeliverFormService deliverFormService;
	
	@RequestMapping("/list")
    public String main(String visitedModule,String visitedResource,HttpServletRequest request,ModelMap map) {

		//初始化用户、菜单
		User user = SessionUtil.getSessionUser(request);
		String menus = privilegeBaseApiService.getModuleTree(user.getId(),visitedModule,visitedResource);
        map.put("user", user);
        map.put("menus", menus);
        
		return "deliver/list.ftl";
    }
	
	@ResponseBody
	@RequestMapping("/getDeliverFormDataTables")
    public String getDeliverFormDataTables(DeliverFormSearchModel searchModel,ModelMap map) {
		return deliverFormService.getDeliverFormDataTables(searchModel);
	}
}
