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
<script type="text/javascript" src="${path}/static/js/menu/menu_edit.js"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
	<div class="x-body layui-anim layui-anim-up">
		<form class="layui-form">
			<input type="hidden" id="menuId" />
			<div class="layui-form-item" id="parentMenu" style="display: none;">
				<input type="hidden" id="parentId" /> <input type="hidden"
					id="parentNum" /> <label for="parentStr" class="layui-form-label">
					<span class="x-red">*</span>父菜单
				</label>
				<div class="layui-input-inline">
					<input type="text" id="parentStr" name="parentStr" required=""
						readonly="readonly" lay-verify="email" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="menuStr" class="layui-form-label"> <span
					class="x-red">*</span>菜单名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="menuStr" name="menuStr" required=""
						lay-verify="email" autocomplete="off" class="layui-input">
				</div>
				<label for="menuNum" class="layui-form-label"> <span
					class="x-red">*</span>菜单编号
				</label>
				<div class="layui-input-inline">
					<input type="text" id="menuNum" name="menuNum" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="url" class="layui-form-label">菜单地址
				</label>
				<div class="layui-input-inline">
					<input type="text" id="url" name="url" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input">
				</div>
				<label for="menuOrder" class="layui-form-label">排序 </label>
				<div class="layui-input-inline">
					<input type="text" id="menuOrder" name="menuOrder" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="showType" class="layui-form-label"> <span
					class="x-red">*</span>是否显示
				</label>
				<div class="layui-input-inline">
					<select id="showType" name="showType" class="valid">
						<option value="1">是</option>
						<option value="2">否</option>
					</select>
				</div>
				<label for="remark" class="layui-form-label">备注 </label>
				<div class="layui-input-inline">
					<input type="password" id="remark" name="remark" required=""
						lay-verify="repass" autocomplete="off" class="layui-input">
				</div>
			</div>
		</form>
	</div>
</body>
</html>