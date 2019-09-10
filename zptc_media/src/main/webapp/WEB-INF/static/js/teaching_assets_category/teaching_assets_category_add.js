/**
 * 新增页面的js
 */
		//关闭弹窗监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		

		layui.use(['form', 'table', 'laydate'], function() {
			var form = layui.form;
			var laydate = layui.laydate;
	
		
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
				params.code = $("#code").val();
				params.name = $("#name").val();
				layer.confirm('确定提交吗?', {icon: 3, title:'提示'}, function(index){
				    $.ajax({
					        type:"POST",
					       url:'/teachingAssetsCategory/addTeachingAssetsCategory',
							data:$.param(params),
					        //预期服务器返回数据的类型
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