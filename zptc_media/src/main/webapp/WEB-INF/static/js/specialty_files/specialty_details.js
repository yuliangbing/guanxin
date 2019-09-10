/**
 * 查看页面的js
 */
	// 初始化
	function init(data) {
		$("#specialtyFilesId").val(data.id);
		$("#date").val(data.date);
		$("#code").val(data.code);
		$("#name").val(data.name);
		$("#cate_name").val(data.cateName);
		$("#reviser").val(data.reviser);
		$("#specialty_name").val(data.specialtyName);
		$("#showFile").text(data.urlFileName);
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