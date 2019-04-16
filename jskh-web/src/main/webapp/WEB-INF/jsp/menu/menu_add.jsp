<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet"
	href="${path}/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<script type="text/javascript"
	src="${path}/static/js/menu/menu_add.js"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
	<div class="x-body layui-anim layui-anim-up">
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="menuStr" class="layui-form-label"> <span
					class="x-red">*</span>菜单名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="menuStr" name="menuStr" required=""
						lay-verify="email" autocomplete="off" class="layui-input">
				</div>
				<label for="menuNum" class="layui-form-label"> <span
					class="x-red">*</span>菜单编号
				</label>
				<div class="layui-input-inline">
					<input type="text" id="menuNum" name="menuNum" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="url" class="layui-form-label"> <span
					class="x-red">*</span>菜单地址
				</label>
				<div class="layui-input-inline">
					<input type="text" id="url" name="url" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input">
				</div>
				<label for="menuOrder" class="layui-form-label">排序 </label>
				<div class="layui-input-inline">
					<input type="text" id="menuOrder" name="menuOrder" required=""
						lay-verify="nikename" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="showType" class="layui-form-label"> <span
					class="x-red">*</span>是否显示
				</label>
				<div class="layui-input-inline">
					<select id="showType" name="showType" class="valid">
						<option value="1">是</option>
						<option value="2">否</option>
					</select>
				</div>
				<label for="remark" class="layui-form-label">备注 </label>
				<div class="layui-input-inline">
					<input type="password" id="remark" name="remark" required=""
						lay-verify="repass" autocomplete="off" class="layui-input">
				</div>
			</div>
		</form>
	</div>
	<script>
		layui.use([ 'form', 'layer' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				nikename : function(value) {
					if (value.length < 5) {
						return '昵称至少得5个字符啊';
					}
				},
				pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
				repass : function(value) {
					if ($('#L_pass').val() != $('#L_repass').val()) {
						return '两次密码不一致';
					}
				}
			});

			//监听提交
			form.on('submit(add)', function(data) {
				console.log(data);
				//发异步，把数据提交给php
				layer.alert("增加成功", {
					icon : 6
				}, function() {
					// 获得frame索引
					var index = parent.layer.getFrameIndex(window.name);
					//关闭当前frame
					parent.layer.close(index);
				});
				return false;
			});

		});
	</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>