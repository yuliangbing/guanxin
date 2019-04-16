$(document).ready(function() {
	layui.use('table', function() {
		var table = layui.table;
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
		html_ += "<td><div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div></td>";
		html_ += "<td><i style='margin-left:" + menu.level * 30 + "px;'></i>"
				+ menu.menuStr;
		if (menu.hasSubMenu) {
			html_ += "<i class=\"layui-icon x-show\" status='true' style='float:right'>&#xe603;</i>";
		}
		html_ += "</td>";
		html_ += "<td>" + menu.menuNum + "</td>";
		html_ += "<td>" + menu.url + "</td>";
		html_ += "<td class=\"td-manage\">";
		html_ += "<button class=\"layui-btn layui-btn layui-btn-xs\" onclick=\"x_admin_show('编辑','admin-edit.html')\"><i class=\"layui-icon\">&#xe642;</i>编辑</button>";
		html_ += "<button class=\"layui-btn layui-btn-warm layui-btn-xs\" onclick=\"x_admin_show('编辑','admin-edit.html')\"> <i class=\"layui-icon\">&#xe642;</i>添加子菜单 </button>";
		html_ += "<button class=\"layui-btn-danger layui-btn layui-btn-xs\" onclick=\"member_del(this,'要删除的id')\" href=\"javascript:;\"><i class=\"layui-icon\">&#xe640;</i>删除</button></td></tr>";
		if (menu.hasSubMenu) {
			var subMenuList = menu.subMenuList;
			html_ = appendMenu(html_, subMenuList);
		}
	}
	return html_;
}

function initMenuEvent() {
	$("tbody.x-cate tr[fid!='']").hide();
	// 栏目多级显示效果
	$('.x-show').click(
			function() {
				if ($(this).attr('status') == 'true') {
					$(this).html('&#xe61a;');
					$(this).attr('status', 'false');
					cateId = $(this).parents('tr').attr('cate-id');
					$("tbody tr[fid=" + cateId + "]").show();
				} else {
					cateIds = [];
					$(this).html('&#xe603;');
					$(this).attr('status', 'true');
					cateId = $(this).parents('tr').attr('cate-id');
					getCateId(cateId);
					for ( var i in cateIds) {
						$("tbody tr[cate-id=" + cateIds[i] + "]").hide().find(
								'.x-show').html('&#xe603;').attr('status',
								'true');
					}
				}
			})
}

function add() {
	layer.open({
		title : '新增父菜单',
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
		}
	});
}