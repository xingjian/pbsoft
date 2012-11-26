package com.promise.cn.common.vo
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="com.promise.cn.filemanager.domain.FileGroup")]
	[Bindable]
	public class FileGroup 
	{
		private var _id:String; 
		private var _name:String;
		private var _remark:String;
		private var _children:ArrayCollection;
		private var _leaf:String;
		private var _docList:ArrayCollection;
		public var parent:FileGroup;
		
		public function FileGroup(object:Object=null):void
		{
			if(object!=null){
				this.id = object.id;
				this.name = object.name;
				this.remark = object.remark;
				this.children = object.children;
				this.leaf = object.leaf;
				this.docList = object.docList;
				this.parent = object.parent;
			}
		}
		
		public function get id():String
		{
			return _id;
		}
		
		public function set id(__id:String):void
		{
			_id = __id;
		}
		public function get name():String
		{
			return _name;
		}
		
		public function set name(__name:String):void
		{
			_name = __name;
		}
		public function get remark():String
		{
			return _remark;
		}
		
		public function set remark(__remark:String):void
		{
			_remark = __remark;
		}
		public function get children():ArrayCollection
		{
			return _children;
		}
		
		public function set children(__children:ArrayCollection):void
		{
			_children = __children;
		}
		public function get leaf():String
		{
			return _leaf;
		}
		
		public function set leaf(__leaf:String):void
		{
			_leaf = __leaf;
		}
		public function get docList():ArrayCollection
		{
			return _docList;
		}
		
		public function set docList(__docList:ArrayCollection):void
		{
			_docList = __docList;
		}
		
	}
}