<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/js/file_category/category_List.js"></script>
<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
<title></title>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:18%;margin-top:2%">
			<!-- <div class="layui-inline">
					<label class="layui-form-label">主键</label>
					<div class="layui-input-inline">
						<input name="id" id="id" disabled  autocomplete="off" class="layui-input">
					</div>
				</div>  -->
				<div class="layui-inline">
					<label class="layui-form-label">类型编码</label>
					<div class="layui-input-inline">
						<input name="code" id="code" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label" >类型名称</label>
					<div class="layui-input-inline">
						<input name="name" id="name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label" >创建时间</label>
					<div class="layui-input-inline">
						<input name="create_time" id="create_time" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" >创建人</label>
					<div class="layui-input-inline">
						<input name="create_user" id="create_user" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">修改时间</label>
					<div class="layui-input-inline"  >
						<input name="modify_time" id="modify_time" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">修改人</label>
					<div class="layui-input-inline"  >
						<input name="modify_user" id="modify_user" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				
		</form>
	</body>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
   	<script>
   	function init(data) {

   		$("#id").val(data.date);
   		$("#code").val(data.code);
		$("#name").val(data.name);
		$("#create_time").val(data.createTime);
		$("#create_user").val(data.createUser);
		$("#modify_time").val(data.modifyTime);
		$("#modify_user").val(data.modifyUser);
	
	}
   	</script>
</html>