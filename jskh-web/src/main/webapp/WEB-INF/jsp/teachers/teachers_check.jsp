<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/js/teachers/teachers_List.js"></script>
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
					<label class="layui-form-label">教师姓名</label>
					<div class="layui-input-inline">
						<input name="name" id="name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">教师编号</label>
					<div class="layui-input-inline">
						<input name="code" id="code" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入职时间</label>
					<div class="layui-input-inline">
						<input name="entry_time" id="entry_time" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">出生时间</label>
					<div class="layui-input-inline">
						<input name="birthday" id="birthday" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">毕业院校</label>
					<div class="layui-input-inline">
						<input name="graduate_school" id="graduate_school" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">学历学位</label>
					<div class="layui-input-inline"  >
						<input name="final_degree" id="final_degree" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">政治面貌</label>
					<div class="layui-input-inline">
						<input name="political_status"  id="political_status" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业编码</label>
					<div class="layui-input-inline">
						<input name="specialty_code"  id="specialty_code" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">研究方向</label>
					<div class="layui-input-inline">
						<input name="research_direction"  id="research_direction" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">是否兼职</label>
					<div class="layui-input-inline">
						<input name="is_part_time"  id="is_part_time" disabled autocomplete="off" class="layui-input">
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
			</div>
		</form>
	</body>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  		<script src="${path}/static/public/lib/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
	//表格数据传值
	function init(data) {

		$("#id").val(data.id);
		$("#name").val(data.name);
		$("#code").val(data.code);
		$("#entry_time").val(data.entry_time);
		$("#birthday").val(data.birthday);
		$("#graduate_school").val(data.graduate_school);
		$("#final_degree").val(data.final_degree);
		$("#political_status").val(data.political_status);
		$("#specialty_code").val(data.specialty_code);
		$("#specialty_name").val(data.specialty_id);
		$("#specialty_name").val(data.specialty_name);
		$("#research_direction").val(data.research_direction);
		$("#is_part_time").val(data.is_part_time);
		$("#create_time").val(data.create_time);
		$("#create_user").val(data.create_user);
		$("#modify_time").val(data.modify_time);
		$("#modify_user").val(data.modify_user);
		$("#specialty_id").val(data.specialty_id);
		$("#modify_user").val(data.modify_user);
		specialty_name = data.specialty_name;
	}
	</script>
</html>