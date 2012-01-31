/*@文件名: MemorandumServiceImpl.java  @创建人: 邢健   @创建日期: 2011-12-9 下午05:46:59*/
package com.promise.cn.memorandum.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.promise.cn.framework.service.PersistenceManager;
import com.promise.cn.framework.service.QueryManager;
import com.promise.cn.memorandum.domain.Memorandum;
import com.promise.cn.memorandum.service.MemorandumService;

/**   
 * @类名: MemorandumServiceImpl.java 
 * @包名: com.promise.cn.memorandum.service.impl 
 * @描述: MemorandumService接口实现类
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-9 下午05:46:59 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
@Service("memorandumService")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class MemorandumServiceImpl implements MemorandumService {

	//日志对象
	private Logger log = LoggerFactory.getLogger(MemorandumServiceImpl.class);
	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	
	/**
	 * 增加备忘录
	 * @param memorandum
	 * @return
	 */
	public String saveMemorandum(Memorandum memorandum){
		log.debug("saveMemorandum="+memorandum.getName());
		persistenceManager.save(memorandum);
		return "success";
	}
	
	/**
	 * 编辑备忘录
	 * @param memorandum
	 * @return
	 */
	public String updateMemorandum(Memorandum memorandum){
		log.debug("updateMemorandum="+memorandum.getName());
		persistenceManager.update(memorandum);
		return "success";
	}
	
	/**
	 * 通过ID删除备忘录 
	 */
	public String deleteMemorandum(String id){
		log.debug("deleteMemorandum id="+id);
		persistenceManager.remove(Memorandum.class, id);
		return "success";
	}
	
	/**
	 * 查询所有的备忘录
	 * @return
	 */
	public List<Memorandum> getAllMemorandums(){
		return queryManager.findByNamedQuery("listMemorandum");
	}
	
	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}
	
	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}
	
}
