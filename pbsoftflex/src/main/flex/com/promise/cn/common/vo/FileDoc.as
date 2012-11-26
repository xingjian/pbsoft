package com.promise.cn.common.vo
{
	[RemoteClass(alias="com.promise.cn.filemanager.domain.FileDoc")]
	[Bindable]
	public class FileDoc 
	{
		private var _id:String;
		private var _fileName:String;
		private var _url:String;
		private var _fileType:String;
		private var _fileGroup:FileGroup;
		private var _uptime:String;
		private var _userName:String;
		private var _remark:String;
		private var _enName:String;
		
		public function FileDoc(object:Object=null):void
		{
			if(object!=null){
				this.id = object.id;
				this.fileName = object.fileName;
				this.url = object.url;
				this.fileType = object.fileType;
				this.fileGroup = object.fileGroup;
				this.uptime = object.uptime;
				this.userName = object.userName;
				this.remark = object.remark;
			}
		}
		
		public function get enName():String
		{
			return _enName;
		}
		
		public function set enName(__enName:String):void
		{
			_enName = __enName;
		}
		
		public function get id():String
		{
			return _id;
		}
		
		public function set id(__id:String):void
		{
			_id = __id;
		}
		public function get fileName():String
		{
			return _fileName;
		}
		
		public function set fileName(__fileName:String):void
		{
			_fileName = __fileName;
		}
		public function get url():String
		{
			return _url;
		}
		
		public function set url(__url:String):void
		{
			_url = __url;
		}
		public function get fileType():String
		{
			return _fileType;
		}
		
		public function set fileType(__fileType:String):void
		{
			_fileType = __fileType;
		}
		public function get fileGroup():FileGroup
		{
			return _fileGroup;
		}
		
		public function set fileGroup(__fileGroup:FileGroup):void
		{
			_fileGroup = __fileGroup;
		}
		public function get uptime():String
		{
			return _uptime;
		}
		
		public function set uptime(__uptime:String):void
		{
			_uptime = __uptime;
		}
		public function get userName():String
		{
			return _userName;
		}
		
		public function set userName(__userName:String):void
		{
			_userName = __userName;
		}
		public function get remark():String
		{
			return _remark;
		}
		
		public function set remark(__remark:String):void
		{
			_remark = __remark;
		}
		
	}
}