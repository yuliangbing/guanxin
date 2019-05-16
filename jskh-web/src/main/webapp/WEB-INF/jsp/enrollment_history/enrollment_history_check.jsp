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
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/enrollment_history/enrollment_history_check.js"></script>
</head>
<body style="margin-left: 25%;">
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-top:5%;">
		  <div>
		  <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">时间</label>
				<div class="layui-input-inline">
					
						<input type="text" id="date" name="date" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				
			</div>	
				</div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">交流学习内容</label>
				<div class="layui-input-inline">
					
						<input type="text" id="content" name="content" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
         
           <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">单位</label>
				<div class="layui-input-inline">
					
						<input type="text" id="units" name="units" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
           
          
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">参与人员</label>
				<div class="layui-input-inline">
					
						<input type="text" id="participants" name="participants" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           </div>
           
           <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">成果</label>
				<div class="layui-input-inline">
					
						<input type="text" id="achievements" name="achievements" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
           </div>
       
             
           <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">专业id</label>
				<div class="layui-input-inline">
					
						<input type="text" id="specialty_id" name="specialty_id" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
           </div>
         <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">专业名称</label>
				<div class="layui-input-inline">
					
						<input type="text" id="specialty_name" name="specialty_name"  class="layui-input" disabled>
					
				</div>
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