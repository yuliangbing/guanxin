$(document).ready(function() {
	layui.use('form', function() {
		var form = layui.form;
	})
})

function addInit(parentId,parentStr){
	if (parentId != null && parentStr != null) {
		$("#parentId").val(parentId);
		$("#parentStr").val(parentStr);
		$("#parentNum").val(parentStr);
		$("#parentMenu").show();
	}
}

function addConfirm() {
	var params = {};
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
		url: "/menu/addMenu",
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