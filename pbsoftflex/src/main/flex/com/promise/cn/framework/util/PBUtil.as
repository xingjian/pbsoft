/**
 * 文件名:PBUtil.as
 * 作者：   promisepb
 * 功能：  工具类
 * 联系:  xingjian@yeah.net
 * 版本：   0.1
 **/
package com.promise.cn.framework.util
{
	import mx.controls.DateField;
	import mx.formatters.DateFormatter;
	import mx.utils.ObjectUtil;
	
	public class PBUtil
	{
		//构造函数
		public function PBUtil(){
		
		}
		
		//生成随机码
		public static function GenerateCheckCode():String{
			//初始化
			var ran:Number;
			var number:Number;
			var  code:String;
			var checkCode:String ="";
			//生成四位随机数
			for(var i:int=0; i<4; i++){
				//Math.random生成数为类似为0.1234
				ran=Math.random();
				number =Math.round(ran*10000); 
				//如果是2的倍数生成一个数字
				if(number % 2 == 0){
					//"0"的ASCII码是48  
					code = String.fromCharCode(48+(number % 10)); 
					//生成一个字母
				}else{  
					//"A"的ASCII码为65
					code = String.fromCharCode(65+(number % 26)) ;
				}
				checkCode += code;
			}
			return checkCode;
		}
		
		//日期转换成字符串
		public static function DateToString(formatString:String,date:Date):String{
			var myDateFormatter:DateFormatter = new DateFormatter();
			myDateFormatter.formatString = formatString;
			return myDateFormatter.format(date);
		}
		//字符串变成日期MM-DD-YYYY
		public static function StringToDate(date:String):Date{
			var dateArray:Array = date.split("-");
			return new Date(dateArray[2],dateArray[0]-1,dateArray[1]);
		}
		
		//日期做比较
		public static function CompareDate(firstDate:String,secondDate:String):Boolean{
			if(ObjectUtil.dateCompare(DateField.stringToDate(firstDate,"YYYY-MM-DD JJ:NN:SS"),DateField.stringToDate(secondDate,"YYYY-MM-DD JJ:NN:SS")) == -1){
				return true;
			}else{
				return false;
			}

		}
	}
}