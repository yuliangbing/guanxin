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
<link rel="stylesheet" href="${path}/static/public/css/teacher.css">
<script type="text/javascript" src="${path}/static/js/specialty_achievements/speConAch_List.js"></script>
<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" action="">

			<div class="sz-form-item">
				<div class="sz-input-inline">
					<label class="sz-form-label">主键</label>
					<div class="layui-input-inline">
						<input name="id"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">时间</label>
					<div class="layui-input-inline">
						<input name="date"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				
				<div class="sz-input-inline">
					<label class="sz-form-label">成果名称</label>
					<div class="layui-input-inline">
						<input name="name"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>
			<div class="sz-form-item" >
				<div class="sz-input-inline">
					<label class="sz-form-label">成果来源</label>
					<div class="layui-input-inline">
						<input name="sources"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">成果级别</label>
					<div class="layui-input-inline">
						<input name="level"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">作者</label>
					<div class="layui-input-inline">
						<input name="author"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">专业id</label>
					<div class="layui-input-inline">
						<input name="specialty_id"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>
			
			<div style="text-align:center;">
			<button class="layui-btn layui-right"  lay-filter="submit">保存</button>
			<button type="reset" class="layui-btn layui-btn-danger">重置</button>
			</div>
		</form>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  		<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
	var cate_name = "";
	var specialty_id = "";
	// 初始化
	function init(data) {
		$("#specialtyFilesId").val(data.id);
		$("#date").val(data.date);
		$("#code").val(data.code);
		$("#name").val(data.name);
		cate_name = data.cate_name;
		$("#reviser").val(data.reviser);
		//$("#specialty_id").val(data.specialty_id);
		specialty_id = data.specialty_id;
	}
	//自定义提交
	/* function addConfirm() {
		var params = {};
		params.id = $("#specialtyFilesId").val();
		params.date = $("#date").val();
		params.code = $("#code").val();
		params.name = $("#name").val();
		params.cate_name =  $("#cate_name option:checked").text();
		params.reviser = $("#reviser").val();
		params.specialty_id = $("#specialty_id").val();
	// 数据保存
	$.ajax({
		type: "post",
		url:'/specialtyFiles/updateSpecialtyFilesIf?specialtyFilesId='+params.id,
		data: $.param(params),
		dataType: "json",
		success:function(data){
			        	if(data){
							console.log($.param(params));
							if (data.code == 0) {
								layer.msg("成功");
								setTimeout(function(){
										parent.window.location.reload();
								},500);
							} else if(data.code != 0) {
								layer.msg("失败,数据缺少!");
							}
						}
					} ,error:function(code1){
			           layer.alert("发生异常,请联系管理员");
			        }
	});
} */
	
	function ajax_h(form,cate_name,url,object){
		//获取文件类型
		$.ajax({
			url:url,
			type:"POST",
			dataType:"json",
			success:function(data){
				layer.msg("获取成功");
				console.log(data.data.length);
				if (data.code == 0) {
					let option = "";
					for (let i=0;i<data.data.length;i++) {
						if(data.data[i].name == cate_name){
							option += "<option value='"+data.data[i].code+"' selected='selected'>"+data.data[i].name+"</option>";
						}
						else{
							option += "<option value='"+data.data[i].code+"'>"+data.data[i].name+"</option>";
						}
						
					}
					console.log("option:"+option);
					$("#"+object).append(option);
					form.render('select');
				} else {
					layer.msg(data.msg);
				}
				
			} ,error:function(code){
	           layer.alert("发生错误,请联系管理员");
	        }
		});
	}

		//关闭监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		
		layui.use('element', function() {
			var element = layui.element;

		});

		layui.use(['form', 'table', 'laydate'], function() {
			var form = layui.form;
			var url ="";
			var object="";
			//文件类型
			url = '/fileCategory/getFileCategoryList';
			object = 'cate_name';
			ajax_h(form,cate_name,url,object);
			//专业
			url = '/specialty/getSpecialtyList';
			object = 'specialty_id';
			ajax_h(form,cate_name,url,object);
			/*
			 实现文件时间选择
			 */
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem: '#date' //指定元素
				//,range: '~' //或 range: '~' 来自定义分割字符
			});
			
		 	// 提交功能
		 	form.on('submit(submit)', function(data) { 
				/*获取$值存入params */
				 var params = {};
				    params.date = $("#date").val();
					params.sources = $("#sources").val();
					params.name = $("#name").val();
				/* 	params.cate_name = $("#cate_name").val(); */
					params.level = $("#level").val();
					params.author = $("#author").val();
					params.specialty_id = $("#specialty_id").val();
				//专业的code
				params.specialty_id = $("#specialty_id").val();
				//专业名称
				//params.specialty_id = $("#specialty_id").text();
				layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
				    $.ajax({
					        type:"POST",
					        url:'/specialtyConstructionAchievements/addSpecialtyConstructionAchievements?name='+params.name,
							data:$.param(params),
					        //预期服务器返回数据的类型
					        dataType:"json", 
					        success:function(data){
					        	if(data){
									console.log($.param(params));
									if (data.code == 0) {
										layer.msg("成功");
										setTimeout(function(){
												parent.window.location.reload();
										},500);
									} else if(data.code != 0) {
										layer.msg("失败,数据缺少!");
									}
								}
							} ,error:function(code1){
					           alert("发生错误,请联系管理员");
					        }
					});
				  layer.close(index);
				});
									
				//return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});  
			
		});
	</script>
	</body>

</html>