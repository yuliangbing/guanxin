<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看页面</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/enrollment_history/enrollment_history_check.js"></script>
</head>
<body style="margin-left: 20%;">
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-top:5%;">
		  
		 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">时间</label>
				<div class="layui-input-inline">
					
						<input type="text" id="date" name="date" disabled class="layui-input">
					
				
			</div>	
				</div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">计划招生数</label>
				<div class="layui-input-inline">
					
						<input type="text" id="plan_num" name="plan_num" disabled class="layui-input">
					
				</div>
			</div>	
           
         
          
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">实际招生数</label>
				<div class="layui-input-inline">
					
						<input type="text" id="actual_num" name="actual_num" disabled class="layui-input">
					
				</div>
			</div>	
           
           
          
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">报到率</label>
				<div class="layui-input-inline">
					
						<input type="text" id="rate" name="rate" disabled class="layui-input">
					
				</div>
			</div>	
           
       
             
          
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">专业id</label>
				<div class="layui-input-inline">
					
						<input type="text" id="specialty_id" name="specialty_id" disabled class="layui-input">
					
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
			
		
		
		 <!--创建时间-->
       <div class=" layui-item">
        <lable class="layui-form-label" style="width:150px;">创建时间</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" id="create_time" name="create_time" disabled class="layui-input">
				</div>
			</div>
			
		</div>
		
		 <!--创建人-->
       <div class=" layui-item">
        <lable class="layui-form-label" style="width:150px;">创建人</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" id="create_user" name="create_user" disabled class="layui-input">
				</div>
			</div>
			
		</div>
		
		 <!--修改时间-->
       <div class=" layui-item">
        <lable class="layui-form-label" style="width:150px;">修改时间</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" id="modify_time" name="modify_time" disabled class="layui-input">
				</div>
			</div>
			
		</div>
		
		 <!--修改人-->
       <div class=" layui-item">
        <lable class="layui-form-label" style="width:150px;">修改人</lable> 
			<div class="layui-inline">

				<div class="layui-input-inline">
					<input type="text" id="modify_user" name="modify_user" disabled class="layui-input">
				</div>
			</div>
		</div>

       </div>
		
	</form>
</body>
</html>