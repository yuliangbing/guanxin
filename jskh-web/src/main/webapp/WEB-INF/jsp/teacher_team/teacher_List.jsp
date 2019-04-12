<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业文件</title>

<link rel="stylesheet" href="/static/public/lib/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/specialty_files.css">
</head>
<body>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 5px;">
			<legend>教师信息搜索</legend>
		</fieldset>
 		
 		<form class="layui-form" action="">
 			
     		<div class="demoTable" style="padding-left: 40%;">
    						教师姓名：
    					<div class="layui-inline">
        					<input class="layui-input" name="keyword" id="demoReload" autocomplete="off">
    					</div>
    							<button class="layui-btn" data-type="reload">搜索</button>
				</div>
				
    <table id="test" lay-filter="test"></table>
    
    </form>
		
</body>
 
    <script src="${path}/static/public/lib/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    
	  <script type="text/html" id="toolbarDemo">
			<div>
				<button class="layui-btn layui-btn-primary layui-btn-sm "><i class="layui-icon"></i>批量删除</button>
				<!--头部工具栏删除按钮-->
			</div>
		</script>
		
		<script type="text/html" id="barDemo">
					<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
			  	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			  	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
	  
		<script>
		layui.use('table', function(){
		  var table = layui.table;
		  var data = [{
		  	id:1,
		  	'name':'yes',
		  },
		  {
		  	id:2,
		  	'name':'2'}]
		  table.render({
		    elem: '#test'
		    //,url:'/test/table/demo1.json'
		    ,data:data
		    ,toolbar: '#toolbarDemo'

		    ,title: '用户数据表'
		    ,page: true
		    ,cols: [[
		      {type: 'checkbox', fixed: 'left'}
		      ,{field:'id', title:'主键', width:100, fixed: 'left', sort: true}
		      ,{field:'specialty_id', title:'专业id', width:120, }
		      ,{field:'specialty_code', title:'专业编码', width:130, }
		      ,{field:'specialty_name', title:'专业名称', width:150, }
		      ,{field:'date', title:'团队变更时间', width:150, } 
		      ,{field:'specialty_teachers', title:'专业教师团队', width:150, }
		      ,{field:'part_time_teachers', title:'兼职教师团队', width:150, }
		      ,{field:'director', title:'团队总负责人', width:150, }
		      ,{field:'latest', title:'是否最新（1=是，2=否）', width:220, }
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:180}
		    ]]
		    
		  });
		  //监听头部工具栏
		  
		  //监听行工具事件
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    var layEvent = obj.event;
		    var tr = obj.tr;
		    var $ = layui.jquery()
		    if(layEvent === 'detail'){//查看
		    	layer.open({
  							title:"教师信息查看",
		    		type:2,
		    		content:['http://localhost:8091/toPage?page=teacher_team/teacher_check','no'],
		    		maxmin:true,
		    		resize:false,
		    		area:['55%','60%']
						}); 
		    	
		    }else if(layEvent === 'del'){//删除
		    	layer.confirm('真的删除行么',function(index){
		    		obj.del();
		    		layer.close(index);
		    	});
		    }else if(layEvent === 'edit'){//编辑
		    	layer.open({
		    		title:"教师信息编辑",
		    		type:2,
		    		content:['http://127.0.0.1:8020/%E5%B8%88%E8%B5%84%E5%9B%A2%E9%98%9F/bianji.jsp?__hbt=1554809161867','no'],
		    		maxmin:true,
		    		resize:false,
		    		area:['70%','90%'],
		    		
    			});
  			}
			});
});
</script>
</html>