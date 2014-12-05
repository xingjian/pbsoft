package com.promise.cn.framework.view
{
	import flash.display.Sprite;
	
	import mx.controls.DataGrid;
	
	public class PBDataGrid extends DataGrid
	{
		private var _rowColorFunction:Function;  
		private var _customed:Boolean;  
		private var _customerColor:uint=0;
		public function PBDataGrid()
		{
			super();
		}
		
		override protected function drawRowBackground(s:Sprite, rowIndex:int, y:Number, height:Number, color:uint, dataIndex:int):void  
		{  
			if (_customed==true)  
			{  
				if(this._rowColorFunction != null&&null!==this.dataProvider)  
				{  
					if (dataIndex < this.dataProvider.length)  
					{  
						var item:Object=this.dataProvider.getItemAt(dataIndex);//设定颜色  
						color=this._rowColorFunction.call(this, item, color);  
					}  
				}  
				else  
				{  
					if (this._customerColor!=0)  
					{  
						if (dataIndex < this.dataProvider.length)  
						{  
							color=this._customerColor;  
						}  
					}  
				}  
			}  
			super.drawRowBackground(s, rowIndex, y, height, color, dataIndex);  
		}   
		
		override public function set columns(value:Array):void  
		{  
			super.columns = value;  
		}  
		
		override public function set dataProvider(value:Object):void  
		{  
			super.dataProvider = value;  
		}  
		
		public function set rowColorFunction(rowColorFunction:Function):void  
		{  
			this._rowColorFunction=rowColorFunction;  
		}  
		
		public function get rowColorFunction():Function  
		{  
			return this._rowColorFunction;  
		}  
		
		public function set customed(customed:Boolean):void  
		{  
			_customed=customed;  
		}  
		
		public function get customed():Boolean  
		{  
			return _customed;  
		}  
		
		public function set customerColor(customerColor:uint):void  
		{  
			_customerColor=customerColor;  
		}  
		
		public function get customerColor():uint  
		{  
			return _customerColor;  
		}  
	}
}