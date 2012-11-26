/** @文件名: FileDoc.java @创建人：邢健  @创建日期： 2012-11-1 下午3:05:35 */
package com.promise.cn.filemanager.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.promise.cn.common.domain.Dict;

/**   
 * @类名: FileDoc.java 
 * @包名: com.promise.cn.filemanager.domain 
 * @描述: 文档管理 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-1 下午3:05:35 
 * @版本: V1.0   
 */
@SuppressWarnings("all")		
@Entity
@Table(name = "FileDoc")
public class FileDoc {

	public String id;
	public String fileName;
	public String url;
	public String fileType;
	public FileGroup fileGroup;
	public String uptime;
	public String userName;
	public String remark;
	public String enName;//英文名称
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	@ManyToOne(targetEntity = FileGroup.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "groupid")
	public FileGroup getFileGroup() {
		return fileGroup;
	}
	public void setFileGroup(FileGroup fileGroup) {
		this.fileGroup = fileGroup;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	
	
}
