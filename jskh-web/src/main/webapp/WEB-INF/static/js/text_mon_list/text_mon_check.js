/**
 * 查看页面的js
 */
	// 初始化
	function init(data) {
		//$("#organization_typeId").val(data.Id);
		$("#status").val(data.status);
		$("#name").val(data.name);
		$("#date").val(data.date);
		$("#press").val(data.press);
		$("#first_author").val(data.first_author);
		$("#other_authors").val(data.other_authors);
		$("#create_time").val(data.create_time);
		$("#create_user").val(data.create_user);
		$("#modify_time").val(data.modify_time);
		$("#modify_user").val(data.modify_user);
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