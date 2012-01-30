package com.promise.cn.common.vo
{
	[RemoteClass(alias="com.promise.cn.common.domain.Dict")]
	public class Dict
	{
		[Bindable]
		public var id:String;
		[Bindable]
		public var code:String;
		[Bindable]
		public var name:String;
		public function Dict(value:Object=null)
		{
			if(value != null){
				this.id = value.id;
				this.code = value.code;
				this.name = value.name;
			}
		}

	}
}
