/**@Title: SpringUtilsTest.java @author promisePB xingjian@yeah.net @date 2010-10-31 下午03:51:06 */

package com.promise.cn.framework;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.promise.cn.model.PbUser;

/**   
 * @Title: SpringUtilsTest.java 
 * @Package com.promise.cn.framework 
 * @Description: 测试spring 环境 
 * @author promisePB xingjian@yeah.net   
 * @date 2010-10-31 下午03:51:06 
 * @version V1.0   
 */

public class SpringUtilsTest extends TestCase{
	
	public BeanFactory beanFactory;
	
	@Override
	protected void setUp() throws Exception {
		beanFactory = new ClassPathXmlApplicationContext("spring/*.xml");
	}
	
	/**
	 * 测试Spring getBean
	 */
	@SuppressWarnings("unused")
	public void testSpringGetBean(){
		PbUser pbUser = (PbUser)beanFactory.getBean("pbUser");
	}
	
}
