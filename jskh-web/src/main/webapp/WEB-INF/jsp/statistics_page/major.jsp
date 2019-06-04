<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%-- <%@ include file="/WEB-INF/Taglib.jsp"%> --%>
<%@ include file="/WEB-INF/Common.jsp"%>
<!DOCTYPE html>
<html class="x-admin-sm">
	</head>
	        <meta charset="UTF-8">
	        <title>统计页面</title>
	        <!-- <meta name="renderer" content="webkit">
	        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" /> -->
	        <link rel="stylesheet" href="${path}/static/public/css/font.css">
	        <link rel="stylesheet" href="${path}/static/public/css/xadmin.css">
	        <script src="./lib/layui/layui.js" charset="utf-8"></script>
	        <script type="text/javascript" src="./js/xadmin.js"></script>
	        <!--[if lt IE 9]>
	          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	        <![endif]-->
	</head>
    <body style="position:absolute; height:400px; overflow:auto">
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">

                <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">专业统计</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                            <div id="main1" class="layui-col-sm12" style="height: 300px;"></div>
							</ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
        <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
        <script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
    	
    	var url = "";
    	var param = "";
    	var counts = "";
    	var  rows = "";
    	url = '/specialty/getSpecialtyList';
    	ajax_hx(url);
    	
    	//获取到专业设立时间
    	function ajax_hx(url) {
            	$.ajax({
            		url : url,
            		type : "POST",
            		dataType : "json",
            		async:false,
            		success : function(data) {
            			sort(data);
            			//console.log(JSON.stringify(data));
            			for(var i=0;i < rows.length;i++){
            				if(param == ""){//取出所有排序好的时间
            					param  = rows[i].setupDate.split(' ')[0];
            					ajax_date(rows[i].setupDate.split(' ')[0]);
            				}else{
    	       					param += ","+rows[i].setupDate.split(' ')[0];
    	       					ajax_date(rows[i].setupDate.split(' ')[0]);
            				}
            				
            				//console.log(rows[i].setupDate.split(' ')[0]);
            			}
            			
            			//console.log(param);
            		},
            		error : function(code) {
            			layer.alert("发生错误,请联系管理员");
            		}
            	});
            }
    	
    	//时间升序
    	function sort(data){
    		  	rows = data.data;  //
    		    rows.sort(function(a,b){
    		        return Date.parse(a.setupDate.split(' ')[0]) - Date.parse(b.setupDate.split(' ')[0]);//时间倒叙 如果是从小到大交换啊a ,b位置即可
    		    });
    		   /* for(var i =0,l=rows.length;i<l;i++){
    		        console.log(" | " + rows[i].setupDate.split(' ')[0]); //输出
    		    }
    		    console.log("rows:"+JSON.stringify(rows));//输出
    		*/
    		}
    	//查从建校日期到该时间的专业数量
        function ajax_date(param) {
        	// 获取下拉列表(公共方法)
        	$.ajax({
        		url :'/specialty/specialtyCounts',
        		type : "POST",
        		dataType : "json",
        		data:{setup_date:param},
        		async:false,
        		success : function(data) {
        			
        				 if(counts == ""){
        					counts = data.code;
        					
        				}else{
        					counts += ","+data.code;
        					//console.log(counts);
        				} 
        				//console.log("全部的counts:"+counts);
        			console.log(JSON.stringify(data));
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
    	
    	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main1'));
        // 专业设立时间
    	
    	var date = param.split(',');
    	var sum = counts.split(',');
    	console.log(sum);
        // 指定图表的配置项和数据
        var option = {
            grid: {
                top: '5%',
                right: '1%',
                left: '1%',
                bottom: '10%',
                containLabel: true
            },
            tooltip: {
                trigger: 'axis'
            },
            xAxis: {
                type: 'category',
                data: date
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                name:'专业数量',
                data: sum,
                type: 'line',
                smooth: true
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

    	
        </script>
    </body>
</html>