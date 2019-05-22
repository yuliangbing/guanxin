<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>教师数据简介</title>
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<!-- <link rel="stylesheet" href="/static/public/css/specialty_files/specialty_filesList.css"> -->

</head>
		<body class="layui-layout-body" style="position:absolute; height:400px; overflow:auto">
		<div>
      		<a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        	<i class="layui-icon" style="line-height:30px">ဂ</i></a>
    	</div>
				<div class="layui-col-md12 layui-content-white">
      				<div class="layui-row">
						<!-- <form class="layui-form layui-col-md12 x-so" onsubmit="return false;">
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label" for="date">文件时间</label>
									<div class="layui-input-inline">
										<input type="text" id="date" name="date" lay-verify="" placeholder="请选择文件时间" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label" for="code">文件编号</label>
									<div class="layui-input-inline">
										<input type="text" id="code" name="code" lay-verify="" placeholder="请输入文件编号" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label" for="name">文件名称</label>
									<div class="layui-input-inline">
										<input type="text" id="name" name="name" lay-verify="" placeholder="请输入文件名称" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label alignment">文件类型</label>
									<div class="layui-input-inline">
										<select id="cate_name" class="layui-select" lay-search>
											<option value=""></option>
											
										</select>
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label" for="reviser">修订人</label>
									<div class="layui-input-inline">
										<input type="text" id="reviser" name="reviser" lay-verify="" placeholder="请输入修订人" autocomplete="off" class="layui-input">
									</div>
								</div>
							</div>
							<button class="layui-btn layui-right" lay-submit lay-filter="search"><i class="layui-icon">&#xe615;</i>搜索</button>
							<button type="reset" class="layui-btn layui-btn-danger">重置</button>
						    
						</form> -->
						<form class="layui-form" action="">
						 <div class="layui-form-item" style="margin: 7px 0px 18px 44%;">
						 	教师<a  id="name" style="color:red;"></a>的数据
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">输入框</label>
						    <div class="layui-input-block">
						      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
						    </div>
						  </div>
						  <div class="layui-form-item">
						   <!--  <label class="layui-form-label">密码框</label> -->
						    <div class="layui-input-inline">
						      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
						    </div>
						   <!--  <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">选择框</label>
						    <div class="layui-input-block">
						      <select name="city" lay-verify="required">
						        <option value=""></option>
						        <option value="0">北京</option>
						        <option value="1">上海</option>
						        <option value="2">广州</option>
						        <option value="3">深圳</option>
						        <option value="4">杭州</option>
						      </select>
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">复选框</label>
						    <div class="layui-input-block">
						      <input type="checkbox" name="like[write]" title="写作">
						      <input type="checkbox" name="like[read]" title="阅读" checked>
						      <input type="checkbox" name="like[dai]" title="发呆">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">开关</label>
						    <div class="layui-input-block">
						      <input type="checkbox" name="switch" lay-skin="switch">
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <label class="layui-form-label">单选框</label>
						    <div class="layui-input-block">
						      <input type="radio" name="sex" value="男" title="男">
						      <input type="radio" name="sex" value="女" title="女" checked>
						    </div>
						  </div>
						  <div class="layui-form-item layui-form-text">
						    <label class="layui-form-label">文本域</label>
						    <div class="layui-input-block">
						      <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
						    </div>
						  </div>
						  <div class="layui-form-item">
						    <div class="layui-input-block">
						      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
						    </div>
						  </div>
						</form>
					</div>
				</div>
		<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   		<script type="text/html" id="toolbarDemo">
			<div style="margin:-5px -1px;">
				<button class="layui-btn layui-btn-danger" lay-event="delData"><i class="layui-icon"></i>批量删除</button>
				<button class="layui-btn" lay-submit lay-filter="insertAdd" id="insert"><i class="layui-icon"></i>添加</button>
			</div>
		</script>
		<script type="text/html" id="barDemo" >
			<a class="layui-btn layui-btn-xs" lay-event="details"><i class="layui-icon">&#xe615;</i>查看</a>
			<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="modify"><i class="layui-icon">&#xe642;</i>编辑</a>
			<a class="layui-btn-danger layui-btn layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
		</script>
		<script>
		function getUser() {
			$.ajax({
				type : "POST", // 提交方式
				url : window.path + "/home/getUser",// 路径
				data : {},// 数据，这里使用的是Json格式进行传输
				dataType : "json",
				success : function(result) {// 返回数据根据结果进行相应的处理
					if (result.code == "0" && result.data.user != null) {
						$("#name").html(result.data.user.teaName);
					} else {
						layer.msg(result.msg);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					layer.msg("系统错误");
				}
			});
		}
		getUser();
		</script>
	</body>
</html>