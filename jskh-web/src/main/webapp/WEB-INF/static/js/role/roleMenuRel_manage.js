function init(data) {
	$("#roleName").html("角色名称：" + data.roleName);
	$("#roleId").val(data.id);
	layui.use([ 'tree', 'form' ], function() {
		var tree = layui.tree;
		var form = layui.form;
		var xtree1 = new layuiXtree({
			elem : 'xtree1' // (必填) 放置xtree的容器，样式参照 .xtree_contianer
			,
			form : form // (必填) layui 的 from
			,
			data : 'roleMenuRel/getRoleMenuRelList?roleId='+data.id
		// (必填) json数据
		});
	});
}

function save() {
	var roleId = $("#roleId").val();
	var menuIds = "";
	var index = 0;
	$.each($('input:checkbox'), function() {
		if (this.checked) {
			if (index == 0) {
				menuIds = $(this).val();
			} else {
				menuIds += "," + $(this).val();
			}
			index++;
		}
	});
	$.ajax({
		type : "post",
		url : "/roleMenuRel/updateRoleMenuRels",
		data : {
			menuIds : menuIds,
			roleId : roleId
		},
		dataType : "json",
		success : function(result) {
			if (result.code == 0) {
				layer.msg("保存成功！");
				tableReload();
			} else {
				var msg = result.retMsg;
				if (msg == "")
					msg = "保存失败！";
				layer.msg(msg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("系统异常，请联系管理员！");
		}
	});
}