/** @文件名: FileDownLoadService.java @创建人：邢健  @创建日期： 2012-11-1 上午9:43:58 */
package com.promise.cn.filemanager.service;

import com.promise.cn.filemanager.domain.FileDoc;
import com.promise.cn.framework.support.PageSupport;

/**   
 * @类名: FileDownLoadService.java 
 * @包名: com.promise.cn.filemanager.service 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-1 上午9:43:58 
 * @版本: V1.0   
 */
public interface FileDownLoadService {

	public String addFileDoc(FileDoc fileDoc);
	public String editFileDoc(FileDoc fileDoc);
	public String deleteFileDoc(FileDoc fileDoc);
	public PageSupport queryFileDoc(int pageSize,int pageNum);
}
