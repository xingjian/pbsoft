/** @文件名: DayPlanServiceImpl.java @创建人：邢健  @创建日期： 2014-12-2 上午11:35:23 */
package com.promise.cn.plan.service.impl;

import java.text.SimpleDateFormat;
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
import com.promise.cn.plan.domain.DayPlan;
import com.promise.cn.plan.domain.TaskRecord;
import com.promise.cn.plan.service.DayPlanService;

/**  
 * @类名: DayPlanServiceImpl.java
 * @包名: com.promise.cn.plan.service.impl
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:2014-12-2 上午11:35:23
 * @版本: V1.0  
 */
@SuppressWarnings("all")
@Service("dayPlanService")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class DayPlanServiceImpl implements DayPlanService {

	//日志对象
	private Logger log = LoggerFactory.getLogger(TaskRecordServiceImpl.class);
	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	@RemotingInclude
	public String saveDayPlan(DayPlan dayPlan) {
		log.debug("saveDayPlanService = "+dayPlan.getContent());
		persistenceManager.save(dayPlan);
		return "success";
	}

	@Override
	@RemotingInclude
	public String updateDayPlan(DayPlan dayPlan) {
		log.debug("updateDayPlanService = "+dayPlan.getContent());
		persistenceManager.update(dayPlan);
		return "success";
	}

	@Override
	@RemotingInclude
	public String deleteDayPlan(String id) {
		log.debug("deleteDayPlanService id = "+id);
		persistenceManager.remove(DayPlan.class,id);
		return "success";
	}

	@Override
	@RemotingInclude
	public List<DayPlan> getAllDayPlan() {
		return null;
	}

	@Override
	@RemotingInclude
	public PageSupport getDayPlanPageSupport(List<QueryObject> valueObject,
			int pageNo, int pageSize) {
		String sql = "from DayPlan t where 1=1";
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
}
