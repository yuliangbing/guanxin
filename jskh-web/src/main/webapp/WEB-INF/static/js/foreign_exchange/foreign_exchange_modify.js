/**
 * 修改页面的js


 */
	// 初始化赋值
	var specialty_name = "";
	var id = "";
	function init(data) {
		//$("#status").val(data.status);
		id = data.id
		$("#id").val(data.id);
		$("#date").val(data.date);
		$("#content").val(data.content);
		$("#units").val(data.units);
		$("#participants").val(data.participants);
		$("#achievements").val(data.achievements);
		$("#specialty_id").val(data.specialtyId);
		specialty_name = data.specialtyName;
    	
	}
	
	
		//关闭监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		
		//专业id下拉列表
		function ajax_h(form,names,url,object,ids)
		{
			$.ajax({
				url:url,
				type:"POST",
				dataType:"json",
				success:function(data){
					//layer.msg("获取成功");
					/*console.log("长度"+data.data.length);
					console.log(names);*/
					let option = "";
					if (data.code == 0) {
						if(ids == 'code'){
							for (let i=0;i<data.data.length;i++)
							{
								if(data.data[i].name == names)
								{
									option += "<option value='"+data.data[i].code+"' selected='selected'>"+data.data[i].name+"</option>";
								}
								else
								{
									option += "<option value='"+data.data[i].code+"'>"+data.data[i].name+"</option>";
								}
							}
							$("#"+object).append(option);
							form.render('select');
						}
					 	else if(ids == 'id')
					 	{
							for (let j=0;j<data.data.length;j++)
							{
								if(data.data[j].name == names )
								{
									option += "<option value='"+data.data[j].id+"' selected='selected'>"+data.data[j].name+"</option>";
								}
								else
								{
									option += "<option value='"+data.data[j].id+"'>"+data.data[j].name+"</option>";
								}
							}
							$("#"+object).append(option);
							form.render('select');
						} 
						//console.log("option:"+option);
						
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
			var laydate = layui.laydate;
			/*
			下拉列表数据获取  开始
		*/
		var url ="";
		var object="";
		var ids="";
		var name;
		//专业
		ids = 'id';
		url = '/specialty/getSpecialtyList';
		object = 'specialty_id';
		names= specialty_name;
		ajax_h(form,names,url,object,ids);
			laydate.render({
				elem: '#date' //指定元素	
			});
			
		
		layui.use('element', function() {
			var element = layui.element;

		});

		

			//时间控件
			var laydate = layui.laydate;
			laydate.render({
			elem: '#date',
			//range: true //或 range: '~' 来自定义分割字符
			});
		
			
		 	// 提交功能
		 	form.on('submit(submit)', function(data) { 
				/*获取$值存入params */
				var params = {};
				params.id = id;
				params.date = $("#date").val();
				params.content = $("#content").val();
				params.units = $("#units").val();
				params.participants = $("#participants").val();
				params.achievements = $("#achievements").val();
				params.specialty_id = $("#specialty_id option:checked").val();
				params.specialty_name = $("#specialty_id option:checked").text();
				//console.log(params);
				layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
				    $.ajax({
					        type:"POST",
					        url:'/foreignExchange/updateForeignExchange',
							data:$.param(params),
					        //预期服务器返回数据的类型
					        dataType:"json", 
					        success:function(data){
					        	if(data){
									//console.log($.param(params));
									if (data.code == 0) {
										layer.msg("成功");
										setTimeout(function(){
												parent.window.location.reload();
										},500);
									} else if(data.code != 0) {
										layer.msg("失败,数据缺少!");
									}
								}
							} ,error:function(code1){
					           alert("发生错误,请联系管理员");
					        }
					});
				  layer.close(index);
				});
									
				return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});  
			
		});