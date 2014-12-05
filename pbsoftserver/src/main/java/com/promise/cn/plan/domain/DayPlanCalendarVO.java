/** @文件名: DayPlanCalendarVO.java @创建人：邢健  @创建日期： 2014-12-4 上午10:44:50 */
package com.promise.cn.plan.domain;

/**  
 * @类名: DayPlanCalendarVO.java
 * @包名: com.promise.cn.plan.domain
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:2014-12-4 上午10:44:50
 * @版本: V1.0  
 */
public class DayPlanCalendarVO {

	private String createDate;
	private int countName;
	private String groupDetail;
	private String user;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getCountName() {
		return countName;
	}
	public void setCountName(int countName) {
		this.countName = countName;
	}
	public String getGroupDetail() {
		return groupDetail;
	}
	public void setGroupDetail(String groupDetail) {
		this.groupDetail = groupDetail;
	}
	
}
