/**@Title: LoginAction.java @author promisePB xingjian@yeah.net @date 2010-10-28 下午08:59:48 */
package com.promise.cn.action;

import com.opensymphony.xwork2.ActionSupport;
import com.promise.cn.manager.PbUserManager;
import com.promise.cn.model.PbUser;
/**
* @Title: LoginAction.java 
* @Package com.promise.cn.action 
* @Description: 控制登录Action 
* @author promisePB xingjian@yeah.net   
* @date 2010-10-28 下午09:00:50 
* @version V1.0
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 4953579570887970787L;
	/**
	 * 前台传过来的用户名和密码
	 */
	private String userName;
	private String password;
	/**
	 * PbUsermanager
	 */
	private PbUserManager pbUserManager;
	
	/**
	 * 用户登录调用
	 */
	@Override
	public String execute() throws Exception {
		PbUser pbUser = pbUserManager.checkLogin(userName, password);
		if(pbUser!=null){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPbUserManager(PbUserManager pbUserManager) {
		this.pbUserManager = pbUserManager;
	}
}
