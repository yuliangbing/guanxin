<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改页面</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<script src="${path}/static/js/organization/organization_type_modify.js"></script>
<style type="text/css">
.all {
				margin-left:40%;
				margin-right:40%;
			}
</style>
</head>
<body class="all">
		<form class="layui-form layui-form-pane" action="">
		  <div class="layui-form-item">
			    <label for="job">组织机构类别名称&emsp;&emsp;</label>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div>
 			    <label for="name">姓名&emsp;&emsp;</label>
				<div class="layui-inline">
					
					<div class="layui-input-inline">
						<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
				</div>
				</div>
			
			<div >
            <lable for="createname">创建人&emsp;</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			</div>
		
		   <div class="layui-inline">
             <label class="layui-label" for="createtime">创建时间</label>
				<div class="layui-inline">
				<div class="layui-input-inline">
						<input type="text" class="layui-input" id="date" name="date" lay-verify="required" autocomplete="off" placeholder="YYYY-MM-DD">
				</div>
				</div>
			</div>
			
			<div class="layui-inline">
             <label class="layui-label" for="modifytime">修改时间</label>
				<div class="layui-inline">
				<div class="layui-input-inline">
						<input type="text" class="layui-input" id="date" name="date" lay-verify="required" autocomplete="off" placeholder="YYYY-MM-DD">
				</div>
				</div>
			</div>
			
			<div class="layui-inline">
             <label class="layui-label" for="modifytime">修改时间</label>
				<div class="layui-inline">
				<div class="layui-input-inline">
						<input type="text" class="layui-input" id="date" name="date" lay-verify="required" autocomplete="off" placeholder="YYYY-MM-DD">
				</div>
				</div>
			</div>
			
			<div style="margin-right: -5%;">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submit">保存</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</div>
			
		</div>
	</form>
</body>
	
   
</html>