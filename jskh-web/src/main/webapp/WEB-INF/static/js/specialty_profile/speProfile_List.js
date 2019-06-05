//function ajax_h(form,url,object,ids){
//			//获取下拉列表(公共方法)
//			$.ajax({
//				url:url,
//				type:"POST",
//				dataType:"json",
//				success:function(data){
//					console.log(data);
//					//layer.msg("获取成功");
//					console.log(data.data.length);
//					if (data.code == 0) {
//							let option = "";
//							for (let i=0;i<data.data.length;i++) {
//								option += "<option value='"+data.data[i].id+"'>"+data.data[i].name+"</option>";
//							}
//							$("#"+object).append(option);
//							form.render('select');
//						
//					} else {
//						layer.msg("请检查网络连接！");
//					}
//					
//				} ,error:function(code){
//		           layer.alert("发生错误,请联系管理员");
//		        }
//			});
//		}
layui.use('element', function() {
				var element = layui.element;

			});
			function ajax_h(form)
			{
				//获取文件类型
				$.ajax({
					url:'specialty/getSpecialtyList',
					type:"POST",
					dataType:"json",
					success:function(data){
						/*console.log(data);
						layer.msg("获取成功");
						console.log(data.data.length);*/
						if (data.code == 0) {
							
							let option = "";
							for (let i=0;i<data.data.length;i++) {
								option += "<option value='"+data.data[i].id+"'>"+data.data[i].name+"</option>";
							}
							$("#specialtyName").append(option);
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
		    ,url:window.path +'/specialtyProfile/getSpecialtyProfileList'
		    ,title: '用户数据表'
		    ,method:'POST'
		    ,toolbar:'#toolbarDemo'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      ,{field:'id', title:'主键', width:'10%',sort: true,align:'center'}
		      ,{field:'specialtyId', title:'专业id', width:'15%',hide:true } 
		      ,{field:'specialtyName', title:'专业名称', width:'15%',align:'center'} 
		      ,{field:'date', title:'年份', width:'15%',align:'center'}	     
		      ,{field:'position', title:'专业定位', width:'15%',align:'center'}
		      ,{field:'characteristic', title:'专业特色', width:'15%',align:'center'}
		      ,{field:'directorName', title:'专业负责人姓名', width:'15%',align:'center'}
		      ,{field:'status', title:'状态(1=正常，2=删除)', width:180,hide:true}
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'19%',align:'center'}
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
	    		content:['/toPage?page=specialty_profile/speProfile_check'],
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
	    }else if(layEvent === 'del'){//删除
	    	layer.confirm('真的删除行么', function(index) {
				/*obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
				layer.close(index);
				//向服务端发送删除指令*/	
	    	//	console.log(data.id);
				$.ajax({
					url:'/specialtyProfile/delSpecialtyProfile',
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
	    		content:['/toPage?page=specialty_profile/speProfile_update'],
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
			if(arr.date != "" && arr.date != null){
				arr.date1 = data.field.date.split('~')[0].replace(/(^\s*)|(\s*$)/g, "");
				arr.date2 = data.field.date.split('~')[1];
			}
			arr.specialty_name = $("#specialtyName option:checked").text();
		//	console.log(JSON.stringify(arr));
			tableIns.reload({
				where:arr,
				page: {
					curr: 1
				}
			});
			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
	  
		
		layui.use('element', function() {
			var element = layui.element;

		});

		layui.use(['form','laydate'], function() {
			var form = layui.form;
			
		
			/*
			 实现文件时间选择
			 */
			var laydate = layui.laydate;
			
			laydate.render({
				elem: '#date' //指定元素
			});
			
	//添加按钮点击事件
	  $("#insert").click(function(){
	  	layer.open({
	  		title:"添加",
	  		type:2,
	  		content:['/toPage?page=specialty_profile/speProfile_insert'],
	  		maxmin:true,
	  		resize:false,
	  		area:['80%','85%'],
			success : function(layero, index) {
				// 获取子页面的iframe
				var iframe = window['layui-layer-iframe' + index];
				// 向子页面的全局函数child传参
				iframe.initAdd(appendOption);
			}
	  	});
	  });
	  //批量删除
	  table.on('toolbar(test)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id);
		    //console.log(JSON.stringify(checkStatus.data.id));
		    
		    switch(obj.event){
		      case 'delData':
		        var data = checkStatus.data;
		        var param = [{}];
		       // layer.alert(JSON.stringify(data));
		        if(data.length > 0){
		        for(var i=0;i< data.length;i++){
		        	param = data[i].id;
//		        	layer.alert(JSON.stringify(data[i].id));
		        	console.log(param);
		        	//向服务端发送删除指令*/		
					$.ajax({
						url:'/specialtyProfile/delSpecialtyProfile',
						type:"POST",
						data:{id:param},
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
		        	layer.msg("请选择要删除的用户");
		        }    
		      break;
		    };
		    
		  });
});
});
