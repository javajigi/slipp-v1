<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Sustainable Life, Programming, Programmer</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/css/default.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js"></script>
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
${head}
</head>
<body>
<!-- start header -->
<div id="header">
	<div class="top">
	<#if isUserLoggedIn>
		${user.email}&nbsp;&nbsp;<a href="/signon/logout">로그아웃</a>
	<#else>
		<a href="/signon/login">로그인</a>
	</#if>	
	</div>
	<div id="logo">
		<h1><a href="/">SLiPP<sup></sup></a></h1>
		<h2>지속가능한 삶, 프로그래밍, 프로그래머(sustainable life, programming, programmer)</h2>
	</div>
	<!--
	<div id="menu">
		<ul>
			<li class="active"><a href="#">homepage</a></li>
			<li><a href="#">photo gallery</a></li>
			<li><a href="#">about us</a></li>
			<li><a href="#">links</a></li>
			<li><a href="#">contact us</a></li>
		</ul>
	</div>
	-->
</div>
<!-- end header -->

${body}

<!-- start footer -->
<div id="footer">
	<p id="legal">Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
</div>
<!-- end footer -->
</body>
</html>
