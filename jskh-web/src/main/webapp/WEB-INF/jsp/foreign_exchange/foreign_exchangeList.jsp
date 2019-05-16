<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>对外学习交流</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/foreign_exchange/foreign_exchangeList.js"></script>
</head>
<body class="layui-layout-body">
     <div class="layui-layout layui-layout-admin">
     <!--<div class="layui-body">-->
				<div class="layui-row layui-col-space15">
					<!-- 内容主体区域 -->
					<div class="layui-col-md12 layui-content-white">
						<form class="layui-form" style="background-color: #f2f2f2;padding: 9px;" onsubmit="return false;">
							<div class="layui-form-item">
							<div class="layui-inline">
							<label class="layui-form-label" >时间</label>
								<div class="layui-inline">
									<div class="layui-input-inline">
										<input type="text" id="date" name="date" lay-verify="" placeholder="请选择时间" autocomplete="off" class="layui-input">
									</div>
								</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label" >单位</label>
									<div class="layui-input-inline">
										<input type="text" id="code" name="code" lay-verify="" placeholder="请输入成果名称" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-inline">
									<label class="layui-form-label"  style="width:120px;">参与人员</label>
									<div class="layui-input-inline">
										<input type="text" id="name" name="name" lay-verify="" placeholder="请输入成果来源" autocomplete="off" class="layui-input">
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
                  <table class="layui-hide" id=test lay-filter="test"></table>
              </div>

	<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs" lay-event="check"><i class="layui-icon">&#xe615;</i>查看</a>
  	<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="edit"> <i class="layui-icon">&#xe642;</i>编辑 </a>
  	<a class="layui-btn-danger layui-btn layui-btn-xs" lay-event="dels"><i class="layui-icon">&#xe640;</i>删除</a>
	</script>
    <script type="text/html" id="toolbarDemo">
    <div style="margin:-5px -1px;">
	 <button class="layui-btn layui-btn-danger" lay-event="dels""><i class="layui-icon">&#xe640;</i>批量删除</button>
	 <button class="layui-btn layui-bg-blue" lay-submit lay-filter="add"><i class="layui-icon">&#xe654;</i>添加</button>
    </div>
    </script>
	</body>
</html>