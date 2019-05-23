<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改页面</title>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script src="${path}/static/js/foreign_exchange/foreign_exchange_modify.js"></script>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">
		  <div class="layui-form-item" style="margin-left:18%;margin-top:2%">
		  <div class="layui-inline">
			    <label class="layui-form-label" >时间</label>
				<div class="layui-input-inline">
						<input type="text" id="date" name="date" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>	
			</div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:26.75%;margin-right: -1.2%;">交流学习内容</label>
				<div class="layui-input-inline">
					
						<input type="text" id="content" name="content" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" >单位</label>
				<div class="layui-input-inline">
					
						<input type="text" id="units" name="units" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" >参与人员</label>
				<div class="layui-input-inline">
					
						<input type="text" id="participants" name="participants" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
			 <div class="layui-inline">
			    <label class="layui-form-label" >成果</label>
				<div class="layui-input-inline">
					
						<input type="text" id="achievements" name="achievements" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
          <div class="layui-inline">
						<label class="layui-form-label" >专业id</label>
						<div class="layui-input-inline">
							<select type="text" id="specialty_id" lay-filter="specialty_id"
								autocomplete="off" placeholder="" lay-verify="required"
								class="layui-select" lay-search>
								<option value="">请选择</option>
							</select>
						</div>
					</div>
         
			<div style="margin-left:20%; margin-top:10%;">
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