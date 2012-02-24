package com.promise.cn.plan.vo
{
	import com.promise.cn.common.vo.DictContent;

	public class TaskRecord
	{
		public var id:String;
		
		public var name:String;
		
		public var createDate:String;
		
		public var endData:String;
		
		public var currentValue:String;
		
		public var createUser:String;
		
		public var content:String;//任务内容
		
		public var  taskType:DictContent;//任务类型
		
		public var activate:String;//1代表启动 0 代表未启动
		
		public var show:String;//是否提示0代表不提示，1代表提示
		
		public var pass:String;//是否完成0代表未完成，1代表完成
		
		public function TaskRecord(object:Object=null)
		{
			if(object!=null){
				this.id = object.id;
				this.name = object.name;
				this.createDate = object.createDate;
				this.endData = object.endData;
				this.currentValue = object.currentValue;
				this.createUser = object.createUser;
				this.content = object.content;
				this.taskType = object.taskType;
				this.activate = object.activate;
				this.show = object.show;
				this.pass = object.pass;
			}
		}
	}
}