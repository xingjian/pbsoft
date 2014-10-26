/** @文件名: Project.java @创建人：邢健  @创建日期： 2014-9-17 下午4:15:02 */
package com.promise.cn.projectmanager.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @类名: Project.java 
 * @包名: com.promise.cn.projectmanager.domain 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2014-9-17 下午4:15:02 
 * @版本: V1.0   
 */
@Entity
@SuppressWarnings("all")
@Table(name="project")
public class Project {

	private String id;
	private String name;
	private String content;
	private String createTime;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Basic
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Basic
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Basic
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
