<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>角色权限管理</title>

<link rel="stylesheet" href="${path}/static/public/css/font.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<style type="text/css">
	td div{
		width: max-content;
	}
</style>
</head>
<body>
	<div class="x-body">
		<form action="" method="post" class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<label for="name" class="layui-form-label" style="width: max-content;" id="roleName"> 角色名 :</label>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label"> 拥有权限 </label>
				<table class="layui-table layui-input-block">
					<tbody>
						<tr>
							<td><input type="checkbox" name="like1[write]"
								lay-skin="primary" title="用户管理" /></td>
							<td>
								<div class="layui-input-block">
									<input name="id[]" lay-skin="primary" type="checkbox"
										title="用户停用" value="2"> <input name="id[]"
										lay-skin="primary" type="checkbox" value="2" title="用户删除">
									<input name="id[]" lay-skin="primary" type="checkbox" value="2"
										title="用户修改"> <input name="id[]" lay-skin="primary"
										type="checkbox" value="2" title="用户改密"> <input
										name="id[]" lay-skin="primary" type="checkbox" value="2"
										title="用户列表"> <input name="id[]" lay-skin="primary"
										type="checkbox" value="2" title="用户改密"> <input
										name="id[]" lay-skin="primary" type="checkbox" value="2"
										title="用户列表"> <input name="id[]" lay-skin="primary"
										type="checkbox" value="2" title="用户改密"> <input
										name="id[]" lay-skin="primary" type="checkbox" value="2"
										title="用户列表">
								</div>
							</td>
						</tr>
						<tr>
							<td><input name="id[]" lay-skin="primary" type="checkbox"
								value="2" title="文章管理"></td>
							<td>
								<div class="layui-input-block">
									<input name="id[]" lay-skin="primary" type="checkbox" value="2"
										title="文章添加"> <input name="id[]" lay-skin="primary"
										type="checkbox" value="2" title="文章删除"> <input
										name="id[]" lay-skin="primary" type="checkbox" value="2"
										title="文章修改"> <input name="id[]" lay-skin="primary"
										type="checkbox" value="2" title="文章改密"> <input
										name="id[]" lay-skin="primary" type="checkbox" value="2"
										title="文章列表">
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="layui-form-item">
				<a class="layui-btn" lay-filter="save">保存</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		layui.use([ 'form', 'layer' ], function() {
			var form = layui.form;
			var layer = layui.layer;
		});
	</script>
</body>
<script src="${path}/static/js/role/roleMenuRel_manage.js"></script>
</html>