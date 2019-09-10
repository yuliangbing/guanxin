/**
 * 查看页面的js
 */
	// 初始化
	function init(data) {
		$("#status").val(data.status);
		id = data.id;
		$("#cate_code").val(data.cateCode);
		$("#name").val(data.name);
		$("#model_num").val(data.modelNum);
		$("#specification").val(data.specification);
		$("#sources").val(data.sources);
		$("#date").val(data.date);
		$("#total_amount").val(data.totalAmount);
		$("#country_code").val(data.countryCode);
		$("#code").val(data.code);
		$("#manufacturer").val(data.manufacturer);
		$("#use_person").val(data.usePerson);
		$("#status_code").val(data.statusCode);
		$("#training_room").val(data.trainingRoom);
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