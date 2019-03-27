$(document).ready(function() {
	if (window.top != null && window.top.document.URL != document.URL) {
		window.top.location = document.URL;
	}
	$("#imgVerify").attr('src',window.path + "/home/getVerify?"+Math.random());
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
    obj.src = window.path + "/home/getVerify?"+Math.random();
}

function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	var valiDate = $("#valiDate").val();
	if(username =="" || password ==""){
		alert("请填写登录信息");
		return;
	}
	else{
		console.log(window.path +"/home/login")
		$.ajax({ 
		     type : "POST", //提交方式 
		     url : window.path +"/home/login",//路径 
		     data : { 
		    	 "username": username,
			     "password": password,
			     "valiDate": valiDate
		     },//数据，这里使用的是Json格式进行传输 
		     dataType:"json",
		     success : function(result) {//返回数据根据结果进行相应的处理 
		    	 if (result.status == "200") { 
		    		window.location.href="/toPage?page=index"; 
			     } else { 
			    	layer.msg(result.msg);
			    	$("#imgVerify").attr('src', window.path+"/home/getVerify?"+Math.random());
			     } 
		     },
		     error : function(XMLHttpRequest, textStatus, errorThrown){
		    	 layer.msg("系统错误");
		     } 
		}); 
	}
}
