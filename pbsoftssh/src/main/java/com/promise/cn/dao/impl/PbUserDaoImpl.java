/**@Title: PbUserDaoImpl.java @author promisePB xingjian@yeah.net @date 2010-10-31 下午05:23:05 */

package com.promise.cn.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.promise.cn.dao.PbUserDao;
import com.promise.cn.model.PbUser;

/**   
 * @Title: PbUserDaoImpl.java 
 * @Package com.promise.cn.dao.impl 
 * @Description: pbuserdao接口实现 
 * @author promisePB xingjian@yeah.net   
 * @date 2010-10-31 下午05:23:05 
 * @version V1.0   
 */

public class PbUserDaoImpl extends HibernateDaoSupport implements PbUserDao {

	/**
	 * 检验用户登录信息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public PbUser checkLogin(String userName, String password) {
		List<PbUser> pbUserList = (List<PbUser>)this.getHibernateTemplate().find("");
		if(pbUserList!=null&&pbUserList.size()>0){
			return pbUserList.get(0);
		}
		return null;
	}

}
