
	layui.use('table', function(){
	      var table = layui.table;
	      
	      //监听单元格编辑
	      table.on('edit(test)', function(obj){
	        var value = obj.value //得到修改后的值
	        ,data = obj.data //得到所在行所有键值
	        ,field = obj.field; //得到字段
	        layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
	      });
	    });


function add() {
	layer.open({
		  type: 2, 
		  area:['90%','90%'],
		  content: "http://localhost:8091/toPage?page=branch/organization_insert"
		});
} 
	



