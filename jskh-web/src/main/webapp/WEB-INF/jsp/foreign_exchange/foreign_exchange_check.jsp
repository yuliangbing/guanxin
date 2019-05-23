<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看页面</title>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/js/foreign_exchange/foreign_exchange_check.js"></script>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">
		  <div class="layui-form-item" style="margin-left:18%;margin-top:2%">
		  <div class="layui-inline">
			    <label class="layui-form-label" >时间</label>
				<div class="layui-input-inline">
						<input type="text" id="date" name="date"  disabled class="layui-input">
				</div>	
		  </div>
		  
		<div class="layui-inline">
			    <label class="layui-form-label" style="width:26.75%;margin-right: -1.2%;">交流学习内容</label>
				<div class="layui-input-inline">
						<input type="text" id="content" name="content"  disabled class="layui-input">
				</div>
		</div>	
           
         
			 <div class="layui-inline">
			    <label class="layui-form-label" >单位</label>
				<div class="layui-input-inline">
					
						<input type="text" id="units" name="units"  disabled class="layui-input">
					
				</div>
			</div>	
           
           
          
			 <div class="layui-inline">
			    <label class="layui-form-label" >参与人员</label>
				<div class="layui-input-inline">
					
						<input type="text" id="participants" name="participants"  disabled class="layui-input">
					
				</div>
			</div>	
           
			 <div class="layui-inline">
			    <label class="layui-form-label" >成果</label>
				<div class="layui-input-inline">
					
						<input type="text" id="achievements" name="achievements"  disabled class="layui-input">
					
				</div>
			</div>	
         
            
			 <div class="layui-inline">
			    <label class="layui-form-label" >专业名称</label>
				<div class="layui-input-inline">
					
						<input type="text" id="specialty_name" name="specialty_name"  class="layui-input" disabled>
					
				</div>
			</div>	
           
            
			<div class="layui-inline">
			<lable class="layui-form-label" >创建人</lable>
				<div class="layui-input-inline">
					<input type="text" name="create_user" id="create_user" disabled  class="layui-input">
				</div>
			</div>
			
		   <div class="layui-inline">
             <label class="layui-form-label" >创建时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="create_time" disabled name="create_time" >
				</div>
			</div>
            
			<div class="layui-inline">
			<lable class="layui-form-label" >修改人</lable>
				<div class="layui-input-inline">
					<input type="text" name="modify_user" lay-verify="required" disabled id="modify_user" class="layui-input">
				</div>
			</div>
		   <div class="layui-inline">
             <label class="layui-form-label" >修改时间</label>
				<div class="layui-input-inline">
						<input type="text" class="layui-input" disabled name="modify_time" id="modify_time">
				</div>
			</div>
		</div>	
			
			
			
	</form>
</body>
</html>