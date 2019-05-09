<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看页面</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
	<script type="text/javascript" src="${path}/static/js/enrollment_history/enrollment_history_check.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" action="">
<!--时间-->
		<div class=" layui-form-item">
			<div class="layui-inline">
             <label class="layui-label">时间</label>
				<div class="layui-inline">
						<input type="text" class="layui-input" id="date1" name="date" placeholder="YYYY-MM-DD">
				</div>
			</div>
			<!--计划招生数-->
       
            <lable class="magin-right:10%;">计划招生数</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		 </div>
        <!--实际招生数-->
         <div class=" layui-form-item">
            <lable>实际招生数</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			</div>
			
        <!--报到率-->
       <div class=" layui-form-item">
        <lable>报到率</lable>
           <div class="layui-inline"> 
            
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>	
        
		
		 <!--创建时间-->
       <div class=" layui-form-item">
        <lable>创建时间</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
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
		
		 <!--修改时间-->
       <div class=" layui-form-item">
        <lable>修改时间</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			
		</div>
		
		 <!--修改人-->
       <div class=" layui-form-item">
        <lable>修改人</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>

       
		
	</form>
</body>
</html>