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
	<script type="text/javascript" src="${path}/static/js/teaching_assets_category/teaching_assets_category_modify.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" action="">

		<div class=" layui-form-item">
			
			<!--分类号-->
       
            <lable class="magin-right:10%;">分类号</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		 </div>
        <!--分类名称-->
         <div class=" layui-form-item">
            <lable>分类名称</lable>
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