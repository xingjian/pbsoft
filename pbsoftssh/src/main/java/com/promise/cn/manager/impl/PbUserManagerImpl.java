/**@Title: PbUserManagerImpl.java @author promisePB xingjian@yeah.net @date 2010-10-31 下午05:43:58 */

package com.promise.cn.manager.impl;

import com.promise.cn.dao.PbUserDao;
import com.promise.cn.manager.PbUserManager;
import com.promise.cn.model.PbUser;

/**   
 * @Title: PbUserManagerImpl.java 
 * @Package com.promise.cn.manager.impl 
 * @Description:  PbUserManager实现类
 * @author promisePB xingjian@yeah.net   
 * @date 2010-10-31 下午05:43:58 
 * @version V1.0   
 */

public class PbUserManagerImpl implements PbUserManager {
	
	/**
	 * pbUserDao 管理pbuser
	 */
	private PbUserDao pbUserDao;
	
	@Override
	public PbUser checkLogin(String userName, String password) {
		return pbUserDao.checkLogin(userName, password);
	}
	
	public void setPbUserDao(PbUserDao pbUserDao) {
		this.pbUserDao = pbUserDao;
	}

}
