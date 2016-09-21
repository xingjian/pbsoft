package com.promise.cn.projectmanager.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import com.promise.cn.framework.service.PersistenceManager;
import com.promise.cn.framework.service.QueryManager;
import com.promise.cn.framework.support.PageSupport;
import com.promise.cn.framework.support.QueryObject;
import com.promise.cn.plan.domain.TaskRecord;
import com.promise.cn.projectmanager.domain.ProjectTask;
import com.promise.cn.projectmanager.domain.ProjectTaskLog;
import com.promise.cn.projectmanager.service.ProjectManagerService;

/**  
 * 功能描述:
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年9月18日 下午11:02:59  
 */
@SuppressWarnings("all")
@Service("projectManagerService")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class ProjectManagerServiceImpl implements ProjectManagerService {

	//日志对象
	private Logger log = LoggerFactory.getLogger(ProjectManagerServiceImpl.class);
	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String success = "success";
	
	@Override
	public String addProjectTask(ProjectTask projectTask) {
		Date systime = new Date();
		projectTask.setCreateDate(sdfTime.format(systime));
		persistenceManager.save(projectTask);
		return success;
	}
	
	@Override
	public String addProjectTaskLog(ProjectTaskLog projectTaskLog) {
		Date systime = new Date();
		projectTaskLog.setCreateDate(sdfTime.format(systime));
		persistenceManager.save(projectTaskLog);
		//任务记录记录任务进度到100的时候，自动结束任务
		projectTaskLog.getProjectTask().setCurrentValue(projectTaskLog.getValue());
		if(projectTaskLog.getValue().equals("100")){
			ProjectTask tr = projectTaskLog.getProjectTask();
			if(tr.getPass().equals("0")){
				tr.setPass("1");
				tr.setRealEndDate(sdf.format(new Date()));
				persistenceManager.update(tr);
			}
		}else{
			persistenceManager.update(projectTaskLog.getProjectTask());
		}
		return success;
	}

	@Override
	public String updateProjectTask(ProjectTask projectTask) {
		Date systime = new Date();
		persistenceManager.update(projectTask);
		return success;
	}

	@Override
	public PageSupport getProjectTaskPageSupport(List<QueryObject> valueObject,int pageNo, int pageSize) {
		String sql = "from ProjectTask t where 1=1";
		if(null!=valueObject&&valueObject.size()>0){//带条件查询
			sql = sql + " "+QueryObject.creatSql(valueObject);
		}
		sql = sql + " order by t.pass,t.project,t.createDate desc";
		return queryManager.find(sql, pageNo, pageSize);
	}
	
	@Override
	public PageSupport getProjectTaskBySQL(String sql,int pageNo,int pageSize){
		return queryManager.find(sql, pageNo, pageSize);
	}
	
	@Override
	public String deleteProjectTask(String id) {
		persistenceManager.remove(ProjectTask.class, id);
		return success;
	}

	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	@Override
	public PageSupport getProjectTaskLogByPTID(String ptid, int pageNo, int pageSize) {
		String hql = "from ProjectTaskLog t where t.projectTask.id='"+ptid+"' order by t.createDate desc";
		return queryManager.find(hql, pageNo, pageSize);
	}

	@Override
	public String deleteProjectTaskLog(String id) {
		persistenceManager.remove(ProjectTaskLog.class, id);
		return success;
	}

	
}
