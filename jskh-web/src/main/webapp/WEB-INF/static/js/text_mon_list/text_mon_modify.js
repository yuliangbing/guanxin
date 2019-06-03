/**
 * 修改页面的js
 */
	// 初始化赋值
	var id ;
function init(data) {
		//$("#status").val(data.status);
		id = data.id;
		$("#date").val(data.date.split(' ')[0]);
		$("#name").val(data.name);
		$("#press").val(data.press);
		$("#first_author").val(data.firstAuthor);
		$("#other_authors").val(data.otherAuthors);
		$("#specialty_id").val(data.specialtyId);
		//$("#specialty_name").val(data.specialtyName);
		specialty_name = data.specialtyName;
	}
	
		//关闭监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		//专业id下拉列表
		var id = 0;
		var specialty_name = "";
		
		function ajax_h(form,names,url,object,ids)
		{
			$.ajax({
				url:url,
				type:"POST",
				dataType:"json",
				success:function(data){
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
		layui.use('element', function() {
			var element = layui.element;

		});

		layui.use(['form', 'table', 'laydate'], function() {
			var form = layui.form;
             var laydate = layui.laydate;
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
 		
			laydate.render({
				elem: '#date' //指定元素
			});
			
		
			 //提交
			form.on('submit(submit)', function(data) {
				var params = {};
				params.id=id;
				params.date=$("#date").val();
				params.name=$("#name").val();
				params.press=$("#press").val();
				params.first_author=$("#first_author").val();
				params.other_authors=$("#other_authors").val();
				params.specialty_id = $("#specialty_id option:checked").val();
				params.specialty_name = $("#specialty_id option:checked").text();
			//	console.log();
				alert(JSON.stringify(params));
				//console.log(params.other_authors);
				//console.log(date,name,press,first_author,other_authors,specialty_id,specialty_name);
				layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
				$.ajax({
					url:"/TextbookOrMonograph/updateTextbookOrMonograph",
					type:"post",
					//发送的数据
					data:$.param(params),
					//发送请求的数据的格式为JSON字符串
//					contentType:"application/json;charset=UTF-8",
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
		 
			
		});