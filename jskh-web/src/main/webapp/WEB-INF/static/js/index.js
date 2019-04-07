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

function getUser() {
	$.ajax({
		type : "POST", // 提交方式
		url : window.path + "/home/getUser",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.status == "200" && result.data.user != null) {
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

function getUserMenu() {
	$.ajax({
		type : "POST", // 提交方式
		url : window.path + "/home/getUserMenu",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.status == "200") {
				$('#nav').empty();
				var menuList = result.data;
				var html_ = "";
				for (var i = 0; i < menuList.length; i++) {
					var menu = menuList[i];
					if (!menu.hasSubMenu) {
						html_ += "<li><a _href='"+menu.url+"'>";
						html_ += "<i class='iconfont'>&#xe6b8;</i>";
						html_ += "<cite>"+menu.menuStr+"</cite>";
						html_ += "</a>";
						html_ += "</li>";
					} else {
						var subMenuList = menu.subMenuList;
						var html_ = "<li><a href='javascript:;'>";
						html_ += "<i class='iconfont'>&#xe6b8;</i>";
						html_ += "<cite>"+menu.menuStr+"</cite>";
						html_ += "<i class='iconfont nav_right'>&#xe697;</i></a>";
						html_ += "<ul class='sub-menu'>";
						for (var i = 0; i < subMenuList.length; i++) {
							var subMenu = subMenuList[i];
							html_ += "<li><a _href='"+subMenu.url+"'>";
							html_ += "<cite>"+subMenu.menuStr+"</cite></a></li>";
						}
						html_ += "</ul>";
					}
				}
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