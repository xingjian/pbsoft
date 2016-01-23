/** @文件名: ConverterServiceImpl.java @创建人：邢健  @创建日期： 2012-11-19 上午8:30:40 */
package com.promise.cn.common.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.promise.cn.common.service.ConverterService;
import com.promise.cn.common.utils.GlobalKeys;

/**   
 * @类名: ConverterServiceImpl.java 
 * @包名: com.promise.cn.common.service.impl 
 * @描述: ConverterService接口实现类 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-19 上午8:30:40 
 * @版本: V1.0   
 */
public class ConverterServiceImpl implements ConverterService{

	private Log log = LogFactory.getLog(ConverterServiceImpl.class);
	
	private GlobalKeys globalKeys;
	
	private String swfToolsPath;
	
	private String swftoolflashversion;
	
	public synchronized boolean convertWordTOPDFByPdfCreator(String word, String pdf) {
		//后期实现
        return true;
	}

	 public synchronized boolean convertWordTOPDFByWPS(String word, String pdf) {
         File pdfFile = new File(pdf);
         File wordFile = new File(word);
         return true;
     }
	 
	/**
	 * tools value wps or pdfcreator
	 * @param word
	 * @param pdf
	 * @param tools
	 * @return
	 */
	@Override
	public boolean convertWordTOPDF(String word, String pdf,String tools) {
		if(tools.equals("wps")){
			return convertWordTOPDFByWPS(word, pdf);
		}else{
			return convertWordTOPDFByPdfCreator(word, pdf);
		}
	}
	
	/**
	 * 接口实现类
	 * @param args
	 */
	public static void main(String[] args) {
		ConverterServiceImpl csi = new ConverterServiceImpl();
		boolean b = csi.convertWordTOPDF("E:\\工作目录\\山洪灾害预警\\山洪市平台\\市级山洪监测预警系统需求规格说明书（张长保）.doc", "E:\\工作目录\\山洪灾害预警\\山洪市平台\\市级山洪监测预警系统需求规格说明书（张长保）.pdf","wps");
		if(b){
			int value = csi.convertPDFTOSWF("E:\\工作目录\\山洪灾害预警\\山洪市平台\\市级山洪监测预警系统需求规格说明书（张长保）.pdf", "E:\\工作目录\\山洪灾害预警\\山洪市平台","山洪市平台.swf");
			System.out.println(value);
		}
	}

	/**
	 * 获取命令行命令
	 * @param sourcePath
	 * @param destPath
	 * @param fileName
	 * @return
	 */
	public String getCommand(String sourcePath, String destPath, String fileName){
		String command = globalKeys.getSwftoolspath() + " -o " + destPath + "\\" + fileName +" -s flashversion="+globalKeys.getSwftoolflashversion()+" "+" -t " + sourcePath;
		log.debug(command);
		return command;
	}
	
	@Override
	public int convertPDFTOSWF(String pdf, String swf,String fileName){
		 //目标路径不存在则建立目标路径   
        File dest = new File(swf);   
        if (!dest.exists()) dest.mkdirs();   
        //源文件不存在则返回   
        File source = new File(pdf);   
        if (!source.exists()) return 0;   
        //调用pdf2swf命令进行转换   
        String command = getCommand(pdf,swf,fileName);
        Process pro = null;
		try {
			pro = Runtime.getRuntime().exec(command);
		} catch (IOException e1) {
			e1.printStackTrace();
		}   
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pro.getInputStream()));   
        try {
			while (bufferedReader.readLine() != null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}    
        try {   
            pro.waitFor();   
        } catch (InterruptedException e) {   
            e.printStackTrace();   
        }   
        return pro.exitValue();   
	}

	public String getSwfToolsPath() {
		return swfToolsPath;
	}

	public void setSwfToolsPath(String swfToolsPath) {
		this.swfToolsPath = swfToolsPath;
	}

	public String getSwftoolflashversion() {
		return swftoolflashversion;
	}

	public void setSwftoolflashversion(String swftoolflashversion) {
		this.swftoolflashversion = swftoolflashversion;
	}

	public GlobalKeys getGlobalKeys() {
		return globalKeys;
	}

	public void setGlobalKeys(GlobalKeys globalKeys) {
		this.globalKeys = globalKeys;
	}
	
	
	
	
}
