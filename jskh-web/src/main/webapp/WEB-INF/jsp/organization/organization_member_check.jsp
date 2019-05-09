<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看页面</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<script src="${path}/static/js/organization/organization_member_check.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" action="">
		  <div class="layui-form-item">
			    <label >职务&emsp;&emsp;</label>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div>
 			    <label >姓名&emsp;&emsp;</label>
				<div class="layui-inline">
					
					<div class="layui-input-inline">
						<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					</div>
				</div>
				</div>
			
			<div >
            <lable>创建人&emsp;</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			</div>
		
		   <div class="layui-inline">
             <label class="layui-label">创建时间</label>
				<div class="layui-inline">
						<input type="text" class="layui-input"  name="date" placeholder="YYYY-MM-DD">
				</div>
			</div>
      </div>
  </form>
</body>
</html>