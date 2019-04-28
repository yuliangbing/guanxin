<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业文件</title>

<link rel="stylesheet" href="/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/specialty_files.css">
<link rel="stylesheet" href="/static/public/css/teacher.css">
</head>
<body>
		<form class="layui-form" action="">

			<div class="sz-form-item" >
				<div class="sz-input-inline">
					<label class="sz-form-label">主键</label>
					<div class="layui-input-inline">
						<input id="id" lay-verify="required"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业id</label>
					<div class="layui-input-inline">
						<input id="specialty_id" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业编码</label>
					<div class="layui-input-inline">
						<input id="specialty_code" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>

				<div class="sz-input-inline">
					<label class="sz-form-label">专业名称</label>
					<div class="layui-input-inline">
						<input id="specialty_name" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">团队变更时间</label>
					<div class="layui-input-inline">
						<input id="date" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业教师团队</label>
					<div class="layui-input-inline">
						<input id="specialty_teachers" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">兼职教师团队</label>
					<div class="layui-input-inline">
						<input id="part_time_teachers" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">团队总负责人</label>
					<div class="layui-input-inline">
						<input id="director" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">是否最新</label>
					<div class="layui-input-inline">
						<input id="latest" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<div class="sz-input-block" style="padding-top:15%">
						<button class="layui-btn" lay-submit="" lay-filter="submit">立即提交</button>
					</div>
				</div>
			</div>
		</form>
		<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  		<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>		
		
	</script>
	</body>
</html>