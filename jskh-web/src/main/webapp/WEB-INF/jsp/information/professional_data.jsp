<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>专业数据简介</title>
<link rel="stylesheet" href="/static/public/css/xadmin.css">

</head>
		<body class="layui-layout-body layui-anim layui-anim-scaleSpring" style="position:absolute; height:400px; overflow:auto">
		<div>
      		<a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        	<i class="layui-icon" style="line-height:30px">ဂ</i></a>
    	</div>
		<div  class="layui-col-sm12 layui-col-md12 layui-content-white">
		<div class="layui-row">
			<form class="layui-form" action="" onsubmit="return false;">
				<!-- <div class="layui-form-item" style="margin-left:18%;margin-top:2%">
					<div class="layui-inline" style="margin: -15px 0px 27px -209px;">
						<label class="layui-form-label" for="specialty_id">专业</label>
						<div class="layui-input-inline">
							<select type="text" id="specialty_id" lay-verify="required" class="layui-select" lay-search>
								<option value="">请选择</option>
							</select>
						</div>
					</div>
					<div class="layui-inline" style="margin: -15px 0px 27px -209px;">
						<button class="layui-btn layui-right" lay-submit
							lay-filter="submit" style="margin: 0px 0px 0px 400%;">确定</button>
					</div>
				</div> -->
					
				<fieldset class="layui-elem-field">
				  <legend>专业数据分析</legend>
				  <div class="layui-field-box">
					 <div id="main" style="width: 700px;height:500px;"></div>
				  </div>
				</fieldset>
			</form>
		</div>
		</div>
		<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
   		<script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
   		<script type="text/html" id="toolbarDemo">
			<div style="margin:-5px -1px;">
				<button class="layui-btn layui-btn-danger" lay-event="delData"><i class="layui-icon"></i>批量删除</button>
				<button class="layui-btn" lay-submit lay-filter="insertAdd" id="insert"><i class="layui-icon"></i>添加</button>
			</div>
		</script>
		<script type="text/html" id="barDemo" >
			<a class="layui-btn layui-btn-xs" lay-event="details"><i class="layui-icon">&#xe615;</i>查看</a>
			<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="modify"><i class="layui-icon">&#xe642;</i>编辑</a>
			<a class="layui-btn-danger layui-btn layui-btn-xs" lay-event="del"><i class="layui-icon">&#xe640;</i>删除</a>
		</script>
		<script>
		var params = "";//存放所有专业名称
		
		//获取专业列表
		function ajax_h(url, object, ids) {
			$.ajax({
				url : url,
				type : "POST",
				dataType : "json",
				async:false,
				success : function(data) {
						
						for (let i = 0; i < data.data.length; i++) {
							
						if(params == ""){
							params = data.data[i].name;
							//console.log(data.data[i].name+"1");
						}else{
							params += ","+data.data[i].name;
							//console.log(data.data[i].name+"2");
						}
					}
						//console.log("总数据："+params);	
				},error : function(code) {
					layer.alert("发生错误,请联系管理员");
				}
			});
		}
		
			// 获取专业属性
			var url = "";
			var object = "";
			var ids = "";
			// 专业
			url = '/specialty/getSpecialtyList';
			object = 'specialty_id';
			ids = 'id';
			ajax_h(url, object, ids);	
	
		/**
		图表js
		*/
		
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
      
		var asd = params.split(',');
        var a=new Array();
        for(var i=0;i<asd.length;i++){
        	var b={};
        	b.value= new Array();
        	
        	/* if(i==1){
	       		for(let j=0;j<6;j++){
	           		b.value[j]=Math.round(Math.random()*1500)+1024;
	           	}
        	}else if(i==4){
        		for(let j=0;j<6;j++){
	           		b.value[j]=Math.round(Math.random()*2000)+2024;
	           	}
        	}else{
        		for(let j=0;j<6;j++){
	           		b.value[j]=Math.round(Math.random()*3000)+1500;
	           	}
        	} */
        	switch (i) {
			case 0:
				b.value[0]=400;
				b.value[1]=420;
				b.value[2]=430;
				b.value[3]=440;
				b.value[4]=450;
				b.value[5]=500;
				break;
			case 1:
				b.value[0]=300;
				b.value[1]=420;
				b.value[2]=430;
				b.value[3]=500;
				b.value[4]=450;
				b.value[5]=450;
				break;
			case 2:
				b.value[0]=300;
				b.value[1]=420;
				b.value[2]=430;
				b.value[3]=500;
				b.value[4]=450;
				b.value[5]=450;
				break;
			case 3:
				b.value[0]=500;
				b.value[1]=420;
				b.value[2]=330;
				b.value[3]=400;
				b.value[4]=450;
				b.value[5]=450;
				break;
			case 4:
				b.value[0]=500;
				b.value[1]=500;
				b.value[2]=330;
				b.value[3]=500;
				b.value[4]=350;
				b.value[5]=350;
				break;
			case 5:
				b.value[0]=300;
				b.value[1]=300;
				b.value[2]=500;
				b.value[3]=400;
				b.value[4]=450;
				b.value[5]=450;
				break;
			case 5:
				b.value[0]=400;
				b.value[1]=450;
				b.value[2]=5400;
				b.value[3]=500;
				b.value[4]=450;
				b.value[5]=350;
				break;
			case 6:
				b.value[0]=500;
				b.value[1]=450;
				b.value[2]=400;
				b.value[3]=500;
				b.value[4]=450;
				b.value[5]=500;
				break;
			case 7:
				b.value[0]=460;
				b.value[1]=470;
				b.value[2]=480;
				b.value[3]=500;
				b.value[4]=450;
				b.value[5]=350;
				break;
			case 8:
				b.value[0]=400;
				b.value[1]=450;
				b.value[2]=500;
				b.value[3]=500;
				b.value[4]=500;
				b.value[5]=450;
				break;
			case 9:
				b.value[0]=400;
				b.value[1]=500;
				b.value[2]=450;
				b.value[3]=470;
				b.value[4]=450;
				b.value[5]=500;
				break;
			case 10:
				b.value[0]=480;
				b.value[1]=350;
				b.value[2]=500;
				b.value[3]=500;
				b.value[4]=450;
				b.value[5]=450;
				break;
			case 11:
				b.value[0]=500;
				b.value[1]=350;
				b.value[2]=500;
				b.value[3]=400;
				b.value[4]=490;
				b.value[5]=450;
				break;
			case 12:
				b.value[0]=300;
				b.value[1]=450;
				b.value[2]=390;
				b.value[3]=490;
				b.value[4]=450;
				b.value[5]=450;
				break;
			case 13:
				b.value[0]=400;
				b.value[1]=450;
				b.value[2]=300;
				b.value[3]=200;
				b.value[4]=370;
				b.value[5]=440;
				break;
			case 14:
				b.value[0]=500;
				b.value[1]=470;
				b.value[2]=440;
				b.value[3]=460;
				b.value[4]=450;
				b.value[5]=480;
				break;
			case 15:
				b.value[0]=400;
				b.value[1]=450;
				b.value[2]=500;
				b.value[3]=300;
				b.value[4]=490;
				b.value[5]=350;
				break;
			case 16:
				b.value[0]=430;
				b.value[1]=420;
				b.value[2]=410;
				b.value[3]=500;
				b.value[4]=450;
				b.value[5]=500;
				break;
			case 17:
				b.value[0]=430;
				b.value[1]=420;
				b.value[2]=500;
				b.value[3]=500;
				b.value[4]=450;
				b.value[5]=250;
				break;
			case 18:
				b.value[0]=420;
				b.value[1]=410;
				b.value[2]=580;
				b.value[3]=500;
				b.value[4]=490;
				b.value[5]=350;
				break;
			
			default:
				b.value[0]=4000;
				b.value[1]=4200;
				b.value[2]=4300;
				b.value[3]=4400;
				b.value[4]=4500;
				b.value[5]=5000;
				break;
			}
        	
        	
        	b.name=asd[i];
        	a.push(b);
        }
        option = {
        	    title: {
        	        text: ''
        	    },
        	    tooltip: {},
        	    legend: {
        	        //data: ['教师技能', '平均技能']
       	    	    type: 'scroll',
       	            orient: 'vertical',
       	            right: -10,
       	            top: 10,
       	            bottom: 10,
       	        	left:10,
        	    	data:asd
        	    },
        	    color:['#7ddd2f','#ba00f6','#fa9a98','#d84c29','#dadee3','#ffcd41','#09b0c3','#31b0d5','pink','red','yellow','blue','black','#d2ffa7','#ffe7ce','#f0f0f0'],
        	    radar: {
        	        // shape: 'circle',
        	        name: {
        	            textStyle: {
        	                color: '#fff',
        	                backgroundColor: '#999',
        	                borderRadius: 3,
        	                padding: [3, 5]
        	           }
        	        },
        	        indicator: [
        	           { name: '师资建设', max: 500},
        	           { name: '人才培养', max: 500},
        	           { name: '教学改革', max: 500},
        	           { name: '校企合作', max: 500},
        	           { name: '科研和社会服务', max: 500},
        	           { name: '开放办学', max: 500}
        	        ]
        	    },
        	    series: [{
        	        name: '预算 vs 开销（Budget vs spending）',
        	        type: 'radar',
        	        // areaStyle: {normal: {}},
        	        /* data : [
        	            {
        	                 value : [4300, 10000, 28000, 35000, 50000, 19000],
        	        	                name : '教师技能'
        	            },
        	             {
        	                value : [2500, 7000, 14000, 31000, 42000, 21000],
        	                name : '平均技能'
        	            }
        	        ] */
        	        data:a
        	    }]
        	};
		 // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
		</script>
	</body>
</html>