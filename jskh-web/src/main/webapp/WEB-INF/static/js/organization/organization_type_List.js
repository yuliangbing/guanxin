

	
			layui.use('element', function() {
		    	var element = layui.element;
		
			});
	
			layui.use(['form', 'table', 'laydate'], function() {
				var form = layui.form;
				var table = layui.table;
				
				
				//时间控件
				var laydate = layui.laydate;
				laydate.render({
				elem: '#date',
				//range: true //或 range: '~' 来自定义分割字符
				});
			

	
	/*表格 */
		var tableIns = table.render({
	    elem: '#test'
	    ,defaultToolbar: ['print', 'exports']
	    //,height: 312
		//,width:1000
	    ,method:'post'
	    ,url: '/organizationType/getOrganizationTypeList' //数据接口
	  //  ,data:[{"id":1,"name":'jsdgufay'}]
	    ,page: true //开启分页
	    ,toolbar:"#toolbarDemo"
	    ,cols: [[ //表头
	       {type:'checkbox', fixed: 'left'}
	      ,{field:'id',title:'主键',align:'center',width:'20%',sort: true,}
	      ,{field:'name', title:'组织机构类别名称',align:'center',width:'35%'}
	     /* ,{field:'create_user', title:'创建人',align:'center',width:'15%'}
	      ,{field:'create_time', title:'创建时间',align:'center',width:'15%'}
	      ,{field:'modify_user', title:'修改人',align:'center',width:'15%'}
	      ,{field:'modify_time', title:'修改时间',align:'center',width:'15%'}*/
	      ,{fixed:'right',toolbar: '#barDemo',title:'操作',align:'center',}
	      ]]
	  });
	

	
	
	/*新增功能*/
		$("#insert").click(function(){
		  	layer.open({
		  		title:"添加",
		  		type:2,
		  		content:['/toPage?page=organization/organization_type_add'],
		  		maxmin:true,
		  		resize:false,
		  		area:['60%','75%']
		  	});
		  });


			 //监听列工具事件
			  table.on('tool(test)', function(obj){
			    var data = obj.data;
			    var layEvent = obj.event;
			    if(layEvent === 'detail'){//查看
			    	
			    	layer.open({
						title:"查看",
			    		type:2,
			    		content:'/toPage?page=organization/organization_type_check',
			    		area:['60%','75%'],
			    		resize:false,
			    		success : function(layero, index) {
							// 获取子页面的iframe
							var iframe = window['layui-layer-iframe' + index];
							// 向子页面的全局函数child传参
							iframe.init(data);
						} 
			    	});
			    }else if(layEvent === 'dels'){//删除
			    	layer.confirm('真的删除行么', function(index) {
						/*obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
						layer.close(index);
						//向服务端发送删除指令*/		
						$.ajax({
							url:'/organizationType/deleteOrganizationType',
							type:"POST",
							data:{id:data.id},
							dataType:"json",
							success:function(data){
								var page = $(".layui-laypage-skip").find("input").val();//获取当前页
								var limits = $(".layui-laypage-limits").find("option:selected").val();//获取当前页条数
								var countstr = $(".layui-laypage-count").text();//获取总数据
								var count = countstr.replace(/[^0-9]/ig,"");
								var nowPage = tableIns.config.page.curr;//返回当前页数
					        	var reloadPage = (nowPage-1) > 0? nowPage:1;
					        	if(count > (limits*(page-1))){
					        		if(count-1 <= (limits*(page-1))){
					        			reloadPage = reloadPage-1;
					        		}
					        	}
					        	
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
			    		content:['/toPage?page=organization/organization_type_modify'],
			    		maxmin:true,
			    		resize:false,
			    		area:['60%','75%'],
			    		success : function(layero, index) {
							// 获取子页面的iframe
							var iframe = window['layui-layer-iframe' + index];
							// 向子页面的全局函数child传参
							iframe.init(data);
							tableIns.reload({
			    				page:{
			    					curr:reloadPage
			    				}
			    			});
						} 
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
			  
			//批量删除
			  table.on('toolbar(test)', function(obj){
				    var checkStatus = table.checkStatus(obj.config.id);
//				    alert(JSON.stringify(checkStatus.data.id));
				    
				    switch(obj.event){
				      case 'delData':
				        var data = checkStatus.data;
				        var param = [{}];
				       // layer.alert(JSON.stringify(data));
				        for(var i=0;i< data.length;i++){
				        	param = data[i].id;
//				        	layer.alert(JSON.stringify(data[i].id));
				        	//console.log(param);
				        	//向服务端发送删除指令*/		
							$.ajax({
								url:'/organizationType/deleteOrganizationType',
								type:"POST",
								data:{id:param},
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
				    //  layer.alert(JSON.stringify(param));
				        
				      break;
				    };
				    
				  });

			});
