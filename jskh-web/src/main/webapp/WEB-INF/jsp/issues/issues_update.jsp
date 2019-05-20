<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
<script type="text/javascript" src="${path}/static/public/layui/layui.js"></script>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="${path}/static/js/issues/issues_List.js"></script>
</head>
<body>
		<form class="layui-form" onsubmit="return false;">

			<div class="layui-form-item" style="margin-left:10%;margin-top:2%">
				
				<div class="layui-inline">
					<label class="layui-form-label">时间</label>
					<div class="layui-input-inline">
						<input name="date" id="date" lay-verify="required|date" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">立项编号</label>
					<div class="layui-input-inline">
						<input name="code" id="code" lay-verify="required|number" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">课题名称</label>
					<div class="layui-input-inline">
						<input name="name" id="name" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			
				<div class="layui-inline">
					<label class="layui-form-label">课题来源</label>
					<div class="layui-input-inline">
						<input name="sources" id="sources" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">主持人</label>
					<div class="layui-input-inline">
						<input name="host" id="host" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">参与人</label>
					<div class="layui-input-inline"  >
						<input name="participants" id="participants" lay-verify="required" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">专业</label>
					<div class="layui-input-inline">
						<select name="specialty_id"  id="specialty_id" lay-verify="required" autocomplete="off" class="layui-input" type="text">
							<option value="">请选择</option>
						</select>
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
  		<script type="text/javascript" src="${path}/static/js/date.js" charset="utf-8"></script>
	<script>
	//表格数据传值
	var id = 0;
	var specialty_name = "";
	function init(data) {

		id = data.id;
		$("#date").val((data.date.split(' '))[0]);
		$("#code").val(data.code);
		$("#name").val(data.name);
		$("#sources").val(data.sources);
		$("#awards_construction").text(data.awards_construction);
		$("#host").val(data.host);
		$("#participants").val(data.participants);
		$("#specialty_id").val(data.specialty_id);
		specialty_name = data.specialty_name;
	}
	
	function ajax_h(form,names,url,object,ids)
	{
		$.ajax({
			url:url,
			type:"POST",
			dataType:"json",
			success:function(data){
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
	object = 'specialty_id';
	names= specialty_name;
	ajax_h(form,names,url,object,ids);
		laydate.render({
			elem: '#date' //指定元素	
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
			params.awardsConstruction = $("#awards_construction").val();
			params.specialty_id = $("#specialty_id option:checked").val();
			params.specialty_name = $("#specialty_id option:checked").text();
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