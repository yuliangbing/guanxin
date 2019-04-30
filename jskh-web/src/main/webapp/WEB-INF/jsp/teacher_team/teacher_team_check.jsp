<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/js/teacher_team/teacher_team_List.js"></script>
<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:10%;margin-top:2%">
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">主键</label>
					<div class="layui-input-inline">
						<input name="id" id="id" disabled  autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">专业id</label>
					<div class="layui-input-inline">
						<input name="specialty_id"  id="specialty_id" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">专业编码</label>
					<div class="layui-input-inline">
						<input name="specialty_code" id="specialty_code" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">专业名称</label>
					<div class="layui-input-inline">
						<input name="specialty_name" id="specialty_name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">团队变更时间</label>
					<div class="layui-input-inline">
						<input name="date" id="date" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">专业教师团队</label>
					<div class="layui-input-inline">
						<input name="specialty_teachers" id="specialty_teachers" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">兼职教师团队</label>
					<div class="layui-input-inline"  >
						<input name="part_time_teachers" id="part_time_teachers" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">团队总负责人</label>
					<div class="layui-input-inline">
						<input name="director"  id="director" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">是否最新</label>
					<div class="layui-input-inline">
						<input name="latest"  id="latest" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">创建时间</label>
					<div class="layui-input-inline">
						<input name="create_time"  id="create_time" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">创建人</label>
					<div class="layui-input-inline">
						<input name="create_user"  id="create_user" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">修改时间</label>
					<div class="layui-input-inline">
						<input name="modify_time"  id="modify_time" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">修改人</label>
					<div class="layui-input-inline">
						<input name="modify_user"  id="modify_user" disabled autocomplete="off" class="layui-input">
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
		$("#specialty_id").val(data.specialty_id);
		$("#specialty_code").val(data.specialty_code);
		$("specialty_name").val(data.specialty_name);
		$("#date").val(data.date);
		$("#specialty_teachers").val(data.specialty_teachers);
		$("#part_time_teachers").val(data.part_time_teachers);
		$("#director").val(data.director);
		$("#latest").val(data.latest);
		$("#create_time").val(data.create_time);
		$("#create_user").val(data.create_user);
		$("#modify_time").val(data.modify_time);
		$("#modify_user").val(data.modify_user);
	}
   	</script>
</html>