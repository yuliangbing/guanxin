<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/js/other_achievements/other_List.js"></script>
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
				</div> -->
				<div class="layui-inline">
					<label class="layui-form-label">时间</label>
					<div class="layui-input-inline">
						<input name="date" id="date" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label" style="width:85px;">成果名称</label>
					<div class="layui-input-inline">
						<input name="name" id="name" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label" >成果来源</label>
					<div class="layui-input-inline">
						<input name="sources" id="sources" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width:85px;">成果级别</label>
					<div class="layui-input-inline">
						<input name="level" id="level" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">第一作者</label>
					<div class="layui-input-inline"  >
						<input name="first_author" id="first_author" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width:85px;">其他作者情况</label>
					<div class="layui-input-inline"  >
						<input name="other_author" id="other_author" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业名称</label>
					<div class="layui-input-inline">
						<input name="specialtyName"  id="specialtyName" disabled autocomplete="off" class="layui-input">
					</div>
				</div>
				
			</div>
		</form>
	</body>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
   	<script>
   	function init(data) {

   		//$("#id").val(data.date);
   		$("#date").val((data.date.split(' '))[0]);
		$("#name").val(data.name);
		$("#sources").val(data.sources);
		$("#level").val(data.level);
		$("#first_author").val(data.firstAuthor);
		$("#other_author").val(data.otherAuthors);
		$("#specialtyName").val(data.specialtyName);
	}
   	</script>
</html>