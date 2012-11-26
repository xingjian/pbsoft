/** @文件名: FileDownLoadController.java @创建人：邢健  @创建日期： 2012-11-26 上午10:48:09 */
package com.promise.cn.filemanager.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.promise.cn.common.utils.GlobalKeys;
import com.promise.cn.framework.utils.FileStreamUtil;

/**   
 * @类名: FileDownLoadController.java 
 * @包名: com.promise.cn.filemanager.web 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-26 上午10:48:09 
 * @版本: V1.0   
 */
public class FileDownLoadController {

	private GlobalKeys globalKeys;
	
	@RequestMapping("/fileDownLoad")
	public void upload(HttpServletRequest request, HttpServletResponse response)throws IOException {
		String fileName = request.getParameter("fileName");
		String fileType = request.getParameter("fileType");
		response.setContentType("text/html;charset=UTF-8");
		File f = null;
		if(fileType.equals("pdf")){
			f = new File(globalKeys.getUploadpathpdf()+"\\"+fileName);
		}else{
			f = new File(globalKeys.getUploadPath()+"\\"+fileName);
		}
		FileStreamUtil.CopyFileStream(new FileInputStream(f),response.getOutputStream());
	}

	public void setGlobalKeys(GlobalKeys globalKeys) {
		this.globalKeys = globalKeys;
	}

}
