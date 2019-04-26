<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet"
	href="${path}/static/public/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<link rel="stylesheet" href="${path}/static/public/css/teacher.css">
<script type="text/javascript" src="${path}/static/js/thesis/thesis_List.js"></script>
<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" action="">

			<div class="sz-form-item">
				<div class="sz-input-inline">
					<label class="sz-form-label">主键</label>
					<div class="layui-input-inline">
						<input name="id"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">发表时间</label>
					<div class="layui-input-inline">
						<input name="date"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">论文题目</label>
					<div class="layui-input-inline">
						<input name="name"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">发表期刊</label>
					<div class="layui-input-inline">
						<input name="published_journal"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>
			<div class="sz-form-item" >
				<div class="sz-input-inline">
					<label class="sz-form-label">索引或级别</label>
					<div class="layui-input-inline">
						<input name="index_level"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">第一作者</label>
					<div class="layui-input-inline">
						<input name="first_author"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">其他作者情况</label>
					<div class="layui-input-inline">
						<input name="other_authors"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业id</label>
					<div class="layui-input-inline">
						<input name="specialty_id"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>
			<div class="sz-form-item" >
				<div class="sz-input-inline">
					<label  class="sz-form-label">状态</label>
					<div class="layui-input-inline">
						<input name="status"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label  class="sz-form-label">创建时间</label>
					<div class="layui-input-inline">
						<input name="create_time"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label  class="sz-form-label">创建人</label>
					<div class="layui-input-inline">
						<input name="create_user"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label  class="sz-form-label">修改时间</label>
					<div class="layui-input-inline">
						<input name="modify_time"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>
			<div class="sz-form-item" >
				<div class="sz-input-inline">
					<label  class="sz-form-label">修改人</label>
					<div class="layui-input-inline">
						<input name="modify_user"  disabled autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>
			<div class="layui-form-item" >
				<div class="sz-input-inline" style="padding-top:2%;">
					<label  class="sz-form-label">获奖情况</label>
					<div class="layui-input-inline">
						<textarea disabled class="layui-textarea"style="width: 1270px;"></textarea>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>