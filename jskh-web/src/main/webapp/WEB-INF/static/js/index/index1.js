/**
 * 折线图的js
 */
	
	var url = "";
	var param = "";
	var counts = "";
	var  rows = "";
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
        				if(param == ""){
        					param  = rows[i].setupDate.split(' ')[0];
        					ajax_date(param);
        				}else{
	       					param += ","+rows[i].setupDate.split(' ')[0];
	       					ajax_date(rows[i].setupDate.split(' ')[0]);
        				}
        			}
        			
        			//console.log(param);
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
	
	
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
	url = '/specialty/getSpecialtyList';
	ajax_hx(url);
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



	