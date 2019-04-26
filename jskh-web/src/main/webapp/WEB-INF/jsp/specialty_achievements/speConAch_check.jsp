<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet"
	href="${path}/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<link rel="stylesheet" href="${path}/static/public/css/teacher.css">
<script type="text/javascript" src="${path}/static/js/specialty_achievements/speConAch_List.js"></script>
<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" action="">

			<div class="sz-form-item">
				<div class="sz-input-inline">
					<label class="sz-form-label">主键</label>
					<div class="layui-input-inline">
						<input name="id"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">时间</label>
					<div class="layui-input-inline">
						<input name="date"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">成果名称</label>
					<div class="layui-input-inline">
						<input name="name"  disabled autocomplete="off" class="layui-input" type="text" />
					</div>
				</div>
			</div>
			<div class="sz-form-item" >
				<div class="sz-input-inline">
					<label class="sz-form-label">成果来源</label>
					<div class="layui-input-inline">
						<input name="sources"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">成果级别</label>
					<div class="layui-input-inline">
						<input name="level"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">作者</label>
					<div class="layui-input-inline">
						<input name="author"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业id</label>
					<div class="layui-input-inline">
						<input name="specialty_id"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>
			
			<div style="margin:1px 533px;">
				<button class="layui-btn layui-btn-normal" onclick="exit();" >关闭</button>
			</div>
		</form>
		<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
	// 初始化
	function init(data) {
		$("#specialtyFilesId").val(data.id);
		$("#date").val(data.date);
		$("#name").val(data.name);
		$("#sources").val(data.sources);
		$("#level").val(data.level);
		$("#specialty_id").val(data.specialty_id);
	}

		//关闭监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		
		layui.use('element', function() {
			var element = layui.element;

		});

		layui.use(['form', 'table', 'laydate'], function() {
			var form = layui.form;
		});
	</script>
	</body>
</html>