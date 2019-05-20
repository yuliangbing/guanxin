<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>详情页面</title>

<link rel="stylesheet" href="/static/public/lib/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-col-md12 layui-content-white">
		<form class="layui-form" action="" onsubmit="return false;">
			<div style="margin: 4% 0% 0% 12%;" class=" layui-anim layui-anim-up">
				<div class="layui-form-item">
					<div class="layui-inline">
					    <label class="layui-form-label" for="date">文件时间</label>
					    <div class="layui-input-inline">
								<input disabled type="text" id="date" name="date" lay-verify="" placeholder="请选择文件时间" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						 <label class="layui-form-label" for="code">文件编号</label>
					    <div class="layui-input-inline">
								<input disabled type="text" id="code" name="code" lay-verify="" placeholder="请输入文件编号" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label" for="name">文件名称</label>
					    <div class="layui-input-inline">
								<input disabled type="text" id="name" name="name" lay-verify="" placeholder="请输入文件名称" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label" for="cate_name">文件类型</label>
					     <div class="layui-input-inline">
								<input disabled type="text" id="cate_name" name="cate_name" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						 <label class="layui-form-label" for="reviser">修订人</label>
					    <div class="layui-input-inline">
								<input disabled type="text" id="reviser" name="reviser" lay-verify="" placeholder="请输入文件名称" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
					 <label class="layui-form-label" for="specialty_id">专业</label>
					    <div class="layui-input-inline">
								<input disabled type="text" id="specialty_name" name="specialty_name" class="layui-input">
						</div>
					</div>
					<div style="margin: 13px 0px 0px 27px;">
						文件附件:&nbsp;&nbsp;&nbsp;<span id="showFile"></span>
						
						<!-- <button type="button" class="layui-btn" id="uploadFile">文件下载</button> -->
					</div>
			    </div>
			</div>
			<div style="margin:73px 257px;">
				<button class="layui-btn layui-btn-normal" onclick="exit();" >关闭</button>
			</div>
		</form>
	</div>
		
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
   	<script src="${path}/static/js/specialty_files/specialty_details.js" type="text/javascript" charset="utf-8"></script>
	
	</body>
</html>