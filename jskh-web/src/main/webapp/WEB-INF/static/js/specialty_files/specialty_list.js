//JavaScript代码区域
 
			function ajax_h(form)
			{
				//获取文件类型
				$.ajax({
					url:'/fileCategory/getFileCategoryList',
					type:"POST",
					dataType:"json",
					success:function(data){
						/*console.log(data);
						layer.msg("获取成功");
						console.log(data.data.length);*/
						if (data.code == 0) {
							
							let option = "";
							for (let i=0;i<data.data.length;i++) {
								option += "<option value='"+data.data[i].code+"'>"+data.data[i].name+"</option>";
							}
							$("#cate_name").append(option);
							form.render('select');
						} else {
							layer.msg("网络错误，请检查网络！");
						}
						
					} ,error:function(code){
			           layer.alert("发生错误,请联系管理员");
			        }
				});
			}
			layui.use(['form', 'table', 'laydate'], function() {
				var form = layui.form;
				var table = layui.table;
				//获取下拉列表
				ajax_h(form);
				
				/* 实现时间选择 */
				var laydate = layui.laydate;
				laydate.render({
					elem: '#date' //指定元素	
					,range: '~' //或 range: '~' 来自定义分割字符
				});

				/*表格 */
				var tableIns = table.render({
					elem: '#demoList'
					,method:'post'
					,id:'idTest'
					,url: window.path +'/specialtyFiles/getSpecialtyFilesList' //数据接口
					,page: true
				    ,toolbar:'#toolbarDemo'
				    ,defaultToolbar:true
					,limits: [10, 15, 20,25] //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]
					,loading: true
					,limit: 10
					,cols: [
						[ //表头
							{type: 'checkbox', fixed: 'left',width:'8%'},
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
							},{
								field: 'urlFileName',
								title: '上传的文件名称',
								width: '14%',
								sort: false,
								align: 'center'
							},{
								field: 'cateName',
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
								field: 'specialtyId',
								title: '专业id',
								width: '10%',
								sort: false,
								align: 'center',
								hide:true
							}, {
								field: 'specialtyName',
								title: '专业名称',
								width: '10%',
								sort: false,
								align: 'center'
							},{
								field: 'status',
								title: '状态',
								width: '10%',
								align: 'center',
								hide:true//隐藏
							},{
								field: 'createUser',
								title: '创建人',
								width: '10%',
								sort: true,
								align: 'center'
							},{
								field: 'createTime',
								title: '创建时间',
								width: '15%',
								sort: true,
								align: 'center'
							},{
								field: 'modifyUser',
								title: '修改人',
								width: '10%',
								sort: true,
								align: 'center'
							},{
								field: 'modifyTime',
								title: '修改时间',
								width: '15%',
								sort: true,
								align: 'center'
							},{
								fixed: 'right',
								title: '操作',
								toolbar: '#barDemo',
								width: '24%',
								sort: false,
								align: 'center'
							}
						]
					]
				});
				
				/* 搜索功能 */
				form.on('submit(search)', function(data) {
					//layer.alert(JSON.stringify($("#cate_name option:checked").text()));
					
					let arr = {};
					arr = data.field;
					arr.cate_name = $("#cate_name option:checked").text();
					//console.log(arr);
					/*layer.alert(JSON.stringify(arr));*/
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
				form.on('submit(add)', function(data) {
					layer.open({
						type:2,
						title:'添加窗口',
						area:['90%','90%'],
						anim:0,
						content: "/toPage?page=specialty_files/specialty_add"
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
									var page = $(".layui-laypage-skip").find("input").val();//返回当前页数
									var nowPage = tableIns.config.page.curr;//返回当前总页数
									//console.log(page);
						        	var reloadPage = (page-1) > 0? page:1;
									layer.msg("删除成功");
									//layer.close(index);
					    			tableIns.reload({
					    				page:{
					    					curr:reloadPage
					    				}
					    			});
								}
							});
							});
						
					} else if(layEvent === 'modify') { //修改
						
						layer.open({
									type: 2,
									title: '修改窗口',
									area:['90%','90%'],
									content:'/toPage?page=specialty_files/specialty_modify',
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
					} else if(layEvent==='details'){
						//layer.msg('用户名：'+  + ' 的查看操作');
						layer.open({
							type:2,
							title:'详情窗口',
							area:['90%','90%'],
							anim:0,
							content: "/toPage?page=specialty_files/specialty_details",
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
				 table.on('toolbar(demoList)', function(res){
					    var checkStatus = table.checkStatus(res.config.id);
					    //console.log(checkStatus.data.length);
					    switch(res.event){
					      case 'dels':
					        var data = checkStatus.data;
					        var param = [{}];
					      //  layer.alert(JSON.stringify(data));
					        if(data.length > 0){
					        	 for(var i=0;i< data.length;i++)
					        	 {
							        	param = data[i].id;
							        	//console.log(param);
							        	//向服务端发送删除指令*/		
										$.ajax({
											url:'/specialtyFiles/delSpecialtyFiles',
											type:"POST",
											data:{specialtyFilesId:param},
											dataType:"json",
											success:function(data){
												/*var page = $(".layui-laypage-skip").find("input").val();//返回当前页数
												var nowPage = tableIns.config.page.curr;//返回当前总页数
									        	var reloadPage = (page-1) > 0? page:1;*/
									        	//console.log(reloadPage);
												layer.msg("删除成功");
								    			tableIns.reload({
								    				page:{
								    					curr:1
								    				}
								    			});
											},error:function(code){
										           layer.alert("发生错误,删除失败");
										        }
										});
							      
							        }
					        }else{
					        	layer.msg("请选择要删除的用户");
					        }
					       
					      break;
					    };
					    
					  });		
				
			});
				
		