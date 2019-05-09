

	
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
				range: true //或 range: '~' 来自定义分割字符
				});
			

	
	/*表格 */
		var tableIns = table.render({
	    elem: '#test'
	    ,height: 312
	    ,method:'post'
	    ,url: '/organizationType/getOrganizationTypeList' //数据接口
	  //  ,data:[{"id":1,"name":'jsdgufay'}]
	    ,page: true //开启分页
	    ,toolbar:"#toolbarDemo"
	    ,cols: [[ //表头
	       {type:'checkbox', fixed: 'left'}
	      ,{field:'id',title:'ID'}
	      ,{field:'name', title:'组织机构类别名称'}
	      ,{field:'createUser', title:'创建人'}
	      ,{field:'createTime', title:'创建时间'}
	      ,{field:'modifyUser', title:'修改人'}
	      ,{field:'modifyTime', title:'修改时间'}
	      ,{fixed:'right',toolbar: '#barDemo',title:'操作',width:237}
	      ]]
	  });
	

	/* 搜索功能 */
//	form.on('submit(search)', function(data) {
//		//layer.alert(JSON.stringify($("#cate_name option:checked").text()));
//		
//		let arr = {};
//		arr = data.field;
//		arr.cate_name = $("#cate_name option:checked").text();
//		//console.log(arr);
//		/*layer.alert(JSON.stringify(arr));*/
//		if(arr.data != "" && arr.date != null){
//			arr.date1 = data.field.date.split('~')[0].replace(/(^\s*)|(\s*$)/g, "");
//			arr.date2 = data.field.date.split('~')[1];
//		}
//		tableIns.reload({
//			where:arr,
//			page: {
//				curr: 1
//			}
//		});
//		return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
//	});
	
	
	/*新增功能*/
	form.on('submit(add)', function(data) {
		layer.open({
			type:2,
			title:'添加窗口',
			area:['90%','90%'],
			anim:0,
			content: "/toPage?page=organization/organization_add"
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
			    		content:'/toPage?page=organization/organization_check',
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
			    		content:['/toPage?page=organization/organization_modify'],
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
