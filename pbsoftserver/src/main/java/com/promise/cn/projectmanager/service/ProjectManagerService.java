package com.promise.cn.projectmanager.service;

import java.util.List;

import com.promise.cn.framework.support.PageSupport;
import com.promise.cn.framework.support.QueryObject;
import com.promise.cn.projectmanager.domain.ProjectTask;
import com.promise.cn.projectmanager.domain.ProjectTaskLog;

/**  
 * 功能描述:ProjectManager 模块的接口
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年9月18日 下午10:45:37  
 */
public interface ProjectManagerService {
	/**
	 * 增加ProjectTask
	 * @param projectTask
	 * @return
	 */
	public String addProjectTask(ProjectTask projectTask);
	/**
	 * 更新project
	 * @param projectTask
	 * @return
	 */
	public String updateProjectTask(ProjectTask projectTask);
	/**
	 * 删除projectTask
	 * @param id
	 * @return
	 */
	public String deleteProjectTask(String id);
	/**
	 * 根据条件查询项目任务
	 * @param valueObject
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageSupport getProjectTaskPageSupport(List<QueryObject> valueObject,int pageNo, int pageSize);
	
	public PageSupport getProjectTaskBySQL(String sql,int pageNo,int pageSize);
	
	public String addProjectTaskLog(ProjectTaskLog projectTaskLog);
	
	public PageSupport getProjectTaskLogByPTID(String ptid,int pageNo,int pageSize);
	
	public String deleteProjectTaskLog(String id);
	
}
