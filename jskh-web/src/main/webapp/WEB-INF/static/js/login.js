$(document).ready(function() {
	if (window.top != null && window.top.document.URL != document.URL) {
		window.top.location = document.URL;
	}
	$("#imgVerify").attr('src',window.path + "/getVerify?"+Math.random());
	// 立即登录
	$("#login").click(function() {
		login();
	})
});

function KeyDown(e) {
    e = window.event || e;
    var ke = e.keyCode || e.which;
    if (ke == 13) {
        login();
    }
}

//获取验证码
function getVerify(obj){
    obj.src = window.path + "/getVerify?"+Math.random();
}

function login(){
	if($("#username").val()==""||$("#password").val()==""){
		alert("请填写登录信息");
		return;
	}
	else{
		console.log(window.path +"/login/login")
		$.ajax({ 
		     type : "POST", //提交方式 
		     url : window.path +"/login/login",//路径 
		     data : { 
		    	 "userName" : $("#username").val(),
			     "userPassword" :$("#password").val(),
			     "valiDate" :$("#valiDate").val(),
			     "login_type" : $("input[name='login-type']:checked").val()
		     },//数据，这里使用的是Json格式进行传输 
		     dataType:"json",
		     success : function(result) {//返回数据根据结果进行相应的处理 
		    	 if (result.success == "1") { 
		    		 console.log(result)
		    		 if(result.data=="qxgmm"){
		    			 window.location.href="/zptc_system/system_pswChange"; 
		    		 }else{
		    			 window.location.href="/zptc_system/index"; 
		    		 }
			     } else { 
			    	 layer.msg(result.retMsg);
			    	 $("#imgVerify").attr('src', window.path+"/login/getVerify?"+Math.random());
			     } 
		     },
		     error : function(XMLHttpRequest, textStatus, errorThrown){
		    	 layer.msg(result);
		     } 
		}); 
	}
}
