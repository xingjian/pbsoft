package com.promise.cn.work.service.impl;

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
import com.promise.cn.plan.service.impl.TaskRecordServiceImpl;
import com.promise.cn.work.domain.WorkLog;
import com.promise.cn.work.service.WorkLogService;

/**  
 * 功能描述:
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年1月11日 下午2:14:18  
 */
@SuppressWarnings("all")
@Service("workLogService")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class WorkLogServiceImpl implements WorkLogService {

	//日志对象
	private Logger log = LoggerFactory.getLogger(TaskRecordServiceImpl.class);
	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public String success = "success";
	
	
	@Override
	@RemotingInclude
	public String addWorkLog(WorkLog wl) {
		Date systime = new Date();
		wl.setSystime(sdfTime.format(systime));
		persistenceManager.save(wl);
		return success;
	}

	@Override
	@RemotingInclude
	public String updateWorkLog(WorkLog wl) {
		Date systime = new Date();
		wl.setSystime(sdfTime.format(systime));
		persistenceManager.update(wl);
		return success;
	}

	@Override
	@RemotingInclude
	public String deleteWorkLog(String id) {
		persistenceManager.remove(WorkLog.class,id);
		return success;
	}

	@Override
	@RemotingInclude
	public List<WorkLog> getListByQueryObject(List<QueryObject> valueObject, int pageNo, int pageSize) {
		return null;
	}
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	@Override
	@RemotingInclude
	public PageSupport getListByTime(String startTime, String endTime, int pageNo, int pageSize) {
		String hql = "from WorkLog t where t.timeStr>='"+startTime+"' and t.timeStr<='"+endTime+"'";
		return queryManager.find(hql, pageNo, pageSize);
	}
	
	@Override
	@RemotingInclude
	public PageSupport getAllWorkLog(List<QueryObject> valueObject,int pageNo,int pageSize){
		String sql = "from WorkLog t where 1=1";
		if(null!=valueObject&&valueObject.size()>0){//带条件查询
			sql = sql + " "+QueryObject.creatSql(valueObject);
		}
		sql = sql + " order by t.timeStr desc";
		return queryManager.find(sql, pageNo, pageSize);
	}
}
