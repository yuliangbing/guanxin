$(document).ready(function() {
	getSystemName();
});

function getSystemName() {
	$.ajax({
		type : "POST", // 提交方式
		url : window.path + "/home/getSystem",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.status == "200") {
				$("#systemName").html(result.data.systemName);
				$("#systemName").attr("href", result.data.systemLink);
			} else {
				layer.msg(result.msg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("系统错误");
		}
	});
}