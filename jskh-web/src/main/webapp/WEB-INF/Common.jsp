<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${path}/static/public/css/global.css" media="all" />
<link rel="stylesheet" href="${path}/static/public/lib/layui/css/layui.css">

<script type="text/javascript" src="${path}/static/public/jquery/jquery-1.10.2.min.js"></script>
<script src="${path}/static/public/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${path}/static/js/xadmin.js"></script>
<script type="text/javascript">
	window.onbeforeunload = function(event) {
		ws.onclose = function() {
		};
		ws.close();
	}
</script>