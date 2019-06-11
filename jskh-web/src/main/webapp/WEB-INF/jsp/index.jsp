<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<!doctype html>
<html>
<head >
	<!-- <title>浙江邮电职业技术学院管信分院</title> -->
	
<link rel="icon" href="${path}/static/public/images/wuyecao.png" type="image/x-icon" />
	<title>专业发展平台</title>
	
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
	
    <link rel="stylesheet" href="/static/public/css/font.css">
	<link rel="stylesheet" href="/static/public/css/xadmin.css">
</head>
<body onload="f1()">
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="#" id="systemName"></a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item"><a>更换主题</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="green()">绿色渐变</a></dd>
              <dd><a onclick="ash()">灰色渐变</a></dd>
              <dd><a onclick="blue()">蓝色渐变</a></dd>
              <dd><a onclick="brown()">棕色渐变</a></dd>
              <dd><a onclick="defau()">默认主体</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item">
            <a href="javascript:;" id="username"></a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
              <dd><a onclick="logout()">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a href="/">前台首页</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav" style="height: 100%;">
      <div id="side-nav">
        <ul id="nav"></ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content" style="z-index: 0;height: 100%">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>首页</li><!-- <i class="layui-icon">&#xe68e;</i>首页</li> -->
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src="/toPage?page=statistics_page/statics_page" frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
	    <!-- 中部底部开始 -->
	    <div class="footer">
	      <!--   <div class="copyright">Copyright ©2017 x-admin v2.3 All Rights Reserved</div>   -->
	        <div class="copyright" id="box" title="点击隐藏"  style="text-align: center;z-index: -1" onclick="remove();">五叶草小组出品</div>  
	    </div>
	    <!-- 中部底部结束 -->
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    
    <script src="${path}/static/js/index.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    var storage=window.localStorage;//获取localStorage对象
    
    function f1() {//找到持久化上的主题,并加载到head上
 
    	 var json1=storage.getItem("data");
         var jsonObj1=JSON.parse(json1);
         if (jsonObj1 != null) {
        	 var link = document.createElement("link");
         	 link.rel = "stylesheet";
         	 link.type = "text/css";
         	 link.href = jsonObj1.Url;
         	 document.getElementsByTagName("head")[0].appendChild(link);
 		}
     	
	}
    
    var ur;
    function ash(){//灰色主题

        var data={
            Url:'/static/public/css/themeStyle/ash.min.css'
        };
        var d=JSON.stringify(data);
        storage.setItem("data",d);
        //将JSON字符串转换成为JSON对象输出
        var json=storage.getItem("data");
        var jsonObj=JSON.parse(json);
    	var link = document.createElement("link");
    	link.rel = "stylesheet";
    	link.type = "text/css";
    	link.href = jsonObj.Url;
    	document.getElementsByTagName("head")[0].appendChild(link);
    }
    
    function green(){//绿色主题
    	
        var data={
            Url:"/static/public/css/themeStyle/green.min.css"
        };
        var d=JSON.stringify(data);
        storage.setItem("data",d);
        //将JSON字符串转换成为JSON对象输出
        var json=storage.getItem("data");
        var jsonObj=JSON.parse(json);
   	    var link = document.createElement("link");
   	    link.rel = "stylesheet";
   	    link.type = "text/css";
   	    link.href = jsonObj.Url;
   	    document.getElementsByTagName("head")[0].appendChild(link);
   }
    function blue(){//蓝色主题
    	
        var data={
            Url: "/static/public/css/themeStyle/blue.min.css"
        };
        var d=JSON.stringify(data);
        storage.setItem("data",d);
        //将JSON字符串转换成为JSON对象输出
        var json=storage.getItem("data");
        var jsonObj=JSON.parse(json);
      	 var link = document.createElement("link");
      	 link.rel = "stylesheet";
      	 link.type = "text/css";
      	 link.href = jsonObj.Url;
      	 document.getElementsByTagName("head")[0].appendChild(link);
      }
  
    function brown(){//棕色主题
    	
        var data={
            Url: "/static/public/css/themeStyle/brown.min.css"
        };
        var d=JSON.stringify(data);
        storage.setItem("data",d);
        //将JSON字符串转换成为JSON对象输出
        var json=storage.getItem("data");
        var jsonObj=JSON.parse(json);
     	var link = document.createElement("link");
     	link.rel = "stylesheet";
     	link.type = "text/css";
     	link.href = jsonObj.Url;
     	document.getElementsByTagName("head")[0].appendChild(link);
     }

    function defau(){//默认主题
    	localStorage.clear();//清空持久化的主题
    	window.location.reload();
     }
    
    function remove(){
	    var box = document.getElementById("box");  
	    if(box){  
	        box.parentNode.removeChild(box);  
	    }  
	    else{  
	        alert("没有这个div");  
	    }  
    }
            
    </script>
</body>
</html>