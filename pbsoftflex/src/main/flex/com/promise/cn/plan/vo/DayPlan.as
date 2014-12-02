package com.promise.cn.plan.vo
{
	import com.promise.cn.common.vo.DictContent;

	[RemoteClass(alias="com.promise.cn.plan.domain.DayPlan")]
	[Bindable]
	public class DayPlan
	{
		public var id:String;
		public var name:String;
		public var createDate:String;
		public var createUser:String;
		public var content:String;//任务内容
		public var  taskType:DictContent;//任务类型
		public var pass:String;//是否完成0代表未完成，1代表完成
		
		public function DayPlan(object:Object=null)
		{
			if(object!=null){
				this.id = object.id;
				this.name = object.name;
				this.createDate = object.createDate;
				this.createUser = object.createUser;
				this.content = object.content;
				this.taskType = object.taskType;
				this.pass = object.pass;
			}
		}
		
		public function get passToString():String{
			if(pass=="0"){
				return "未完成";
			}else{
				return "完成";
			}
		}
	}
}