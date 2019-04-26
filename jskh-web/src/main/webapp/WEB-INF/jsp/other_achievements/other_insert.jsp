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
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" action="">

			<div class="sz-form-item">
				
				<div class="sz-input-inline">
					<label class="sz-form-label">时间</label>
					<div class="layui-input-inline">
					<input  type="text" id="date" name="date" lay-verify="date" placeholder="请选择时间" class="layui-input">
					
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">成果名称</label>
					<div class="layui-input-inline">
						<input name="name"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">成果来源</label>
					<div class="layui-input-inline">
						<input name="sources"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>
			<div class="sz-form-item" >
				<div class="sz-input-inline">
					<label class="sz-form-label">成果级别</label>
					<div class="layui-input-inline">
						<input name="level"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">第一作者</label>
					<div class="layui-input-inline">
						<input name="first-author"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="sz-input-inline">
					<label class="sz-form-label">其他作者情况</label>
					<div class="layui-input-inline">
						<input name="other-author"   autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				
				</div>	
			</div>
			</div>
			<div style="text-align:center;">
			<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
			<button type="reset" class="layui-btn layui-btn-danger">重置</button>
			</div>
		</form>
		<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  		<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
		//关闭弹窗监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		
		function ajax_h(form,url,object,ids){
			//获取下拉列表(公共方法)
			$.ajax({
				url:url,
				type:"POST",
				dataType:"json",
				success:function(data){
					console.log(data);
					//layer.msg("获取成功");
					console.log(data.data.length);
					if (data.code == 0) {
						if(ids == 'id'){
							let option = "";
							for (let i=0;i<data.data.length;i++) {
								option += "<option value='"+data.data[i].id+"'>"+data.data[i].name+"</option>";
								console.log("输出打印"+data.data[i].ids+"id=="+ids);
							}
							$("#"+object).append(option);
							form.render('select');
						}
						else{
							let option = "";
							for (let i=0;i<data.data.length;i++) {
								option += "<option value='"+data.data[i].code+"'>"+data.data[i].name+"</option>";
								console.log("输出打印"+data.data[i].ids+"id=="+ids);
							}
							$("#"+object).append(option);
							form.render('select');
						}
						
					} else {
						layer.msg(data.msg);
					}
					
				} ,error:function(code){
		           layer.alert("发生错误,请联系管理员");
		        }
			});
		}
		
		layui.use('element', function() {
			var element = layui.element;

		});

		layui.use(['form','laydate'], function() {
			var form = layui.form;
			//获取选中的值
			/* $('#cate_name').val();
			var selects =$('#cate_name option:selected').val();
			console.log("select"+selects); */
			
			//获取下拉框属性
			var url ="";
			var object="";
			var ids ="";
			//文件类型
			url = '/fileCategory/getFileCategoryList';
			object = 'cate_name';
			ids = 'code';
			ajax_h(form,url,object,ids);
			//专业
		 	url = '/specialty/getSpecialtyList';
			object = 'specialty_id';
			ids = 'id';
			ajax_h(form,url,object,ids);
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
				params.status = $("#status").val();
				params.date = $("#date").val();
				params.code = $("#code").val();
				params.name = $("#name").val();
			/* 	params.cate_name = $("#cate_name").val(); */
				params.cate_name = $("#cate_name option:checked").text();
				params.reviser = $("#reviser").val();
				params.specialty_id = $("#specialty_id option:checked").val();
				params.specialty_name = $("#specialty_id option:checked").text();
				console.log("文件类型输出打印"+params.specialty_id);
				layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
				    $.ajax({
					        type:"POST",
					        url:'/specialtyFiles/addSpecialtyFiles',
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
	</body>
</html>