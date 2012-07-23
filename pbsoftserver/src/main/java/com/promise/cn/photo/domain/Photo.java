/**@文件名: Photo.java @作者: promisePB xingjian@yeah.net @日期： 2012-5-23 下午06:11:47*/
package com.promise.cn.photo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.promise.cn.common.domain.DictContent;

/**   
 * @类名: Photo.java 
 * @包名: com.promise.cn.photo.domain 
 * @描述: 照片 
 * @作者： xingjian xingjian@yeah.net   
 * @日期： 2012-5-23 下午06:11:47 
 * @版本： V1.0   
 */
@Entity
@Table(name="photo")
public class Photo {

	private String id;
	
	private String name;
	
	private String url;
	
	private DictContent photoType;
	
	private DictContent photoGroup;
	
	private String remark;
	
	private Date createTime;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DictContent getPhotoType() {
		return photoType;
	}

	public void setPhotoType(DictContent photoType) {
		this.photoType = photoType;
	}

	public DictContent getPhotoGroup() {
		return photoGroup;
	}

	public void setPhotoGroup(DictContent photoGroup) {
		this.photoGroup = photoGroup;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
