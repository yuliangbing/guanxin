<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/issues/issues_List.js"></script>
</head>
<body >
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:18%;margin-top:2%">
				<div class="layui-inline">
					<label class="layui-form-label">主键</label>
					<div class="layui-input-inline">
						<input name="id" id="id" disabled  autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">时间</label>
					<div class="layui-input-inline">
						<input name="date" id="date" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">立项编号</label>
					<div class="layui-input-inline">
						<input name="code" id="code" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">课题名称</label>
					<div class="layui-input-inline">
						<input name="name" id="name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">课题来源</label>
					<div class="layui-input-inline">
						<input name="sources" id="sources" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">主持人</label>
					<div class="layui-input-inline">
						<input name="host" id="host" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">参与人</label>
					<div class="layui-input-inline"  >
						<input name="participants" id="participants" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业</label>
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
				
					<label  class="layui-form-label">获奖情况</label>
					<div class="layui-input-inline">
						<textarea  class="layui-textarea" disabled id="awards_construction" style="width:272%;"></textarea>
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
		$("#date").val((data.date.split(' '))[0]);
		$("#code").val(data.code);
		$("#name").val(data.name);
		$("#sources").val(data.sources);
		$("#awards_construction").val(data.awards_construction);
		$("#host").val(data.host);
		$("#participants").val(data.participants);
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