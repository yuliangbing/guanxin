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
		    ,url:window.path +'/issuesList/getIssuesList'
		    ,title: '用户数据表'
		    ,toolbar:'#toolbarDemo'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      ,{field:'id', title:'主键', width:100,sort: true}
		      ,{field:'specialty_id', title:'专业id', width:130,hide:true}
		      ,{field:'specialty_code', title:'专业编码', width:150, }
		      ,{field:'specialty_name', title:'专业名称', width:150, }
		      ,{field:'date', title:'团队变更时间', width:150, } 
		      ,{field:'specialty_teachers', title:'专业教师团队', width:150, }
		      ,{field:'part_time_teachers', title:'兼职教师团队', width:150, }
		      ,{field:'director', title:'团队总负责人', width:150, }
		      ,{field:'latest', title:'是否最新', width:150,}
		      ,{field:'create_time', title:'创建时间', width:150, }
		      ,{field:'create_user', title:'创建人', width:130, }
		      ,{field:'modify_time', title:'修改时间', width:150, }
		      ,{field:'modify_user', title:'修改人', width:130, }
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:237}
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
	    		content:['/toPage?page=teacher_team/teacher_team_check'],
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
				 //删除对应行（tr）的DOM结构，并更新缓存
				layer.close(index);
				//向服务端发送删除指令		
				$.ajax({
					url:'/issuesList/del',
					type:"POST",
					data:{Id:data.id},
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
	    }/*else if(layEvent === 'edit'){//编辑
	    	layer.open({
	    		title:"编辑",
	    		type:2,
	    		content:['/toPage?page=teacher_team/teacher_team_update','no'],
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
			}*/
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
	  		content:['/toPage?page=teacher_team/teacher_team_insert'],
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
						url:'/issuesList/del',
						type:"POST",
						data:{Id:param},
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
