<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业成果</title>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/js/text_mon_list/text_mon_check.js"></script>
</head>
<body >
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-left:10%;margin-top:2%">
		   			<div class="layui-inline">
			    		<label for="job"class="layui-form-label" style="width:150px;">出版时间</label>
							<div class="layui-input-inline">
								<input type="text" id="date" name="date" disabled class="layui-input">
							</div>
					</div>	
					<div class="layui-inline">
			    		<label for="job"class="layui-form-label" style="width:150px;">教材或专著名称</label>
							<div class="layui-input-inline">
								<input type="text" id="name" name="name" disabled class="layui-input">
							</div>
					</div>	
					<div class="layui-inline">
			    		<label for="job"class="layui-form-label" style="width:150px;">出版社</label>
							<div class="layui-input-inline">
								<input type="text" id="press" name="press" disabled class="layui-input">
							</div>
					</div>	
					<div class="layui-inline">
			    		<label for="job"class="layui-form-label" style="width:150px;">第一作者</label>
							<div class="layui-input-inline">
								<input type="text" id="first_author" name="first_author" disabled class="layui-input">
							</div>
					</div>	
					<div class="layui-inline">
			    		<label for="job"class="layui-form-label" style="width:150px;">其他作者情况</label>
							<div class="layui-input-inline">
								<input type="text" id="other_authors" name="other_authors" disabled class="layui-input">
							</div>
					</div>	
			 		<div class="layui-inline">
			    		<label class="layui-form-label" style="width:150px;">专业id</label>
							<div class="layui-input-inline">
								<input type="text" id="specialty_id" name="specialty_id"  class="layui-input" disabled>
							</div>
					</div>	
			 		<div class="layui-inline">
			    		<label class="layui-form-label" style="width:150px;">专业名称</label>
							<div class="layui-input-inline">
								<input type="text" id="specialty_name" name="specialty_name"  class="layui-input" disabled>
							</div>
					</div>	
					<div class="layui-inline">
						<lable class="layui-form-label" style="width:150px;">创建人</lable>
							<div class="layui-input-inline">
								<input type="text" name="create_user" id="create_user" disabled  class="layui-input">
							</div>
					</div>
			
		   			<div class="layui-inline">
             			<label class="layui-form-label" style="width:150px;">创建时间</label>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="create_time" disabled name="create_time" >
							</div>
					</div>
					<div class="layui-inline">
						<lable class="layui-form-label" style="width:150px;">修改人</lable>
							<div class="layui-input-inline">
								<input type="text" name="modify_user"  disabled id="modify_user" class="layui-input">
							</div>
					</div>
		   			<div class="layui-inline">
            			 <label class="layui-form-label" style="width:150px;">修改时间</label>
							<div class="layui-input-inline">
								<input type="text" class="layui-input" disabled name="modify_time" id="modify_time">
							</div>
					</div>
			</div>
		</form>
</html>