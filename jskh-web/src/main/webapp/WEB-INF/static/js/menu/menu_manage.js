$(document).ready(function() {
	layui.use(['table','form'], function() {
		var table = layui.table;
		var form = layui.form;
		getMenuList();
	})
})

function getMenuList() {
	$.ajax({
		type : "POST", // 提交方式
		url : "/menu/getMenuList",// 路径
		data : {},// 数据，这里使用的是Json格式进行传输
		dataType : "json",
		success : function(result) {// 返回数据根据结果进行相应的处理
			if (result.code == "0") {
				var menuList = result.data;
				$("#menuTableBody").empty();
				var html_ = "";
				html_ = appendMenu(html_, menuList);
				$("#menuTableBody").append(html_);
				initMenuEvent();
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
		html_ += "<tr cate-id='" + menu.id + "' fid='";
		if (menu.parentId != null) {
			html_ += menu.parentId;
		}
		html_ += "'>";
		html_ += "<td><i style='margin-left:" + menu.level * 30 + "px;'></i>"
				+ menu.menuStr;
		if (menu.hasSubMenu) {
			html_ += "<i class=\"layui-icon x-show\" status='true' style='float:right'>&#xe603;</i>";
		}
		html_ += "</td>";
		html_ += "<td>" + menu.menuNum + "</td>";
		html_ += "<td>" + menu.url + "</td>";
		html_ += "<td class=\"td-manage\">";
		html_ += "<button class=\"layui-btn layui-btn layui-btn-xs\" onclick=\"edit("+menu.id+")\"><i class=\"layui-icon\">&#xe642;</i>编辑</button>";
		html_ += "<button class=\"layui-btn layui-btn-warm layui-btn-xs\" onclick=\"add("+menu.id+",'"+menu.menuStr+"')\"> <i class=\"layui-icon\">&#xe642;</i>添加子菜单 </button>";
		html_ += "<button class=\"layui-btn-danger layui-btn layui-btn-xs\" onclick=\"del("+menu.id+")\" href=\"javascript:;\"><i class=\"layui-icon\">&#xe640;</i>删除</button></td></tr>";
		if (menu.hasSubMenu) {
			var subMenuList = menu.subMenuList;
			html_ = appendMenu(html_, subMenuList);
		}
	}
	return html_;
}

function initMenuEvent() {
	$("tbody.x-cate tr[fid!='']").hide();
}

function add(parentId,parentStr) {
	layer.open({
		title : '新增菜单',
		type : 2,
		content : 'toPage?page=menu/menu_add',
		area : [ ($(window).width() * 0.9) + "px",
				($(window).height() * 0.9) + "px" ],
		btn : [ '保存', '取消' ],
		btnAlign : 'c',
		yes : function(index, layero) {
			// 获取子页面的iframe
			var iframe = window['layui-layer-iframe' + index];
			// 向子页面的全局函数child传参
			iframe.addConfirm();
		},
		btn2 : function(index, layero) {
			layer.closeAll();
		},
		cancel : function() {
			layer.closeAll();
		},
		success : function(layero, index) {
			// 获取子页面的iframe
			var iframe = window['layui-layer-iframe' + index];
			// 向子页面的全局函数child传参
			iframe.addInit(parentId,parentStr);
		}
	});
}

function del(id){
	layer.confirm('确认要删除吗？', function(index) {
		$.ajax({
			type : "POST", // 提交方式
			url : "/menu/deleteMenu",// 路径
			data : {
				"menuId": id
			},// 数据，这里使用的是Json格式进行传输
			dataType : "json",
			success : function(result) {// 返回数据根据结果进行相应的处理
				if (result.code == "0") {
					layer.msg('已删除!', {
						time : 1000
					});
					getMenuList();
				} else {
					layer.msg('删除失败!', {
						time : 1000
					});
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				layer.msg("系统错误");
			}
		});
	});
}

function edit(id) {
	layer.open({
		title : '新增父菜单',
		type : 2,
		content : 'toPage?page=menu/menu_edit',
		area : [ ($(window).width() * 0.9) + "px",
				($(window).height() * 0.9) + "px" ],
		btn : [ '保存', '取消' ],
		btnAlign : 'c',
		yes : function(index, layero) {
			// 获取子页面的iframe
			var iframe = window['layui-layer-iframe' + index];
			// 向子页面的全局函数child传参
			iframe.editConfirm();
		},
		btn2 : function(index, layero) {
			layer.closeAll();
		},
		cancel : function() {
			layer.closeAll();
		},
		success : function(layero, index) {
			// 获取子页面的iframe
			var iframe = window['layui-layer-iframe' + index];
			// 向子页面的全局函数child传参
			iframe.editInit(id);
		}
	});
}