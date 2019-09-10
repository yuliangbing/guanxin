<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<script type="text/javascript"
	src="${path}/static/js/menu/menu_manage.js"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body class="layui-layout-body">
	<div class="x-body">
		<xblock>
		<button class="layui-btn" onclick="add()">
			<i class="layui-icon">&#xe654;</i>新增父菜单
		</button>
		</xblock>
		<table class="layui-table layui-form">
			<thead>
				<tr>
					<th style="min-width: 150px;">菜单名称</th>
					<th>菜单编号</th>
					<th>菜单地址</th>
					<th>图标</th>
					<th style="width: 220px">操作</th>
				</tr>
			</thead>
			<tbody class="x-cate" id="menuTableBody">
			</tbody>
		</table>
	</div>
</body>
</html>