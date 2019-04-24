layui.use(['laydate','table','form'],function(){
	var laydate = layui.laydate;
	var table = layui.table;
	var form = layui.form;
	//加载时间选择器
	  laydate.render({
  	    elem: '#date'
  	  });
	  laydate.render({
	  	    elem: '#date2'
	  	  });
	//加载数据表格
	  var tableIns = table.render({
		    elem: '#test'
		    ,url:window.path +'/issuesList/getIssuesList'
//		    ,data:tableData
		    ,title: '用户数据表'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      
		      ,{field:'date', title:'时间', width:130,}
		      ,{field:'name', title:'成果名称', width:130, }
		      ,{field:'sources', title:'成果来源', width:150, }
		      ,{field:'level', title:'成果级别', width:150, }
		      ,{field:'first_author', title:'第一作者', width:150, } 
		      ,{field:'other_authors', title:'其他作者情况', width:230, }
		    
		    ]]
		  });  
	  //监听行工具事件
	  table.on('tool(test)', function(obj){
	    var data = obj.data;
	    var layEvent = obj.event;
	    if(layEvent === 'detail'){//查看
	    	layer.open({
							title:"查看",
	    		type:2,
	    		content:['/toPage?page=other_achievements/other_check','no'],
	    		maxmin:true,
	    		resize:false,
	    		area:['90%','90%']
					}); 
	    	
	    }else if(layEvent === 'del'){//删除
	    	layer.confirm('真的删除行么',function(index){
	    		obj.del();
	    		layer.close(index);
	    	});
	    }else if(layEvent === 'edit'){//编辑
	    	layer.open({
	    		title:"编辑",
	    		type:2,
	    		content:['/toPage?page=other_achievements/othe_updata','no'],
	    		maxmin:true,
	    		resize:false,
	    		area:['90%','90%']
			});
			}
		});
		/* 搜索功能 */
	  form.on('submit(search)', function(data) {
			/*layer.alert(JSON.stringify(data.field));*/
			let arr = {};
			arr = data.field;
			if(arr.data != "" && arr.date != null){
				arr.date1 = data.field.date.split('~')[0].replace(/(^\s*)|(\s*$)/g, "");
				arr.date2 = data.field.date.split('~')[1];
			}
			tableIns.reload({
				where:arr,
				page: {
					curr: 1
				}
			});
			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	//添加按钮点击事件
	  $("#insert").click(function(){
	  	layer.open({
	  		title:"添加",
	  		type:2,
	  		content:['/toPage?page=other_achievements/other_insert','no'],
	  		maxmin:true,
	  		resize:false,
	  		area:['90%','90%']
	  	});
	  });
});
/**
 * 
 */