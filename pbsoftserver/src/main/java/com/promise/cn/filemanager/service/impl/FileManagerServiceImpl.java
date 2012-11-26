/** @文件名: FileManagerServiceImpl.java @创建人：邢健  @创建日期： 2012-11-20 下午3:42:35 */
package com.promise.cn.filemanager.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import com.promise.cn.filemanager.domain.FileDoc;
import com.promise.cn.filemanager.domain.FileGroup;
import com.promise.cn.filemanager.service.FileManagerService;
import com.promise.cn.framework.service.PersistenceManager;
import com.promise.cn.framework.service.QueryManager;
import com.promise.cn.framework.support.PageSupport;

/**   
 * @类名: FileManagerServiceImpl.java 
 * @包名: com.promise.cn.filemanager.service.impl 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-20 下午3:42:35 
 * @版本: V1.0   
 */
@SuppressWarnings("all")
@Service("fileManagerService")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class FileManagerServiceImpl implements FileManagerService {

	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	
	@Override
	@RemotingInclude
	public String addFileGroup(FileGroup fileGroup) {
		persistenceManager.save(fileGroup);
		return fileGroup.getId();
	}

	@Override
	@RemotingInclude
	public String editFileGroup(FileGroup fileGroup) {
		persistenceManager.update(fileGroup);
		return "success";
	}

	@Override
	@RemotingInclude
	public String deleteFileGroup(FileGroup fileGroup) {
		String fileGroupId = fileGroup.getId();
		deleteFileGroupByFileGroup(fileGroup);
		return fileGroupId;
	}

	/**
	 * 级联删除
	 * @param fileGroup
	 */
	public void deleteFileGroupByFileGroup(FileGroup fileGroup){
		if(null!=fileGroup.getChildren()&&fileGroup.getChildren().size()>0){
			for(FileGroup fg:fileGroup.getChildren()){
				deleteFileGroupByFileGroup(fg);
			}
			persistenceManager.remove(fileGroup);
		}else{
			persistenceManager.remove(fileGroup);	
		}
	}
	
	
	@Override
	@RemotingInclude
	public List<FileGroup> getAllFileGroupTree() {
		List<FileGroup> retList = new ArrayList<FileGroup>();
		//获取根节点,要求数据库对应
		FileGroup root = (FileGroup)queryManager.get(FileGroup.class, "root");
		getSubFileGroup(root);
		retList.add(root);
		return retList;
	}

	public FileGroup getSubFileGroup(FileGroup fileGroup){
		String hql = "from FileGroup t where t.parent.id='"+fileGroup.getId()+"'";
		List<FileGroup> list = queryManager.find(hql);
		if(null!=list&&list.size()>0){
			fileGroup.setChildren(list);
		}
		for(FileGroup fileGroupTemp:list){
			fileGroupTemp.setParent(fileGroup);
			getSubFileGroup(fileGroupTemp);
		}
		return fileGroup;
	}
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	@Override
	public String addFileDoc(FileDoc fileDoc) {
		persistenceManager.save(fileDoc);
		return "success";
	}

	@Override
	public String editFileDoc(FileDoc fileDoc) {
		persistenceManager.update(fileDoc);
		return "success";
	}

	@Override
	public String deleteFileDoc(FileDoc fileDoc) {
		persistenceManager.remove(fileDoc);
		return "success";
	}

	@Override
	@RemotingInclude
	public PageSupport getFileDocPageSupport(int pagenum, int pagesize) {
		String hql = "from FileDoc t";
		return queryManager.find(hql, pagenum, pagesize);
	}

	@Override
	public FileGroup getFileGroupByID(String id) {
		return (FileGroup)queryManager.get(FileGroup.class, id);
	}
	
	
}
