<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加页面</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/enrollment_history/enrollment_history_add.js"></script>
</head>
<body style="margin-left: 25%;">
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-top:5%;">
		  
		  <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">时间</label>
				<div class="layui-input-inline">
					
						<input type="text" id="date" name="date" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				
			</div>	
				</div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">计划招生数</label>
				<div class="layui-input-inline">
					
						<input type="text" id="plan_num" name="plan_num" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
         
          
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">实际招生数</label>
				<div class="layui-input-inline">
					
						<input type="text" id="actual_num" name="actual_num" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
           
          
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">报到率</label>
				<div class="layui-input-inline">
					
						<input type="text" id="rate" name="rate" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
           
          
          <div class="layui-inline">
						<label class="layui-form-label" style="width:150px;">专业id</label>
						<div class="layui-input-inline">
							<select type="text" id="specialty_id" lay-filter="specialty_id"
								autocomplete="off" placeholder="" lay-verify="required"
								class="layui-select" lay-search>
								<option value="">请选择</option>
							</select>
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