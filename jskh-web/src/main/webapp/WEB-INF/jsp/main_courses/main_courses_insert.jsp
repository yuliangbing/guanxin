<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${path}/static/js/main_courses/main_courses_List.js"></script>
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:10%;margin-top:2%">
				
				<div class="layui-inline">
					<label class="layui-form-label">专业</label>
					<div class="layui-input-inline">
						<select name="specialtyId"  id="specialtyId" lay-verify="required" autocomplete="off" class="layui-input" type="text">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">年级</label>
					<div class="layui-input-inline">
						<input name="date" id="date" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">课程</label>
					<div class="layui-input-inline">
						<input name="courses" id="courses" lay-verify="required" autocomplete="off" class="layui-input" type="text">
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

	//专业id select
	var id = 0;
	var specialty_name = "";	
	function ajax_h(form,names,url,object,ids)
	{
		$.ajax({
			url:url,
			type:"POST",
			dataType:"json",
			success:function(data){
				//layer.msg("获取成功");
				console.log("长度"+data.data.length);
				console.log(names);
				let option = "";
				if (data.code == 0) {
					if(ids == 'code'){
						for (let i=0;i<data.data.length;i++)
						{
							if(data.data[i].name == names)
							{
								option += "<option value='"+data.data[i].code+"' selected='selected'>"+data.data[i].name+"</option>";
							}
							else
							{
								option += "<option value='"+data.data[i].code+"'>"+data.data[i].name+"</option>";
							}
						}
						$("#"+object).append(option);
						form.render('select');
					}
				 	else if(ids == 'id')
				 	{
						for (let j=0;j<data.data.length;j++)
						{
							if(data.data[j].name == names )
							{
								option += "<option value='"+data.data[j].id+"' selected='selected'>"+data.data[j].name+"</option>";
							}
							else
							{
								option += "<option value='"+data.data[j].id+"'>"+data.data[j].name+"</option>";
							}
						}
						$("#"+object).append(option);
						form.render('select');
					} 
					console.log("option:"+option);
					
				} else {
					layer.msg(data.msg);
				}
				
			} ,error:function(code){
	           layer.alert("发生错误,请联系管理员");
	        }
		});
	}
	layui.use(['form', 'table', 'laydate'], function() {
		var form = layui.form;
		var laydate = layui.laydate;
	
			/*
			下拉列表数据获取  开始
		*/
	var url ="";
	var object="";
	var ids="";
	var name;
	//专业
	ids = 'id';
	url = '/specialty/getSpecialtyList';
	object = 'specialtyId';
	names= specialty_name;
	ajax_h(form,names,url,object,ids);
	laydate.render({
		elem: '#date' //指定元素	
		,type: 'year'
	});
	/*提交功能*/
	  form.on('submit(submit)', function(data) {
			/*获取$值存入params */
			var date = $("#date").val();
			var courses = $("#courses").val();
			var specialtyId = $("#specialtyId option:checked").val();
			var specialtyName = $("#specialtyId option:checked").text();
			console.log(specialtyId);
			console.log(specialtyName);
			layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
			    $.ajax({
				        type:"POST",
				        url:window.path+'/MainCourses/addMainCourses',
						data:JSON.stringify({date:date,courses:courses,specialtyId:specialtyId,specialtyName:specialtyName}),
						contentType:"application/json;charset=UTF-8",
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
									layer.msg(data.msg);
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