/**
 * 文件名:PBUtil.as
 * 作者：   promisepb
 * 功能：  工具类
 * 联系:  xingjian@yeah.net
 * 版本：   0.1
 **/
package com.promise.cn.framework.util
{
	
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
	}
}