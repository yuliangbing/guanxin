<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>组织机构</title>
<link rel="stylesheet"
	href="${path}/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
<script type="text/javascript"
	src="${path}/static/js/menu/menu_manage.js"></script>
</head>
<div class="x-body">
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn layui-btn-normal"  data-method="offset" data-type="auto" onclick="add()">
			<i class="layui-icon">&#xe654;</i>新增父菜单
		</button>
		</xblock>
		<table class="layui-table layui-form">
			<thead>
				<tr>
					<th width="20">
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th style="min-width: 150px;">组织机构</th>
					<th>创建人</th>
					<th>创建时间</th>
					<th>操作</th>
			</thead>
			<tbody class="x-cate" id="organizationbady">
			</tbody>
		</table>
	</div>
	<style type="text/css">
</style>
	<script>
		layui.use([ 'form' ], function() {
			form = layui.form;

		});

		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		}

		function delAll(argument) {

			var data = tableCheck.getData();

			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			});
		}
		
		layui.use('layer', function(){ //独立版的layer无需执行这一句
			  var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
			  
			  //触发事件
			  var active = {
			    setTop: function(){
			      var that = this; 
		offset: function(othis){
		      var type = othis.data('type')
		      ,text = othis.text();
		      
		      layer.open({
		        type: 1
		        ,offset: 'branch/organization_insert' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
		        ,id: 'layerDemo'+type //防止重复弹出
		        ,content: '<div style="padding: 200px 500px;">'+ text +'</div>'
		        ,btn: '关闭全部'
		        ,btnAlign: 'c' //按钮居中
		        ,shade: 0 //不显示遮罩
		        ,yes: function(){
		          layer.closeAll();
		        }
		      });
		    }
	</script>

</html>