layui.use(['laydate','table','form'],function(){
	var laydate = layui.laydate;
	var table = layui.table;
	var form = layui.form;
	//加载时间选择器
	  laydate.render({
  	    elem: '#date1'
  	  });
	 
	  laydate.render({
	  	    elem: '#date2'
	  	  });
	  var tables= [
		  {"name":"123"},{"name":"yyy"}
	  ];
	//加载数据表格
	  var tableIns = table.render({
		    elem: '#test'
		   //,url:window.path +'/otherList/getOtherList'
		    ,data:tables
		    ,title: '用户数据表'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      
		      ,{field:'date', title:'时间', width:130,}
		      ,{field:'name', title:'成果名称', width:130, }
		      ,{field:'sources', title:'成果来源', width:150, }
		      ,{field:'level', title:'成果级别', width:150, }
		      ,{field:'first_author', title:'第一作者', width:150, } 
		      ,{field:'other_authors', title:'其他作者情况', width:150, }
		      ,{field:'right', title:'操作',toolbar: '#barDemo', width:150, }
		 
		    
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
	    		content:['/toPage?page=other_achievements/othe_update','no'],
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
	  
	  
	  
	//监听工具条
		table.on('tool(demoList)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			//alert(JSON.stringify(data));
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
			if(layEvent === 'del') { //删除
				layer.confirm('真的删除行么', function(index) {
					/*obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					//向服务端发送删除指令*/		
					$.ajax({
						url:'/otherAchievements/delOptherAchievements',
						type:"POST",
						data:{otherAchievementsId:data.id},
						dataType:"json",
						success:function(data){
							var nowPage = tableIns.config.page.curr;//返回当前页数
				        	var reloadPage = (nowPage-1) > 0? nowPage:1;
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
				
			} else if(layEvent === 'update') { //修改
				
				layer.open({
							type: 2,
							title: '修改窗口',
							area:['90%','90%'],
							content:'/toPage?page=other_achievements/other_update',
							/*btn : [ '保存', '取消' ],
							btnAlign : 'c',
							yes : function(index, layero) {
								// 获取子页面的iframe
								var iframe = window['layui-layer-iframe' + index];
								// 向子页面的全局函数child传参
								iframe.addConfirm();
							},
							btn2 : function(index, layero) {
								layer.closeAll();
							},
							cancel : function() {
								layer.closeAll();
							},*/
							success : function(layero, index) {
								// 获取子页面的iframe
								var iframe = window['layui-layer-iframe' + index];
								// 向子页面的全局函数child传参
								iframe.init(data);
							}
							
					});
			} else if(layEvent==='check'){
				//layer.msg('用户名：'+ data.code + ' 的查看操作');
				layer.open({
					type:2,
					title:'查看窗口',
					area:['90%','90%'],
					anim:0,
					content: "/toPage?page=other_achievements/other_check",
					success : function(layero, index) {
						// 获取子页面的iframe
						var iframe = window['layui-layer-iframe' + index];
						// 向子页面的全局函数child传参
						iframe.init(data);
					}
					
				});
			} 

		});
		
	  
});
