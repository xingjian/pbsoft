/**@文件名: PhotoServiceImpl.java @作者: promisePB xingjian@yeah.net @日期： 2012-5-23 下午06:39:18*/
package com.promise.cn.photo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.flex.remoting.RemotingExclude;

import com.promise.cn.consume.service.impl.MoneyConsumeServiceImpl;
import com.promise.cn.framework.service.PersistenceManager;
import com.promise.cn.framework.service.QueryManager;
import com.promise.cn.framework.support.PageSupport;
import com.promise.cn.framework.support.QueryObject;
import com.promise.cn.photo.domain.Photo;
import com.promise.cn.photo.service.PhotoService;

/**   
 * @类名: PhotoServiceImpl.java 
 * @包名: com.promise.cn.photo.service.impl 
 * @描述: 照片服务接口实现类 
 * @作者： xingjian xingjian@yeah.net   
 * @日期： 2012-5-23 下午06:39:18 
 * @版本： V1.0   
 */
public class PhotoServiceImpl implements PhotoService {

	//日志对象
	private Logger log = LoggerFactory.getLogger(PhotoServiceImpl.class);
	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	private String message = "success";
	
	/**
	 * 保存照片
	 */
	@Override
	@RemotingExclude
	public String savePhoto(Photo photp) {
		persistenceManager.save(photp);
		return message;
	}

	/**
	 * 编辑照片
	 */
	@Override
	@RemotingExclude
	public String editPhoto(Photo photp) {
		persistenceManager.update(photp);
		return message;
	}

	/**
	 * 删除照片
	 */
	@Override
	@RemotingExclude
	public String deletePhoto(Photo photp) {
		persistenceManager.remove(photp);
		return message;
	}

	/**
	 * 照片查询
	 */
	@Override
	@RemotingExclude
	public PageSupport photoQuery(int pageNum, int pageSize) {
		String sql = "from PageSupport t where 1=1 order by t.createTime";
		return queryManager.find(sql, pageNum, pageSize);
	}
	
	/**
	 * 照片查询
	 */
	@Override
	@RemotingExclude
	public PageSupport photoQueryByQueryObject(List<QueryObject> list,int pageNum, int pageSize) {
		String sql = "from PageSupport t where 1=1";
		if(null!=list&&list.size()>0){//带条件查询
			sql = sql + " "+QueryObject.creatSql(list);
		}
		sql = sql + " order by t.createTime";
		return queryManager.find(sql, pageNum, pageSize);
	}
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

}
