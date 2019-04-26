layui.use('element', function() {
				var element = layui.element;

			});
layui.use(['form', 'table', 'laydate'], function() {
				var form = layui.form;
				var table = layui.table;
				
				/*
				 实现时间选择
				 */
				var laydate = layui.laydate;

				//执行一个laydate实例
				laydate.render({
					elem: '#date' //指定元素	
					,range: '~' //或 range: '~' 来自定义分割字符
				});
	//加载数据表格
	  var tableIns = table.render({
		    elem: '#test'
		    ,url:window.path +'/thesisList/getThesisList'
//		    ,data:tableData
		    ,title: '用户数据表'
		    ,toolbar:'#toolbarDemo'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      ,{field:'id', title:'主键', width:100,sort: true}
		      ,{field:'date', title:'发表时间', width:130,}
		      ,{field:'published_journal', title:'发表期刊', width:130, }
		      ,{field:'name', title:'论文题目', width:150, }
		      ,{field:'index_level', title:'索引或级别', width:150, } 
		      ,{field:'awards', title:'获奖情况', width:230, }
		      ,{field:'first_author', title:'第一作者', width:130, }
		      ,{field:'other_authors', title:'其他作者情况', width:130, }
		      ,{field:'specialty_id', title:'专业id', width:130, }
		      ,{field:'status', title:'状态(1=正常，2=删除)', width:180, }
		      ,{field:'create_time', title:'创建时间', width:150, }
		      ,{field:'create_user', title:'创建人', width:150, }
		      ,{field:'modify_time', title:'修改时间', width:150, }
		      ,{field:'modify_user', title:'修改人', width:130, }
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:237}
		    ]]
		  });  
	  //监听列工具事件
	  table.on('tool(test)', function(obj){
	    var data = obj.data;
	    var layEvent = obj.event;
	    if(layEvent === 'detail'){//查看
	    	
	    	layer.open({
							title:"查看",
	    		type:2,
	    		content:['/toPage?page=thesis/thesis_check','no'],
	    		maxmin:true,
	    		resize:false,
	    		area:['90%','90%']
					}); 
	    	
	    }else if(layEvent === 'del'){//删除
	    	layer.confirm('真的删除行么', function(index) {
				/*obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				layer.close(index);
				//向服务端发送删除指令*/		
				$.ajax({
					url:'/thesisList/del',
					type:"POST",
					data:{specialtyId:data.id},
					dataType:"json",
					success:function(data){
						var nowPage = tableIns.config.page.curr;//返回当前页数
			        	var reloadPage = (nowPage-1) > 0? nowPage:1;
			        	//console.log((nowPage-1));
			        	//console.log(reloadPage);
						layer.msg("删除成功");
						layer.close(index);
		    			tableIns.reload({
		    				page:{
		    					curr:reloadPage
		    				}
		    			});
					}
				});
				});
	    }else if(layEvent === 'edit'){//编辑
	    	layer.open({
	    		title:"编辑",
	    		type:2,
	    		content:['/toPage?page=thesis/thesis_update','no'],
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
	  		content:['/toPage?page=thesis/thesis_insert','no'],
	  		maxmin:true,
	  		resize:false,
	  		area:['90%','90%']
	  	});
	  });
	  //批量删除
	  table.on('toolbar(test)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id);
//		    alert(JSON.stringify(checkStatus.data.id));
		    
		    switch(obj.event){
		      case 'delData':
		        var data = checkStatus.data;
		        var param = [{}];
		       // layer.alert(JSON.stringify(data));
		        for(var i=0;i< data.length;i++){
		        	param = data[i].id;
//		        	layer.alert(JSON.stringify(data[i].id));
		        	console.log(param);
		        	//向服务端发送删除指令*/		
					$.ajax({
						url:'/thesisList/del',
						type:"POST",
						data:{specialtyId:param},
						dataType:"json",
						success:function(data){
							var nowPage = tableIns.config.page.curr;//返回当前页数
				        	var reloadPage = (nowPage-1) > 0? nowPage:1;
							layer.msg("删除成功");
							//layer.close(index);
			    			tableIns.reload({
			    				page:{
			    					curr:reloadPage
			    				}
			    			});
						}
					});
		        	
		        	
		        }
		       //layer.alert(JSON.stringify(param));
		        
		      break;
		    };
		    
		  });
});
