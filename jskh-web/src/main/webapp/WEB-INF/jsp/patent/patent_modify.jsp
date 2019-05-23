<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业成果</title>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${path}/static/js/patent/patent_modify.js"></script>
</head>
 <body style="margin-left: 25%;">
<form class="layui-form" action="" onsubmit="return false;">
		  <div class="layui-form-item" style="margin-top:5%;" >
				  <div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">发表时间</label>
				<div class="layui-input-inline">
					
						<input type="text" id="date" name="date"  class="layui-input" lay-verify="required" placeholder="请输入" autocomplete="off">
					
				</div>
			</div>	
				<div>
			 <div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">专利号</label>
				<div class="layui-input-inline">
					
						<input type="text" id="code" name="code"  class="layui-input" lay-verify="required" placeholder="请输入" autocomplete="off">
					
				</div>
			</div>	
           </div>
           
           <div>
			 <div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">专利名称</label>
				<div class="layui-input-inline">
					
						<input type="text" id="name" name="name"  class="layui-input" lay-verify="required" placeholder="请输入" autocomplete="off">
					
				</div>
			</div>	
           </div>
           
           <div>
			 <div class="layui-inline">
						<label class="layui-form-label" style="width:150px;">专利类型</label>
						<div class="layui-input-inline">
							<select type="text" id="type" lay-filter="type"
								autocomplete="off" placeholder="" lay-verify="required"
								class="layui-select" lay-search>
								<option value="">请选择</option>
							</select>
						</div>
					</div>
           </div>
           
           <div>
			 <div class="layui-inline">
			    <label for="job"class="layui-form-label" style="width:150px;">第一作者</label>
				<div class="layui-input-inline">
					
						<input type="text" id="first_author" name="first_author"  class="layui-input" lay-verify="required" placeholder="请输入" autocomplete="off">
					
				</div>
			</div>	
           </div>
           
           <div>
			 <div class="layui-inline">
			    <label class="layui-form-label" style="width:150px;">其他作者情况</label>
				<div class="layui-input-inline">
					
						<input type="text" id="other_authors" name="other_authors"  class="layui-input"  placeholder="请输入" autocomplete="off">
					
				</div>
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
      <div style="margin-left: 8%; margin-top:10%;">
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submit">保存</button>
						<button type="reset" class="layui-btn layui-btn-danger">重置</button>
					</div>
				</div>
			</div>
  </form>
  </body>
</html>