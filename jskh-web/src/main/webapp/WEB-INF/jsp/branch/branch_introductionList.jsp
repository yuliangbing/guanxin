<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>学院介绍</title>
<style type="text/css">
.my-label {
	width: 100px;
}

.my-input-block {
	margin-left: 130px;
}
</style>
</head>
<body>
<body class="all">
	<h1 style="text-align: center;">学院简介</h1>
	<div>
		<div class="layui-form-item">
			<label class="layui-form-label my-label">设立时间</label>
			<div class="layui-input-block my-input-block">
				<input type="text" id="date" name="date" lay-verify="date"
					placeholder="请选择设立时间" class="layui-input">
			</div>
		</div>
	</div>

	<div>
		<div class="layui-form-item">
			<label class="layui-form-label my-label">专业设立情况</label>
			<div class="layui-input-block my-input-block situation"></div>
		</div>
	</div>

	<div>
		<div class="layui-form-item">
			<label class="layui-form-label my-label">分院特色</label>
			<div class="layui-input-block characteristic my-input-block"></div>
		</div>
	</div>

	<div style="margin-left: -5%;">
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
				<button type="cancel" class="layui-btn layui-btn-primary">取消</button>
			</div>
		</div>
	</div>
</body>
</body>
<script type="text/javascript"
	src="${path}/static/js/branch/branch_introduction.js"></script>
<!-- 加载编辑器的容器 -->
<script id="situation" name="characteristic"
	style="height: 200px; margin: 10px auto; z-index: 600"
	type="text/plain"></script>
<script id="characteristic" name="characteristic"
	style="height: 200px; margin: 10px auto; z-index: 600"
	type="text/plain"></script>
<!-- 配置文件 -->
<script type="text/javascript"
	src="${path}/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript"
	src="${path}/ueditor/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
	UE.getEditor('situation');
	$('.situation').append($('#situation'));

	UE.getEditor('characteristic');
	$('.characteristic').append($('#characteristic'));
</script>
</html>