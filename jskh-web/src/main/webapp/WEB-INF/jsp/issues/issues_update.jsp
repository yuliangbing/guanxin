<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/js/issues/issues_List.js"></script>
<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:10%;margin-top:2%">
				
				<div class="layui-inline">
					<label class="layui-form-label">时间</label>
					<div class="layui-input-inline">
						<input name="date" id="date"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">立项编号</label>
					<div class="layui-input-inline">
						<input name="code" id="code"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">课题名称</label>
					<div class="layui-input-inline">
						<input name="name" id="name"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">课题来源</label>
					<div class="layui-input-inline">
						<input name="sources" id="sources"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">主持人</label>
					<div class="layui-input-inline">
						<input name="host" id="host"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">参与人</label>
					<div class="layui-input-inline"  >
						<input name="participants" id="participants"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业id</label>
					<div class="layui-input-inline">
						<input name="specialty_id"  id="specialty_id" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				
			
				<div class="layui-form-item">
				
					<label  class="layui-form-label">获奖情况</label>
					<div class="layui-input-inline">
						<textarea  class="layui-textarea" id="awards_construction" style="width: 440%;"></textarea>
					</div>
				
				</div>
			</div>
			<div style="text-align:center;">
			<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
			<button type="reset" class="layui-btn layui-btn-danger">重置</button>
			</div>
		</form>
	</body>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  		<script src="${path}/static/public/lib/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
	//表格数据传值
	var id = 0;
	function init(data) {

		id = data.id;
		$("#date").val(data.date);
		$("#code").val(data.code);
		$("#name").val(data.name);
		$("#sources").val(data.sources);
		$("#awards_construction").text(data.awards_construction);
		$("#host").val(data.host);
		$("#participants").val(data.participants);
		$("#specialty_id").val(data.specialty_id);
		$("#status").val(data.status);
		$("#create_time").val(data.create_time);
		$("#create_user").val(data.create_user);
		$("#modify_time").val(data.modify_time);
		$("#modify_user").val(data.modify_user);
	}
	//编辑保存效果
	layui.use(['form','laydate'], function() {	
	var form = layui.form;
	var laydate = layui.laydate;
	laydate.render({
		elem: '#date' //指定元素	
	});
	laydate.render({
		elem: '#date1' //指定元素	
	});
	laydate.render({
		elem: '#date2' //指定元素	
	});
	/*提交功能*/
	  form.on('submit(submit)', function(data) {
			/*获取$值存入params */
			var params = {};
			params.date = $("#date").val();
			params.code = $("#code").val();
			params.name = $("#name").val();
			params.sources = $("#sources").val();
			params.host = $("#host").val();
			params.participants = $("#participants").val();
			params.create_time = $("#create_time").val();
			params.awardsConstruction = $("#awards_construction").val();
			params.create_user = $("#create_user").val();
			params.modify_user = $("#modify_user").val();
			params.modify_time = $("#modify_time").val();
			params.specialty_id = $("#specialty_id").val();
			layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
			    $.ajax({
				        type:"POST",
				        url:window.path+'/issuesList/updateIssues?id='+id,
						data:$.param(params),
				        //预期服务器返回数据的类型
				        dataType:"json", 
				        success:function(data){
				        	if(data){
								if (data.code == 0) {
									layer.msg("成功");
									setTimeout(function(){
											parent.window.location.reload();
									},500);
								} else if(data.code != 0) {
									layer.msg("失败,可能为数据填写错误或缺少必要数据！");
								}
							}
						} ,error:function(code){
				           layer.alert("发生错误,请联系管理员");
				        }
				});

			  
			  layer.close(index);
			});
								
			//return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
});
	</script>
</html>