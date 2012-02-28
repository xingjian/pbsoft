package com.promise.cn.plan.vo
{
	import com.promise.cn.common.vo.DictContent;

	[RemoteClass(alias="com.promise.cn.plan.domain.TaskRecord")]
	[Bindable]
	public class TaskRecord
	{
		public var id:String;
		
		public var name:String;
		
		public var createDate:String;
		
		public var startDate:String;
		
		public var endDate:String;
		
		public var currentValue:String;
		
		public var createUser:String;
		
		public var content:String;//任务内容
		
		public var  taskType:DictContent;//任务类型
		
		public var activate:String;//1代表启动 0 代表未启动
		
		public var showTip:String;//是否提示0代表不提示，1代表提示
		
		public var pass:String;//是否完成0代表未完成，1代表完成
		
		public var activateDate:String;//激活时间
		
		public var realEndDate:String;
		
		public function TaskRecord(object:Object=null)
		{
			if(object!=null){
				this.id = object.id;
				this.name = object.name;
				this.createDate = object.createDate;
				this.endDate = object.endDate;
				this.currentValue = object.currentValue;
				this.createUser = object.createUser;
				this.content = object.content;
				this.taskType = object.taskType;
				this.activate = object.activate;
				this.showTip = object.showTip;
				this.pass = object.pass;
				this.startDate = object.startDate;
				this.activateDate = object.activateDate;
				this.realEndDate = object.realEndDate;
			}
		}
		
		public function get passToString():String{
			if(pass=="0"){
				return "未完成";
			}else{
				return "完成";
			}
		}
		
		public function get activateDateToString():String{
			if(null==activateDate||activateDate==""){
				return "无";
			}else{
				return activateDate;
			}
		}
		
		public function get showTipToString():String{
			if(showTip=="0"){
				return "不提示"
			}else{
				return "提示";
			}
		}
		
		public function get activateToString():String{
			if(activate=="0"){
				return "未激活";
			}else{
				return "激活"
			}
		}
	}
}