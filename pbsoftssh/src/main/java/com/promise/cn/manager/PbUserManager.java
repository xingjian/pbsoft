/**@Title: PbUserManager.java @author promisePB xingjian@yeah.net @date 2010-10-31 下午05:40:57 */

package com.promise.cn.manager;

import com.promise.cn.model.PbUser;

/**   
 * @Title: PbUserManager.java 
 * @Package com.promise.cn.manager 
 * @Description: 用户管理action 
 * @author promisePB xingjian@yeah.net   
 * @date 2010-10-31 下午05:40:57 
 * @version V1.0   
 */

public interface PbUserManager {

	/**
	 * 根据用户名和密码校验用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public PbUser checkLogin(String userName, String password);
}
