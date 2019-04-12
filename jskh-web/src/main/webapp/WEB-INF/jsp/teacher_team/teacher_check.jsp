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
						<input name="id" lay-verify="required" readonly="" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业id</label>
					<div class="layui-input-inline">
						<input name="specialty_id" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业编码</label>
					<div class="layui-input-inline">
						<input name="specialty_code" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>

				<div class="sz-input-inline">
					<label class="sz-form-label">专业名称</label>
					<div class="layui-input-inline">
						<input name="specialty_name" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">团队变更时间</label>
					<div class="layui-input-inline">
						<input name="date" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业教师团队</label>
					<div class="layui-input-inline">
						<input name="specialty_teachers" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">兼职教师团队</label>
					<div class="layui-input-inline">
						<input name="part_time_teachers" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">团队总负责人</label>
					<div class="layui-input-inline">
						<input name="director" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">是否最新（1=是，2=否）</label>
					<div class="layui-input-inline">
						<input name="latest" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				
			</div>
		</form>
	</body>
</html>