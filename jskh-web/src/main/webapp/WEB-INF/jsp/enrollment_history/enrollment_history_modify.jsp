<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改页面</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
	<script type="text/javascript" src="${path}/static/js/enrollment_history/enrollment_history_modify.js"></script>
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
			</div>
			
        <!--参与人员-->
       <div class=" layui-form-item">
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
		
		<div style="margin: center">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</div>

       
		
	</form>
</body>
</html>