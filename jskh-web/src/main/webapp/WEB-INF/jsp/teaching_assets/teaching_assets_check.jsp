<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看页面</title>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/teaching_assets/teaching_assets_check.js"></script>
</head>
<body style="margin-left: 25%;">
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-top:5%;">
 
		  <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">分类号</label>
				<div class="layui-input-inline">
					
						<input type="text" id="cate_code" name="cate_code" disabled class="layui-input">
					
				
			</div>	
				</div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">仪器名称</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name" disabled class="layui-input">
					
				</div>
			</div>	
           
         
           <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">型号</label>
				<div class="layui-input-inline">
					
						<input type="text" id="model_num" name="model_num" disabled class="layui-input">
					
				</div>
			</div>	
           
           
          
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">规格</label>
				<div class="layui-input-inline">
					
						<input type="text" id="specification" name="specification" disabled class="layui-input">
					
				</div>
			</div>	
           </div>
           
           <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">仪器来源</label>
				<div class="layui-input-inline">
					
						<input type="text" id="sources" name="sources" disabled class="layui-input">
					
				</div>
			</div>	
           
           
       
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">购置日期</label>
				<div class="layui-input-inline">
					
						<input type="text" id="date" name="date" disabled class="layui-input">
					
				</div>
			</div>	
			
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">总金额</label>
				<div class="layui-input-inline">
					
						<input type="text" id="total_amount" name="total_amount" disabled class="layui-input">
					
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">国别码</label>
				<div class="layui-input-inline">
					
						<input type="text" id="country_code" name="country_code" disabled class="layui-input">
					
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">资产编号</label>
				<div class="layui-input-inline">
					
						<input type="text" id="code" name="code" disabled class="layui-input">
					
				</div>
			</div>	
			
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">生产厂家</label>
				<div class="layui-input-inline">
					
						<input type="text" id="manufacturer" name="manufacturer" disabled class="layui-input">
					
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">领用人</label>
				<div class="layui-input-inline">
					
						<input type="text" id="use_person" name="use_person" disabled class="layui-input">
					
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">现状码</label>
				<div class="layui-input-inline">
					
						<input type="text" id="status_code" name="status_code" disabled class="layui-input">
					
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">所在实验室</label>
				<div class="layui-input-inline">
					
						<input type="text" id="training_room" name="training_room" disabled class="layui-input">
					
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">备注</label>
				<div class="layui-input-inline">
					
						<input type="text" id="remark" name="remark" disabled class="layui-input">
					
				</div>
			</div>	
           </div>
           
            <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">专业id</label>
				<div class="layui-input-inline">
					
						<input type="text" id="specialty_id" name="specialty_id" disabled class="layui-input">
					
				</div>
			</div>	          
         
			<div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">专业名称</label>
				<div class="layui-input-inline">
					
						<input type="text" id="specialty_name" name="specialty_name" disabled class="layui-input">
					
				</div>
			</div>	
		<div class="layui-inline">
			<lable class="layui-form-label" style="width:150px;">创建人</lable>
				<div class="layui-input-inline">
					<input type="text" name="create_user" id="create_user" disabled  class="layui-input">
				</div>
			</div>
			
		<div>
		   <div class="layui-inline">
             <label class="layui-form-label" style="width:150px;">创建时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="create_time" disabled name="create_time" >
				</div>
			</div>
			</div>
			<div >
            
			<div class="layui-inline">
			<lable class="layui-form-label" style="width:150px;">修改人</lable>
				<div class="layui-input-inline">
					<input type="text" name="modify_user" lay-verify="required" disabled id="modify_user" class="layui-input">
				</div>
			</div>
			</div>
		<div>
		   <div class="layui-inline">
             <label class="layui-form-label" style="width:150px;">修改时间</label>
				<div class="layui-input-inline">
						<input type="text" class="layui-input" disabled name="modify_time" id="modify_time">
				</div>
			</div>
		</div>	
			</div>
			</form>
</body>
</html>