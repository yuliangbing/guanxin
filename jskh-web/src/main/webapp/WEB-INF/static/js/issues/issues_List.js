layui.use('element', function() {
				var element = layui.element;

			});
layui.use(['form', 'table', 'laydate','laytpl'], function() {
				var form = layui.form;
				var table = layui.table;
				var laytpl = layui.laytpl;
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
		    ,url:window.path +'/issuesList/getIssuesList'
		    ,title: '用户数据表'
		    ,toolbar:'#toolbarDemo'
		    ,method:'post'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      ,{field:'id', title:'主键', width:'10%',sort: true,align:'center'}
		      ,{field:'date', title:'时间', width:'15%',align:'center',templet:"<div>{{layui.util.toDateString(d.date, 'yyyy-MM-dd')}}</div>"}
		      ,{field:'code', title:'立项编号', width:'15%',align:'center' }
		      ,{field:'name', title:'课题名称', width:'15%',align:'center' }
		      ,{field:'sources', title:'课题来源', width:'15%',align:'center' } 
		      ,{field:'host', title:'主持人', width:'15%',align:'center' }
		      ,{field:'participants', title:'参与人', width:'15%',align:'center' }
		      ,{field:'specialty_id', title:'专业id', width:'15%',hide:true }
		      ,{field:'specialty_name', title:'专业名称', width:'15%',align:'center' }
		      ,{field:'status', title:'状态(1=正常，2=删除)', width:180,hide:true}
		      ,{field:'awards_construction', title:'获奖及建设情况', width:'25%',align:'center' }
		     /* ,{field:'create_time', title:'创建时间', width:'15%',align:'center' }
		      ,{field:'create_user', title:'创建人', width:'15%',align:'center' }
		      ,{field:'modify_time', title:'修改时间', width:'15%',align:'center' }
		      ,{field:'modify_user', title:'修改人', width:'15%',align:'center' }*/
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'20%',align:'center'}
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
	    		content:'/toPage?page=issues/issues_check',
	    		area:['80%','85%'],
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
					url:'/issuesList/del',
					type:"POST",
					data:{Id:data.id},
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
	    		content:['/toPage?page=issues/issues_update'],
	    		maxmin:true,
	    		resize:false,
	    		area:['80%','85%'],
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
	//添加按钮点击事件
	  $("#insert").click(function(){
	  	layer.open({
	  		title:"添加",
	  		type:2,
	  		content:['/toPage?page=issues/issues_insert'],
	  		maxmin:true,
	  		resize:false,
	  		area:['80%','85%']
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
		        if(data.length > 0){
		        for(var i=0;i< data.length;i++){
		        	param = data[i].id;
//		        	layer.alert(JSON.stringify(data[i].id));
		        	//console.log(param);
		        	//向服务端发送删除指令*/		
					$.ajax({
						url:'/issuesList/del',
						type:"POST",
						data:{Id:param},
						dataType:"json",
						success:function(data){
							var page = $(".layui-laypage-skip").find("input").val();//返回当前页数
							var nowPage = tableIns.config.page.curr;//返回当前总页数
							var limits = $(".layui-laypage-limits").find("option:selected").val();//获取当前条数10/ye
							var countstr = $(".layui-laypage-count").text();//总数据条数
							var count = countstr.replace(/[^0-9]/ig,"");
							var lengths = checkStatus.data.length;
							//alert(lengths);
							var reloadPage = (page-1) > 0? page:1;
				        	if(count > (limits*(page-lengths))){//有分页		12>10*1
				        		if(count-1 <= (limits*(page-lengths))){//判断在当前页是否还有数据  11-1<=10*1
					        		reloadPage = reloadPage-1;		// 1
					        	}
				        	}
							layer.msg("删除成功");
			    			tableIns.reload({
			    				page:{
			    					curr:reloadPage
			    				}
			    			});
						}
					});
		        	
		        	
		        }
		    }else{
		      	layer.msg("请选择要删除的课题");
		 }
		      break;
		    };
		    
		  });
});
