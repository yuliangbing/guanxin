/**
 * 修改页面的js
 */
	var fileUrl="";
	var urlFileName="";
	var cate_name = "";
	var specialty_name = "";
	var id=0;
	// 初始化赋值
	function init(data) {
		id = data.id;
		$("#date").val((data.date.split(' '))[0]);
		$("#code").val(data.code);
		$("#name").val(data.name);
		cate_name = data.cateName;
		$("#reviser").val(data.reviser);
		fileUrl = data.urlFile;
		urlFileName = data.urlFileName;
		$("#showFile").text(urlFileName);
		specialty_name = data.specialtyName;
		
	}
	//获取下拉列表(公共方法)
	function ajax_h(form,names,url,object,ids)
	{
		$.ajax({
			url:url,
			type:"POST",
			dataType:"json",
			success:function(data){
				//layer.msg("获取成功");
				//console.log("长度"+data.data.length);
				//console.log(names);
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
	
		//关闭监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		
		layui.use(['element','upload'], function() {
			var element = layui.element;

			var upload = layui.upload;
			// 选完文件后不自动上传
			upload.render({
				elem : '#uploadFile',
				url : '/ueditor/jsp/controller.jsp?action=uploadfile',
			    method: 'post',
			    accept: 'file',
				auto : true,
				done : function(res) {
					console.log(res);
					fileUrl = res.url;
					urlFileName = res.original;
					$("#showFile").text(res.original);
				}
			})
		});

		layui.use(['form', 'table', 'laydate'], function() {
			var form = layui.form;
			
			/*
				下拉列表数据获取  开始
			*/
			var url ="";
			var object="";
			var ids="";
			var name;
			//文件类型
			url = '/fileCategory/getFileCategoryList';
			object = 'cate_name';
			ids = 'code';
			names = cate_name;
			ajax_h(form,names,url,object,ids);
			//专业
			ids = 'id';
			url = '/specialty/getSpecialtyList';
			object = 'specialty_id';
			names= specialty_name;
			ajax_h(form,names,url,object,ids);
			/*
				下拉列表数据获取  结束
			*/
			
			// 实现文件时间选择
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem: '#date' //指定元素
				//,range: '~' //或 range: '~' 来自定义分割字符
			});
			
		 	// 提交功能
		 	form.on('submit(submit)', function(data) { 
				/*获取$值存入params */
				var params = {};
				params.date = $("#date").val();
				params.code = $("#code").val();
				params.name = $("#name").val();
				params.cate_name = $("#cate_name option:checked").text();
				params.reviser = $("#reviser").val();
				params.specialty_id = $("#specialty_id option:checked").val();
				params.specialty_name = $("#specialty_id option:checked").text();
				params.url_file = fileUrl;
				params.url_file_name = urlFileName;
				//params.url = $()
				layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
				    $.ajax({
					        type:"POST",
					        url:'/specialtyFiles/updateSpecialtyFilesIf?Id='+id,
							data:$.param(params),
					        //预期服务器返回数据的类型
					        dataType:"json", 
					        success:function(data){
					        	if(data){
									console.log($.param(params));
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
									
				//return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});  
			
		});