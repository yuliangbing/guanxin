var pageUrl_ = "toPage?page=";
//var pageUrl_ = "";

$(document).ready(function() {
	getSystemName();
	getUser();
	getUserMenu();
});

function getSystemName() {
	$.ajax({
		type : "POST", // 提交方式
		url : window.path + "/home/getSystem",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.code == "0") {
				//$("#systemName").html(result.data.systemName);
				$("#systemName").html('专业发展平台');
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

function getUser() {
	$.ajax({
		type : "POST", // 提交方式
		url : window.path + "/home/getUser",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.code == "0" && result.data.user != null) {
				$("#username").html(result.data.user.teaName);
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
			if (result.code == "0") {
				layer.alert("退出成功!", function() {
					window.location.href = "/home/toLogin";
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

function getUserMenu() {
	$.ajax({
		type : "POST", // 提交方式
		url : window.path + "/home/getUserMenu",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.code == "0") {
				$('#nav').empty();
				var menuList = result.data;
				var html_ = "";
				html_ = appendMenu(html_, menuList);
				$("#nav").html(html_);
			} else {
				layer.msg(result.msg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("系统错误");
		}
	});
}

function appendMenu(html_, menuList) {
	for (var i = 0; i < menuList.length; i++) {
		var menu = menuList[i];
		if (!menu.hasSubMenu) {
			html_ += "<li><a _href='" + pageUrl_ + menu.url + "'>";
			html_ += "<i class='iconfont'>&#xe6b8;</i>";
			html_ += "<cite>" + menu.menuStr + "</cite>";
			html_ += "</a>";
			html_ += "</li>";
		} else {
			var subMenuList = menu.subMenuList;
			html_ += "<li><a href='javascript:;'>";
			html_ += "<i class='iconfont'>&#xe6b8;</i>";
			html_ += "<cite>" + menu.menuStr + "</cite>";
			html_ += "<i class='iconfont nav_right'>&#xe697;</i></a>";
			html_ += "<ul class='sub-menu'>";
			html_ = appendMenu(html_,subMenuList);
			html_ += "</ul>";
		}
	}
	return html_;
}