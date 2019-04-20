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
						<!-- 隐藏text,用于存放入参的status -->
						<input type="hidden" id="status" name="status" value="1" >
						<!-- <input type="hidden" id="specialtyFilesId" name="specialtyFilesId" > -->
					    <div class="layui-form-item">
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
							</div>
					    </div>
				<div style="margin:;">
					<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
					<button type="reset" class="layui-btn layui-btn-danger">重置</button>
					<button class="layui-btn layui-btn-normal" onclick="exit();" >关闭</button>
				</div>
			</form>
		</div>
</div>
	<%-- <div class="layui-col-md12 layui-content-white">

		<form class="layui-form" action="" onsubmit="return false;">
					<!-- <input type="hidden" id="specialtyFilesId" name="id" > -->
					<input type="hidden" id="status" name="status" value="1" >
					<div class="layui-form-item">
					    <label class="layui-form-label" for="code">文件编号</label>
					    <div class="layui-input-block">
								<input  type="text" id="code" name="code" lay-verify="required" placeholder="请输入文件编号" class="layui-input" value="${list[0].code}">
						</div>
				    </div>
					<div class="layui-form-item">
					    <label class="layui-form-label" for="date">文件时间</label>
					    <div class="layui-input-block">
								<input  type="text" id="date" name="date" lay-verify="date" placeholder="请选择文件时间" class="layui-input">
						</div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="name">文件名称</label>
					    <div class="layui-input-block">
								<input  type="text" id="name" name="name" lay-verify="required" placeholder="请输入文件名称" class="layui-input">
						</div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="cate_name">文件类型名称</label>
					    <div class="layui-input-block">
							<select  type="text" id="cate_name" lay-filter="cate_name" autocomplete="off" placeholder="" lay-verify="required" class="layui-select" lay-search>
								<option value="">请选择</option>
								
							</select>
						</div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="reviser">修订人</label>
					    <div class="layui-input-block">
								<input  type="text" id="reviser" name="reviser" lay-verify="required" placeholder="请输入文件名称" class="layui-input">
						</div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="specialty_id">专业id</label>
					    <div class="layui-input-block">
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
				    </div>
			<div style="margin:1px 533px;">
				<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
				<button type="reset" class="layui-btn layui-btn-danger">重置</button>
				<button class="layui-btn layui-btn-normal" onclick="exit();" >关闭</button>
			</div>
			

		</form>
	</div> --%>
		
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  		<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
		//关闭弹窗监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		
		function ajax_h(form){
			//获取状态
			$.ajax({
				url:'/fileCategory/getFileCategoryList',
				type:"POST",
//				data:{specialtyFilesId:data.id},
				dataType:"json",
				success:function(data){
					console.log(data);
					layer.msg("获取成功");
					console.log(data.data.length);
					if (data.code == 0) {
						
						let option = "";
						for (let i=0;i<data.data.length;i++) {
							option += "<option value='"+data.data[i].code+"'>"+data.data[i].name+"</option>";
							
						}
						$("#cate_name").append(option);
						form.render('select');
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
			//获取文件类型下拉框属性
			ajax_h(form);
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
				params.specialty_id = $("#specialty_id").val();
				console.log("文件类型输出打印"+params.cate_name);
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