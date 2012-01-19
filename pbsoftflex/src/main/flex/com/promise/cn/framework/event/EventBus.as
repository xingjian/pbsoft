package com.promise.cn.framework.event
{
import flash.events.Event;
import flash.events.EventDispatcher;
import flash.events.IEventDispatcher;
/**
 * 事件纷发器 
 */
public class EventBus extends EventDispatcher
{
	public static const instance:EventBus = new EventBus();
	
	public function EventBus(target:IEventDispatcher=null){
		super(target);
	}
	
	[Deprecated(replacement="instance")]
	public static function getInstance():EventBus{
		return instance;
	}
	
	[Deprecated(replacement="AppEvent.dispatch")]
	public function dispatch(type:String):Boolean{
		return dispatchEvent(new Event(type));
	}
}
}