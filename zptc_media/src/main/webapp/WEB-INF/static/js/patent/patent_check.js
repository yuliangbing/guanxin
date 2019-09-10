/**
 * 查看页面的js
 */
	// 初始化
	function init(data) {
		$("#status").val(data.status);
		id = data.id;
		$("#date").val(data.date);
		$("#code").val(data.code);
		$("#name").val(data.name);
		$("#type").val(data.type);
		$("#first_author").val(data.firstAuthor);
		$("#other_authors").val(data.otherAuthors);
		$("#specialty_id").val(data.specialtyId);
		$("#specialty_name").val(data.specialtyName);
		$("#create_time").val(data.createTime);
		$("#create_user").val(data.createUser);
		$("#modify_time").val(data.modifyTime);
		$("#modify_user").val(data.modifyUser);
		specialty_name = data.specialty_name;
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