/*@文件名: Memorandum.java  @创建人: 邢健   @创建日期: 2011-12-9 下午05:39:19*/
package com.promise.cn.memorandum.domain;

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
import com.promise.cn.common.domain.PBUser;

/**   
 * @类名: Memorandum.java 
 * @包名: com.promise.cn.memorandum.domain 
 * @描述: 备忘录
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-9 下午05:39:19 
 * @版本 V1.0   
 */
@NamedQueries({
	@NamedQuery(name = "listMemorandum", query = "select t from Memorandum t order by t.createDate asc")
})
@SuppressWarnings("all")
@Table(name = "memorandum")
public class Memorandum implements Serializable{
	
	private String id;
	private String name;
	private String createDate;
	private String isComplete;
	private String remark;
	private String endDate;
	private PBUser createUser;
	
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
	
	public String getIsComplete() {
		return isComplete;
	}
	
	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@ManyToOne(targetEntity=PBUser.class,fetch=FetchType.EAGER)
    @JoinColumn(name="createUser")
	public PBUser getCreateUser() {
		return createUser;
	}
	
	public void setCreateUser(PBUser createUser) {
		this.createUser = createUser;
	}
	
}
