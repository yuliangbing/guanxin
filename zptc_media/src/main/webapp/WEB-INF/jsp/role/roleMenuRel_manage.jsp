<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>角色权限管理</title>

<link rel="stylesheet" href="${path}/static/public/css/font.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<style type="text/css">
body {
	overflow-y: auto;
}

form {
	width: 500px;
	margin: 10px auto;
}

h1, h2, h3 {
	padding: 10px 0;
}

a {
	text-align: right;
	font-size: 18px;
	color: #1C86EE;
}

.xtree_contianer {
	width: 500px;
	border: 1px solid #9C9C9C;
	overflow: auto;
	margin-bottom: 30px;
	background-color: #fff;
	padding: 10px 0 25px 5px;
}

.div-btns {
	margin: 20px 0;
}

.layui-form-label {
	width: 60px !important;
}
</style>
</head>
<body>
	<div class="x-body">
		<form action="" method="post" class="layui-form layui-form-pane">
			<input type="hidden" id="roleId" />
			<div class="layui-form-item">
				<label for="name" style="width: max-content;" id="roleName">
					角色名 :</label>
			</div>
			<div id="xtree1" class="xtree_contianer"></div>
			<div class="layui-form-item">
				<a class="layui-btn" onclick="save()">保存</a>
			</div>
		</form>
	</div>
</body>
<script src="${path}/static/js/role/roleMenuRel_manage.js"></script>
<script src="${path}/static/js/layui-xtree.js"></script>
</html>