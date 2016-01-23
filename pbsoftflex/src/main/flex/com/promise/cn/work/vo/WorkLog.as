package com.promise.cn.work.vo
{

	[RemoteClass(alias="com.promise.cn.work.domain.WorkLog")]
	[Bindable]
	public class WorkLog
	{
		public var id:String;
		public var timeStr:String;
		public var systime:String;
		public var content:String;
		public var workHour:Number;
		public var remark:String;
		public var workName:String;
		
		public function WorkLog(object:Object=null)
		{
			if(object!=null){
				this.id = object.id;
				this.timeStr = object.timeStr;
				this.systime = object.systime;
				this.content = object.content;
				this.workHour = object.workHour;
				this.remark = object.remark;
				this.workName = object.workName;
			}
		}
		
	}
}