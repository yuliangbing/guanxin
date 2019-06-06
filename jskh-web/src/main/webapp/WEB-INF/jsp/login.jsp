<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" type="text/css" href="${path}/static/public/css/login.css" />
<%-- <title>浙江邮电职业技术学院${systemName}</title> --%>
<title>专业发展平台</title>
<%-- <link rel="icon" href="${path}/static/public/images/title.ico" type="image/x-icon" /> --%>
<link rel="icon" href="${path}/static/public/images/wuyecao.png" type="image/x-icon" />
<style type="text/css">
	.layui-form-radio * {
	    font-size: 20px;
	    color: #fff;
	}
	.layui-input-block{
		margin-left:80px;
	}
</style>
</head>
<body class="login-bg" onkeydown="KeyDown(event);">
	<div class="container">
		<div class="header">
			<div class="logo">
				<%-- <img src="${path}/static/public/images/logo.png"/> --%>
				<div style="font-size:35px;margin-left:10px;display:inline-block">
				<%-- 	<div style="position: relative;top: 8px;">${systemName}</div> --%>
					<div style="position: relative;top: 22px;">专业发展平台</div>
				</div>	
			</div>
			
		</div>
		<div class="content">
			<div class="form">	
				<div style="color: #FFFFFF;font-size: 24px;margin: 5%;">登录</div>
				<div class="one">
					<img src="${path}/static/public/images/user.png" alt="" />
					<input style="font-size: 21px;margin-left: 5%;" type="text" id="username" value="" placeholder="请输入账号" />
				</div>
				<div class="two">
					<img src="${path}/static/public/images/pw.png" alt="" />
					<input style="font-size: 21px;margin-left: 5%;" type="password" id="password" value="" placeholder="请输入密码" />
				</div>
				<div class="three">
					<input type="text" name="valiDate" id="valiDate" class="login-yzm" value="" placeholder="请输入验证码" />
					<img id="imgVerify" src="" alt="更换验证码" onclick="getVerify(this);"/>
				</div>
				<div class="five">
					<a class="layui-btn layui-btn-normal layui-btn-fluid" id="login" style="height:50px;line-height:50px">立即登录</a>
				</div>
			</div>
		</div>
		 <div class="footer">Copyright © 2018 浙江邮电职业技术学院${systemName} v1.0.0</div>
	
	</div>
</body>
<script src="${path}/static/js/login.js" type="text/javascript" charset="utf-8"></script>
<script>	
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
});
</script>
</html>