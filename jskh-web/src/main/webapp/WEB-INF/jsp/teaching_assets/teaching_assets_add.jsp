<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加页面</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
	<script type="text/javascript" src="${path}/static/js/teaching_assets/teaching_assets_add.js"></script>
</head>
<body>
<!--分类号-->
       <div class=" layui-form-item">
            <lable class="magin-right:10%;">分类号</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		
		 
<!--仪器名称-->
       
            <lable class="magin-right:10%;">仪器名称</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		 </div>
		 
<!--型号-->
       <div class=" layui-form-item">
            <lable class="magin-right:10%;">型号</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		
		 
<!--规格-->
       
            <lable class="magin-right:10%;">规格</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		 </div>
		 
<!--仪器来源-->
       <div class=" layui-form-item">
            <lable class="magin-right:10%;">仪器来源</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		
		 
<!--购置日期-->
	
			<div class="layui-inline">
             <label class="layui-label">购置日期</label>
				<div class="layui-inline">
						<input type="text" class="layui-input" id="date" name="date" autocomplete="off" placeholder="YYYY-MM-DD">
				</div>
			</div>
		 </div>
<!--总金额-->
       <div class=" layui-form-item">
            <lable class="magin-right:10%;">总金额</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		
		 
<!--国别码-->
     
            <lable class="magin-right:10%;">国别码</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		 
<!--资产编号-->
       <div class=" layui-form-item">
            <lable class="magin-right:10%;">资产编号</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
	
		 
<!--生产厂家-->
       
            <lable class="magin-right:10%;">生产厂家</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		 
<!--领用人-->
       <div class=" layui-form-item">
            <lable class="magin-right:10%;">领用人</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		
		
<!--现状码-->
      
            <lable class="magin-right:10%;">现状码</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		 
<!--所在实训室-->
       <div class=" layui-form-item">
            <lable class="magin-right:10%;">所在实训室</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>

		 
<!--备注-->
      
            <lable class="magin-right:10%;">备注</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		 
		  <!--修改-->
       <div class=" layui-form-item">
            <lable class="magin-right:10%;">修改时间</lable>
			<div class="layui-inline">
				<div class="layui-inline">
					<input type="text" class="layui-input" id="date1" name="date1" autocomplete="off" placeholder="YYYY-MM-DD">
				</div>
			</div>
	
	
		
		  <lable class="magin-right:10%;">修改人</lable>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
		 </div>
		 
		 <div style="margin: center">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">增加</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</div>
</body>
</html>