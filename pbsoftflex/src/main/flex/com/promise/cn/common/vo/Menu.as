package com.promise.cn.common.vo
{
import mx.collections.ArrayCollection;

[RemoteClass(alias="com.promise.cn.common.domain.Menu")]
[Bindable]
public class Menu
{
	public var id:String;
	public var name:String;
	public var parent:Menu;
	public var remark:String;
	public var sort:String;
	public var children:ArrayCollection;
	public var url:String;
	public var leaf:String;
	public var state:Boolean;
	
	public function Menu(object:Object=null){
		if(null!=object){
			this.id = object.id;
			this.name = object.name;
			this.parent = object.parent;
			this.remark = object.remark;
			this.sort = object.code;
			this.children = object.children;
			this.url = object.url;
			this.leaf = object.leaf;
			this.state = object.state;
		}
	}
}

}