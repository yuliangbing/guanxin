<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看页面</title>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/teaching_assets_category/teaching_assets_category_check.js"></script>
</head>
<body style="margin-left: 18%;">
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-top:5%;">
		  <div>
		  <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">分类号</label>
				<div class="layui-input-inline">
					
						<input type="text" id="code" name="code" disabled class="layui-input">
					
				
			</div>	
				</div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">分类名称</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name" disabled class="layui-input">
					
				</div>
			</div>	
           
         
          
         
			</div>
			<div class="layui-inline">
			<lable class="layui-form-label" style="width:150px;">创建人</lable>
				<div class="layui-input-inline">
					<input type="text" name="create_user" id="create_user" disabled  class="layui-input">
				</div>
			</div>
			
		<div>
		   <div class="layui-inline">
             <label class="layui-form-label" style="width:150px;">创建时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="create_time" disabled name="create_time" >
				</div>
			</div>
			</div>
			<div >
            
			<div class="layui-inline">
			<lable class="layui-form-label" style="width:150px;">修改人</lable>
				<div class="layui-input-inline">
					<input type="text" name="modify_user" lay-verify="required" disabled id="modify_user" class="layui-input">
				</div>
			</div>
			</div>
		<div>
		   <div class="layui-inline">
             <label class="layui-form-label" style="width:150px;">修改时间</label>
				<div class="layui-input-inline">
						<input type="text" class="layui-input" disabled name="modify_time" id="modify_time">
				</div>
			</div>
		</div>	
		</div>
	</form>
</body>
</html>