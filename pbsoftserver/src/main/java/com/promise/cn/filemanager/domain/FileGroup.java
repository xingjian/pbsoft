/** @文件名: FileGroup.java @创建人：邢健  @创建日期： 2012-11-19 下午2:27:01 */
package com.promise.cn.filemanager.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @类名: FileGroup.java 
 * @包名: com.promise.cn.filemanager.domain 
 * @描述: 文档分类 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-19 下午2:27:01 
 * @版本: V1.0   
 */
@Entity
@Table(name="filegroup")
public class FileGroup implements Serializable{

	private String id;
	
	private String name;
	
	private FileGroup parent;
	
	private String remark;//备注
	
	public List<FileGroup> children;
	
	private String leaf;//0表示不是叶子 1表示叶子
	
	private List<FileDoc> docList;

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

	@ManyToOne(targetEntity = FileGroup.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "parent")
	public FileGroup getParent() {
		return parent;
	}

	public void setParent(FileGroup parent) {
		this.parent = parent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Transient
	public List<FileGroup> getChildren() {
		return children;
	}

	public void setChildren(List<FileGroup> children) {
		this.children = children;
	}

	@Transient
	public List<FileDoc> getDocList() {
		return docList;
	}

	public void setDocList(List<FileDoc> docList) {
		this.docList = docList;
	}

	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	
}
