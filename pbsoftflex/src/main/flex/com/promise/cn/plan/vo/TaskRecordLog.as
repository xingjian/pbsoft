package com.promise.cn.plan.vo
{
	[RemoteClass(alias="com.promise.cn.plan.domain.TaskRecordLog")]
	[Bindable]
	public class TaskRecordLog
	{
		public var  id:String;
		
		public var taskRecord:TaskRecord;
		
		public var  remark:String;
		
		public var  value:String;
		
		public var  createDate:String;
		
		public function TaskRecordLog(obj:Object=null)
		{
			if(obj!=null){
				this.id = obj.id;
				this.taskRecord = obj.taskRecord;
				this.remark = obj.remark;
				this.value = obj.value;
				this.createDate = obj.createDate;
			}
		}
	}
}