<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>专业文件</title>
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<link rel="stylesheet" href="${path}/static/public/css/common.css">
</head>
<body class="layui-body my-body" style="height: 100%">
	<div class="x-body layui-anim layui-anim-up">
		<form class="layui-form center-div my-center-div">
			<div class="layui-form-item">
				<input type="hidden" id="roleId" /> <label for="roleName"
					class="layui-form-label"> <span class="x-red">*</span>角色名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="roleName" name="roleName" required=""
						lay-verify="email" autocomplete="off" class="layui-input">
				</div>
				<label for="roleNum" class="layui-form-label">角色编号 </label>
				<div class="layui-input-inline">
					<input type="text" id="" roleNum"" name="" roleNum"" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="roleOrder" class="layui-form-label">排序 </label>
				<div class="layui-input-inline">
					<input type="text" id="menuOrder" name="roleOrder" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input">
				</div>
			</div>
		</form>
		<div class="center-div my-center-div">
			<button class="layui-btn layui-right layui-btn-sm"
				onclick="editConfirm()">保存</button>
			<button class="layui-btn layui-btn-normal layui-btn-sm"
				onclick="x_admin_close();">关闭</button>
		</div>
	</div>
</body>
<script type="text/javascript" src="${path}/static/js/role/role_edit.js"></script>
</html>