<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加页面</title>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/teaching_assets/teaching_assets_add.js"></script>
</head>
<body>
		<form class="layui-form" action="">
		  <div class="layui-form-item" style="margin-left:10%;margin-top:2%">
		  <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">分类号</label>
				<div class="layui-input-inline">
						<input type="text" id="cate_code" name="cate_code" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
		</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">仪器名称</label>
				<div class="layui-input-inline">
						<input type="text" id="name" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">型号</label>
				<div class="layui-input-inline">
						<input type="text" id="model_num" name="model_num" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">规格</label>
				<div class="layui-input-inline">
						<input type="text" id="specification" name="specification" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">仪器来源</label>
				<div class="layui-input-inline">
						<input type="text" id="sources" name="sources" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">购置日期</label>
				<div class="layui-input-inline">
						<input type="text" id="date" name="date" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">总金额</label>
				<div class="layui-input-inline">
						<input type="text" id="total_amount" name="total_amount" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">国别码</label>
				<div class="layui-input-inline">
						<input type="text" id="country_code" name="country_code" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">资产编号</label>
				<div class="layui-input-inline">
						<input type="text" id="code" name="code" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">生产厂家</label>
				<div class="layui-input-inline">
						<input type="text" id="manufacturer" name="manufacturer" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">领用人</label>
				<div class="layui-input-inline">
						<input type="text" id="use_person" name="use_person" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">现状码</label>
				<div class="layui-input-inline">
						<input type="text" id="status_code" name="status_code" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">所在实验室</label>
				<div class="layui-input-inline">
						<input type="text" id="training_room" name="training_room" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>	
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">备注</label>
				<div class="layui-input-inline">
						<input type="text" id="remark" name="remark"  placeholder="请输入" autocomplete="off" class="layui-input">
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
			<div style="margin-left: 25%; margin-top:4%;">
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