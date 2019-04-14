//JavaScript代码区域

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
				
					//,range: '~' //或 range: '~' 来自定义分割字符
				});

				/*
				 表格
				 */
				//第一个表格
				var tableIns = table.render({
					elem: '#demoList'
					,id:'idTest'
					,url: window.path +'/specialtyFiles/getSpecialtyFilesList' //数据接口
					//额外条件
					,page: true,
					toolbar: '#toolbarDemo',
					limits: [10, 15, 20,25] //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]
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
								width: '15%',
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
					if(arr.date != "" && arr.date != null){
						arr.date = data.field.date.split('~')[0].replace(/(^\s*)|(\s*$)/g, "");
					}
					//alert(JSON.stringify(arr));
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
				table.on('tool(test)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
					var data = obj.data; //获得当前行数据
					var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					var tr = obj.tr; //获得当前行 tr 的DOM对象
					if(layEvent === 'del') { //删除
						layer.confirm('真的删除行么', function(index) {
							obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
							layer.close(index);
							//向服务端发送删除指令
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
						layer.msg('用户名：'+ data.code + ' 的查看操作');
						layer.open({
							type:2,
							title:'查看窗口',
							area:['90%','90%'],
							anim:0,
							content: "/toPage?page=specialty_files/specialty_check",
							success : function(layero, index) {
								// 获取子页面的iframe
//								alert(index);
								var iframe = window['layui-layer-iframe' + index];
								// 向子页面的全局函数child传参
								iframe.init(data);
							}
							
						});
					} 

				});
				//头工具栏事件
				  table.on('toolbar(test)', function(obj){
					  alert("11obj"+obj);
				    var checkStatus = table.checkStatus(obj.config.id);
				    switch(obj.event){
				      case 'getCheckData':
				        var data = checkStatus.data;
				        layer.alert(JSON.stringify(data));
				      break;
				      case 'getCheckLength':
				        var data = checkStatus.data;
				        layer.msg('选中了：'+ data.length + ' 个');
				      break;
				      case 'isAll':
				        layer.msg(checkStatus.isAll ? '全选': '未全选');
				      break;
				    };
				  });
			});
		