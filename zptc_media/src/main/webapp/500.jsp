<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/Taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>500</title>

<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.js"></script>
 　	<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<![endif]-->

<style type="text/css">
body {
	overflow: hidden;
	background: #2A3F54;
	font-family: "Helvetica Neue", Roboto, Arial, "Droid Sans", sans-serif;
	font-size: 13px;
	font-weight: 400;
	line-height: 1.471;
	height: 100%;
}

*, *:before, *:after {
	box-sizing: border-box
}

.container {
	width: 100%;
	padding: 0;
}

.main_container {
	overflow: hidden;
}

.col-middle {
	margin-top: 5%;
}

.error-number {
	font-size: 90px;
	line-height: 90px;
	margin: 20px 0;
}

h2 {
	font-size: 18px;
	font-weight: 400;
}

h1, .h1, h2, .h2, h3, .h3 {
	margin-top: 10px;
	margin-bottom: 10px
}
</style>
</head>

<body class="nav-md" style="color: #73879C;">
	<div class="container body">
		<div class="main_container">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="col-middle">
					<div class="text-center">
						<h1 class="error-number">500</h1>
						<h2>内部服务器错误，请联系管理员！</h2>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>