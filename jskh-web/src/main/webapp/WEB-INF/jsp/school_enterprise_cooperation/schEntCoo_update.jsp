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

			<div class="layui-form-item" style="margin-left:10%;margin-top:2%">
				
				<div class="layui-inline">
					<label class="layui-form-label">时间</label>
					<div class="layui-input-inline">
						<input name="date" id="date"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label">合作内容</label>
					<div class="layui-input-inline">
						<input name="content" id="content"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">合作单位</label>
					<div class="layui-input-inline">
						<input name="units" id="units"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">参与人员</label>
					<div class="layui-input-inline">
						<input name="participants" id="participants"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">取得成果</label>
					<div class="layui-input-inline"  >
						<input name="achievements" id="achievements"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业名称</label>
					<div class="layui-input-inline">
						<select  type="text" id="specialtyName"  lay-filter="specialtyName" autocomplete="off" placeholder="" lay-verify="required" class="layui-select" lay-search>
								<option value="">请选择</option>
							</select>
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
<%-- 	<script src="${path}/static/public/lib/layui.js" type="text/javascript" charset="utf-8"></script> --%>
		<script type="text/javascript" src="${path}/static/js/school_enterprise_cooperation/schEntCoo_List.js"></script>
	<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
	<script>
	//表格数据传值
	var id = 0;
	var specialtyName = "";
	function init(data) {
		id= data.id;
		$("#date").val((data.date.split(' '))[0]);
		$("#content").val(data.content);
		$("#units").val(data.units);
		$("#participants").val(data.participants);
		$("#achievements").val(data.achievements);
	//$("#specialtyName").val(data.specialtyName);
		specialtyName = data.specialtyName;

	}
	
	function ajax_h(form,names,url,object,ids)
	{
		$.ajax({
			url:url,
			type:"POST",
			dataType:"json",
			success:function(data){
				//console.log("长度"+data.data.length);
				//console.log(names);
				let option = "";
				 if(ids == 'id')
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
					//console.log("option:"+option);
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
	object = 'specialtyName';
	names = specialtyName;
	ajax_h(form,names,url,object,ids);
		laydate.render({
			elem: '#date' //指定元素	
		});
		
	/*提交功能*/
	  form.on('submit(submit)', function(data) {
			/*获取$值存入params */
			var params = {};
			params.date = $("#date").val();
			params.content = $("#content").val();
			params.units = $("#units").val();
			params.participants = $("#participants").val();
			params.achievements = $("#achievements").val();
			params.specialty_id = $("#specialtyName option:checked").val();
			params.specialty_name = $("#specialtyName option:checked").text();
//console.log(params);

			layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
			    $.ajax({
				        type:"POST",
				        url:window.path+'/SchoolEnterpriseCooperation/updateSchoolEnterpriseCooperation?id='+id,
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