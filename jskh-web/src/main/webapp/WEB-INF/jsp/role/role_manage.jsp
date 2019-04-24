<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>角色管理</title>

<link rel="stylesheet" href="/static/public/css/xadmin.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<!--<div class="layui-body">-->
		<div class="layui-row layui-col-space15">
			<!-- 内容主体区域 -->
			<!--table表格部分 -->
			<div class="layui-col-md12 layui-content-white">
				<table class="layui-hide" id="demoList" lay-filter="demoList"></table>
			</div>
		</div>
		<!--</div>-->
	</div>
	<script src="${path}/static/js/role/role_manage.js"></script>
	<script type="text/html" id="toolbarDemo">
			<div class="layui-btn-container">
				<button class="layui-btn layui-btn-danger" lay-event="delAll">批量删除</button>
			 	<button class="layui-btn" lay-event="add">添加</button>
			</div>
		</script>
	<script type="text/html" id="barDemo">
		{{#  if(d.status == 1){ }}
			<a  class="layui-btn layui-btn-primary layui-btn-xs" lay-event="updateStatus" href="javascript:;"  title="停用">
            	<i class="layui-icon">&#xe601;</i>
            </a>
		{{#  } else if(d.status == 2) { }}
			<a  class="layui-btn layui-btn-primary layui-btn-xs" lay-event="updateStatus" href="javascript:;"  title="启用">
            	<i class="layui-icon">&#xe62f;</i>
            </a>
		{{#  } }}
			<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="roleMenuRel">权限</a>
			<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
	<script type="text/html" id="isDefaultTem">
  		{{#  if(d.isDefault == 1){ }}
			是
  		{{#  } else { }}
    		<button class="layui-btn layui-btn-xs" lay-event="setDefault">设为默认</button>
  		{{#  } }}
		</script>
	<script type="text/html" id="statusTem">
  		{{#  if(d.status == 1){ }}
			<span class="layui-btn layui-btn-sm layui-btn-mini status-btn">已启用</span>
  		{{#  } else if(d.status == 2) { }}
			<span class="layui-btn layui-btn-sm layui-btn-mini status-btn layui-btn-disabled">已停用</span>
  		{{#  } }}
		</script>
</body>
</html>