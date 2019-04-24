$(document).ready(function() {
	layui.use('form', function() {
		var form = layui.form;
	})
})

function init(data) {
	$("#roleId").val(data.id);
	$("#roleName").val(data.roleName);
	$("#roleNum").val(data.roleNum);
	$("#roleOrder").val(data.roleOrder);
}

function editConfirm() {
	var params = {};
	params.roleId = $("#roleId").val();
	params.roleName = $("#roleName").val();
	params.roleNum = $("#roleNum").val();
	params.roleOrder = $("#roleOrder").val();

	if (params.roleName == '') {
		layer.alert("角色名称不能为空");
		return false;
	}
	// 数据保存
	$.ajax({
		type : "post",
		url : "/role/updateRole",
		data : $.param(params),
		dataType : "json",
		success : function(result) {
			if (result.code == 0) {
				parent.layer.open({
					title : '提示',
					content : "修改成功！",
					btn : [ '确定' ],
					yes : function(index, layero) {
						parent.layer.closeAll();
						parent.tableReload();
					},
				});

			} else {
				var msg = result.retMsg;
				if (msg == "")
					msg = "修改失败！";
				parent.layer.open({
					title : '提示',
					content : "修改失败！",
					btn : [ '确定' ],
					yes : function(index, layero) {
						parent.layer.closeAll();
					},
				});
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			parent.layer.msg("系统异常，请联系管理员！");
		}
	});
}
