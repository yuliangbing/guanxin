<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${path}/static/public/css/global.css" media="all" />
<link rel="stylesheet" href="${path}/static/public/layui/css/layui.css">

<script src="${path}/static/public/jquery/jquery-1.10.2.min.js"></script>
<script src="${path}/static/public/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/static/js/xadmin.js"></script>
<script type="text/javascript">
	//时间格式转化,如时间字段"createTime"转成:"yyyy-MM-dd",createTime.Format(data1)
	var date1 = "yyyy-MM-dd";
	var date2 = "yyyy-MM-dd HH:mm:ss";
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
	window.onbeforeunload = function(event) {
		ws.onclose = function(){
		};
		ws.close();
	}</script>