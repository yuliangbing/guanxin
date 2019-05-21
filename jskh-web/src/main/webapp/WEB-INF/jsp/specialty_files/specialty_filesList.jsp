<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>专业文件</title>
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<link rel="stylesheet" href="/static/public/css/specialty_files/specialty_filesList.css">

</head>
		<body class="layui-layout-body" style="background-color: #ffff;padding: 10px;position:absolute; height:400px; overflow:auto"  >
		<div class="layui-layout layui-layout-admin">

			<!--<div class="layui-body">-->
				<div class="layui-row layui-col-space15">
					<!-- 内容主体区域 -->
					<div class="layui-col-md12 layui-content-white">
						<form class="layui-form" style="background-color: #f2f2f2;padding: 9px;" onsubmit="return false;">
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
						    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
						       <i class="layui-icon" style="line-height:30px">ဂ</i>
						    </a>
						</form>
					</div>
					<!--table表格部分 -->
					<div class="layui-col-md12 layui-content-white">
						<table class="layui-hide" id="demoList" lay-filter="demoList"></table>
					</div>
				</div>
		</div>
		<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   		<script src="${path}/static/js/specialty_files/specialty_list.js" type="text/javascript" charset="utf-8"></script>
   		<script type="text/html" id="toolbarDemo">
			<div style="margin:-5px -1px;">
			 	 <button class="layui-btn layui-btn-danger" lay-event="dels""><i class="layui-icon">&#xe640;</i>批量删除</button>
			 	 <button class="layui-btn layui-bg-blue" lay-submit lay-filter="add"><i class="layui-icon">&#xe654;</i>添加</button>
			</div>
		</script>
		<script type="text/html" id="barDemo" >
			<a class="layui-btn layui-btn-xs" lay-event="details"><i class="layui-icon">&#xe615;</i>查看</a>
			<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="modify"><i class="layui-icon">&#xe642;</i>编辑</a>
			<a class="layui-btn-danger layui-btn layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
		</script>
	</body>
</html>