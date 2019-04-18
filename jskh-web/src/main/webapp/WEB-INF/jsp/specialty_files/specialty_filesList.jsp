<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>专业文件</title>

<link rel="stylesheet" href="/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/specialty_files.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
</head>
		<body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin">

			<!--<div class="layui-body">-->
				<div class="layui-row layui-col-space15">
					<!-- 内容主体区域 -->
					<div class="layui-col-md12 layui-content-white">

						<form class="layui-form" action="" onsubmit="return false;">
							<div class="layui-form-item">
		 					<fieldset class="layui-elem-field">
		 						<legend>专业文件</legend>
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
									<label class="layui-form-label alignment">文件类型名称</label>
									<div class="layui-input-inline">
										<select id="cate_name" class="layui-select" lay-search>
											<option value=""></option>
											
										</select>
									</div>
								</div>
								<!-- <div class="layui-inline">
						      		<label class="layui-form-label">状态</label>
								    <div class="layui-input-inline">
									    <select name="status" lay-search="" id="status">
										    <option value=""></option>
									    </select>
								    </div>
							    </div> -->
								<div class="layui-inline">
									<label class="layui-form-label" for="reviser">修订人</label>
									<div class="layui-input-inline">
										<input type="text" id="reviser" name="reviser" lay-verify="" placeholder="请输入修订人" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label" for="specialty_id">专业id</label>
									<div class="layui-input-inline">
										<select type="text" id="specialty_id" lay-filter="specialty_id" autocomplete="off" placeholder="" lay-verify="" class="layui-select" lay-search>
											<option value="">请选择</option>
											<option value="0">已报名</option>
											<option value="1">已缴费</option>
											<option value="2">已上传</option>
											<option value="3">审核中</option>
											<option value="4">视频不合格</option>
											<option value="5">体检合格</option>
											<option value="6">体检不合格</option>
										</select>
									</div>
								</div>
							</div>
							</fieldset>
							</div>
							<!-- <a class="layui-top-icon" href="javascript:;" layadmin-event="refresh" title="刷新">
								<i class="layui-icon layui-icon-refresh-3"></i>
							</a> -->
							<button class="layui-btn layui-right" lay-submit lay-filter="search">搜索</button>
							<button type="reset" class="layui-btn layui-btn-danger">重置</button>
							<!--<button class="layui-btn layui-btn-warm" lay-submit lay-filter="insertAdd" >新增</button>   -->
							<script type="text/html" id="toolbarDemo">
							<div style="margin:-5px -1px;">
			 				  <button class="layui-btn layui-btn-danger" lay-event="delData""><i class="layui-icon"></i>批量删除</button>
			 				  <button class="layui-btn" lay-submit lay-filter="insertAdd"><i class="layui-icon"></i>添加</button>
							</div>
							</script>
						</form>
					</div>
					<!--table表格部分 -->
					<div class="layui-col-md12 layui-content-white">
						<table class="layui-hide" id="demoList" lay-filter="demoList"></table>
					</div>
				</div>
			<!--</div>-->
		</div>
		<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   		<%-- <script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script> --%>
   		<script src="${path}/static/public/layui/layui.js" type="text/javascript" charset="utf-8"></script>
   		<script src="${path}/static/js/specialty_files.js"></script>
   		
		<script type="text/html" id="barDemo" >
			<a class="layui-btn layui-btn-xs" lay-event="check">查看</a>
			<a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
	</body>
</html>