<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业文件</title>

<link rel="stylesheet" href="/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/specialty_files.css">
</head>
<body>
		
		<div class="layui-form-item" style="text-align: center;margin-top: 2%;">
			<div class="layui-inline">
				<label class="layui-form-label">时间</label>
      				<div class="layui-input-inline">
        				<input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
      				</div>
      				
      			<label class="layui-form-label">主持人</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" placeholder="请输入内容" autocomplete="off" class="layui-input">
					</div>
					
				<label class="layui-form-label">参与人</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" placeholder="请输入内容" autocomplete="off" class="layui-input">
					</div>
			</div>
		</div>
		<div class="layui-form-item" style="text-align: center;">	
			<div class="layui-inline">
				<label class="layui-form-label">立项编号</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input">
					</div>

				<label class="layui-form-label">课题名称</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" placeholder="请输入课题名称" autocomplete="off" class="layui-input">
					</div>
					
				<label class="layui-form-label">课题来源</label>
					<div class="layui-input-inline">
						<input type="text" lay-verify="required" placeholder="请输入课题来源" autocomplete="off" class="layui-input">
					</div>
			</div>	
		</div>
		
		<div class="layui-form-item"style="padding-left: 126px;">
			<div class="layui-inline">
				<label class="layui-form-label"style="width: 322px;">获奖及建设情况</label>
					<div class="layui-input-inline">
						<textarea placeholder="请输入内容" class="layui-textarea"style="width: 815px;"></textarea>
					</div>
			</div>
		</div>
		
		<div style="text-align: center;">
			<button class="layui-btn">保存</button>
    		<button class="layui-btn layui-btn-normal">修改</button>
		</div>
	</body>
	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script>
		layui.use('laydate',function(){
			var laydate = layui.laydate;
			laydate.render({
				elem:'#test1'
			});
		});
	</script>
</html>