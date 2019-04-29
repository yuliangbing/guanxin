<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet"
	href="${path}/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<link rel="stylesheet" href="${path}/static/public/css/teacher.css">
<script type="text/javascript" src="${path}/static/js/other_achievements/other_List.js"></script>
<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" action="">

			
				<!--时间-->
		<div class="layui-form-item ">
			<div class="layui-inline">
             <label class="layui-form-label">时间</label>
				<div class="layui-input-inline">
						<input type="text" class="layui-input" id="date" name="date"  disabled  placeholder="请选择时间">
				</div>
			</div>
		</div>
		
		<!--成果名称-->
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">成果名称</label>
					<div class="layui-input-inline ">
						 <input type="text" name="name" required  lay-verify="required" placeholder="请输入内容" disabled  autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
			
		<!--成果来源-->
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">成果来源</label>
					<div class="layui-input-inline ">
						 <input type="text" name="sources" required  lay-verify="required"  placeholder="请输入内容" disabled  autocomplete="off" class="layui-input">
						
					</div>
				</div>
			</div>
			<!--成果级别-->
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">成果级别</label>
					<div class="layui-input-inline ">
						 <input type="text" name="level" required  lay-verify="required" placeholder="请输入内容"  disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
		
		<!--第一作者-->
		
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">第一作者</label>
					<div class="layui-input-inline ">
						 <input type="text" name="first-author" required  lay-verify="required" placeholder="请输入内容"  disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
		
		<!--其他作者-->
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">其他作者</label>
					<div class="layui-input-inline ">
				 <input type="text" name="other-author" required  lay-verify="required" placeholder="请输入内容"  disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
				
		</form>
	</body>
</html>