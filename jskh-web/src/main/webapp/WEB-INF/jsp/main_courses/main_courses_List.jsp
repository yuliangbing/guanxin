<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript" src="${path}/static/js/main_courses/main_courses_List.js"></script>
</head>
<body class="layui-layout-body" style="position:absolute; height:400px; overflow:auto">

    <div>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
      <div class="layui-row">
						<form class="layui-form" style="padding: 9px;" onsubmit="return false;">
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label" for="date">年级</label>
									<div class="layui-input-inline">
										<input type="text" id="date" name="date"  placeholder="请选择年级" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label alignment">专业</label>
									<div class="layui-input-inline">
										<select name="specialtyId"  id="specialtyId"  autocomplete="off" class="layui-input" type="text">
											<option value="">请选择</option>
										</select>
									</div>
								</div>
							<button class="layui-btn layui-right" lay-submit lay-filter="search"><i class="layui-icon">&#xe615;</i>搜索</button>
							<button type="reset" class="layui-btn layui-btn-danger">重置</button>
        </form>
      </div>
       <table class="layui-hide" id="test" lay-filter="test"></table>
    
    <script type="text/html" id="toolbarDemo">
		<div style="margin:-5px -1px;">
			<button class="layui-btn layui-btn-danger" lay-event="delData"><i class="layui-icon"></i>批量删除</button>
			<button class="layui-btn" lay-submit lay-filter="insertAdd" id="insert"><i class="layui-icon"></i>添加</button>
		</div>
	</script> 
    <script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs" lay-event="detail"><i class="layui-icon">&#xe615;</i>查看</a>
  	<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="edit"> <i class="layui-icon">&#xe642;</i>编辑 </a>
  	<a class="layui-btn-danger layui-btn layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
  </body>
</html>