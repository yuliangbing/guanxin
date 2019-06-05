

	
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
			

				//加载数据表格
				  var tableIns = table.render({
					    elem: '#test'
					    ,url:'/TeachingAssets/getTeachingAssets'
					    //,data:[{"id":1,"content":'jsdgufay'}]
					    ,method:'post'
					    //,height: 312
					    	,defaultToolbar: ['print', 'exports']
					    ,toolbar:'#toolbarDemo'
					    ,page: true
					    ,cols: [[
					      {type: 'checkbox', fixed: 'left'}
					      ,{field:'id', title:'主键', width:'8%',sort: true,align:'center',}
					      ,{field:'cateCode', title:'分类号', width:'15%',align:'center',}
					      ,{field:'name', title:'仪器名称', width:'15%',align:'center', }
					      ,{field:'modelNum', title:'型号', width:'15%',align:'center', }
					      ,{field:'specification', title:'规格', width:'15%',align:'center', }
					      ,{field:'sources', title:'仪器来源', width:'15%',align:'center', }
					      ,{field:'date', title:'购置日期', width:'15%',align:'center', }
					      ,{field:'totalAmount', title:'总金额', width:'15%',align:'center', }
					      ,{field:'countryCode', title:'国别码', width:'15%',align:'center', }
					      ,{field:'code', title:'资产编号', width:'15%',align:'center', }
					      ,{field:'manufacturer', title:'生产厂家', width:'15%',align:'center' ,}
					      ,{field:'usePerson', title:'领用人', width:'15%',align:'center' ,}
					      ,{field:'statusCode', title:'现状码', width:'15%',align:'center' ,}
					      ,{field:'trainingRoom', title:'所在实训室', width:'15%',align:'center', }
					      ,{field:'remark', title:'备注', width:'15%',align:'center', }
					      ,{field:'specialtyId', title:'专业id',width:100,hide:true,align:'center',}
					      ,{field:'specialtyName', title:'专业名称',width:'15%',align:'center',}
					      /*,{field:'createTime', title:'创建时间', width:'15%',align:'center' ,}
					      ,{field:'createUser', title:'创建人', width:'15%',align:'center' ,}
					      ,{field:'modifyTime', title:'修改时间', width:'15%',align:'center' ,}
					      ,{field:'modifyUser', title:'修改人', width:'15%',align:'center' ,}*/
					      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'19%',align:'center',}
					    ]]
					  });  

	
	
	/*新增功能*/
				  $("#insert").click(function(){
					  	layer.open({
					  		title:"添加",
					  		type:2,
					  		content:['/toPage?page=teaching_assets/teaching_assets_add'],
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
			    		content:'/toPage?page=teaching_assets/teaching_assets_check',
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
							url:'/TeachingAssets/delTeachingAssets',
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
			    		content:['/toPage?page=teaching_assets/teaching_assets_modify'],
			    		maxmin:true,
			    		resize:false,
			    		area:['60%','75%'],
			    		success : function(layero, index) {
							// 获取子页面的iframe
							var iframe = window['layui-layer-iframe' + index];
							// 向子页面的全局函数child传参
							iframe.init(data);
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
				        if(data.length > 0){
				        for(var i=0;i< data.length;i++){
				        	param = data[i].id;
//				        	layer.alert(JSON.stringify(data[i].id));
				        	//console.log(param);
				        	//向服务端发送删除指令*/		
							$.ajax({
								url:'/TeachingAssets/delTeachingAssets',
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
				    }else{
				      	layer.msg("请选择要删除的教学资产");
				 }
				        
				      break;
				    };
				    
				  });

			});

    
	
