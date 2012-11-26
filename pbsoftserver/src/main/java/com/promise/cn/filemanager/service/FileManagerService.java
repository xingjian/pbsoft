/** @文件名: FileManagerService.java @创建人：邢健  @创建日期： 2012-11-19 下午3:39:39 */
package com.promise.cn.filemanager.service;

import java.util.List;

import com.promise.cn.filemanager.domain.FileDoc;
import com.promise.cn.filemanager.domain.FileGroup;
import com.promise.cn.framework.support.PageSupport;

/**   
 * @类名: FileManagerService.java 
 * @包名: com.promise.cn.filemanager.service 
 * @描述: 文件管理
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-19 下午3:39:39 
 * @版本: V1.0   
 */
public interface FileManagerService {

	public String addFileGroup(FileGroup fileGroup);
	public String editFileGroup(FileGroup fileGroup);
	public String deleteFileGroup(FileGroup fileGroup);
	public List<FileGroup> getAllFileGroupTree();
	public FileGroup getFileGroupByID(String id);
	
	public String addFileDoc(FileDoc fileDoc);
	public String editFileDoc(FileDoc fileDoc);
	public String deleteFileDoc(FileDoc fileDoc);
	public PageSupport getFileDocPageSupport(int pagenum,int pagesize);
}
