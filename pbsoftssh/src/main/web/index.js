var Login = {     
    author: "Seraph",    
    version: "0.1.0"   
};    
   
var loginPanel;    
   
Ext.onReady(function(){    
        
        var loginFormPanel = new Ext.FormPanel({    
            id: 'login-form',    
            renderTo: Ext.getBody(),    
            labelWidth: 55,    
            frame: false,    
            defaults: {
                width: 130,    
                anchor: '88%',    
                allowBlank: false,    
                selectOnFocus: true,    
                msgTarget: 'side'   
            },    
            defaultType: 'textfield',    
            method: 'POST',    
            bodyBorder: false,    
            border: false,    
            items: [    
                {   xtype: 'combo',    
                    store: store,    
                    id: 'j_username',    
                    name: 'j_username',    
                    fieldLabel: '用户名',    
                    displayField: 'userName',    
                    valueField: 'userName',    
                    typeAhead: true,    
                    mode: 'local',    
                    triggerAction: 'all',    
                    selectOnFocus: true,    
                    allowBlank: false,    
                    blankText: '请输入用户名'   
                },{    
                    id: 'j_password',    
                    name: 'j_password',    
                    fieldLabel: '密&nbsp;&nbsp;&nbsp;码',    
                    inputType: 'password',    
                    blankText: '请输入密码'   
                }]    ,
            buttons: [{    
                        text:'登录'  
                          
                    },{    
                        text: '重置'    
                    }]    
        });  
        var LoginPanel = {    
            
    show : function() {    
        loginPanel.show();    
    }    
}
loginPanel.show();
}

);    
   
  
