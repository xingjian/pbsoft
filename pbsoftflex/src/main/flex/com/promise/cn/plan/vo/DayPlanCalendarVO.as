package com.promise.cn.plan.vo
{
	[RemoteClass(alias="com.promise.cn.plan.domain.DayPlanCalendarVO")]
	[Bindable]
	public class DayPlanCalendarVO
	{
		public var createDate:String;
		public var countName:int;
		public var groupDetail:String;
		public var user:String;
		
		public function DayPlanCalendarVO(obj:Object=null)
		{
			if(null!=obj){
				this.createDate = obj.createDate;
				this.countName = obj.countName;
				this.groupDetail = obj.groupDetail;
				this.user = obj.user;
			}
		}
		
		public function progressBarValue():Number{
			var rtn:Number = 0;
			if(null!=groupDetail){
				var arr1:Array = groupDetail.split(",");
				var passInt:Number = 0;
				for(var i:int=0;i<arr1.length;i++){
					var pass:Number =  Number((String(arr1[i]).split(":"))[1]);
					passInt +=pass;
				}
				rtn = Number(((passInt/countName)*100).toFixed(2));   
			}
			return rtn;
		}
	}
}