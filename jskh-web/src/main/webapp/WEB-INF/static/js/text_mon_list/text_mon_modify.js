/**
 * 修改页面的js
 */
	// 初始化赋值
	function init(data) {
		//$("#status").val(data.status);
		$("#id").val(data.id);
		$("#date").val(data.date);
		$("#name").val(data.name);
		$("#press").val(data.press);
		$("#first_author").val(data.firstAuthor);
		$("#other_authors").val(data.otherAuthors);
		$("#specialty_id").val(data.specialtyId);
		specialty_name = data.specialtyName;
	}
	
		//关闭监听
		function exit(){
		    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭  
		}
		
		layui.use('element', function() {
			var element = layui.element;

		});

		layui.use(['form', 'table', 'laydate'], function() {
			var form = layui.form;
             var laydate = layui.laydate;
			
			laydate.render({
				elem: '#date' //指定元素
			});
		
			 //提交
			form.on('submit(submit)', function(data) {
				var date=$("#date").val;
				var name=$("#name").val;
				var press=$("#press").val;
				var first_author=$("#first_author").val;
				var other_authors=$("#other_authors").val;
				$.ajax({
					url:"/TextbookOrMonograph/updateTextbookOrMonograph",
					type:"post",
					//发送的数据
					date:JSON.stringify({date:date,name:name,press:press,first_author:first_author,other_authors:other_authors}),
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