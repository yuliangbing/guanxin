<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%-- <%@ include file="/WEB-INF/Taglib.jsp"%> --%>
<%@ include file="/WEB-INF/Common.jsp"%>
<!DOCTYPE html>
<html class="x-admin-sm">
	</head>
	        <meta charset="UTF-8">
	        <title>专利类型统计</title>
	        <!-- <meta name="renderer" content="webkit">
	        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" /> -->
	        <link rel="stylesheet" href="${path}/static/public/css/font.css">
	        <link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
	        <!--[if lt IE 9]>
	          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	        <![endif]-->
	</head>
    <body style="position:absolute; height:400px; overflow:auto">
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
   
                <div class="layui-col-sm12 layui-col-md12" style="margin: 38px 0px 0px 0px;">
                	<!-- <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
				       <i class="layui-icon" style="line-height:30px">ဂ</i>
				    </a> -->
				    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin: -10px 0px 2% 90%;" href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
                    <div class="layui-card">
                        <div class="layui-card-header">专利类型</div>
                        <div class="layui-card-body" style="min-height: 780px;">
                            <div id="main" class="layui-col-sm12" style="height: 500px;"></div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    
        <script src="${path}/static/js/echarts.min.js"></script>
        <script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
        
        var param = "";
        var names="";
        var counts = "" ;
    	var url = "";
    	// 专利类型列表下拉方法接口
    	url = '/patentType/PatentTypeList';
    	ajax_h(url);
        function ajax_h(url) {
        	// 获取专利类型
        	$.ajax({
        		url : url,
        		type : "POST",
        		dataType : "json",
        		async:false,
        		success : function(data) {
        			for(var i=0;i < data.data.length;i++){
        				if(param == ""){
        					param = data.data[i].name;
        					ajax_name(data.data[i].name);
        				}else{
        					param += ","+data.data[i].name;
        					ajax_name(data.data[i].name);
        				}
        			}
        			/* split_array(param); */
        			//console.log("获得的专业date.name="+param);
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        
        //查该专利列表中有多少个文件
        function ajax_name(names) {
        	// 
        	$.ajax({
        		url :'/patent/patentCounts',
        		type : "POST",
        		dataType : "json",
        		data:{type:names},
        		async:false,
        		success : function(data) {
        			
        				 if(counts == ""){
        					counts = data.code;
        					
        				}else{
        					counts += ","+data.code;
        					//console.log(counts);
        				} 
        				//console.log("全部的counts:"+counts);
        			//console.log("全部的data:"+data);
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        
       
        
        // 基于准备好的dom，初始化echarts实例
        
        var myChart = echarts.init(document.getElementById('main'));
        var asd=param.split(',');//字符串转数组
        var psd = counts.split(',');
        var a=new Array();//转换为json
        for(var i=0;i<asd.length;i++){
        	var b={};
        	b.value=psd[i];
        	b.name=asd[i];
        	a.push(b);
        }
       // console.log(a)
        // 指定图表的配置项和数据
        var option = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            color:['#a1e2fb','#c9f0ff','#68b6d4','#55ccfa','#68b6d3','#33c9ff','#02bbfc'],
            legend: {
                orient: 'vertical',
                left: 'left',
                data: asd
            },
            series : [
                {
                    name: '专利类型',
                    type: 'pie',
                    radius : '50%',//图的大小
                    center: ['50%', '60%'],//图所在的位置
                    data:a,
                  /*   data:[
                        {value:335, name:'直接1访问'},
                        {value:310, name:'邮件营销'},
                        {value:234, name:'联盟广告'},
                        {value:135, name:'视频广告'},
                        {value:1548, name:'搜索引擎'}
                    ], */
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,//外阴影大小
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };



        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

      
    </script>
    </body>
</html>