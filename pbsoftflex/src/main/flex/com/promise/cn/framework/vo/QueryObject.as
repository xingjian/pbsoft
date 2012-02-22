package com.promise.cn.framework.vo
{	
	[Bindable]
	[RemoteClass(alias="com.promise.cn.framework.support.QueryObject")]
	public class QueryObject
	{
		public var key:String;
		public var value:String;
		public var queryType:String;//0等值查询 1模糊查询  2大于查询 3小于查询
		public var andOr:String;
        public var className:String;//hibernate的类值
		public function QueryObject(value:Object=null)
		{
	         if(value != null){
				this.key=value.key;
				this.value=value.value;
				this.queryType=value.queryType;
				this.andOr = value.andOr;
	            this.className = value.className;
	          }
		}
	}
}
