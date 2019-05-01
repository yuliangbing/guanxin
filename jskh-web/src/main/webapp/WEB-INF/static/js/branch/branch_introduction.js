layui.use([ 'table', 'form', 'laydate' ], function() {
	var table = layui.table;
	var form = layui.form;
	var laydate = layui.laydate;
	
	laydate.render({
		elem: '#date' //指定元素
	});
})