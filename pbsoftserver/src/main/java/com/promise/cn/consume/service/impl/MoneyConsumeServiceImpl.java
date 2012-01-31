/*@文件名: MoneyConsumeServiceImpl.java  @创建人: 邢健   @创建日期: 2011-12-9 下午05:18:10*/
package com.promise.cn.consume.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import com.promise.cn.consume.domain.MoneyConsume;
import com.promise.cn.consume.service.MoneyConsumeService;
import com.promise.cn.framework.service.PersistenceManager;
import com.promise.cn.framework.service.QueryManager;

/**   
 * @类名: MoneyConsumeServiceImpl.java 
 * @包名: com.promise.cn.consume.service.impl 
 * @描述: 消费服务接口 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-9 下午05:18:10 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
@Service("moneyConsumeService")
@RemotingDestination(channels={"my-amf","my-secure-amf"})
public class MoneyConsumeServiceImpl implements MoneyConsumeService {

	//日志对象
	private Logger log = LoggerFactory.getLogger(MoneyConsumeServiceImpl.class);
	//pm对象
	private PersistenceManager persistenceManager;
	//查询对象
	private QueryManager queryManager;
	
	/**
	 * 保存消费记录
	 */
	@Override
	@RemotingInclude
	public String saveMoneyConsume(MoneyConsume moneyConsume) {
		log.debug("saveMoneyConsume="+moneyConsume.getDescribe());
		persistenceManager.save(moneyConsume);
		return "success";
	}

	/**
	 * 更新消费记录
	 */
	@RemotingInclude
	@Override
	public String updateMoneyConsume(MoneyConsume moneyConsume) {
		log.debug("updateMoneyConsume="+moneyConsume.getDescribe());
		persistenceManager.update(moneyConsume);
		return "success";
	}

	/**
	 * 删除消费记录
	 */
	@Override
	@RemotingInclude
	public String deleteMoneyConsume(String id) {
		log.debug("deleteMoneyConsume id ="+id);
		persistenceManager.remove(MoneyConsume.class,id);
		return "success";
	}

	/**
	 * 通过用户ID查询消费记录
	 */
	@Override
	@RemotingInclude
	public List<MoneyConsume> getMoneyConsumeByUserID(String pbID) {
		return queryManager.findByNamedQuery("listMoneyConsumeByUserID", pbID);
	}

	public void setPersistenceManager(PersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}
	
	

}
