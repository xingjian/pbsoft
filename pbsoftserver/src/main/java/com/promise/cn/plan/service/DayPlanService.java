/*@文件名: DayPlanService.java  @创建人: 邢健   @创建日期: 2011-12-12 上午11:06:22*/
package com.promise.cn.plan.service;

import java.util.List;

import com.promise.cn.framework.support.PageSupport;
import com.promise.cn.framework.support.QueryObject;
import com.promise.cn.plan.domain.DayPlan;
import com.promise.cn.plan.domain.DayPlanCalendarVO;

/**   
 * @类名: DayPlanService.java 
 * @包名: com.promise.cn.plan.service 
 * @描述: 任务记录接口 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-12 上午11:06:22 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
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
	/**
	 * 根据条件查询
	 * @param valueObject
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageSupport getDayPlanPageSupport(List<QueryObject> valueObject, int pageNo,int pageSize);
	/**
	 * 结束任务
	 * @param id
	 * @return
	 */
	public String passDayPlanByID(String id);
	/**
	 * 日历模式查询返回结果
	 * @param start
	 * @param end
	 * @param user
	 * @return
	 */
	public List<DayPlanCalendarVO> getDayPlanCalendarVOByDate(String start,String end,String user);
}
