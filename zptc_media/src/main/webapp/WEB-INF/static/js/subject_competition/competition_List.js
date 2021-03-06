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
				
				
				/* 搜索功能 */
				  form.on('submit(searchH)', function(data) {
						//layer.alert(JSON.stringify(data.field));
						//arr = data.field;
					  
						let arr = {};
						arr.date = $("#date").val();
						//console.log("时间："+arr.date);
						arr.award_level = $("#award_level").val();
						if(arr.data != "" && arr.date != null){
							arr.date1 = arr.date.split('~')[0].replace(/(^\s*)|(\s*$)/g, "");
							arr.date2 = arr.date.split('~')[1];
						}
						//console.log(arr);
						tableIns.reload({
							where:arr,
							page: {
								curr: 1
							}
						});
						return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
					});
				
				
	//加载数据表格
	  var tableIns = table.render({
		    elem: '#test'
		    ,defaultToolbar:[]
		    ,url:'/subjectCompetition/getSubjectCompetitionList'
		    ,method:'post'
		    ,title: '用户数据表'
		    ,toolbar:'#toolbarDemo'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		    /*  ,{field:'id', title:'主键', width:'8%',sort: true ,align:'center'}*/
		      ,{type:'numbers', title:'序号', width:'8%',align:'center'}
		      ,{field:'date', title:'时间', width:'15%',align:'center',templet:"<div>{{layui.util.toDateString(d.date,'yyyy-MM-dd')}}</div>"}	     
		      ,{field:'name', title:'竞赛名称', width:'15%', align:'center'}
		      ,{field:'awardLevel', title:'获奖级别', width:'15%', align:'center'}
		      ,{field:'students', title:'获奖学生', width:'15%', align:'center'}
		      ,{field:'teachers', title:'指导老师', width:'15%',align:'center' }
		      ,{field:'specialtyName', title:'专业名称', width:'15%',align:'center' }
		
		     // ,{field:'status', title:'状态(1=正常，2=删除)', width:180,hide:true}
		     // ,{field:'create_time', title:'创建时间', width:'15%',  hide:true}
		   //   ,{field:'create_user', title:'创建人', width:'15%', hide:true }
		     // ,{field:'modify_time', title:'修改时间', width:'15%',  hide:true}
		     // ,{field:'modify_user', title:'修改人', width:'15%', hide:true }
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:237 ,align:'center'}
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
	    		content:['/toPage?page=subject_competition/competition_check'],
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
				$.ajax({
					url:'/subjectCompetition/delSubjectCompetition',
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
	    		content:['/toPage?page=subject_competition/competition_update'],
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

	//添加按钮点击事件
	  $("#insert").click(function(){
	  	layer.open({
	  		title:"添加",
	  		type:2,
	  		content:['/toPage?page=subject_competition/competition_insert'],
	  		maxmin:true,
	  		resize:false,
	  		area:['80%','85%']
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
		        	//console.log(param);
		        	//向服务端发送删除指令*/		
					$.ajax({
						url:'/subjectCompetition/delSubjectCompetition',
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
		      	layer.msg("请选择要删除的学科竞赛");
		 }
		      break;
		    };
		    
		  });
});

