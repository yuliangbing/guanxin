layui.use('element', function() {
    	var element = layui.element;

	});
	layui.use(['form', 'table', 'laydate'], function() {
		var table = layui.table;
		var form = layui.form;
		
			//时间控件
			var laydate = layui.laydate;
			laydate.render({
			elem: '#date1'
			});

    
	
	//加载数据表格
	  var tableIns = table.render({
		    elem: '#test'
		   // ,url:window.path +'/issuesList/getIssuesList'
		    ,data:[{"id":1,"content":'jsdgufay'}]
		    ,method:'post'
		    ,height: 312
		    ,toolbar:'#toolbarDemo'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      ,{field:'id', title:'id', width:100,sort: true}
		      ,{field:'date', title:'时间', width:130,}
		      ,{field:'plan_num', title:'计划招生数', width:130, }
		      ,{field:'actual_num', title:'实际招生数', width:150, }
		      ,{field:'rate', title:'报到率', width:150, } 
		      ,{field:'achievements', title:'成果', width:130, }
		      ,{field:'createUser', title:'创建人', width:150, }
		      ,{field:'modifyTime', title:'修改时间', width:150, }
		      ,{field:'modifyUser', title:'修改人', width:130, }
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:237}
		    ]]
		  });  
	  
	  /*新增功能*/
		form.on('submit(add)', function(data) {
			layer.open({
				type:2,
				title:'添加窗口',
				area:['90%','90%'],
				anim:0,
				content: '/toPage?page=enrollment_history/enrollment_history_add'
			});
			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		   
		 });


				 //监听列工具事件
				  table.on('tool(test)', function(obj){
				    var data = obj.data;
				    var layEvent = obj.event;
				    if(layEvent === 'check'){//查看
				    	
				    	layer.open({
							title:"查看",
				    		type:2,
				    		content:'/toPage?page=enrollment_history/enrollment_history_check',
				    		area:['90%','90%'],
				    		resize:false,
				    		success : function(layero, index) {
								// 获取子页面的iframe
								var iframe = window['layui-layer-iframe' + index];
								// 向子页面的全局函数child传参
								iframe.init(data);
							} 
				    	});
				    }else if(layEvent === 'del'){//删除
				    	layer.confirm('真的删除行么', function(index) {
							/*obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
							layer.close(index);
							//向服务端发送删除指令*/		
							$.ajax({
								//url:'/organizationType/deleteOrganizationType',
								type:"POST",
								data:{Id:data.id},
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
				    		content:['/toPage?page=enrollment_history/enrollment_history_modify'],
				    		maxmin:true,
				    		resize:false,
				    		area:['90%','90%'],
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