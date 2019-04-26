<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>组织机构</title>
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/public/lib/layui/layui.js"></script>
	<script src="${path}/static/js/organization/organization.js"></script>
	<script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<div class="x-body">
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn layui-btn-normal"  data-method="offset" data-type="auto" onclick="add()">
			<i class="layui-icon">&#xe654;</i>新增
		</button>
		</xblock>
		<table class="layui-table" lay-data="{page:true,id:'test'}" lay-filter="test">
			<thead>
				<tr>
					<th width="20" lay-data="{type:'checkbox'}">
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th style="min-width: 150px;">组织机构</th>
					<th>创建人</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			
			  <tr>
					
			  </tr>
			  <tr>
			  </tr>
			<tbody class="x-cate" id="organizationbady">
			</tbody>
		</table>
	</div>
	<style type="text/css">
</style>
	
</html>