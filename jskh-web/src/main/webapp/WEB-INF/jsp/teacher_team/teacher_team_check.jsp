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
					<label class="layui-form-label" style="width: 84px;">专业编码</label>
					<div class="layui-input-inline">
						<input name="specialtyCode" id="specialtyCode" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">专业id</label>
					<div class="layui-input-inline">
						<input name="specialtyName" id="specialtyName" disabled autocomplete="off" class="layui-input">
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
						<input name="specialtyTeachers" id="specialtyTeachers" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">兼职教师团队</label>
					<div class="layui-input-inline"  >
						<input name="partTimeTeachers" id="partTimeTeachers" disabled autocomplete="off" class="layui-input">
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
				<!-- <div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">创建时间</label>
					<div class="layui-input-inline">
						<input name="createTime"  id="createTime" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">创建人</label>
					<div class="layui-input-inline">
						<input name="createUser"  id="createUser" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">修改时间</label>
					<div class="layui-input-inline">
						<input name="modifyTime"  id="modifyTime" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 84px;">修改人</label>
					<div class="layui-input-inline">
						<input name="modifyUser"  id="modifyUser" disabled autocomplete="off" class="layui-input">
					</div>
				</div> -->
			</div>
		</form>
	</body>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
   	<script>
   	function init(data) {
   		$("#id").val(data.id);
		$("#specialtyId").val(data.specialtyId);
		$("#specialtyCode").val(data.specialtyCode);
		$("#specialtyName").val(data.specialtyName);
		$("#date").val((data.date.split(' '))[0]);
		$("#specialtyTeachers").val(data.specialtyTeachers);
		$("#partTimeTeachers").val(data.partTimeTeachers);
		$("#director").val(data.director);
		$("#latest").val(data.latest==1?'是':'否');
		$("#createTime").val(data.createTime);
		$("#createUser").val(data.createUser);
		$("#modifyTime").val(data.modifyTime);
		$("#modifyUser").val(data.modifyUser);
		specialty_name = data.specialty_name;
	}
   	</script>
</html>