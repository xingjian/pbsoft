/*@文件名: MemorandumService.java  @创建人: 邢健   @创建日期: 2011-12-9 下午05:46:38*/
package com.promise.cn.memorandum.service;

import java.util.List;

import com.promise.cn.memorandum.domain.Memorandum;

/**   
 * @类名: MemorandumService.java 
 * @包名: com.promise.cn.memorandum.service 
 * @描述: 备忘录接口 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-9 下午05:46:38 
 * @版本 V1.0   
 */
public interface MemorandumService {

	/**
	 * 增加备忘录
	 * @param memorandum
	 * @return
	 */
	public String saveMemorandum(Memorandum memorandum);
	/**
	 * 编辑备忘录
	 * @param memorandum
	 * @return
	 */
	public String updateMemorandum(Memorandum memorandum);
	/**
	 * 通过ID删除备忘录 
	 */
	public String deleteMemorandum(String id);
	/**
	 * 查询所有的备忘录
	 * @return
	 */
	public List<Memorandum> getAllMemorandums();
}
