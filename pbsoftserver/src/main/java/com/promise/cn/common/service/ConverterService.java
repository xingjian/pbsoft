/** @文件名: Converter.java @创建人：邢健  @创建日期： 2012-11-19 上午8:28:10 */
package com.promise.cn.common.service;

/**   
 * @类名: Converter.java 
 * @包名: com.promise.cn.common.service 
 * @描述: 文件转换接口实现 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-11-19 上午8:28:10 
 * @版本: V1.0   
 */
public interface ConverterService {
	/**
	 * word 转换成 pdf
	 * @param word
	 * @param pdf
	 * @param tools
	 * @return
	 */
	public boolean convertWordTOPDF(String word, String pdf,String tools);
	/**
	 * pdf 转换成 swf
	 * @param pdf
	 * @param swf
	 * @return
	 */
	public int convertPDFTOSWF(String pdf,String swf,String fileName);
}
