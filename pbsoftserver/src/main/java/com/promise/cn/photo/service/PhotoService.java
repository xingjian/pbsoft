/**@文件名: PhotoService.java @作者: promisePB xingjian@yeah.net @日期： 2012-5-23 下午06:31:35*/
package com.promise.cn.photo.service;

import java.util.List;

import com.promise.cn.framework.support.PageSupport;
import com.promise.cn.framework.support.QueryObject;
import com.promise.cn.photo.domain.Photo;

/**   
 * @类名: PhotoService.java 
 * @包名: com.promise.cn.photo.service 
 * @描述: 照片服务对象接口 
 * @作者： xingjian xingjian@yeah.net   
 * @日期： 2012-5-23 下午06:31:35 
 * @版本： V1.0   
 */
public interface PhotoService {

	/**
	 * 增加照片
	 * @return
	 */
	public String savePhoto(Photo photp);
	/**
	 * 编辑照片
	 * @param photp
	 * @return
	 */
	public String editPhoto(Photo photp);
	/**
	 * 删除照片
	 * @param photp
	 * @return
	 */
	public String deletePhoto(Photo photp);
	/**
	 * 获取图片
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageSupport photoQuery(int pageNum,int pageSize);
	/**
	 * 通过条件查询照片
	 * @param list
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageSupport photoQueryByQueryObject(List<QueryObject> list,int pageNum,int pageSize);
}
