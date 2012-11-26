/** @文件名: FileDownLoadServiceImpl.java @创建人：邢健  @创建日期： 2012-11-1 上午9:44:38 */
package com.promise.cn.filemanager.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.promise.cn.consume.service.impl.MoneyConsumeServiceImpl;
import com.promise.cn.filemanager.domain.FileDoc;
import com.promise.cn.filemanager.service.FileDownLoadService;
import com.promise.cn.framework.service.PersistenceManager;
import com.promise.cn.framework.service.QueryManager;
import com.promise.cn.framework.support.PageSupport;

/**   
 * @类名: FileDownLoadServiceImpl.java 
 * @包名: com.promise.cn.filemanager.service.impl 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-1 上午9:44:38 
 * @版本: V1.0   
 */
@Service("fileDownLoadService")
@SuppressWarnings("all")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class FileDownLoadServiceImpl implements FileDownLoadService {

	//日志对象
	private Logger log = LoggerFactory.getLogger(FileDownLoadServiceImpl.class);
	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	
	@Override
	public String addFileDoc(FileDoc fileDoc) {
		return null;
	}

	@Override
	public String editFileDoc(FileDoc fileDoc) {
		return null;
	}

	@Override
	public String deleteFileDoc(FileDoc fileDoc) {
		return null;
	}

	@Override
	public PageSupport queryFileDoc(int pageSize, int pageNum) {
		return queryManager.find("from FileDoc", pageNum, pageSize);
	}

	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	
	
}
