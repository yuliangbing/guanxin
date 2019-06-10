<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>
<%@ include file="/WEB-INF/Common.jsp"%>
<html>
<head>
<link rel="stylesheet" href="/static/public/layui/css/layui.css">
<link rel="stylesheet" href="/static/public/css/xadmin.css">
</head>
<body>
	<div class="layui-container">
		<div class="layui-row layui-col-space10">
			<div class="layui-fluid">
				<div class="layui-collapse">
					<div class="layui-colla-item">
						<div class="layui-colla-title">专业发展<i class="layui-icon layui-colla-icon"></i></div>
						<div class="layui-colla-content layui-show">
							<div class="layui-form layui-form-panel" lay-filter="show_form">
								<div class="layui-form-item">
									<label class="layui-form-label">时间：</label>
									<div class="layui-input-block">
										<input type="text" id="date" name="date" class="layui-input" disabled="disabled">
									</div>
								</div>
								<!-- <div class="layui-form-item">
									<label class="layui-form-label">parentId：</label>
									<div class="layui-input-block">
										<input type="text" id="parentId" name="parentId" class="layui-input" disabled="disabled">
									</div>
								</div> -->
								<div class="layui-form-item">
									<label class="layui-form-label">专业名称：</label>
									<div class="layui-input-block">
										<input type="text" id="name" name="name" class="layui-input" disabled="disabled">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">专业定位：</label>
									<div class="layui-input-block">
										<textarea id="position" name="position" class="layui-textarea" disabled="disabled"></textarea>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">专业特色：</label>
									<div class="layui-input-block">
										<textarea id="characteristic" name="characteristic" class="layui-textarea" disabled="disabled"></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="${path}/static/public/jquery/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${path}/static/public/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript">
layui.use('form', function(){
	  var form = layui.form;
var getUrlParam = function(name) {
	//alert(name);
	  var url = location.search;
	  url = url.substring(url.indexOf("?"));
	  if (url.indexOf("?") != -1) {
	    var str = url.substr(1);
	    strs = str.split("&");
	    for ( var i = 0; i < strs.length; i++) {
	      if (name == strs[i].split("=")[0]) {
	        return unescape(strs[i].split("=")[1]);
	      }
	    }
	  }
	  return "";
	}
	
	var date = getUrlParam("date"),
		parentId = getUrlParam("parentId"),
		//context = decodeURI(getUrlParam("context")),  // 注意，此处对context做了一次转码
		positions = decodeURI(getUrlParam("position")), //对中文进行转码，不然会出现乱码
		characteristics = decodeURI(getUrlParam("characteristic")),
	    names = decodeURI(getUrlParam("name"));
	//分割数组
		var asd = date.split(','); 
		var nsd = names.split(',');
		var psd = positions.split(',');
		var csd = characteristics.split(',');
		var date2;
		var name2;
		var position2;
		var characteristic2;
	//通过parentId来判断，获取值
		for (var i = 0; i < date.length; i++) {
	    	if ((i+1) == parentId) {
	    		date2 = asd[i];
	    		name2 = nsd[i];
	    		position2 = psd[i];
	    		characteristic2 = csd[i];
			}
			
		}
	    
	// 赋值
	form.val("show_form",{
	  "date" : date2,
	  "name" : name2,
	  "position" : position2,
	  "characteristic" : characteristic2,
	});

	form.render(); //刷新表单
});
</script>


</html>