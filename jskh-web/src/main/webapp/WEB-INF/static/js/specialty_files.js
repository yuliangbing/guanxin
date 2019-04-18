//JavaScript代码区域

			//获取文件类型名称
	/*		$.ajax({
				url:'',
				type:"POST",
				data:,
				dataType:"json",
				success:function(data){
					layer.msg("获取成功");
					
				}
			});*/
			function ajax_h(form){
				//获取状态
				$.ajax({
					url:'/fileCategory/getFileCategoryList',
					type:"POST",
//					data:{specialtyFilesId:data.id},
					dataType:"json",
					success:function(data){
						console.log(data);
						layer.msg("获取成功");
						console.log(data.data.length);
						if (data.code == 0) {
							
							let option = "";
							for (let i=0;i<data.data.length;i++) {
								option += "<option value='"+data.data[i].code+"'>"+data.data[i].name+"</option>";
								
							}
							$("#cate_name").append(option);
							form.render('select');
//							layui.use('form', function() {
//						        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
//						        form.render();
//						    });
						} else {
							layer.msg(data.msg);
						}
						
					} ,error:function(code){
			           layer.alert("发生错误,请联系管理员");
			        }
				});
			}
			layui.use(['form', 'table', 'laydate'], function() {
				var form = layui.form;
				var table = layui.table;
				ajax_h(form);
			
				//获取体检状态
				/*	var url = "/api/admin/common/second/dictionary";
					var param = {
							fatherCode:"014000"
						};
					var met="GET";
					ajax_hm(url,param,met,function(err,data){
						if(err,data){
							console.log(data);
							if (data.code == 0) {
								let option = "";
								for (let i=0;i<data.dictionaryListByFatherCode.length;i++) {
									option += "<option value='"+data.dictionaryListByFatherCode[i].code+"'>"+data.dictionaryListByFatherCode[i].name+"</option>";
								}
								$("#status").append(option);
								form.render('select');
							} else {
								layer.msg(data.msg);
							}
						}else{
							console.log(err);
							layer.msg(msg_000000001);
						}
					});	*/
				
				/*
				 实现时间选择
				 */
				var laydate = layui.laydate;

				//执行一个laydate实例
				laydate.render({
					elem: '#date' //指定元素	
					,range: '~' //或 range: '~' 来自定义分割字符
				});

				/*
				 表格
				 */
				//第一个表格
				var tableIns = table.render({
					elem: '#demoList'
					//,id:'idTest'
					,url: window.path +'/specialtyFiles/getSpecialtyFilesList' //数据接口
					,height: 515
					//额外条件
					,page: true
					//toolbar: '<div class="layui-btn-container"> <button class="layui-btn layui-btn-sm" lay-submit lay-filter="delCheckData">批量删除</button></div>',
				    ,toolbar:'#toolbarDemo'
					,limits: [10, 15, 20,25] //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]
					,loading: true
					,limit: 10
					,cols: [
						[ //表头
							{
								type:'checkbox'
								,fixed:'left'
							},
							{
								field: 'id',
								title: '主键',
								width: '10%',
								sort: true,
								align: 'center'
							}, {
								field: 'date',
								title: '文件时间',
								width: '15%',
								align: 'center'
							}, {
								field: 'code',
								title: '文件编号',
								width: '15%',
								sort: false,
								align: 'center'
							}, {
								field: 'name',
								title: '文件名称',
								width: '10%',
								align: 'center'
							}, {
								field: 'cate_name',
								title: '文件类型名称',
								width: '10%',
								align: 'center'
							}, {
								field: 'reviser',
								title: '修订人',
								width: '10%',
								sort: false,
								align: 'center'
							}, {
								field: 'specialty_id',
								title: '专业id',
								width: '10%',
								sort: false,
								align: 'center'
							}, {
								field: 'status',
								title: '状态',
								width: '10%',
								align: 'center'
							},{
								field: 'create_user',
								title: '创建人',
								width: '10%',
								sort: true,
								align: 'center'
							},{
								field: 'create_time',
								title: '创建时间',
								width: '15%',
								sort: true,
								align: 'center'
							},{
								field: 'modify_user',
								title: '修改人',
								width: '10%',
								sort: true,
								align: 'center'
							},{
								field: 'modify_time',
								title: '修改时间',
								width: '15%',
								sort: true,
								align: 'center'
							},{
								fixed: 'right',
								title: '操作',
								toolbar: '#barDemo',
								width: '14%',
								sort: false,
								align: 'center'
							}
						]
					]
				});
				/* 搜索功能 */
				form.on('submit(search)', function(data) {
					//layer.alert(JSON.stringify(data.field));
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
				/*新增功能*/
				form.on('submit(insertAdd)', function(data) {
					layer.open({
						type:2,
						title:'查看窗口',
						area:['90%','90%'],
						anim:0,
						content: "/toPage?page=specialty_files/specialty_insert"
					});
					return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
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
								url:'/specialtyFiles/delSpecialtyFiles',
								type:"POST",
								data:{specialtyFilesId:data.id},
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
						
					} else if(layEvent === 'update') { //审核
						
						layer.open({
									type: 2,
									title: '修改窗口',
									area:['90%','90%'],
									content:'/toPage?page=specialty_files/specialty_update',
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
							content: "/toPage?page=specialty_files/specialty_check",
							success : function(layero, index) {
								// 获取子页面的iframe
								var iframe = window['layui-layer-iframe' + index];
								// 向子页面的全局函数child传参
								iframe.init(data);
							}
							
						});
					} 

				});
				
				 //批量删除
				 table.on('toolbar(demoList)', function(obj){
					    var checkStatus = table.checkStatus(obj.config.id);
//					    alert(JSON.stringify(checkStatus.data.id));
					    
					    switch(obj.event){
					      case 'delData':
					        var data = checkStatus.data;
					        var param = [{}];
					       // layer.alert(JSON.stringify(data));
					        for(var i=0;i< data.length;i++){
					        	param = data[i].id;
//					        	layer.alert(JSON.stringify(data[i].id));
					        	console.log(param);
					        	//向服务端发送删除指令*/		
								$.ajax({
									url:'/specialtyFiles/delSpecialtyFiles',
									type:"POST",
									data:{specialtyFilesId:param},
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
				
		