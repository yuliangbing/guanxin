//JavaScript代码区域

			layui.use('element', function() {
				var element = layui.element;

			});

			layui.use(['form', 'table', 'laydate'], function() {
				var form = layui.form;

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
				var table = layui.table;
				//data数据
				var data = [
				{id:1,'code':'管理员菜单','cate_name':'1111'},{id:2,'code':'root菜单','menu_num':'2222'},{id:3,'code':'psd','menu_num':'333'}
				,{id:4,'code':'管理员菜单','cate_name':'1111'},{id:5,'code':'root菜单','menu_num':'2222'},{id:6,'code':'psd','menu_num':'333'}
				,{id:7,'code':'管理员菜单','cate_name':'1111'},{id:8,'code':'root菜单','menu_num':'2222'},{id:9,'code':'psd','menu_num':'333'}
				,{id:10,'code':'菜单','menu_num':'1111000'},{id:12,'code':'root菜单','menu_num':'2222'},{id:53,'code':'psd','menu_num':'333'}
				]
				//第一个表格
				var tableIns = table.render({
					elem: '#demoList'
					//,url: 'http://47.111.23.192:82/hmBack/adminApi/examination/getExaminationListById?id=1' //数据接口
					,data:data
					,parseData: function(res) { //res 即为原始返回的数据
						console.log(res);
						return {
							"code": res.code, //解析接口状态
							"msg": res.success, //解析提示文本
							"count": res.counts, //解析数据长度
							"data": res.examinationList //解析数据列表
						};
					},
					page: true,
					limits: [10, 20, 30] //每页条数的选择项，默认：[10,20,30,40,50,60,70,80,90]
						// ,toolbar:true//开启表格头部工具栏区域
						,
					loading: true,
					cols: [
						[ //表头
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
								field: 'right',
								title: '操作',
								toolbar: '#barDemo',
								width: '30%',
								sort: false,
								align: 'center'
							}
						]
					],
					response: {
						statusName: 'code' //数据状态的字段名称，默认：code
							,
						statusCode: 0 //成功的状态码，默认：0
							,
						msgName: 'msg' //状态信息的字段名称，默认：msg
							,
						countName: 'count' //数据总数的字段名称，默认：count
							,
						dataName: 'data' //数据列表的字段名称，默认：data
					},
					done: function(res, curr, count) {
						//如果是异步请求数据方式，res即为你接口返回的信息。
						//如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
						console.log(res);

						//得到当前页码
						console.log(curr);

						//得到数据总量
						console.log(count);
					}
					//,id: 'idTest'
				});
				/*
				 搜索功能
				 * */
				form.on('submit(formDemo)', function(data) {

//					if(data.field.paymentDt != "" && data.field.paymentDt != null) {
//						data.field.paymentDt1 = data.field.paymentDt.split('~')[0];
//						data.field.paymentDt2 = data.field.paymentDt.split('~')[1];
//					}
					//layer.msg(JSON.stringify(data.field));
					var username = $('#username').val();
					tableIns.reload({
			
						where: {
							'name':username
						},
						page: {
							curr: 1
						}
					});
					return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
				});
				//监听工具条
				table.on('tool(test)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
					var data = obj.data; //获得当前行数据
					var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					var tr = obj.tr; //获得当前行 tr 的DOM对象
					console.log(layEvent+"111");
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
									content: '/jsp/specialty_update.jsp'
							});
					} else if(layEvent==='check'){
						layer.open({
							type:2,
							title:'查看',
							area:['90%','90%'],
							anim:0,
							content:'/jsp/specialty_check.jsp'
						});
					} else if(layEvent==='insert'){
						layer.open({
							type:2,
							title:'新增',
							area:['90%','90%'],
							anim:0,
							content:'/jsp/specialty_insert.jsp'
						});
					}
				});
			});