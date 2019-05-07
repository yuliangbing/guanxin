<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/js/outstanding_graduate_history/outstanding_graduate_history_List.js"></script>
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
					<label class="layui-form-label">毕业时间</label>
					<div class="layui-input-inline">
						<input name="date" id="date" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-inline">
						<input name="name" id="name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">公司</label>
					<div class="layui-input-inline">
						<input name="company" id="company" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">岗位</label>
					<div class="layui-input-inline">
						<input name="position" id="position" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">薪资</label>
					<div class="layui-input-inline">
						<input name="salary" id="salary" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业id</label>
					<div class="layui-input-inline">
						<input name="specialty_name"  id="specialty_name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-inline">
						<input name="create_time"  id="create_time" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">创建人</label>
					<div class="layui-input-inline">
						<input name="create_user"  id="create_user" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">修改时间</label>
					<div class="layui-input-inline">
						<input name="modify_time"  id="modify_time" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">修改人</label>
					<div class="layui-input-inline">
						<input name="modify_user"  id="modify_user" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
				
					<label  class="layui-form-label">先进描述</label>
					<div class="layui-input-inline">
						<textarea  class="layui-textarea" disabled id="advanced_description" style="width: 440%;"></textarea>
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
		$("#date").val(data.date);
		$("#graduate_num").val(data.graduate_num);
		$("#employed_num").val(data.employed_num);
		$("#entrepreneurs_num").val(data.entrepreneurs_num);
		$("#employment_rate").val(data.employment_rate);
		$("#specialty_id").val(data.specialty_id);
		$("#specialty_name").val(data.specialty_name);
		$("#status").val(data.status);
		$("#create_time").val(data.create_time);
		$("#create_user").val(data.create_user);
		$("#modify_time").val(data.modify_time);
		$("#modify_user").val(data.modify_user);
		specialty_name = data.specialty_name;
	}
   	</script>
</html>