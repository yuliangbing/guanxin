<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/js/specialty/specialty_List.js"></script>
<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:10%;margin-top:2%">
				<div class="layui-inline">
					<label class="layui-form-label">主键</label>
					<div class="layui-input-inline">
						<input name="id" id="id" disabled  autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">设立时间</label>
					<div class="layui-input-inline">
						<input name="setup_date" id="setupDate" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label">专业编码</label>
					<div class="layui-input-inline">
						<input name="code" id="code" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">专业名称</label>
					<div class="layui-input-inline">
						<input name="name" id="name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>

				
			</div>
		</form>
	</body>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
   	<script>
   	function init(data) {

   		$("#id").val(data.id);
		$("#setupDate").val((data.setupDate.split(' '))[0]);
		$("#code").val(data.code);
		$("#name").val(data.name);
	
	}
   	</script>
</html>