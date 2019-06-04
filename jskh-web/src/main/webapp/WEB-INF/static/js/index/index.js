//首页图表的js

 
/**
 * 饼图的js
 */ 
        var param = "";
        var arr;
        var counts = "" ;
        function ajax_h(url) {
        	// 获取下拉列表(公共方法)
        	$.ajax({
        		url : url,
        		type : "POST",
        		dataType : "json",
        		async:false,
        		success : function(data) {
        			for(var i=0;i < data.data.length;i++){
        				if(param == ""){
        					param = data.data[i].name;
        					ajax_name(param);
        				}else{
        					param += ","+data.data[i].name;
        					ajax_name(data.data[i].name);
        				}
        			}
        			/* split_array(param); */
        			//console.log("获得的文件类型数据date.name="+param);
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        
        //查文件类型名称为改名称name的数据有多少条
        function ajax_name(param) {
        	// 获取下拉列表(公共方法)
        	$.ajax({
        		url :'/specialtyFiles/FilesCounts',
        		type : "POST",
        		dataType : "json",
        		data:{cate_name:param},
        		async:false,
        		success : function(data) {
        			
        				if(counts == ""){
        					counts = data.code;
        					
        				}else{
        					counts += ","+data.code;
        					//console.log(counts);
        				}
        				//console.log("全部的counts:"+counts);
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        
        // 获取下拉框属性
    	var url = "";
    	// 文件类型
    	url = '/fileCategory/getFileCategoryList';
    	ajax_h(url);
        
        // 基于准备好的dom，初始化echarts实例
        
        var myChart = echarts.init(document.getElementById('main3'));
        var asd=param.split(',');
        //console.log(asd)
        //console.log(counts);
        var psd = counts.split(',');
        var a=new Array();
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
            }
           , color: ['#37A2DA', '#32C5E9', '#67E0E3', '#9FE6B8', '#FFDB5C','#ff9f7f', '#fb7293', '#E062AE', '#E690D1', '#e7bcf3', '#9d96f5', '#8378EA', '#96BFFF']
           , legend: {
                orient: 'vertical',
                left: 'left',
                data: asd
            },
            series : [
                {
                    name: '专业文件',
                    type: 'pie',
                    radius : '78%',//图的大小
                    center: ['50%', '60%'],//图所在的位置
                    data:a,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,//图形阴影的模糊大小
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
