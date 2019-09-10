//使用layui
$(document).ready(function() {
	layui.use('form', function() {
		var form = layui.form;
	})
})

//初始化编辑页面，data是从rola_manage.jsp传入的
function init(data) {
	$("#roleId").val(data.id);
	$("#roleName").val(data.roleName);
	$("#roleNum").val(data.roleNum);
	$("#roleOrder").val(data.roleOrder);
}

//保存数据
function editConfirm() {
	//编写参数开始
	var params = {};
	params.roleId = $("#roleId").val();
	params.roleName = $("#roleName").val();
	params.roleNum = $("#roleNum").val();
	params.roleOrder = $("#roleOrder").val();
	//编写参数结束

	if (params.roleName == '') {
		layer.alert("角色名称不能为空");
		return false;
	}
	$.ajax({
		type : "post",
		url : "/role/updateRole",//请求接口地址
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
