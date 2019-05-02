layui.use([ 'table', 'form', 'laydate' ], function() {
	var table = layui.table;
	var form = layui.form;
	var laydate = layui.laydate;
	
	laydate.render({
		elem: '#date' //指定元素
	});
})

function save(){
	//获取富文本框内容
	var situationUEStr = situationUE.getContent();
	var characteristicUEStr = characteristicUE.getContent();
}