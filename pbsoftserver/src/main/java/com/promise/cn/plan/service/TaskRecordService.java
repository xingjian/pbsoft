/*@文件名: TaskRecordService.java  @创建人: 邢健   @创建日期: 2011-12-12 上午11:06:22*/
package com.promise.cn.plan.service;

import java.util.List;

import com.promise.cn.plan.domain.TaskRecord;
import com.promise.cn.plan.domain.TaskRecordLog;

/**   
 * @类名: TaskRecordService.java 
 * @包名: com.promise.cn.plan.service 
 * @描述: 任务记录接口 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-12 上午11:06:22 
 * @版本 V1.0   
 */
public interface TaskRecordService {

	/**
	 * 增加任务
	 * @param taskRecord
	 * @return
	 */
	public String saveTaskRecord(TaskRecord taskRecord);
	/**
	 * 修改任务
	 * @param taskRecord
	 * @return
	 */
	public String updateTaskRecord(TaskRecord taskRecord);
	/**
	 * 通过ID删除任务
	 * @param id
	 * @return
	 */
	public String deleteTaskRecord(String id);
	/**
	 * 获取全部的任务
	 * @return
	 */
	public List<TaskRecord> getAllTaskRecord();
	/**
	 * 增加一条记录日志
	 * @param taskRecordLog
	 * @return
	 */
	public String saveTaskRecordLog(TaskRecordLog taskRecordLog);
	/**
	 * 删除一条任务记录日志
	 * @param id
	 * @return
	 */
	public String deleteTaskRecordLog(String id);
}
