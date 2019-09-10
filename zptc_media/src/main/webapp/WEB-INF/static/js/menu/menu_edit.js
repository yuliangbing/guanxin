$(document).ready(function() {
	layui.use('form', function() {
		var form = layui.form;
	})
})

function editInit(id){
	$("#menuId").val(id);
	$.ajax({
		type: "post",
		url: "/menu/getMenuById",
		data: {
			"menuId": id
		},
		dataType: "json",
		success: function(result) {
			if(result.code == 0) {
				var menu = result.data;
				if (menu.parentId != null) {
					$("#parentMenu").show();
					$("#parentId").val(menu.parentId);
					$("#parentStr").val(menu.parentStr);
					$("#parentNum").val(menu.parentNum);
				}
				$("#menuStr").val(menu.menuStr);
				$("#menuNum").val(menu.menuNum);
				$("#url").val(menu.url);
				$("#menuOrder").val(menu.menuOrder);
				$("#showType").val(menu.showType);
				$("#remark").val(menu.remark);
				$("#icon").val(menu.icon);
			}else{
				layer.msg("初始化失败!");
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			parent.layer.msg("系统异常，请联系管理员！");
		}
	});
}

function editConfirm() {
	var params = {};
	params.menuId = $("#menuId").val();
	params.parentId = $("#parentId").val();
	params.parentStr = $("#parentStr").val();
	params.parentNum = $("#parentNum").val();
	params.menuStr = $("#menuStr").val();
	params.menuNum = $("#menuNum").val();
	params.url = $("#url").val();
	params.menuOrder = $("#menuOrder").val();
	params.showType = $("#showType").val();
	params.remark = $("#remark").val();
	params.icon = $("#icon").val();
	
	if (params.menuStr == '') {
		layer.alert("菜单名称不能为空");
		return false;
	}
	if (params.menuNum == '') {
		layer.alert("菜单编号不能为空");
		return false;
	}
	if (params.showType == '') {
		layer.alert("是否显示不能为空");
		return false;
	}
	// 数据保存
	$.ajax({
		type: "post",
		url: "/menu/updateMenu",
		data: $.param(params),
		dataType: "json",
		success: function(result) {
			if(result.code == 0) {
				parent.layer.open({
					title: '提示',
					content: "保存成功！",
					btn: ['确定'],
					yes: function(index, layero) {
						parent.layer.closeAll();
						parent.getMenuList();
					},
				});
				
			}else{
				var msg = result.retMsg;
				if(msg == "")
					msg = "保存失败！";
				parent.layer.open({
					title: '提示',
					content: "保存失败！",
					btn: ['确定'],
					yes: function(index, layero) {
						parent.layer.closeAll();
					},
				});
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			parent.layer.msg("系统异常，请联系管理员！");
		}
	});
}