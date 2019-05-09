

	
			layui.use('element', function() {
		    	var element = layui.element;
		
			});
	
			layui.use(['form', 'table', 'laydate'], function() {
				var form = layui.form;
				var table = layui.table;
				//获取下拉列表
				ajax_h(form);
				
				//时间控件
				var laydate = layui.laydate;
				laydate.render({
				elem: '#date',
				range: true //或 range: '~' 来自定义分割字符
				});
			

	
	/*表格 */
	layui.use('table', function(){
	      var table = layui.table;
	table.render({
	    elem: '#demo'
	    ,height: 312
	    ,method:'post'
	   // ,url: '/demo/table/user/' //数据接口
	    ,data:[{"id":1,"name":'jsdgufay'}]
	    ,page: true //开启分页
	    ,toolbar:"#toolbarDemo"
	    ,cols: [[ //表头
	       {type:'checkbox', fixed: 'left'}
	      ,{field:'id',title:'ID'}
	      ,{field:'position',title:'职务'}
	      ,{field:'name', title:'姓名'}
	      ,{field:'create-user', title:'创建人'}
	      ,{field:'create-time', title:'创建时间'}
	      ,{align:'center', toolbar: '#barDemo',title:'操作'}
	      ]]
	  });
	});

	/* 搜索功能 */
	form.on('submit(search)', function(data) {
		//layer.alert(JSON.stringify($("#cate_name option:checked").text()));
		
		let arr = {};
		arr = data.field;
		arr.cate_name = $("#cate_name option:checked").text();
		//console.log(arr);
		/*layer.alert(JSON.stringify(arr));*/
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
	
	
	/*新增功能*/
	form.on('submit(add)', function(data) {
		layer.open({
			type:2,
			title:'添加窗口',
			area:['90%','90%'],
			anim:0,
			content: "/toPage?page=organization/organization_add"
		});
		return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	   
	 });
	
	
	});




