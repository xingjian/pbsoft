package com.promise.cn.moneyconsume.vo
{
	import com.promise.cn.common.vo.DictContent;
	import com.promise.cn.common.vo.PBUser;

	[RemoteClass(alias="com.promise.cn.consume.domain.MoneyConsume")]
	[Bindable]
	public class MoneyConsume
	{
		public var  id:String;
		public var  consumeType:DictContent;
		public var  num:Number;
		public var  pbUser:PBUser;
		public var  consumeDate:String;
		public var  describe:String;
		public var  sysDate:String;
		
		public function MoneyConsume(object:Object=null){
			if(object!=null){
				this.id = object.id;
				this.consumeType = object.consumeType;
				this.num = object.num;
				this.pbUser = object.pbUser;
				this.consumeDate = object.consumeDate;
				this.describe = object.describe;
				this.sysDate = object.sysDate;
			}
		}
	}
}