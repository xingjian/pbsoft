/** @文件名: FileDownLoadController.java @创建人：邢健  @创建日期： 2012-11-1 上午9:41:40 */
package com.promise.cn.filemanager.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.promise.cn.common.service.ConverterService;
import com.promise.cn.common.utils.CnToSpell;
import com.promise.cn.common.utils.GlobalKeys;
import com.promise.cn.common.utils.PBStringUtil;
import com.promise.cn.filemanager.domain.FileDoc;
import com.promise.cn.filemanager.service.FileManagerService;
import com.promise.cn.framework.utils.FileStreamUtil;

/**
 * @类名: FileDownLoadController.java
 * @包名: com.promise.cn.filemanager.web
 * @描述: 下载上传
 * @作者: xingjian xingjian@yeah.net
 * @日期:2012-11-1 上午9:41:40
 * @版本: V1.0
 */
public class FileUpLoadController{

	private GlobalKeys globalKeys;
	private ConverterService converterService;
	private FileManagerService fileManagerService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
	private Log log = LogFactory.getLog(FileUpLoadController.class);
	
	/**
	 * 文件上传
	 * 通过springmvc 获取到文件流
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/fileUpLoad")
	public void upload(HttpServletRequest request, HttpServletResponse response)throws IOException {
		log.debug("fileUpLoad");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multiRequest.getFile("Filedata");
			String fileName = multiRequest.getParameter("fileName");
			String fileGroupID = multiRequest.getParameter("fileGroup");
			String userName = multiRequest.getParameter("userName");
			String pdfName = fileName.substring(0, fileName.lastIndexOf("."));
			String enName = PBStringUtil.getAZTo09(CnToSpell.getFullSpell(pdfName));
			String fileType = multiRequest.getParameter("fileType");
			if (file != null && !file.isEmpty()){
				try {
					if (file.getSize() > 0) {
						FileStreamUtil.SaveFileFromInputStream(file,globalKeys.getUploadPath(), fileName);
					}
//					out.print("\"pdf文档转换中......\"");
					//开始转换
					boolean boo = converterService.convertWordTOPDF(globalKeys.getUploadPath()+"\\"+fileName, globalKeys.getUploadpathpdf()+"\\"+pdfName+".pdf", "wps");
					if(boo){
//						out.print("\"swf文档转换中......\"");
						int value = converterService.convertPDFTOSWF(globalKeys.getUploadpathpdf()+"\\"+pdfName+".pdf", globalKeys.getUploadpathswf(), enName+".swf");
						if(value==0){
							out.print("文档上传成功!");
							FileDoc fileDoc = new FileDoc();
							fileDoc.fileName = fileName;
							fileDoc.userName = userName;
							fileDoc.fileType = fileType;
							fileDoc.setFileGroup(fileManagerService.getFileGroupByID(fileGroupID));
							fileDoc.url = globalKeys.getUploadPath()+"\\"+fileName;
							fileDoc.remark = fileName;
							fileDoc.uptime = sdf.format(new Date());
							fileDoc.enName = enName;
							fileManagerService.addFileDoc(fileDoc);
						}else{
							out.print("swf文档转换失败!");
						}
					}else{
						out.print("pdf文档转换失败!");
					}
					out.close();
				} catch (Exception e) {
					out.print("上传发生异常!");
					out.close();
				}
			} else {
				out.print("上传文件为空异常!");
				out.close();
			}
		} else {
			out.print("对象匹配错误!");
			out.close();
		}
		//上传成功之后将文档转换成pdf 在转换swf调用swf tools
	}

	/**
	 * 上传大文件
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/fileUpLoadBig",method=RequestMethod.POST)
	public String uploadBigFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("fileupLoadBig");
		try {
			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				MultipartFile file = multiRequest.getFile("Filedata");
				String fileName = multiRequest.getParameter("fileName");
				String fileGroupID = multiRequest.getParameter("fileGroup");
				String spath=globalKeys.getUploadPath();
				if(!new File(spath).exists()){
					new File(spath).mkdir();
				}
				File savedFile = new File(spath);
				if (!savedFile.exists()){
					savedFile.mkdirs();
				}
				File file1=new File(spath+"\\"+fileName);
		        if(!file1.exists()){
		        	file1.createNewFile();
		        }
		        FileOutputStream out=new FileOutputStream(file1);
				FileCopyUtils.copy(file.getInputStream(),out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("{\"msg\":0}");
		out.flush();
		out.close();
		return "success";
	}
	
	public void setGlobalKeys(GlobalKeys globalKeys) {
		this.globalKeys = globalKeys;
	}

	public void setConverterService(ConverterService converterService) {
		this.converterService = converterService;
	}

	public void setFileManagerService(FileManagerService fileManagerService) {
		this.fileManagerService = fileManagerService;
	}

	
}
