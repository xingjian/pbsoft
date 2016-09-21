package com.promise.cn.projectmanager.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
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
 * 功能描述: 项目任务记录
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2016年9月18日 下午10:46:13  
 */
@NamedQueries({
	@NamedQuery(name="listProjectTask",query="select t from ProjectTask t order by t.createDate desc")
})
@Entity
@SuppressWarnings("all")
@Table(name="projecttask")
public class ProjectTask {
	private String id;
	private DictContent project;
	private String taskName;
	private String createDate;
	private String startDate;
	private String endDate;
	private String currentValue;
	private String createUser;
	private String executeUser;
	private String taskContent;//任务内容
	private String activate;//1代表启动 0 代表未启动
	private String pass;//是否完成0代表未完成，1代表完成
	private String activateDate;
	private String realEndDate;
	private int level;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@ManyToOne(targetEntity=DictContent.class,fetch=FetchType.EAGER)
    @JoinColumn(name="projectid")
	public DictContent getProject() {
		return project;
	}
	public void setProject(DictContent project) {
		this.project = project;
	}
	@Basic
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	@Basic
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Basic
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	@Basic
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Basic
	public String getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	@Basic
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	@Basic
	public String getExecuteUser() {
		return executeUser;
	}
	public void setExecuteUser(String executeUser) {
		this.executeUser = executeUser;
	}
	@Basic
	public String getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	@Basic
	public String getActivate() {
		return activate;
	}
	public void setActivate(String activate) {
		this.activate = activate;
	}
	@Basic
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Basic
	public String getActivateDate() {
		return activateDate;
	}
	public void setActivateDate(String activateDate) {
		this.activateDate = activateDate;
	}
	@Basic
	public String getRealEndDate() {
		return realEndDate;
	}
	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
