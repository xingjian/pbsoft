package com.promise.cn.framework.util
{
	import mx.collections.ArrayCollection;
	import mx.core.IVisualElement;
	
	import spark.components.NavigatorContent;

	public class ControlManageServer
	{
		[Bindable]
		public var registerArray:ArrayCollection = new ArrayCollection();
		
		public function ControlManageServer()
		{
		}
		
		//通过名字返回
		public function getIVisualElementByName(name:String):NavigatorContent{
			for(var j:int;j<registerArray.length;j++){
				var messObject:Object = registerArray.getItemAt(j);
				if(messObject.name==name){
					return messObject.element as NavigatorContent;
					break;
				}
			}
			return null;
		}
		
		//注册使用
		public function registerMessageHandleObject(element:NavigatorContent,name:String):void{
			var object:Object = {element:element,name:name};
			//判断是否重复
			if(isExist(name)){
				registerArray.addItem(object);
			}
		}
		
		//判断是否重复存在  true 代表不重复  false代表重复
		public function isExist(name:String):Boolean{
			var boolean:Boolean = true;
			for(var j:int;j<registerArray.length;j++){
				var messObject:Object = registerArray.getItemAt(j);
				if(messObject.name==name){
					boolean = false;
					break;
				}
			}
			return boolean;
		}
		
		//注销
		public function deleteRegisterArrayByName(name:String):void{
			for(var i:int=0;i<registerArray.length;i++){
				if(registerArray.getItemAt(i).name==name){
					registerArray.removeItemAt(i);
					registerArray.refresh();
					break;
				}
			}
		}
		
		//注销全部
		public function deleteRegisterArray():void{
			registerArray.removeAll();
		}
	}
}