<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
	<script type="text/javascript" src="${path}/static/js/specialty_profile/speProfile_List.js"></script>
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
					<label class="layui-form-label">专业id</label>
					<div class="layui-input-inline">
						<input name="specialty_id"  id="specialty_id" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业名称</label>
					<div class="layui-input-inline">
						<input name="specialty_name"  id="specialty_name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">年份</label>
					<div class="layui-input-inline">
						<input name="date" id="date" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label">专业定位</label>
					<div class="layui-input-inline">
						<input name="position" id="position" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">专业特色</label>
					<div class="layui-input-inline">
						<input name="characteristic" id="characteristic" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业负责人ID</label>
					<div class="layui-input-inline">
						<input name="director_id" id="director_id" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业负责人姓名</label>
					<div class="layui-input-inline"  >
						<input name="director_name" id="director_name" disabled autocomplete="off" class="layui-input">
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
		$("#specialty_name").val(data.specialty_name);
		$("#date").val(data.date);
		$("#position").val(data.position);
		$("#characteristic").val(data.characteristic);
		$("#director_id").val(data.director_id);
		$("#director_name").val(data.director_name);
		//$("#branch_introduction").val(data.branch_introduction);
		
	}
   	</script>
</html>