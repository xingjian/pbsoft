package com.promise.cn.framework.util
{
	import com.promise.cn.common.vo.Menu;
	import com.promise.cn.common.vo.PBUser;
	
	import mx.collections.ArrayCollection;
	import mx.collections.ArrayList;
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.ISystemManager;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.http.HTTPService;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import spark.components.Application;
	import spark.components.TitleWindow;

	[Mixin]
	public class Global{
		public static var appName:String="";//程序名称
		public static var appWebName:String="";//应用部署的地址，注意/号,应对不同的部署名称情况
		public static var appBlazeUri:String="";
		private static var application:Global=null;
		public static var styleXML:XML = null;
		public static var pbUser:PBUser;//登录成功后自动初始化
		
		//传入[{label:"",uri:"",icon:"systemLogView",toolTip:""},"......."],返回[{},{}]
		public static function checkPowerArray(arr:Array):ArrayList{
			var res:ArrayList = new ArrayList();
			for(var i:uint=0;i<arr.length;i++){
				if(checkPower(arr[i].uri)){
					var obj:Object = new Object();
					obj["label"] = arr[i].label;
					obj["uri"] = arr[i].uri;
					if(arr[i].icon != undefined)
						obj["icon"] = arr[i].icon;
					if(arr[i].enabled != undefined)
						obj["enabled"] = arr[i].enabled;
					if(arr[i].toolTip != undefined)
						obj["toolTip"] = arr[i].toolTip;
					res.addItem(obj);
				}
			}
			return res;
		}
		
		//监测权限通过url
		public static function checkPower(url:String):Boolean{
			var menus:ArrayCollection = pbUser.menus;
			var retBoo:Boolean = false;
			if(null!=menus){
				for(var i:int=0;i<menus.length;i++){
					var menu:Menu = menus.getItemAt(i) as Menu;
					if(url==menu.url){
						retBoo = true;
						break;
					}
				}
			}
			return retBoo;
		}
		
		public static function init(systemManager:ISystemManager):void{
			var httpService:HTTPService=new HTTPService();
			httpService.url="mainconfig.xml";
			httpService.resultFormat="e4x";
			httpService.addEventListener(ResultEvent.RESULT,resultHandler);
			function resultHandler(r:ResultEvent):void{
				initKey(String(r.result));
			}
			httpService.send();
		}
		
		private static function initKey(s:String):void{
			var x:XML=new XML(s);
			appName=x.appName;
			appWebName=x.appWebName;
			appBlazeUri=appWebName+x.appBlazeUri;
			styleXML = new XML(x.style);
		}
		
		//返回远程对象
		public static function getRemoteObject(destination:String,resultHandler:Function=null,rfaultHandler:Function=null):RemoteObject{
			var service:ChannelSet=new ChannelSet();
			service.addChannel(new AMFChannel("amf",appBlazeUri));
			var ro:RemoteObject=new RemoteObject();
			ro.destination=destination;
			ro.channelSet=service;
			if(resultHandler != null){
				ro.addEventListener(ResultEvent.RESULT,resultHandler);
			}
			if(rfaultHandler != null){
				ro.addEventListener(FaultEvent.FAULT,rfaultHandler);
			}else{
				ro.addEventListener(FaultEvent.FAULT,faultHandler);
			}
			return ro;
		}
		
		public static function faultHandler(event:FaultEvent):void{
			Alert.show("服务发生错误，请稍后再试!\n错误原因:"+event.fault.faultDetail,"错误",1);
		}
		
		public static function getInstance():Global{
			if(application == null){
				application=new Global();
			}
			return application;
		}
		
		//弹出窗体居中
		public static function centerPopUpPos(displayObj:TitleWindow):void{
			var width = displayObj.width;
			var height = displayObj.height;
			var app_width:Number = ((Application)(FlexGlobals.topLevelApplication)).width;
			var app_height:Number = ((Application)(FlexGlobals.topLevelApplication)).height;
			displayObj.x = (app_width-width)/2;
			displayObj.y = (app_height-height)/2;
		}
	}
}