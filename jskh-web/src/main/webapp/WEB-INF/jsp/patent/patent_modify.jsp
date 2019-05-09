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
	<style type="text/css">
.all1 {
				margin-left:30%;
			
			}
</style>
</head>
<body>
<form class="layui-form layui-form-pane" action="">
<!--时间-->
<div class="all1">
		<div class=" layui-form-item">
			<div class="layui-inline">
             <label class="layui-label">发表时间</label>
				<div class="layui-inline">
						<input type="text" class="layui-input" id="date" name="date" placeholder="YYYY-MM-DD">
				</div>
			</div>
        <!--专利号-->
        
            <lable>&emsp;专利号&nbsp;</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>	
			
        <!--专利名称-->
       <div class=" layui-form-item">
        <lable>专利名称</lable>
           <div class="layui-inline"> 
            
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			
        <!--专利类型-->
       
            <lable class="magin-right:10%;">专利类型</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		 </div>
		 <!--作者-->
       <div class=" layui-form-item">
        <lable>第一作者</lable> 
			<div class="layui-inline">
			 
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			
            <lable>其他作者</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div style="margin: center">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">增加</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
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
			elem: '#date'
			});

    });
	</script>
</html>