package com.cl.purchase.biz;

import java.util.List;

import com.cl.privilege.model.User;
import com.cl.purchase.model.backtrack.BacktrackForm;
import com.cl.purchase.model.backtrack.BacktrackFormSearchModel;

/**
 * 返厂单表相关操作
 */
public interface IBacktrackFormService {
	/**
	 * 根据no获取BacktrackForm对象
	 * @param no
	 * @return
	 */
	BacktrackForm getBacktrackFormByNo(String no);
	
	/**
	 * 新增记录
	 * @param backtrackForm
	 * @param user
	 * @return
	 */
	Integer createBacktrackForm(BacktrackForm backtrackForm,User user);

	/**
	 * 根据id修改一条记录
	 * @param backtrackForm
	 * @return
	 */
	Integer updateBacktrackFormById(BacktrackForm backtrackForm,User user);
	
	/**
	 * 根据条件查询返厂单列表总数
	 * @return
	 */
	Integer getBacktrackFormTotalBySearch(BacktrackFormSearchModel searchModel);
	
	/**
	 * 根据条件查询返厂单列表
	 * @return
	 */
	List<BacktrackForm> getBacktrackFormListBySearch(BacktrackFormSearchModel searchModel);
	
	
	/**
	 * 所有返厂单列表
	 * @return
	 */
	List<BacktrackForm> getBacktrackFormList();
	
	/**
	 * 根据查询条件，返回DataTables控件需要的Json数据格式
	 * @param searchModel
	 * @return
	 */
	String getBacktrackFormDataTables(BacktrackFormSearchModel searchModel);
	
	/**
	 * 返回DataTables控件需要的一行Json数据格式
	 * @param no
	 * @return
	 */
	String getBacktrackFormDataRow(String no);
	
}
