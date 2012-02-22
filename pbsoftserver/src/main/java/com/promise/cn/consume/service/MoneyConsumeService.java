/*@文件名: MoneyConsumeService.java  @创建人: 邢健   @创建日期: 2011-12-9 下午05:12:57*/
package com.promise.cn.consume.service;

import java.util.List;

import com.promise.cn.consume.domain.MoneyConsume;
import com.promise.cn.framework.support.PageSupport;
import com.promise.cn.framework.support.QueryObject;

/**   
 * @类名: MoneyConsumeService.java 
 * @包名: com.promise.cn.consume.service 
 * @描述: 金钱消费服务接口 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-9 下午05:12:57 
 * @版本 V1.0   
 */
@SuppressWarnings("all")
public interface MoneyConsumeService {

	/**
	 * 增加消费记录
	 * @param moneyConsume
	 * @return
	 */
	public String saveMoneyConsume(MoneyConsume moneyConsume);
	/**
	 * 更新消费记录
	 * @param moneyConsume
	 * @return
	 */
	public String updateMoneyConsume(MoneyConsume moneyConsume);
	/**
	 * 删除消费记录
	 * @param id
	 * @return
	 */
	public String deleteMoneyConsume(String id);
	/**
	 * 通过personName来查询记录
	 */
	public List<MoneyConsume> getMoneyConsumeByUserID(String pbID);
	/**
	 * 获取分页消费记录
	 * @param valueObject
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageSupport getMoneyConsumePageSupport(List<QueryObject> valueObject,int pageNo,int pageSize);
}
