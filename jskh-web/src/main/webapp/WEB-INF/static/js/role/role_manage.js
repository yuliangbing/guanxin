layui.use([ 'table' ], function() {
	var table = layui.table;

	/*
	 * 表格
	 */
	table.render({
		elem : '#demoList',
		url : '/role/getRoleList',
		page : true,
		toolbar : '#toolbarDemo',
		defaultToolbar : [],
		limits : [ 10, 15, 20, 25 ],
		limit : 10,
		cols : [ [ // 表头
		{
			type : 'checkbox',
			fixed : 'left'
		}, {
			field : 'id',
			title : 'ID',
			sort : true,
			align : 'center'
		}, {
			field : 'roleName',
			title : '角色名称',
			align : 'center'
		}, {
			field : 'roleNum',
			title : '角色编号',
			align : 'center'
		}, {
			field : 'isDefault',
			title : '是否默认',
			align : 'center',
			templet : '#isDefaultTem'
		}, {
			field : 'status',
			title : '状态',
			align : 'center',
			templet : '#statusTem'
		}, {
			fixed : 'right',
			title : '操作',
			toolbar : '#barDemo',
			sort : false,
			align : 'center'
		} ] ]
	});

	table.on('toolbar(demoList)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		switch (obj.event) {
		case 'add':
			layer.open({
				type : 2,
				title : '添加角色',
				area : [ '90%', '90%' ],
				anim : 0,
				content : "/toPage?page=role/role_add"
			});
			break;
		case 'delAll':
			layer.msg('批量删除');
			break;
		}
		;
	});

	table.on('tool(demoList)', function(obj) {
		var data = obj.data; // 获得当前行数据
		switch (obj.event) {
		case 'edit':
			layer.open({
				type : 2,
				title : '修改角色',
				area : [ '90%', '90%' ],
				anim : 0,
				content : "/toPage?page=role/role_edit",
				success : function(layero, index) {
					// 获取子页面的iframe
					var iframe = window['layui-layer-iframe' + index];
					// 向子页面的全局函数child传参
					iframe.init(data);
				}
			});
			break;
		case 'del':
			layer.confirm('确认要删除吗？', function() {
				del(data.id);
			});
			break;
		case 'setDefault':
			setDefault(data.id);
			break;
		case 'updateStatus':
			updateStatus(data.id, data.status);
			break;
		case 'roleMenuRel':
			layer.open({
				type : 2,
				title : '修改角色',
				area : [ '90%', '90%' ],
				anim : 0,
				content : "/toPage?page=role/roleMenuRel_manage",
				success : function(layero, index) {
					// 获取子页面的iframe
					var iframe = window['layui-layer-iframe' + index];
					// 向子页面的全局函数child传参
					iframe.init(data);
				}
			});
			break;
		}
		;
	});
});

function tableReload() {
	layui.use('table', function() {
		var table = layui.table;

		table.reload('demoList', {
			url : '/role/getRoleList',
			where : {}
		// 设定异步数据接口的额外参数
		// ,height: 300
		});
	})
}

function setDefault(roleId) {
	$.ajax({
		type : "post",
		url : "/role/setDefault",
		data : {
			roleId : roleId
		},
		dataType : "json",
		success : function(result) {
			if (result.code == 0) {
				layer.msg("设置成功！");
				tableReload();
			} else {
				var msg = result.retMsg;
				if (msg == "")
					msg = "设置失败！";
				layer.msg(msg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("系统异常，请联系管理员！");
		}
	});
}

function updateStatus(roleId, thisStatus) {
	var status;
	var msg;
	if (thisStatus == 1) {
		status = 2;
		msg = "确定要停用吗？";
	} else if (thisStatus == 2) {
		status = 1;
		msg = "确定要启用吗？";
	}
	layer.confirm(msg, function() {
		$.ajax({
			type : "post",
			url : "/role/updateRole",
			data : {
				roleId : roleId,
				status : status
			},
			dataType : "json",
			success : function(result) {
				if (result.code == 0) {
					layer.msg("设置成功！");
					tableReload();
				} else {
					var msg = result.retMsg;
					if (msg == "")
						msg = "设置失败！";
					layer.msg(msg);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				layer.msg("系统异常，请联系管理员！");
			}
		});
	})
}

function del(roleId) {
	$.ajax({
		type : "post",
		url : "/role/updateRole",
		data : {
			roleId : roleId,
			status : 3
		},
		dataType : "json",
		success : function(result) {
			if (result.code == 0) {
				layer.msg("删除成功！");
				tableReload();
			} else {
				var msg = result.retMsg;
				if (msg == "")
					msg = "删除失败！";
				layer.msg(msg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg("系统异常，请联系管理员！");
		}
	});
}