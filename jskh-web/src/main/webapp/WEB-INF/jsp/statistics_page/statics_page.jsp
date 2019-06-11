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
	        <link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">
	        <link rel="stylesheet" href="${path}/static/dtree/dtree/font/dtreefont.css">
	        <link rel="stylesheet" href="${path}/static/dtree/dtree/dtree.css">
	        <!--[if lt IE 9]>
	          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	        <![endif]-->
	</head>
    <body class="layui-anim layui-anim-up" style="position:absolute; height:400px; overflow:auto">
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
            
            
            <ul id="demoTree1" class="dtree" data-id="0"></ul>
            <iframe src="/toPage?page=iframeContent" id="iframe_content" name="iframe_content" frameborder="0" style="width:60%; height: 99%; position:absolute; top:0px;right: 10%;"></iframe>
            
            

                <!-- <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">专业发展时间轴</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                             <div id="main1" class="layui-col-sm12" style="height: 300px;"></div>
							<ul class="layui-timeline">
							  <li class="layui-timeline-item" id="Timeline">
							 	 时间轴主体，index1.js生成代码
							  </li>
							</ul>
                        </div>
                    </div>
                </div> -->
                
                
                
                
                
                
                <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">科研成果</div>
                        <div class="layui-card-body" style="min-height:780px;">
                            <div id="main5" class="layui-col-sm12" style="height: 500px;"></div>
									<!-- index2.js -->
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">文件类型</div>
                        <div class="layui-card-body" style="min-height: 780px;">
                            <div id="main3" class="layui-col-sm12" style="height: 500px;"></div>
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
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/logo1.png"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/logo2.png"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/logo3.png"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/logo4.png"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/logo5.png"></div>
							    <div><img style=" width:100%; height:100%;" src="/static/public/images/logo1.png"></div>
							    <div><img  style=" width:100%; height:100%;" src="/static/public/images/bg.png"></div>
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
        <script src="${path}/static/dtree/dtree/dtree.js" type="text/javascript" charset="utf-8"></script>
        <script src="${path}/static/public/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    
        <script type="text/javascript">
        var datas=[];
		var dataDATE="";
    	var url = "";
    	var param = "";
    	var counts = "";
    	var  rows = "";
    	var names='';
    	var positions ='';
    	var characteristics = '';
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
            				}else{
    	       					param += ","+rows[i].setupDate.split(' ')[0];
            				}
            				ajax_profile(rows[i].id,rows[i].setupDate.split(' ')[0],rows[i].name,i);//去拿该专业里的各种数据
            				//console.log(rows[i]);
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
    	
    	
        layui.config({
        	  base: '../static/dtree/dtree/' //配置 layui 第三方扩展组件存放的基础目录
        	}).extend({
        	  dtree: 'dtree' //定义该组件模块名
        	}).use(['element','layer', 'dtree'], function(){
        		var layer = layui.layer,
        		    dtree = layui.dtree,
        		    $ = layui.$;
        		//分割数组
        		var dateList = dataDATE.split(',');
        		var nameList = names.split(',');
        		var positionList = positions.split(',');
        		var characteristicList = characteristics.split(',');
        			//alert(characteristicList);
        			
        		dtree.render({
        		  elem: "#demoTree1",  //绑定元素
        		  data: datas,//异步接口
        		  useIframe: true,////启用iframe
        		  nodeIconArray:{"3":{"open":"dtree-icon-pulldown","close":"dtree-icon-pullup"}},  // 自定扩展的二级非最后一级图标，从1开始
        		  leafIconArray:{"11":"dtree-icon-star"},  // 自定义扩展的二级最后一级图标，从11开始
        		  icon: ["3","11"],// 使用
        		  iframe: {
        			    iframeElem: "#iframe_content",  // iframe的ID
        			    iframeUrl: "/toPage?page=iframeContent", // iframe路由到的地址
        			    iframeLoad: "all",// 表示点击任意节点加载iframe
        			    iframeRequest: {date: dateList,name:nameList,position:positionList,characteristic:characteristicList}//自定义参数
        			  }
        		
        		});
        		
        	        //单击节点 监听事件
        	        dtree.on("node('demoTree1')" ,function(param){
        		  layer.msg(JSON.stringify(param));
        		 
        		});
        	        
        	});

 		function ajax_profile(ids,date,name,i) {
     	// 获取下拉列表(公共方法)
     	$.ajax({
     		url :'specialtyProfile/ByIdSpecialtyProfile',
     		type : "POST",
     		dataType : "json",
     		data:{specialty_id:ids},
     		async:false,
     		success : function(data) {
     			var obj2 = eval(data); //使用eval方法
     			//console.log(JSON.stringify(obj2.data[0].characteristic));
     			//dataDATE += date;
     			if (dataDATE == '') {
     				dataDATE = date;
     				names = obj2.data[0].specialtyName;//获取返回数据的专业名称
     				positions = obj2.data[0].position;
     				characteristics = obj2.data[0].characteristic;
				}else{
					dataDATE+=','+date;
					names += ','+obj2.data[0].specialtyName;
					positions +=','+obj2.data[0].position;
					characteristics +=','+obj2.data[0].characteristic;
				}
     			
     				
     				  datas[i]  =  {
     		    		"id":"00"+i+1,
     		    		"title":obj2.data[0].specialtyName,
     		    		"isLast": false,
     		    		"level": "1",
     		    		"parentId":i+1
     		    	};
     		      
     				
     				
     		},
     		error : function(code) {
     			layer.alert("发生错误,请联系管理员");
     		}
     	});
 		}
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