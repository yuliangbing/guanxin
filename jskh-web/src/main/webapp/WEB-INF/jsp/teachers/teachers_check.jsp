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
<script type="text/javascript" src="${path}/static/js/teachers/teachers_List.js"></script>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:18%;margin-top:2%">
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
						<input name="entryTime" id="entryTime" disabled autocomplete="off" class="layui-input">
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
						<input name="graduateSchool" id="graduateSchool" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">学历学位</label>
					<div class="layui-input-inline"  >
						<input name="finalDegree" id="finalDegree" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">政治面貌</label>
					<div class="layui-input-inline">
						<input name="politicalStatus"  id="politicalStatus" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<!-- <div class="layui-inline">
					<label class="layui-form-label">专业编码</label>
					<div class="layui-input-inline">
						<input name="specialtyCode"  id="specialtyCode" disabled autocomplete="off" class="layui-input">
					</div>
				</div> -->
				<div class="layui-inline">
					<label class="layui-form-label">研究方向</label>
					<div class="layui-input-inline">
						<input name="researchDirection"  id="researchDirection" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">是否兼职</label>
					<div class="layui-input-inline">
						<input name="isPartTime"  id="isPartTime" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">团队负责人</label>
					<div class="layui-input-inline">
						<input name="director"  id="director" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业</label>
					<div class="layui-input-inline">
						<input name="specialtyName"  id="specialtyName" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-inline">
						<input name="createTime"  id="createTime" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">创建人</label>
					<div class="layui-input-inline">
						<input name="createUser"  id="createUser" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">修改时间</label>
					<div class="layui-input-inline">
						<input name="modifyTime"  id="modifyTime" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">修改人</label>
					<div class="layui-input-inline">
						<input name="modifyUser"  id="modifyUser" disabled autocomplete="off" class="layui-input">
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
		$("#entryTime").val((data.entryTime.split(' '))[0]);
		$("#birthday").val((data.birthday.split(' '))[0]);
		$("#graduateSchool").val(data.graduateSchool);
		$("#finalDegree").val(data.finalDegree);
		$("#politicalStatus").val(data.politicalStatus);
		/* $("#specialtyCode").val(data.specialtyCode); */
		$("#specialtyName").val(data.specialtyName);
		$("#researchDirection").val(data.researchDirection);
		$("#isPartTime").val(data.isPartTime==2?'是':'否');
		$("#director").val(data.director==1?'是':'否');
		$("#createTime").val(data.createTime);
		$("#createUser").val(data.createUser);
		$("#modifyTime").val(data.modifyTime);
		$("#modifyUser").val(data.modifyUser);
	}
	</script>
	
</html>