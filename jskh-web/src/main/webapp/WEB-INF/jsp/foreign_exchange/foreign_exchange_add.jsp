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
<script src="${path}/static/js/foreign_exchange/foreign_exchange_add.js"></script>
</head>
<body style="margin-left: 15%;">
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-top:5%;">
		  <div>
		  <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">时间</label>
				<div class="layui-input-inline">
					
						<input type="text" id="date" name="date" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				
			</div>	
				</div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">交流学习内容</label>
				<div class="layui-input-inline">
					
						<input type="text" id="content" name="content" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
         
           <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">单位</label>
				<div class="layui-input-inline">
					
						<input type="text" id="units" name="units" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           
           
          
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">参与人员</label>
				<div class="layui-input-inline">
					
						<input type="text" id="participants" name="participants" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
				</div>
			</div>	
           </div>
           
           <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">成果</label>
				<div class="layui-input-inline">
					
						<input type="text" id="achievements" name="achievements" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
					
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