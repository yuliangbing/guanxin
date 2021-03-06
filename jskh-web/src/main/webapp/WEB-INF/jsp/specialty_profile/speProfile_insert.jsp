<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
	<form class="layui-form" onsubmit="return false;">
		<div id="main">
			<div class="layui-form-item" style="margin-left: 18%; margin-top: 2%">
				<div class="layui-inline">
					<label class="layui-form-label">专业名称</label>
					<div class="layui-input-inline">
						<select type="text" id="specialty_name"lay-filter="specialty_name" autocomplete="off" placeholder=""lay-verify="required" class="layui-select" lay-search>
							<option value="">请选择</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">年份</label>
					<div class="layui-input-inline">
						<input name="date" id="date" autocomplete="off"class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业定位</label>
					<div class="layui-input-inline">
						<input name="position" id="position" autocomplete="off"class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业特色</label>
					<div class="layui-input-inline">
						<input name="characteristic" id="characteristic"autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业负责人</label>
					<div class="layui-input-inline">
						<input name="director_name" id="director_name" autocomplete="off"class="layui-input" type="text">
					</div>
				</div>

			</div>
			<div style="text-align: center;">
				<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
				<button type="reset" class="layui-btn layui-btn-danger">重置</button>
			</div>
		</div>
	</form>
</body>
  <script src="${path}/static/public/jquery/jquery-3.3.1.min.js"type="text/javascript" charset="utf-8"></script>
  <script src="${path}/static/public/layui/layui.js"type="text/javascript" charset="utf-8"></script>
  <script type="text/javascript"src="${path}/static/js/specialty_profile/speProfile_List.js"></script>
  <script src="${path}/static/public/layui/layui.js"type="text/javascript"></script>
  <script type="text/javascript">
	//时间控件
	layui.use([ 'form', 'laydate' ], function() {
		var form = layui.form;
		var laydate = layui.laydate;
		laydate.render({
			elem : '#date' //指定元素	
		});
		laydate.render({
			elem : '#date1' //指定元素	
		});
		laydate.render({
			elem : '#date2' //指定元素	
		});
		/*提交功能*/
		form.on('submit(submit)', function(data) {
			/*获取$值存入params */
			var params = {};
			params.specialty_id = $("#specialty_name").val();
			params.specialty_name = $("#specialty_name option:checked").text();
			params.date = $("#date").val();
			params.position = $("#position").val();
			params.characteristic = $("#characteristic").val();
			params.director_name = $("#director_name").val();
			params.specialty_id = $("#specialty_name option:checked").val();

			//console.log(params);
			layer.confirm('确定提交吗?', {
				icon : 3,
				title : '提示'
			}, function(index) {
				$
						.ajax({
							type : "POST",
							url : window.path
									+ '/specialtyProfile/addSpecialtyProfile',
							data : $.param(params),
							//预期服务器返回数据的类型
							dataType : "json",
							success : function(data) {
								if (data) {
									if (data.code == 0) {
										layer.msg("成功");
										setTimeout(function() {
											parent.window.location.reload();
										}, 500);
									} else if (data.code != 0) {
										layer.msg("失败,可能为数据填写错误或缺少必要数据！");
									}
								}
							},
							error : function(code) {
								layer.alert("发生错误,请联系管理员");
							}
						});

				layer.close(index);
			});

			//return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	});
	
	function initAdd(option) {
		$("#specialty_name").append(option);
		layui.use('form', function() {
			var form = layui.form;
			form.render('select');
		})
	}
</script>
</html>

</html>