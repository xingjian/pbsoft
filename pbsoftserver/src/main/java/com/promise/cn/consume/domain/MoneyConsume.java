/*@文件名: MoneyConsume.java  @创建人: 邢健   @创建日期: 2011-12-9 下午03:35:13*/
package com.promise.cn.consume.domain;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.promise.cn.common.domain.DictContent;
import com.promise.cn.common.domain.PBUser;

/**
 * @类名: MoneyConsume.java
 * @包名: com.promise.cn.consume.domain
 * @描述: 金钱消费
 * @作者: 邢健 xingjian@dhcc.com.cn
 * @日期: 2011-12-9 下午03:35:13
 * @版本 V1.0
 */
@NamedQueries({
	@NamedQuery(name="listMoneyConsumeByUserID",query="select t from MoneyConsume t where t.pbUser.id=? order by t.consumeDate asc")
})
@SuppressWarnings("all")
@Table(name = "moneyconsume")
public class MoneyConsume implements Serializable {

	private String id;
	private DictContent consumeType;
	private float num;
	private PBUser pbUser;
	private String consumeDate;
	private String describe;
	private String sysDate;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=DictContent.class,fetch=FetchType.EAGER)
    @JoinColumn(name="consumeType")
	public DictContent getConsumeType() {
		return consumeType;
	}
	
	public void setConsumeType(DictContent consumeType) {
		this.consumeType = consumeType;
	}
	
	public float getNum() {
		return num;
	}
	
	public void setNum(float num) {
		this.num = num;
	}
	
	@ManyToOne(targetEntity=PBUser.class,fetch=FetchType.EAGER)
    @JoinColumn(name="person")
	public PBUser getPbUser() {
		return pbUser;
	}
	
	public void setPbUser(PBUser pbUser) {
		this.pbUser = pbUser;
	}
	
	public String getConsumeDate() {
		return consumeDate;
	}
	
	public void setConsumeDate(String consumeDate) {
		this.consumeDate = consumeDate;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getSysDate() {
		return sysDate;
	}
	
	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}
	
}
