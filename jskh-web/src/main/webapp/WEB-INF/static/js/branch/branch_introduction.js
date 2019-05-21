layui.use([ 'table', 'form', 'laydate' ], function() {
	var table = layui.table;
	var form = layui.form;
	var laydate = layui.laydate;

	laydate.render({
		elem : '#date' // 指定元素
	});
})

function save() {
	// 获取富文本框内容
	var situationUEStr = situationUE.getContent();
	var characteristicUEStr = characteristicUE.getContent();
	console.log("situationUEStr==" + situationUEStr);//控制台打印富文本框内容
	console.log("characteristicUEStr==" + characteristicUEStr);
	var params = {};
	params.specialtyInfo = situationUEStr
	params.date = $("#date").val();
	params.branchCharacteristic = characteristicUEStr;
	layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
	$.ajax({
		type : "POST",
		url : '/branch/addBranch',
		data : $.param(params),
		// 预期服务器返回数据的类型
		dataType : "json",
		success : function(data) {
			if (data) {
				console.log($.param(params));
				if (data.code == 0) {
					layer.msg("成功");
					setTimeout(function() {
						parent.window.location.reload();
					}, 500);
				} else if (data.code != 0) {
					layer.msg(data.msg);
				}
			}
		},
		error : function(code) {
			alert("发生错误,请联系管理员");
		}
		
	});
	 layer.close(index);
	});
			
	return false;
}