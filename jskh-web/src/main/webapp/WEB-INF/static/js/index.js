$(document).ready(function() {
	getSystemName();
	layui.use('layer', function() {
		var layer = layui.layer;
	});
});

function getSystemName() {
	$.ajax({
		type : "POST", // 提交方式
		url : window.path + "/home/getUser",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.status == "200" && result.data.user != null) {
				$("#username").html(result.data.user.teaName);
				console.log(JSON.Stringify(result.user));
			} else {
				layer.msg(result.msg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("系统错误");
		}
	});
}

function getUser() {
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

function logout() {
	$.ajax({
		type : "POST", // 提交方式
		url : window.path + "/home/logout",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.status == "200") {
				layer.alert("退出成功!", function(){
					window.location.href="/home/toLogin";
				});       
			} else {
				layer.msg(result.msg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("系统错误");
		}
	});
}