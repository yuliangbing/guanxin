<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业成果</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript"
	src="${path}/static/public/lib/layui/layui.js"></script>
<style>
			.all {
				position: absolute;
				left: 38%;
				top: 10%;
				
			}
		</style>
</head>
<body>
<div class="all">
		<!--时间-->
		<div class="layui-form-item ">
			<div class="layui-inline">
             <label class="layui-form-label">出版时间</label>
				<div class="layui-input-inline">
						<input type="text" class="layui-input" id="date" name="date" placeholder="YYYY-MM-DD">
				</div>
			</div>
		</div>
		
		<!--教材或者专著名称-->
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">教材或者专著名称</label>
					<div class="layui-input-inline ">
						<input type="tel " name="phone " lay-verify="required|phone " autocomplete="off " class="layui-input ">
					</div>
				</div>
			</div>
			
		<!--出版社-->
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">出版社</label>
					<div class="layui-input-inline ">
						<input type="tel " name="phone " lay-verify="required|phone " autocomplete="off " class="layui-input ">
					</div>
				</div>
			</div>
		
		<!--第一作者-->
		
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">第一作者</label>
					<div class="layui-input-inline ">
						<input type="tel " name="phone " lay-verify="required|phone " autocomplete="off " class="layui-input ">
					</div>
				</div>
			</div>
		
		<!--其他作者-->
			<div class="layui-form-item ">
				<div class="layui-inline ">
					<label class="layui-form-label ">其他作者</label>
					<div class="layui-input-inline ">
						<input type="tel " name="phone " lay-verify="required|phone " autocomplete="off " class="layui-input ">
					</div>
				</div>
			</div>
		
			<div style="margin-left: -5%;">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">增加</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</div>
		</div>
		
</body>
<script>
	layui.use('element', function() {
    	var element = layui.element;

	});
	layui.use(['form', 'table', 'laydate'], function() {
		var table = layui.table;

		
			//时间控件
			var laydate = layui.laydate;
			laydate.render({
			elem: '#date'
			});

    });
	</script>
</html>