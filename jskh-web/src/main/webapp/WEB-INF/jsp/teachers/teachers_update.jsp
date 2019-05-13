<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
<script type="text/javascript" src="${path}/static/js/teachers/teachers_List.js"></script>
<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
<title>浙江邮电职业技术学院管理系统</title>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:10%;margin-top:2%">
				
				<div class="layui-inline">
					<label class="layui-form-label">教师姓名</label>
					<div class="layui-input-inline">
						<input name="name" id="name"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">教师编号</label>
					<div class="layui-input-inline">
						<input name="code" id="code"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入职时间</label>
					<div class="layui-input-inline">
						<input name="entryTime" id="entryTime"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">出生时间</label>
					<div class="layui-input-inline">
						<input name="birthday" id="birthday"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">毕业院校</label>
					<div class="layui-input-inline">
						<input name="graduateSchool" id="graduateSchool"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">学历学位</label>
					<div class="layui-input-inline"  >
						<select name="finalDegree"  id="finalDegree" autocomplete="off" class="layui-input" type="text">
							<option value="">请选择</option>
							<option value="高中">高中</option>
							<option value="大专">大专</option>
							<option value="本科">本科</option>
							<option value="研究生">研究生</option>
							<option value="学士">学士</option>
							<option value="硕士">硕士</option>
							<option value="博士">博士</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">政治面貌</label>
					<div class="layui-input-inline">
						<select name="politicalStatus"  id="politicalStatus" autocomplete="off" class="layui-input" type="text">
							<option value="">请选择</option>
							<option value="中共党员">中共党员</option>
							<option value="中共预备党员">中共预备党员</option>
							<option value="共青团员">共青团员</option>
							<option value="群众">群众</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">研究方向</label>
					<div class="layui-input-inline">
						<input name="researchDirection" id="researchDirection"  autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">是否兼职</label>
					<div class="layui-input-block">
						<input type="radio" name="isPartTime" id="isPartTime"  value="2" title="是" class="layui-input" checked="checked">
						<input type="radio" name="isPartTime" id="isPartTime"  value="1" title="否" class="layui-input" >					
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业</label>
					<div class="layui-input-inline">
						<select name="specialtyId"  id="specialtyId" autocomplete="off" class="layui-input" type="text">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" style="width: 33%;">团队负责人</label>
					<div class="layui-input-block">
						<input type="radio" name="director" id="director"  value="1" title="是" class="layui-input" checked="checked">
						<input type="radio" name="director" id="director"  value="2" title="否" class="layui-input" >					
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
	var specialty_name = "";
	function init(data) {

		$("#id").val(data.id);
		$("#name").val(data.name);
		$("#code").val(data.code);
		$("#entryTime").val((data.entryTime.split(' '))[0]);
		$("#birthday").val((data.birthday.split(' '))[0]);
		$("#graduateSchool").val(data.graduateSchool);
		$("#finalDegree").val(data.finalDegree);
		$("#politicalStatus").val(data.politicalStatus);
		//$("#specialtyCode").val(data.specialtyCode);
		$("#specialtyName").val(data.specialtyId);
		$("#specialtyName").val(data.specialtyName);
		$("#researchDirection").val(data.researchDirection);
		$("input[name='isPartTime']:checked").val();
		$("#director").val(data.director);
		$("#createTime").val(data.createTime);
		$("#createUser").val(data.createUser);
		$("#modifyTime").val(data.modifyTime);
		$("#modifyUser").val(data.modifyUser);
		$("#specialtyId").val(data.specialtyId);
		specialty_name = data.specialtyName;
	}
	//专业id select
	/* var id = 0;
	var specialty_name = ""; */	
	function ajax_h(form,names,url,object,ids)
	{
		$.ajax({
			url:url,
			type:"POST",
			dataType:"json",
			success:function(data){
				layer.msg("获取成功");
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
			elem: '#entryTime' //指定元素	
		});
		laydate.render({
			elem: '#birthday' //指定元素	
		});
	/*提交功能*/
	  form.on('submit(submit)', function(data) {
			/*获取$值存入params */
			var params = {};
			params.name = $("#name").val();
			params.code = $("#code").val();
			params.entry_time = $("#entryTime").val();
			params.birthday = $("#birthday").val();
			params.graduate_school = $("#graduateSchool").val();
			params.final_degree = $("#finalDegree").val();
			params.political_status = $("#politicalStatus").val();
			params.specialty_code = $("#specialtyCode").val();
			params.research_direction = $("#researchDirection").val();
			params.is_part_time = $("input[name='isPartTime']:checked").val();
			params.director = $("input[name='director']:checked").val();
			params.specialty_id = $("#specialtyId option:checked").val();
			params.specialty_name = $("#specialtyId option:checked").text();
			console.log(params);
			layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
			    $.ajax({
				        type:"POST",
				        url:window.path+'/teachers/addTeacher',
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