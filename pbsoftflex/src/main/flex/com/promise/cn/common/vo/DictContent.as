package com.promise.cn.common.vo
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="com.promise.cn.common.domain.DictContent")]
	public class DictContent
	{
		[Bindable]
		public  var id:String;
		[Bindable]
		public  var dict:Dict;
		[Bindable]
		public  var code:String;
		[Bindable]
		public  var name:String;
        [Bindable]
        public var parent:DictContent;
		
		public function DictContent(value:Object=null)
		{
			if(value != null){
				this.id = value.id;
				this.dict = new Dict(value.dict);
				this.code = value.code;
				this.name = value.name;
                this.parent = value.parent;
			}
		}
	}
}
