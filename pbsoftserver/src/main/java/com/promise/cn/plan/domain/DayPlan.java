/** @文件名: DayPlan.java @创建人：邢健  @创建日期： 2014-12-2 上午10:16:57 */
package com.promise.cn.plan.domain;

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
 * @类名: DayPlan.java
 * @包名: com.promise.cn.plan.domain
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:2014-12-2 上午10:16:57
 * @版本: V1.0  
 */
@Entity
@SuppressWarnings("all")
@Table(name="dayplan")
public class DayPlan {
	private String id;
	private String name;
	private String createDate;
	private String createUser;
	private String content;//任务内容
	private DictContent taskType;//任务类型
	private String pass;//是否完成0代表未完成，1代表完成
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
