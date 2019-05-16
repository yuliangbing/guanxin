/**
 * 查看页面的js
 */
	// 初始化
	function init(data) {
		$("#status").val(data.status);
		id = data.id;
		$("#cate_code").val(data.cate_code);
		$("#name").val(data.name);
		$("#model_num").val(data.model_num);
		$("#specification").val(data.specification);
		$("#sources").val(data.sources);
		$("#date").val(data.date);
		$("#total_amount").val(data.total_amount);
		$("#country_code").val(data.country_code);
		$("#code").val(data.code);
		$("#manufacturer").val(data.manufacturer);
		$("#use_person").val(data.use_person);
		$("#status_code").val(data.status_code);
		$("#training_room").val(data.training_room);
		$("#remark").val(data.remark);
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