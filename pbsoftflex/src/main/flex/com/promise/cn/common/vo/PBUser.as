package com.promise.cn.common.vo
{
	import mx.collections.ArrayCollection;

[RemoteClass(alias="com.promise.cn.common.domain.PBUser")]
[Bindable]
public class PBUser
{
	public var name:String;//用户名
	public var password:String;//密码
	public var id:String;//id
	public var email:String;//email
	public var menus:ArrayCollection;
	
	public function PBUser(object:Object=null)
	{
		if(object!=null){
			this.name = object.name;
			this.password = object.password;
			this.id = object.id;
			this.email = object.email;
			this.menus = object.menus;
		}
	}
}

}