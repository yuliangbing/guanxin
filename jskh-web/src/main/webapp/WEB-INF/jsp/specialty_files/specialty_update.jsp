<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业文件</title>

<link rel="stylesheet" href="/static/public/lib/layui/css/layui.css">
</head>
<body class="layui-layout-body">
		<!--<div class="layui-layout layui-layout-admin">-->
				<!--<div class="layui-row layui-col-space15">-->
					<!-- 内容主体区域 -->
	<div class="layui-col-md12 layui-content-white">

		<form class="layui-form" action="" onsubmit="return false;">
			<div class="layui-form-item">
				<fieldset class="layui-elem-field">
					<legend>新增专业文件</legend>
					<div class="layui-form-item">
					    <label class="layui-form-label" for="date">文件时间</label>
					    <div class="layui-input-block">
								<input  type="text" id="date" name="date" lay-verify="" placeholder="请选择文件时间" class="layui-input">
						</div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="code">文件编号</label>
					    <div class="layui-input-block">
								<input  type="text" id="code" name="code" lay-verify="" placeholder="请输入文件编号" class="layui-input">
						</div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="name">文件名称</label>
					    <div class="layui-input-block">
								<input  type="text" id="name" name="name" lay-verify="" placeholder="请输入文件名称" class="layui-input">
						</div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="cate_name">文件类型名称</label>
					    <div class="layui-input-block">
							<select  type="text" id="cate_name" lay-filter="cate_name" autocomplete="off" placeholder="" lay-verify="" class="layui-select" lay-search>
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
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="reviser">修订人</label>
					    <div class="layui-input-block">
								<input  type="text" id="reviser" name="reviser" lay-verify="" placeholder="请输入文件名称" class="layui-input">
						</div>
				    </div>
				    <div class="layui-form-item">
					    <label class="layui-form-label" for="specialty_id">文件类型名称</label>
					    <div class="layui-input-block">
							<select  type="text" id="specialty_id" lay-filter="specialty_id" autocomplete="off" placeholder="" lay-verify="" class="layui-select" lay-search>
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
				</fieldset>
			</div>
			<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
			<button type="reset" class="layui-btn layui-btn-danger">重置</button>
			<button class="layui-btn layui-btn-normal" onclick="exit();" >关闭</button>

		</form>
	<!--</div>-->
<!--</div>-->
	</div>
		
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
  		<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
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
				layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
				    $.ajax({
					        type:"PUT",
					        url:"http://47.111.23.192:82/hmBack/adminApi/examination/updateExaminationDetailsById",
							data:data.field,
					        //预期服务器返回数据的类型
					        dataType:"json", 
					        success:function(err,msg){
					        	if(err,msg){
									console.log(err);
									console.log(msg);
									if (msg.code == 0) {
										layer.msg("11"+msg_000000004);
										setTimeout(function(){
												parent.window.location.reload();
										},500);
									} else {
										layer.msg("22"+msg.code);
									}
								}else{
									console.log(err);
									layer.msg(msg_000000001);
								}
							} ,error:function(err,msg){
					           alert("发生错误");
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