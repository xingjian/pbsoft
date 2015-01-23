/**@Title: HibernatUtilsTest.java @author promisePB xingjian@yeah.net @date 2010-10-28 下午08:59:48 */
package com.promise.cn.framework;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.promise.cn.framework.pojo.TestUser;
import com.promise.cn.model.PbUser;
/**
* @Title: HibernatUtilsTest.java 
* @Package com.promise.cn.utils 
* @Description:  HibernatUtils测试类
* @author promisePB xingjian@yeah.net   
* @date 2010-10-28 下午09:01:45 
* @version V1.0
 */
public class HibernatUtilsTest extends TestCase {
	/**
	 * hibernate session工厂
	 */
	public SessionFactory sessionFactory;
	/**
	 * 读取配置文件的类
	 */
	public Configuration configuration;
	/**
	 * hibernate session
	 */
	public Session session;
	/**
	 * 事务对象
	 */
	public Transaction transaction;
	
	@Override
	protected void setUp() throws Exception {
		configuration = new Configuration().configure("/hibernate/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	/**
	 * 测试hibernat 查询
	 */
	@SuppressWarnings({"rawtypes","unchecked"})
	public void testQuery(){
		List userList = session.createQuery("from PbUser").list();
		for(Iterator<PbUser> items = userList.iterator();items.hasNext();){		
			PbUser pbUser = items.next();
			System.out.println(pbUser.getName());
		}
	} 
	
	/**
	 * 测试hibernate 保存
	 */
	public void testSave(){
		PbUser pbuser = new PbUser("001", "xigjian", "aaaaaa");
		transaction = session.getTransaction();
		transaction.begin();
		session.save(pbuser);
		session.flush();
		transaction.commit();
	}
	
	/**
	 * 测试hibernate 删除
	 */
	public void testDelete(){
		PbUser pbuser = new PbUser("001", "xigjian", "aaaaaa");
		transaction = session.getTransaction();
		transaction.begin();
		session.delete(pbuser);
		session.flush();
		transaction.commit();
	}
	
	/**
	 * 测试hibernate 使用TestUser.hbm.xml文件
	 */
	public void testSaveTestUser(){
		TestUser pbuser = new TestUser();
		pbuser.setName("孟子");
		pbuser.setPassword("mengzi");
		PbUser pbuser1 = new PbUser();
		pbuser1.setName("贝贝");
		pbuser1.setPassword("贝贝");
		transaction = session.getTransaction();
		transaction.begin();
		session.save(pbuser);
		session.save(pbuser1);
		session.flush();
		transaction.commit();
	}
}
