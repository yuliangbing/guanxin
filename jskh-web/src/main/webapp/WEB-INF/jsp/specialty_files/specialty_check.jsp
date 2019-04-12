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
	<div class="layui-col-md12 layui-content-white">

		<form class="layui-form" action="" onsubmit="return false;">
			<div class="layui-form-item">
				<fieldset class="layui-elem-field">
					<legend>查看专业文件</legend>
				<div class="layui-form-item">
				    <label class="layui-form-label" for="date">文件时间</label>
				    <div class="layui-input-block">
							<input disabled type="text" id="date" name="date" lay-verify="" placeholder="请选择文件时间" class="layui-input">
					</div>
			    </div>
			    <div class="layui-form-item">
				    <label class="layui-form-label" for="code">文件编号</label>
				    <div class="layui-input-block">
							<input disabled type="text" id="code" name="code" lay-verify="" placeholder="请输入文件编号" class="layui-input">
					</div>
			    </div>
			    <div class="layui-form-item">
				    <label class="layui-form-label" for="name">文件名称</label>
				    <div class="layui-input-block">
							<input disabled type="text" id="name" name="name" lay-verify="" placeholder="请输入文件名称" class="layui-input">
					</div>
			    </div>
			    <div class="layui-form-item">
				    <label class="layui-form-label" for="cate_name">文件类型名称</label>
				    <div class="layui-input-block">
						<select disabled type="text" id="cate_name" lay-filter="cate_name" autocomplete="off" placeholder="" lay-verify="" class="layui-select" lay-search>
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
							<input disabled type="text" id="reviser" name="reviser" lay-verify="" placeholder="请输入文件名称" class="layui-input">
					</div>
			    </div>
			    <div class="layui-form-item">
				    <label class="layui-form-label" for="specialty_id">文件类型名称</label>
				    <div class="layui-input-block">
						<select disabled type="text" id="specialty_id" lay-filter="specialty_id" autocomplete="off" placeholder="" lay-verify="" class="layui-select" lay-search>
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
			<!--<button class="layui-btn layui-right" lay-submit lay-filter="submit">保存</button>
			<button type="reset" class="layui-btn layui-btn-danger">重置</button>-->
			<button class="layui-btn layui-btn-normal" onclick="exit();" >关闭</button>
		</form>
	<!--</div>-->
<!--</div>-->
	</div>
		
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   	<script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script>
	// 初始化
	function init(data) {
		$("#specialtyFilesId").val(data.id);
		$("#date").val(data.date);
		$("#code").val(data.code);
		$("#name").val(data.name);
		$("#cate_name").val(data.cate_name);
		$("#reviser").val(data.reviser);
		$("#specialty_id").val(data.specialty_id);
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
	
		});
	</script>
	</body>
</html>