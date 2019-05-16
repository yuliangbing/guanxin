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
		    ,defaultToolbar: ['print', 'exports']
		    ,url:window.path +'/outstandingGraduateHistory/ListOutstandingGraduateHistory'
		    ,title: '用户数据表'
	    	,method:'post'
		    ,toolbar:'#toolbarDemo'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      ,{field:'id', title:'主键', width:100,sort: true,align:'center'}
		      ,{field:'date', title:'毕业时间', width:130,align:'center'}
		      ,{field:'name', title:'姓名', width:130,align:'center' }
		      ,{field:'company', title:'公司', width:150,align:'center' }
		      ,{field:'position', title:'岗位', width:150,align:'center' } 
		      ,{field:'salary', title:'薪资', width:130,align:'center' }
		      ,{field:'advancedDescription', title:'先进描述', width:220,align:'center' }
		      ,{field:'specialtyId', title:'专业id', width:130,hide:true }
		      ,{field:'specialtyName', title:'专业名称', width:130,align:'center' }
		      ,{field:'status', title:'状态(1=正常，2=删除)', width:180,hide:true}
		      ,{field:'createTime', title:'创建时间', width:150,align:'center' }
		      ,{field:'createUser', title:'创建人', width:150,align:'center' }
		      ,{field:'modifyTime', title:'修改时间', width:150,align:'center' }
		      ,{field:'modifyUser', title:'修改人', width:130,align:'center' }
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:237,align:'center'}
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
	    		content:['/toPage?page=outstanding_graduate_history/outstanding_graduate_history_check'],
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
	    }else if(layEvent === 'del'){//删除
	    	layer.confirm('真的删除行么', function(index) {
				/*obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				layer.close(index);
				//向服务端发送删除指令*/		
				$.ajax({
					url:'/outstandingGraduateHistory/delOutstandingGraduateHistory',
					type:"POST",
					data:{id:data.id},
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
	    		content:['/toPage?page=outstanding_graduate_history/outstanding_graduate_history_update'],
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

		/* 搜索功能 */
	  form.on('submit(search)', function(data) {
			/*layer.alert(JSON.stringify(data.field));*/
			let arr = {};
			arr = data.field;
			if(arr.data != "" && arr.date != null){
				arr.date1 = data.field.date.split('~')[0].replace(/(^\s*)|(\s*$)/g, "");
				arr.date2 = data.field.date.split('~')[1];
			}
			console.log(arr);
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
	  		content:['/toPage?page=outstanding_graduate_history/outstanding_graduate_history_insert'],
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
						url:'/outstandingGraduateHistory/delOutstandingGraduateHistory',
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
		       //layer.alert(JSON.stringify(param));
		        
		      break;
		    };
		    
		  });
});
