<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业成果</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/js/text_mon_list/text_mon_add.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body style="margin-left: 25%;">
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-top:5%;">
		  <div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">出版时间</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
				
			<div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">教材或专著名称</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
			
			<div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">出版社</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
			
			<div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">第一作者</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
			
			<div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">其他作者情况</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
           	<div >
            
			<div class="layui-inline">
			<lable class="layui-form-label" style="width:150px;">创建人</lable>
				<div class="layui-input-inline">
					<input type="text" name="create_user" id="create_user" disabled  class="layui-input">
				</div>
			</div>
			</div>
		
		   <div class="layui-inline">
             <label class="layui-form-label" style="width:150px;">创建时间</label>
				<div class="layui-input-inline">
						<input type="text" class="layui-input" id="create_time" disabled name="create-time" >
				</div>
			</div>
			
			<div >
            
			<div class="layui-inline">
			<lable class="layui-form-label" style="width:150px;">修改人</lable>
				<div class="layui-input-inline">
					<input type="text" name="modify_user" lay-verify="required" disabled id="modify-user" class="layui-input">
				</div>
			</div>
			</div>
		
		   <div class="layui-inline">
             <label class="layui-form-label" style="width:150px;">修改时间</label>
				<div class="layui-input-inline">
						<input type="text" class="layui-input" disabled name="modify_time" id="modify_time">
				</div>
			</div>
			
</html>