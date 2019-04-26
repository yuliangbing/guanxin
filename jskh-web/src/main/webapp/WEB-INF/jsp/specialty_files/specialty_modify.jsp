<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改页面</title>

<link rel="stylesheet" href="/static/public/lib/layui/css/layui.css">
</head>
<body class="layui-body ">
	<div class="layui-row layui-col-space15">
		<div class="layui-col-md12 layui-content-white">
			<form class="layui-form" onsubmit="return false;">
			    <div class="layui-form-item layui-anim layui-anim-up" style="margin: 7% 10% 10% 0px;">
			    	<div class="layui-inline">
						<label class="layui-form-label" for="date">文件时间</label>
					    <div class="layui-input-inline">
								<input  type="text" id="date" name="date" lay-verify="date" placeholder="请选择文件时间" class="layui-input">
						</div>
					</div>
			    	<div class="layui-inline">
					    <label class="layui-form-label" for="code">文件编号</label>
					    <div class="layui-input-inline">
								<input  type="text" id="code" name="code" lay-verify="required" placeholder="请输入文件编号" class="layui-input" value="">
						</div>
					</div>
					<div class="layui-inline ">
						<label class="layui-form-label" for="name">文件名称</label>
					    <div class="layui-input-inline">
								<input  type="text" id="name" name="name" lay-verify="required" placeholder="请输入文件名称" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
					<label class="layui-form-label" for="cate_name">文件类型</label>
				    <div class="layui-input-inline">
						<select  id="cate_name" lay-verify="required" class="layui-select" lay-search>
							<option value="">请选择</option>
						</select>
					</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label" for="reviser">修订人</label>
					    <div class="layui-input-inline">
							<input  type="text" id="reviser" name="reviser" lay-verify="required" placeholder="请输入文件名称" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label" for="specialty_id">专业id</label>
					    <div class="layui-input-inline">
							<select id="specialty_id" lay-filter="specialty_id" lay-verify="required" class="layui-select" lay-search>
								<option value="">请选择</option>
								
							</select>
						</div>
					</div>
			    </div>
				<div style="margin: 0% 0% 0% 6%;" >
					<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
					<button type="reset" class="layui-btn layui-btn-danger" id="reset">重置</button>
					<button class="layui-btn layui-btn-normal" onclick="exit();" >关闭</button>
				</div>
			</form>
		</div>
	</div>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${path}/static/js/specialty_files/specialty_modify.js" type="text/javascript" charset="utf-8"></script>
	
	</body>

</html>