/*@文件名: TaskRecord.java  @创建人: 邢健   @创建日期: 2011-12-12 上午10:47:59*/
package com.promise.cn.plan.domain;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.promise.cn.common.domain.DictContent;

/**   
 * @类名: TaskRecord.java 
 * @包名: com.promise.cn.plan.domain 
 * @描述: 任务记录 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-12 上午10:47:59 
 * @版本 V1.0   
 */
@NamedQueries({
	@NamedQuery(name="listTaskRecord",query="select t from TaskRecord t order by t.createDate asc")
})
@SuppressWarnings("all")
@Table(name="taskrecord")
public class TaskRecord implements Serializable {

	private String id;
	
	private String name;
	
	private String createDate;
	
	private String startDate;
	
	private String endData;
	
	private String currentValue;
	
	private String createUser;
	
	private String content;//任务内容
	
	private DictContent taskType;//任务类型
	
	private String activate;//1代表启动 0 代表未启动

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getEndData() {
		return endData;
	}

	public void setEndData(String endData) {
		this.endData = endData;
	}

	public String getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(targetEntity=DictContent.class,fetch=FetchType.EAGER)
    @JoinColumn(name="tasktype")
	public DictContent getTaskType() {
		return taskType;
	}

	public void setTaskType(DictContent taskType) {
		this.taskType = taskType;
	}

	public String getActivate() {
		return activate;
	}

	public void setActivate(String activate) {
		this.activate = activate;
	}
	
}
