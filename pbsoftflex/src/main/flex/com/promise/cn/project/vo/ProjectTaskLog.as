package com.promise.cn.project.vo
{
	[RemoteClass(alias="com.promise.cn.projectmanager.domain.ProjectTaskLog")]
	[Bindable]
	public class ProjectTaskLog
	{
		public var  id:String;
		
		public var projectTask:ProjectTask;
		
		public var  remark:String;
		
		public var  value:String;
		
		public var  createDate:String;
		
		public function ProjectTaskLog(obj:Object=null)
		{
			if(obj!=null){
				this.id = obj.id;
				this.projectTask = obj.projectTask;
				this.remark = obj.remark;
				this.value = obj.value;
				this.createDate = obj.createDate;
			}
		}
	}
}