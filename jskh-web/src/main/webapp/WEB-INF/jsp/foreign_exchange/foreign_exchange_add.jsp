<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加页面</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<script src="${path}/static/js/foreign_exchange/foreign_exchange_add.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<style type="text/css">
.all {
				margin-left:40%;
				margin-right:50%;
			}
</style>
<body class="all">
<form class="layui-form layui-form-pane" action="">
<!--时间-->
		<div class=" layui-form-item">
			<div class="layui-inline">
             <label class="layui-label">时间</label>
				<div class="layui-inline">
						<input type="text" class="layui-input" id="date" autocomplete="off" name="date" placeholder="YYYY-MM-DD">
				</div>
			</div>
			<!--单位-->
       
            <lable class="magin-right:10%;">单位</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		 </div>
        <!--交流学习内容-->
         <div class=" layui-form-item">
            <lable>交流学习内容</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			
        <!--参与人员-->
      
        <lable>参与人员</lable>
           <div class="layui-inline"> 
            
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>	
        
		 <!--成果-->
       <div class=" layui-form-item">
        <lable>成果</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			
		
		
		 <!--创建时间-->
      
        <lable>创建时间</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" id="date" placeholder="YYYY-MM-DD" autocomplete="off" class="layui-input">
				</div>
			</div>
			
		</div>
		
		 <!--创建人-->
       <div class=" layui-form-item">
        <lable>创建人</lable> 
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
       
		
	</form>
	
</body>
</html>