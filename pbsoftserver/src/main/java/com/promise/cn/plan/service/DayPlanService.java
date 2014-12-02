/*@文件名: DayPlanService.java  @创建人: 邢健   @创建日期: 2011-12-12 上午11:06:22*/
package com.promise.cn.plan.service;

import java.util.List;

import com.promise.cn.framework.support.PageSupport;
import com.promise.cn.framework.support.QueryObject;
import com.promise.cn.plan.domain.DayPlan;

/**   
 * @类名: DayPlanService.java 
 * @包名: com.promise.cn.plan.service 
 * @描述: 任务记录接口 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-12 上午11:06:22 
 * @版本 V1.0   
 */
public interface DayPlanService {

	/**
	 * 增加任务
	 * @param DayPlan
	 * @return
	 */
	public String saveDayPlan(DayPlan dayPlanService);
	/**
	 * 修改任务
	 * @param DayPlan
	 * @return
	 */
	public String updateDayPlan(DayPlan dayPlanService);
	/**
	 * 通过ID删除任务
	 * @param id
	 * @return
	 */
	public String deleteDayPlan(String id);
	/**
	 * 获取全部的任务
	 * @return
	 */
	public List<DayPlan> getAllDayPlan();
	public PageSupport getDayPlanPageSupport(List<QueryObject> valueObject, int pageNo,int pageSize);
}
