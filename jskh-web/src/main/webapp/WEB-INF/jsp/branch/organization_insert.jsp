<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>组织机构</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<style type="text/css">
.all {
				margin-left:40%;
				margin-right:40%;
			}
</style>
</head>
<body class="all">
		<form class="layui-form layui-form-pane" action="">
		  <div class="layui-form-item">
			    <label >职务&emsp;&emsp;</label>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div>
 			    <label >姓名&emsp;&emsp;</label>
				<div class="layui-inline">
					
					<div class="layui-input-inline">
						<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
				</div>
				</div>
			
			<div >
            <lable>创建人&emsp;</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			</div>
		
		   <div class="layui-inline">
             <label class="layui-label">创建时间</label>
				<div class="layui-inline">
						<input type="text" class="layui-input" id="date" name="date" placeholder="YYYY-MM-DD">
				</div>
			</div>
			
			<div style="margin-right: -5%;">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">增加</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</div>
			</form>
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
					elem: '#date',
					//range: true //或 range: '~' 来自定义分割字符
					});

            });
    </script>
</html>