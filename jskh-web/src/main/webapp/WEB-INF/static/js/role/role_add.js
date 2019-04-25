//使用layui
$(document).ready(function() {
	layui.use('form', function() {
		var form = layui.form;
	})
})

//保存数据开始
function addConfirm() {
	//编写参数开始
	var params = {};
	params.roleName = $("#roleName").val();
	params.roleNum = $("#roleNum").val();
	params.roleOrder = $("#roleOrder").val();
	//编写参数结束
	
	if (params.roleName == '') {
		layer.alert("角色名称不能为空");
		return false;
	}
	// 数据保存
	$.ajax({
		type: "post",
		url: "/role/addRole",//请求接口地址
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
						parent.tableReload();
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
//保存数据结束
