<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加页面</title>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/js/organization/organization_type_add.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body style="margin-left: 20%;">
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-top:5%;">
		  <div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">组织机构类别名称</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
				
			
           
			
			<div style="margin-left: 8%; margin-top:10%;">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submit">保存</button>
						<button type="reset" class="layui-btn layui-btn-danger">重置</button>
					</div>
				</div>
			</div>
			
		</div>
	</form>
</body>
	
   
</html>