/*@文件名: TaskRecordLog.java  @创建人: 邢健   @创建日期: 2011-12-12 上午11:00:22*/
package com.promise.cn.plan.domain;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.promise.cn.common.domain.DictContent;

/**   
 * @类名: TaskRecordLog.java 
 * @包名: com.promise.cn.plan.domain 
 * @描述: 任务日志记录 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-12 上午11:00:22 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
@Table(name="taskrecordlog")
public class TaskRecordLog implements Serializable {

	private String id;
	
	private TaskRecord taskRecord;
	
	private String remark;
	
	private String value;
	
	private String createDate;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@OneToMany(targetEntity=DictContent.class,fetch=FetchType.EAGER)
    @JoinColumn(name="taskrecordid")
	public TaskRecord getTaskRecord() {
		return taskRecord;
	}

	public void setTaskRecord(TaskRecord taskRecord) {
		this.taskRecord = taskRecord;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
