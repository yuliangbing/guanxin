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
		    ,url:window.path +'/specialtyConstructionAchievements/getSpecialtyConstructionAchievements'
//		    ,data:tableData
		    ,title: '用户数据表'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      ,{field:'id', title:'主键', width:100,sort: true}
		      ,{field:'date', title:'时间', width:130,}	     
		      ,{field:'name', title:'成果名称', width:150, }
		      ,{field:'sources', title:'成果来源', width:150, } 
		      ,{field:'leve', title:'成果级别', width:130, }
		      ,{field:'author', title:'作者', width:130, }
		      ,{field:'specialty_id', title:'专业id', width:130, }
		     // ,{field:'status', title:'状态(1=正常，2=删除)', width:180,hide:true}
		     // ,{field:'create_time', title:'创建时间', width:150,  hide:true}
		   //   ,{field:'create_user', title:'创建人', width:150, hide:true }
		     // ,{field:'modify_time', title:'修改时间', width:150,  hide:true}
		     // ,{field:'modify_user', title:'修改人', width:130, hide:true }
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:237}
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
	    		content:['/toPage?page=specialty_achievements/speConAch_check','no'],
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
	    		content:['/toPage?page=specialty_achievements/speConAch_updata','no'],
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
	  		content:['/toPage?page=specialty_achievements/speConAch_insert','no'],
	  		maxmin:true,
	  		resize:false,
	  		area:['90%','90%']
	  	});
	  });
	  /*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		}

		function delAll(argument) {

			var data = tableCheck.getData();

			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			});
		}
});
