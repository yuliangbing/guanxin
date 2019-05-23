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
<script type="text/javascript" src="${path}/static/js/teaching_assets/teaching_assetsList.js"></script>
</head>
<body class="layui-layout-body">

    <div>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="layui-col-md12 layui-content-white">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
         <!--  <input class="layui-input" placeholder="时间"  name="date" id="date" autocomplete="off" style="width:200px;"> -->
          <input type="text" name="name" id="name" placeholder="请输入仪器名称" autocomplete="off" class="layui-input">
          <button  class="layui-btn"  lay-submit lay-filter="search" id="search"><i class="layui-icon">&#xe615;</i>搜索</button>
          <button type="reset" class="layui-btn layui-btn-danger">重置</button>
        </form>
      </div>
       <table class="layui-hide" id="test" lay-filter="test"></table>
    </div>
    
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