/**
 * 新增页面的js
 */
		//关闭弹窗监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		
		//专业id下拉列表
		var id = 0;
		var specialty_name = "";
		function init(data) {
			specialty_name = data.specialty_name;
		}
		
		function ajax_h(form,names,url,object,ids)
		{
			$.ajax({
				url:url,
				type:"POST",
				dataType:"json",
				success:function(data){
					//layer.msg("获取成功");
					console.log("长度"+data.data.length);
					console.log(names);
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
						console.log("option:"+option);
						
					} else {
						layer.msg(data.msg);
					}
					
				} ,error:function(code){
		           layer.alert("发生错误,请联系管理员");
		        }
			});
		}
		
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
			
			/*
			下拉列表数据获取
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
			
		    //提交
		form.on('submit(submit)', function(data) {
				var date=$("#date").val;
				var name=$("#name").val;
				var press=$("#press").val;
				var specialtyId = $("#specialty_id option:checked").val();
				var specialtyName = $("#specialty_id option:checked").text();
				var firstAuthor=$("#first_author").val;
				var otherAuthors=$("#other_authors").val;
				console.log(specialtyId);
				$.ajax({
					url:"/TextbookOrMonograph/addTextbookOrMonograph",
					type:"post",
					//发送的数据
					date:JSON.stringify({date:date,name:name,press:press,firstAuthor:firstAuthor,otherAuthors:otherAuthors,specialtyId:specialtyId,specialtyName:specialtyName}),
					//发送请求的数据的格式为JSON字符串
					contentType:"application/json;charset=UTF-8",
					dataType:"json",
					success:function(data){
						        	if(data){
										if (data.code == 0) {
											layer.msg("成功");
											setTimeout(function(){
													parent.window.location.reload();
											},500);
										} else if(data.code != 0) {
											layer.msg("失败,可能为数据填写错误或缺少必要数据！");
										}
									}
								} ,error:function(code){
						           layer.alert("发生错误,请联系管理员");
						}
					
				});
				 layer.close(index);
			});
			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			
		});