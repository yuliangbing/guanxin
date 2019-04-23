<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业文件</title>

<link rel="stylesheet" href="/static/public/lib/layui/css/layui.css">
</head>
<body class="layui-body">
	<div class="layui-row layui-col-space15">
		<div class="layui-col-md12 layui-content-white">
	
			<form class="layui-form" onsubmit="return false;">
						<!-- 隐藏text,用于存放入参的id -->
						<input type="hidden" id="specialtyFilesId" name="specialtyFilesId" >
					    <div class="layui-form-item" style="margin: 7% 10% 10% 0px;">
					    	<div class="layui-inline">
							    <label class="layui-form-label" for="code">文件编号</label>
							    <div class="layui-input-inline">
										<input  type="text" id="code" name="code" lay-verify="required" placeholder="请输入文件编号" class="layui-input" value="">
								</div>
							</div>
							<div class="layui-inline">
								<label class="layui-form-label" for="date">文件时间</label>
							    <div class="layui-input-inline">
										<input  type="text" id="date" name="date" lay-verify="date" placeholder="请选择文件时间" class="layui-input">
								</div>
							</div>
							<div class="layui-inline">
								<label class="layui-form-label" for="name">文件名称</label>
							    <div class="layui-input-inline">
										<input  type="text" id="name" name="name" lay-verify="required" placeholder="请输入文件名称" class="layui-input">
								</div>
							</div>
							<div class="layui-inline">
							<label class="layui-form-label" for="cate_name">文件类型</label>
						    <div class="layui-input-inline">
								<select  id="cate_name" lay-verify="required" class="layui-select" lay-search>
									<option value="">请选择</option>
								</select>
							</div>
							</div>
							<div class="layui-inline">
								<label class="layui-form-label" for="reviser">修订人</label>
							    <div class="layui-input-inline">
									<input  type="text" id="reviser" name="reviser" lay-verify="required" placeholder="请输入文件名称" class="layui-input">
								</div>
							</div>
							<div class="layui-inline">
								<label class="layui-form-label" for="specialty_id">专业id</label>
							    <div class="layui-input-inline">
									<select id="specialty_id" lay-filter="specialty_id" lay-verify="required" class="layui-select" lay-search>
										<option value="">请选择</option>
										
									</select>
								</div>
							</div>
					    </div>
					    <!-- <div class="layui-form-item">
						    <label class="layui-form-label" for="date">文件时间</label>
						    <div class="layui-input-inline">
									<input  type="text" id="date" name="date" lay-verify="date" placeholder="请选择文件时间" class="layui-input">
							</div>
					    </div> -->
					   <!--  <div class="layui-form-item">
						    <label class="layui-form-label" for="name">文件名称</label>
						    <div class="layui-input-inline">
									<input  type="text" id="name" name="name" lay-verify="required" placeholder="请输入文件名称" class="layui-input">
							</div>
					    </div> -->
					    <!-- <div class="layui-form-item">
						    <label class="layui-form-label" for="cate_name">文件类型</label>
						    <div class="layui-input-inline">
								<select  id="cate_name" lay-verify="required" class="layui-select" lay-search>
									<option value="">请选择</option>
								</select>
							</div>
					    </div> -->
					    <!-- <div class="layui-form-item">
						    <label class="layui-form-label" for="reviser">修订人</label>
						    <div class="layui-input-inline">
									<input  type="text" id="reviser" name="reviser" lay-verify="required" placeholder="请输入文件名称" class="layui-input">
							</div>
					    </div> -->
					   <!--  <div class="layui-form-item">
						    <label class="layui-form-label" for="specialty_id">专业id</label>
						    <div class="layui-input-inline">
								<select  type="text" id="specialty_id" lay-filter="specialty_id" autocomplete="off" placeholder="" lay-verify="required" class="layui-select" lay-search>
									<option value="">请选择</option>
									<option value="0">已报名</option>
									<option value="1">已缴费</option>
									<option value="2">已上传</option>
									<option value="3">审核中</option>
									<option value="4">视频不合格</option>
									<option value="5">体检合格</option>
									<option value="6">体检不合格</option>
								</select>
							</div>
					    </div> -->
					<!-- </fieldset>
				</div> -->
				<div style="margin: 0% 0% 0% 6%;">
					<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
					<button type="reset" class="layui-btn layui-btn-danger" id="reset">重置</button>
					<button class="layui-btn layui-btn-normal" onclick="exit();" >关闭</button>
				</div>
			</form>
		</div>
</div>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  		<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
	var cate_name = "";
	var specialty_name = "";
	// 初始化赋值
	function init(data) {
		$("#specialtyFilesId").val(data.id);
		$("#date").val(data.date);
		$("#code").val(data.code);
		$("#name").val(data.name);
		cate_name = data.cate_name;
		$("#reviser").val(data.reviser);
		specialty_name = data.specialty_name;
	}
	//获取下拉列表(公共方法)
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
			
			/*
				下拉列表数据获取  开始
			*/
			var url ="";
			var object="";
			var ids="";
			var name;
			//文件类型
			url = '/fileCategory/getFileCategoryList';
			object = 'cate_name';
			ids = 'code';
			names = cate_name;
			ajax_h(form,names,url,object,ids);
			//专业
			ids = 'id';
			url = '/specialty/getSpecialtyList';
			object = 'specialty_id';
			names= specialty_name;
			ajax_h(form,names,url,object,ids);
			/*
				下拉列表数据获取  结束
			*/
			
			// 实现文件时间选择
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
				params.id = $("#specialtyFilesId").val();
				params.date = $("#date").val();
				params.code = $("#code").val();
				params.name = $("#name").val();
				params.cate_name = $("#cate_name option:checked").text();
				params.reviser = $("#reviser").val();
				params.specialty_id = $("#specialty_id option:checked").val();
				params.specialty_name = $("#specialty_id option:checked").text();
				layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
				    $.ajax({
					        type:"POST",
					        url:'/specialtyFiles/updateSpecialtyFilesIf?specialtyFilesId='+params.id,
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