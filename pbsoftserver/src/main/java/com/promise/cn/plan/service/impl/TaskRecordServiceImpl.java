/*@文件名: TaskRecordServiceImpl.java  @创建人: 邢健   @创建日期: 2011-12-12 上午11:11:13*/
package com.promise.cn.plan.service.impl;

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
import com.promise.cn.plan.domain.TaskRecordLog;
import com.promise.cn.plan.service.TaskRecordService;

/**   
 * @类名: TaskRecordServiceImpl.java 
 * @包名: com.promise.cn.plan.service.impl 
 * @描述: 任务记录接口实现类 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-12 上午11:11:13 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
@Service("taskRecordService")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class TaskRecordServiceImpl implements TaskRecordService {

	//日志对象
	private Logger log = LoggerFactory.getLogger(TaskRecordServiceImpl.class);
	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 增加任务
	 */
	@Override
	@RemotingInclude
	public String saveTaskRecord(TaskRecord taskRecord) {
		log.debug("saveTaskRecord = "+taskRecord.getContent());
		persistenceManager.save(taskRecord);
		return "success";
	}

	/**
	 * 修改任务
	 */
	@Override
	@RemotingInclude
	public String updateTaskRecord(TaskRecord taskRecord) {
		log.debug("updateTaskRecord = "+taskRecord.getContent());
		persistenceManager.update(taskRecord);
		return "success";
	}

	/**
	 * 删除任务
	 */
	@Override
	@RemotingInclude
	public String deleteTaskRecord(String id) {
		log.debug("deleteTaskRecord id = "+id);
		deleteTaskRecordLogByTaskRecordID(id);
		persistenceManager.remove(TaskRecord.class,id);
		return "success";
	}

	/**
	 * 获取所有任务
	 */
	@Override
	@RemotingInclude
	public List<TaskRecord> getAllTaskRecord() {
		log.debug("getAllTaskRecord");
		return (List<TaskRecord>)queryManager.findByNamedQuery("listAllTaskRecord");
	}

	/**
	 * 保存任务记录日志
	 */
	@Override
	@RemotingInclude
	public String saveTaskRecordLog(TaskRecordLog taskRecordLog) {
		log.debug("saveTaskRecordLog = "+taskRecordLog.getRemark());
		persistenceManager.save(taskRecordLog);
		taskRecordLog.getTaskRecord().setCurrentValue(taskRecordLog.getValue());
		persistenceManager.update(taskRecordLog.getTaskRecord());
		//任务记录记录任务进度到100的时候，自动结束任务
		if(taskRecordLog.getTaskRecord().getCurrentValue().equals("100")){
			TaskRecord tr = taskRecordLog.getTaskRecord();
			if(tr.getPass().equals("0")){
				tr.setPass("1");
				tr.setRealEndDate(sdf.format(new Date()));
				persistenceManager.update(tr);
			}
		}
		return "success";
	}

	/**
	 * 删除任务日志
	 */
	@Override
	@RemotingInclude
	public String deleteTaskRecordLog(String id) {
		persistenceManager.remove(TaskRecordLog.class, id);
		return "success";
	}
	
	@Override
	@RemotingInclude
	public PageSupport getTaskRecordPageSupport(List<QueryObject> valueObject,
			int pageNo, int pageSize) {
		String sql = "from TaskRecord t where 1=1";
		if(null!=valueObject&&valueObject.size()>0){//带条件查询
			sql = sql + " "+QueryObject.creatSql(valueObject);
		}
		sql = sql + " order by t.createDate desc";
		return queryManager.find(sql, pageNo, pageSize);
	}
	
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	@Override
	@RemotingInclude
	public PageSupport getTaskRecordLogByTaskRecordID(String id, int pageNo,int pageSize) {
		String hql = "from TaskRecordLog t where t.taskRecord.id='"+id+"' order by t.createDate desc";
		return queryManager.find(hql, pageNo, pageSize);
	}

	@Override
	public String deleteTaskRecordLogByTaskRecordID(String id) {
		String hql = "from TaskRecordLog t where t.taskRecord.id='"+id+"'";
		List<TaskRecordLog> list = queryManager.find(hql);
		persistenceManager.removeAll(list);
		return null;
	}

}
