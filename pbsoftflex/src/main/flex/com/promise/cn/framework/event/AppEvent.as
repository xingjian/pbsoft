package com.promise.cn.framework.event
{
	import flash.events.Event;
	
	public class AppEvent extends Event
	{
		public static const APP_ERROR:String = "appError";
		//事件传递数据对象
		private var _data:Object;
		//回调函数
		private var _callback:Function;
		
		public function AppEvent(type:String,data:Object = null, callback:Function = null){
			super(type, bubbles, cancelable);
			if(data!=null){
				_data = data;
				_callback = callback;
			}
		}
		
		public function get callback():Function{
			return _callback;
		}
		
		public function set callback(value:Function):void
		{
			_callback = value;
		}
		
		public function get data():Object{
			return _data;
		}
		
		public function set data(data:Object):void{
			this._data = data;
		}
		
		public function dispatch():Boolean{
			return EventBus.instance.dispatchEvent(this);
		}
		
		public static function dispatch(type:String, data:Object = null, callback:Function = null):Boolean{
			return EventBus.instance.dispatchEvent(new AppEvent(type, data, callback));
		}
		
		public static function addListener(type:String, listener:Function, useCapture:Boolean = false, priority:int = 0, useWeakReference:Boolean = false):void{
			EventBus.instance.addEventListener(type, listener, useCapture, priority, useWeakReference);
		}
		
		public static function removeListener(type:String, listener:Function, useCapture:Boolean = false):void{
			EventBus.instance.removeEventListener(type, listener, useCapture);
		}
		
		public static function showError(errorStr:String):void{
			AppEvent.dispatch(AppEvent.APP_ERROR,errorStr);
		}
	}
}