//科研成果
 
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
        
        var myChart = echarts.init(document.getElementById('main5'));
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
            },
            //color:['#31b0d5','pink'],
            legend: {
                orient: 'vertical',
                left: 'left',
                data: asd
            },
            series : [
                {
                    name: '专业文件',
                    type: 'pie',
                    radius : '55%',//图的大小
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