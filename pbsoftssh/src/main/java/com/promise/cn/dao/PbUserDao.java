/**@Title: PbUserDao.java @author promisePB xingjian@yeah.net @date 2010-10-31 下午04:19:11 */

package com.promise.cn.dao;

import com.promise.cn.model.PbUser;

/**   
 * @Title: PbUserDao.java 
 * @Package com.promise.cn.dao 
 * @Description: 用户的Dao
 * @author promisePB xingjian@yeah.net   
 * @date 2010-10-31 下午04:19:11 
 * @version V1.0   
 */

public interface PbUserDao  {
	/**
	 * 检验用户是否存在
	 * @return
	 */
	public PbUser checkLogin(String userName,String password);
}
