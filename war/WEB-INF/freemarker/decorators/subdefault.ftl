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
<!-- start page -->
<div id="page">
	${body}

	<!-- start sidebar -->
	<div id="sidebar">
		<ul>		
			<li id="about">
				<h2><b class="text1">SLiPP이 추구하는 가치와 방향</b></h2>
				SLiPP은 많은 부분을 미리 결정하지 않는다. SLiPP은 최소한의 기능만을 제공한다.
				SLiPP은 사용자가 원하는 기능에 대한 의견을 받고, 각각의 의견 중에서 사용자에게 가장 큰 가치를 줄 것이라 판단되는 기능을 우선적으로 개발한다.
				<br/><br/>
				SLiPP이 이 같은 방향을 가지는 이유는 사용자와 더불어 성장하는 서비스가 되기를 바라기 때문이다.
				같이 만들고, 성장할 때의 즐거움을 느껴보기 위함이다.   
				<br/><br/>
				SLiPP은 의견을 제시하는 단계에서 머무르지 않고, 적극적으로 개발에 참여할 수 있다.
				자신이 만들고 싶은 기능이 있지만 서버 설정이나 기타 부가적인 이유 때문에 도전하지 못한다면 이 공간을 통해서 도전할 수 있다.				
			</li>
		</ul>
	</div>	
	<!-- end sidebar -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->

<!-- start footer -->
<div id="footer">
	<p id="legal">Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
</div>
<!-- end footer -->
</body>
</html>
