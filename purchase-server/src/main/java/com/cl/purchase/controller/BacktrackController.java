package com.cl.purchase.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cl.privilege.api.IPrivilegeBaseApiService;
import com.cl.privilege.model.User;
import com.cl.purchase.biz.IBacktrackFormService;
import com.cl.purchase.model.backtrack.BacktrackFormSearchModel;
import com.cl.purchase.utils.ConfigUtil;
import com.cl.purchase.utils.SessionUtil;




/**
 *返厂单管理相关的控制器 
 */

@Controller
@RequestMapping("/controller/backtrack")
public class BacktrackController {

	@Autowired
	private IPrivilegeBaseApiService privilegeBaseApiService;
	@Autowired
	private ConfigUtil configUtil;
	@Autowired
	private IBacktrackFormService backtrackFormService;
	
	@RequestMapping("/list")
    public String main(String visitedModule,String visitedResource,HttpServletRequest request,ModelMap map) {

		//初始化用户、菜单
		User user = SessionUtil.getSessionUser(request);
		String menus = privilegeBaseApiService.getModuleTree(user.getId(),visitedModule,visitedResource);
        map.put("user", user);
        map.put("menus", menus);
        
		return "backtrack/list.ftl";
    }
	
	@ResponseBody
	@RequestMapping("/getBacktrackFormDataTables")
    public String getBacktrackFormDataTables(BacktrackFormSearchModel searchModel,ModelMap map) {
		return backtrackFormService.getBacktrackFormDataTables(searchModel);
	}
}
