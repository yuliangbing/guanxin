<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%-- <%@ include file="/WEB-INF/Taglib.jsp"%> --%>
<%@ include file="/WEB-INF/Common.jsp"%>
<!DOCTYPE html>
<html class="x-admin-sm">
	</head>
	        <meta charset="UTF-8">
	        <title>首页面</title>
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
    <body class="layui-anim layui-anim-up" style="position:absolute; height:400px; overflow:auto">
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">

                <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">专业发展时间轴</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                            <!--  <div id="main1" class="layui-col-sm12" style="height: 300px;"></div> -->
							<ul class="layui-timeline">
							  <li class="layui-timeline-item" id="Timeline">
							 	 <!-- 时间轴主体，index1.js生成代码 -->
							  </li>
							</ul>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">科研成果</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                            <div id="main5" class="layui-col-sm12" style="height: 300px;"></div>
									<!-- index2.js -->
                        </div>
                    </div>
                </div>
             <!--    <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">最新一周PV/UV量</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                            <div id="main2" class="layui-col-sm12" style="height: 300px;"></div>

                        </div>
                    </div>
                </div> -->
                <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">文件类型</div>
                        <div class="layui-card-body" style="min-height: 70%;">
                            <div id="main3" class="layui-col-sm12" style="height: 55%;"></div>
								<!-- index.js -->
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                      <!--   <div class="layui-card-header">校企合作</div> -->
                        <div class="layui-card-body" style="min-height: 280px;margin:0 auto ;">
                           <!--  <div id="main4" class="layui-col-sm12" style="height: 300px;"></div> -->

							<!-- 轮播校企合作 -->
							
							<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
							  <legend>校企合作</legend>
							</fieldset>    
							 
							<div class="layui-carousel" id="test10">
							  <div carousel-item="">
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/1.jpg"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/2.jpg"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/3.jpg"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/5.jpg"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/6.jpeg"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/7.jpeg"></div>
							    <div><img  style=" width:100%; height:100%;" src="/static/public/images/8.jpeg"></div>
							  </div>
							</div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    
        <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
        <script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="${path}/static/js/index/index1.js" type="text/javascript" charset="utf-8"></script>
        <script src="${path}/static/js/index/index2.js" type="text/javascript" charset="utf-8"></script>
        <script src="${path}/static/js/index/index.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
        
      
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main2'));

        // 指定图表的配置项和数据
        var option = {
            tooltip : {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#6a7985'
                    }
                }
            },
            grid: {
                top: '5%',
                right: '2%',
                left: '1%',
                bottom: '10%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'PV',
                    type:'line',
                    areaStyle: {normal: {}},
                    data:[120, 132, 101, 134, 90, 230, 210],
                    smooth: true
                },
                {
                    name:'UV',
                    type:'line',
                    areaStyle: {normal: {}},
                    data:[45, 182, 191, 234, 290, 330, 310],
                    smooth: true,

                }
            ]
        };


        // 使用刚指定的配置项和数据显示图表。
       // myChart.setOption(option);


       /*  // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main3'));

        // 指定图表的配置项和数据
        var option = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
            },
            series : [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        {value:335, name:'直接访问'},
                        {value:310, name:'邮件营销'},
                        {value:234, name:'联盟广告'},
                        {value:135, name:'视频广告'},
                        {value:1548, name:'搜索引擎'}
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
 */


        // 使用刚指定的配置项和数据显示图表。
    /*     myChart.setOption(option); */

      /*    // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main4'));

        // 指定图表的配置项和数据
        var option = {
            tooltip : {
                formatter: "{a} <br/>{b} : {c}%"
            },
            series: [
                {
                    name: '硬盘使用量',
                    type: 'gauge',
                    detail: {formatter:'{value}%'},
                    data: [{value: 88, name: '已使用'}]
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option); */
    </script>
    <script>
      /*   var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })(); */
        
        layui.use(['carousel', 'form'], function(){//轮播图
        	  var carousel = layui.carousel
        	  ,form = layui.form;
        	  
        	  //图片轮播
        	  carousel.render({
        	    elem: '#test10'
        	    ,width: '90%'
        	    ,height: '80%'
        	    ,interval: 5000
        	  });
        	  
        	 /*  //事件
        	  carousel.on('change(test4)', function(res){
        	    console.log(res)
        	  }); */
        	/*   
        	  var $ = layui.$, active = {
        	    set: function(othis){
        	      var THIS = 'layui-bg-normal'
        	      ,key = othis.data('key')
        	      ,options = {};
        	      
        	      othis.css('background-color', '#5FB878').siblings().removeAttr('style'); 
        	      options[key] = othis.data('value');
        	      ins3.reload(options);
        	    }
        	  }; */
        	  
        	/*   //监听开关
        	  form.on('switch(autoplay)', function(){
        	    ins3.reload({
        	      autoplay: this.checked
        	    });
        	  }); */
        	  
        	   $('.demoSet').on('keyup', function(){
        	    var value = this.value
        	    ,options = {};
        	    if(!/^\d+$/.test(value)) return;
        	    
        	    options[this.name] = value;
        	    ins3.reload(options);
        	  }); 
        	  
        	 /*  //其它示例
        	  $('.demoTest .layui-btn').on('click', function(){
        	    var othis = $(this), type = othis.data('type');
        	    active[type] ? active[type].call(this, othis) : '';
        	  }); */
        	});
        </script>
    </body>
</html>