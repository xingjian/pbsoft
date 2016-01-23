package com.promise.cn.work.service;

import java.util.List;

import com.promise.cn.framework.support.PageSupport;
import com.promise.cn.framework.support.QueryObject;
import com.promise.cn.work.domain.WorkLog;

/**  
 * 功能描述:
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年1月11日 下午2:09:07  
 */
public interface WorkLogService {

	/**
	 * 增加工作日志
	 * @param wl
	 * @return
	 */
	public String addWorkLog(WorkLog wl);
	/**
	 * 修改工作日志
	 * @param wl
	 * @return
	 */
	public String updateWorkLog(WorkLog wl);
	/**
	 * 删除工作日志
	 * @param id
	 * @return
	 */
	public String deleteWorkLog(String id);
	/**
	 * 根据条件查询工作日志
	 * @param valueObject
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<WorkLog> getListByQueryObject(List<QueryObject> valueObject, int pageNo,int pageSize);
	/**
	 * 根据时间范围查询工作日志
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public PageSupport getListByTime(String startTime,String endTime,int pageNo,int pageSize);
	
	/**
	 * 按分页查询工作日志
	 * 按照时间倒序
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageSupport getAllWorkLog(List<QueryObject> valueObject,int pageNo,int pageSize);
}
