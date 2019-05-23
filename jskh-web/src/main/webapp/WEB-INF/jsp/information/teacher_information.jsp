<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>教师数据简介</title>
<link rel="stylesheet" href="/static/public/css/xadmin.css">

</head>
		<body class="layui-layout-body layui-anim layui-anim-scaleSpring" style="position:absolute; height:400px; overflow:auto">
		<div>
      		<a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        	<i class="layui-icon" style="line-height:30px">ဂ</i></a>
    	</div>
    	<div class="layui-form-item" style="margin: 7px 0px 48px 37%;font-size:36px">
		 	教师:<a  id="name" style="color:red;"></a>
		</div>
		<div class="layui-col-sm12 layui-col-md6 layui-content-white">
			<div class="layui-row" style="width: 600px;height:500px;">
			<form class="layui-form" action="" style="margin: 20px 128px 0px 0px;">
				  <fieldset class="layui-elem-field">
				  <legend>教师数据</legend>
				  <div class="layui-field-box">
					  <div class="layui-form-item" style="margin-left:18%;margin-top:2%">
						<!-- <div class="layui-inline">
							<label class="layui-form-label">教师姓名</label>
							<div class="layui-input-inline">
								<input name="name" id="name1" disabled autocomplete="off" class="layui-input">
							</div>
						</div> -->
						<div class="layui-inline">
							<label class="layui-form-label">教师编号</label>
							<div class="layui-input-inline">
								<input name="code" id="code1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">入职时间</label>
							<div class="layui-input-inline">
								<input name="entryTime" id="entryTime1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
					
						<div class="layui-inline">
							<label class="layui-form-label">出生时间</label>
							<div class="layui-input-inline">
								<input name="birthday" id="birthday1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">毕业院校</label>
							<div class="layui-input-inline">
								<input name="graduateSchool" id="graduateSchool1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">学历学位</label>
							<div class="layui-input-inline"  >
								<input name="finalDegree" id="finalDegree1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">政治面貌</label>
							<div class="layui-input-inline">
								<input name="politicalStatus"  id="politicalStatus1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
						<!-- <div class="layui-inline">
							<label class="layui-form-label">专业编码</label>
							<div class="layui-input-inline">
								<input name="specialtyCode"  id="specialtyCode" disabled autocomplete="off" class="layui-input">
							</div>
						</div> -->
						<div class="layui-inline">
							<label class="layui-form-label">研究方向</label>
							<div class="layui-input-inline">
								<input name="researchDirection"  id="researchDirection1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">是否兼职</label>
							<div class="layui-input-inline">
								<input name="isPartTime"  id="isPartTime1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label" style="width:160px;margin: 0px 0px 0px -80px;">是否为团队负责人</label>
							<div class="layui-input-inline">
								<input name="director"  id="director1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<label class="layui-form-label">专业</label>
							<div class="layui-input-inline">
								<input name="specialtyName"  id="specialtyName1" disabled autocomplete="off" class="layui-input">
							</div>
						</div>
					</div>
				</div>
			</fieldset>
			</form>
			</div>
		</div>
		<div  class="layui-col-sm12 layui-col-md6 layui-content-white">
		<div class="layui-row">
			<form class="layui-form" action="" style="margin: 20px 128px 0px 0px;">
				<fieldset class="layui-elem-field">
				  <legend>教师数据分析</legend>
				  <div class="layui-field-box">
					 <div id="main" style="width: 600px;height:500px;"></div>
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
		var TeacherName = '';
		
		getUser();
		
		function getUser() {//获取用户名
			$.ajax({
				type : "POST", // 提交方式
				url : window.path + "/home/getUser",// 路径
				data : {},// 数据，这里使用的是Json格式进行传输
				dataType : "json",
				success : function(result) {// 返回数据根据结果进行相应的处理
					if (result.code == "0" && result.data.user != null) {
						$("#name").html(result.data.user.teaName);
						TeacherName = result.data.user.teaName;
						getTeaches(TeacherName);
					} else {
						layer.msg(result.msg);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					layer.msg("系统错误");
				}
			});
		}
		
	  function getTeaches(TeacherName) {//获取教师数据
			$.ajax({
				url:'/teachers/getTeachers',
				type:"POST",
				data:{name:TeacherName},
				dataType:"json",
				success:function(data){
					//console.log(JSON.stringify(data));
					var obj2 = eval(data); //使用eval方法
					//console.log(obj2);
					//$("#name1").val(obj2.data[0].name);
					$("#code1").val(obj2.data[0].code);
					$("#entryTime1").val((obj2.data[0].entryTime.split(' '))[0]);
					$("#birthday1").val((obj2.data[0].birthday.split(' '))[0]);
					$("#graduateSchool1").val(obj2.data[0].graduateSchool);
					$("#finalDegree1").val(obj2.data[0].finalDegree);
					$("#politicalStatus1").val(obj2.data[0].politicalStatus);
					$("#specialtyName1").val(obj2.data[0].specialtyName);
					$("#researchDirection1").val(obj2.data[0].researchDirection);
					$("#isPartTime1").val(obj2.data[0].isPartTime==2?'是':'否');
					$("#director1").val(obj2.data[0].director==1?'是':'否');
				}
			});
	  }
		
		/**
		图表js
		*/
		// Schema:
		// date,AQIindex,PM2.5,PM10,CO,NO2,SO2
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        option = {
        	    title: {
        	        text: ''
        	    },
        	    tooltip: {},
        	    legend: {
        	        data: ['教师技能', '平均技能']
        	    },
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
        	           { name: '论文', max: 6500},
        	           { name: '课题', max: 16000},
        	           { name: '专利', max: 30000},
        	           { name: '其他成果', max: 38000},
        	           { name: '专业建设成果', max: 52000},
        	           { name: '指导老师', max: 25000}
        	        ]
        	    },
        	    series: [{
        	        name: '预算 vs 开销（Budget vs spending）',
        	        type: 'radar',
        	        radius : '60%',//图的大小
                    center: ['80%', '70%'],//图所在的位置
        	        // areaStyle: {normal: {}},
        	        data : [
        	            {
        	                 value : [4300, 10000, 28000, 35000, 50000, 19000],
        	        	                name : '教师技能'
        	            },
        	             {
        	                value : [2500, 7000, 14000, 31000, 42000, 21000],
        	                name : '平均技能'
        	            }
        	        ]
        	    }]
        	};
		 // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
		</script>
	</body>
</html>