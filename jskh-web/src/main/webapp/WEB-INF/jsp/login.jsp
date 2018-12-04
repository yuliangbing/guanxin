<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<html lang="zh">
<head>
<%@ include file="/WEB-INF/Common.jsp"%>
<title>登录页</title>
<link rel="stylesheet" type="text/css" href="${path}/static/public/css/login.css" />
<script src="${path}/static/js/login.js" type="text/javascript" charset="utf-8"></script>
<title>浙江邮电职业技术学院管理系统</title>
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
				<img src="${path}/static/public/images/logo.png"/>
				<div style="font-size:40px;margin-left:10px;display:inline-block">
					<div style="position: relative;top: 8px;">教师管理系统</div>
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
					<!-- <input style="margin: 4% 10%;" type="button" id="login" value="立即登录" /> -->
				</div>
			</div>
		</div>
	</div>
</body>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
});
</script>
</html>