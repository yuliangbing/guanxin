//使用layui
$(document).ready(function() {
	layui.use('form', function() {
		var form = layui.form;
	})
})

function init(data) {
	$("#roleName").html("角色名称：" + data.roleName);
}

function getMenuList(data) {
	$("#roleName").html("角色名称：" + data.roleName);
}