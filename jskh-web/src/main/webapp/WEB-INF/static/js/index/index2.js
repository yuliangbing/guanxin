//科研成果
 
/**
 * 饼图的js
 */ 
        var param = "课题,论文,专利,教材或专著,其他成果";//这字符串表示科研成果的组成
        var arr = "";//这表示获取到每个组成部分获取到的数量
        
        /**
         * 获取课题
         */
        
    	var url = "";
    	// 课题接口
    	url = '/issuesList/getIssuesList';
    	ajax_i(url);
        function ajax_i(url) {
        	// 获取该列表中的数据总条数
        	$.ajax({
        		url : url,
        		type : "POST",
        		dataType : "json",
        		async:false,
        		success : function(data) {
        			//console.log("获得的课题数据date.name="+JSON.stringify(data.count));
        			arr += data.count;
        			//console.log(arr);
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        
        /**
         * 获取论文
         */
        
    	var url = "";
    	// 论文接口
    	url = '/thesisList/getThesisList';
    	ajax_t(url);
        function ajax_t(url) {
        	// 获取该列表中的数据总条数
        	$.ajax({
        		url : url,
        		type : "POST",
        		dataType : "json",
        		async:false,
        		success : function(data) {
        			arr += ","+data.count;//获的总数据量加到arr
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        
        /**
         * 获取专利
         */
        
    	var url = "";
    	// 专利接口
    	url = '/patent/getPatentList';
    	ajax_p(url);
        function ajax_p(url) {
        	// 获取该列表中的数据总条数
        	$.ajax({
        		url : url,
        		type : "POST",
        		dataType : "json",
        		async:false,
        		success : function(data) {
        			arr += ","+data.count;//获的总数据量加到arr
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        
        /**
         * 获取教材或专著
         */
        
    	var url = "";
    	// 教材或专著接口
    	url = '/TextbookOrMonograph/getTextbookOrMonographList';
    	ajax_text(url);
        function ajax_text(url) {
        	// 获取该列表中的数据总条数
        	$.ajax({
        		url : url,
        		type : "POST",
        		dataType : "json",
        		async:false,
        		success : function(data) {
        			arr += ","+data.count;//获的总数据量加到arr
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        
        /**
         * 获取其他成果
         */
        
    	var url = "";
    	// 其他成果
    	url = '/otherAchievements/getOtherAchievementsList';
    	ajax_o(url);
        function ajax_o(url) {
        	// 获取该列表中的数据总条数
        	$.ajax({
        		url : url,
        		type : "POST",
        		dataType : "json",
        		async:false,
        		success : function(data) {
        			arr += ","+data.count;//获的总数据量加到arr
        		},
        		error : function(code) {
        			layer.alert("发生错误,请联系管理员");
        		}
        	});
        }
        //console.log("arr="+arr);
        
        
        // 基于准备好的dom，初始化echarts实例
        
        var myChart = echarts.init(document.getElementById('main5'));
        var asd=param.split(',');
        var psd = arr.split(',');
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
            color:['#31b0d5','#ff20ff','#ff1e41','#fff7b2','#7cd8fb','#594567','#d2ffa7','#ffe7ce', '#9FE6B8', '#FFDB5C','#ff9f7f','#f0f0f0'],
            legend: {
                orient: 'vertical',
                left: 'left',
                data: asd
               // data:['课题','论文','专利','教材或专著','其他成果']
            },
            series : [
                {
                    name: '科研成果',
                    type: 'pie',
                    radius : '78%',//图的大小
                    center: ['50%', '60%'],//图所在的位置
                    data:a,
//                    data:[
//                        {value:335, name:'课题'},
//                        {value:310, name:'论文'},
//                        {value:234, name:'专利'},
//                        {value:135, name:'教材或专著'},
//                        {value:1548, name:'其他成果'}
//                    ],
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