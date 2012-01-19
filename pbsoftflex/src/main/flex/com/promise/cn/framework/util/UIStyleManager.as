/**
 * 文件名:UIStyleManager.as
 * 作者：   promisepb
 * 功能：   管理样式
 * 联系:  xingjian@yeah.net
 * 版本：   0.1
 **/
package com.promise.cn.framework.util
{
	import com.promise.cn.framework.event.AppEvent;
	import mx.core.FlexGlobals;
	import mx.styles.CSSStyleDeclaration;
	import mx.styles.IStyleManager2;

	public class UIStyleManager
	{
		//构造函数
		public function UIStyleManager()
		{
			AppEvent.addListener(PBConstant.APP_CREATECOMPLETE,loadStyleHandler);
		}
		
		//开始加载样式
		public function loadStyleHandler(event:AppEvent):void{
			setViewStyle(Global.styleXML);
		}
		
		//设置样式方法
		public function setViewStyle(xml:XML):void{
			var fontFamily:String = xml.font.@name;
			var fontSize:String = xml.font.@size;
			var topLevelStyleManager:IStyleManager2 = FlexGlobals.topLevelApplication.styleManager;
			var cssStyleDeclarationGlobal:CSSStyleDeclaration = topLevelStyleManager.getStyleDeclaration("global")
			if(fontFamily!=null&&fontFamily!=""){
				cssStyleDeclarationGlobal.setStyle("fontFamily",fontFamily);
			}
			if(fontSize!=null&&fontSize!=""){
				cssStyleDeclarationGlobal.setStyle("fontSize",fontSize);
			}
		}
	}
}