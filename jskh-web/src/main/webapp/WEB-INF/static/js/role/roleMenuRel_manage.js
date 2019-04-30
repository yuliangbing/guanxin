function init(data) {
	$("#roleName").html("角色名称：" + data.roleName);
	layui.use([ 'tree', 'form' ], function() {
		var tree = layui.tree;
		var form = layui.form;
		var xtree1 = new layuiXtree({
			elem : 'xtree1' // (必填) 放置xtree的容器，样式参照 .xtree_contianer
			,
			form : form // (必填) layui 的 from
			,
			data : 'roleMenuRel/getRoleMenuRelList'
		// (必填) json数据
		});
	});
}

function save(){
	$.each($('input:checkbox'),function(){
        if(this.checked){
            window.alert("你选了："+
                $('input[type=checkbox]:checked').length+"个，其中有："+$(this).val());
        }
    });
}