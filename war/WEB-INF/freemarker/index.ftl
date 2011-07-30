<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Sustainable People, Programming, Programmer</title>
</head>
<body>
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="rss">
			<a href="http://feeds.feedburner.com/slipp"><img src="http://feeds.feedburner.com/~fc/slipp?bg=99CCFF&amp;fg=444444&amp;anim=0" height="26" width="88" style="border:0" alt="" /></a>
		</div>
		<h2><b class="text1">개발일지</b></h2><br/>
		<#if isUserAdmin>
		<div class="button">
			<a href="/diaries/form">개발일지 쓰기</a>
		</div>
		</#if>
		<#list diaries as diary>
		<div class="post">
			<h2 class="title"><a href="${diary.url}">${diary.title?if_exists}(${diary.commentCount})</a></h2>
			<p class="date">${diary.createdDate?string("yyyy")}<b>${diary.createdDate?string("MM.dd")}</b></p>
			<div class="entry">
				<p>${diary.displayContents?if_exists}</p>
			</div>
			<#if isUserAdmin>
			<div class="button">
				<a href="${diary.url}/form">수정하기</a>
			</div>
			</#if>			
			<!--
			<div class="meta">
				<p class="links"><a href="#" class="more">Read full article</a></p>
			</div>
			-->
		</div>
		</#list>
	</div>
	<!-- end content -->
	<!-- start sidebar -->
	<div id="sidebar">
		<ul>
			<li>
				<h2><strong>SLiPP에 이런 기능 있었으면...</strong></h2>
				<div class="button">
				    <a href="/ideas">의견 남기기</a>&nbsp;&nbsp;<a href="/ideas">더보기</a>
				</div>
				<ul>
					<#list ideas as idea>
					<li>
						<a href="/ideas/${idea.id?c}">${idea.displayContents}</a><br/>
						${idea.createdDate?string("yyyy-MM-dd HH:mm:ss")}에 ${idea.nickname} 의견
					</li>
					</#list>
				</ul>
			</li>		
			<li id="about">
				<h2><b class="text1">About Here</b></h2>
				이 공간은 삶과 일의 균형을 맞추면서 지속 가능한 삶을 살아갈 것인가에 고민을 담기 위한 곳이다.  
				삶 뿐만 아니라 우리 개발자가 고민하고 있는 프로그래밍과 프로그래머를 어떻게 지속 가능하도록 만들 것인가에 대해서도 고민을 담기 위한 공간이다.
				이와 관련하여 아무리 많은 고민을 하더라도 정해진 정답은 없는 것이 우리네 삶이지만 그래도 그 길을 가기 위한 노력을 멈추지 않기 위한 노력의 일환이다.<br/><br/>

				공간을 시작했지만 어떻게 발전해 갈 것인지 어떤 형태로 만들어 갈 것인지 결정한 부분이 많지 않다.
				이 공간은 누구 한 사람에 의해 만들어 가는 공간이 아니라 같이 만들어가면서 성장하는 것을 목표로 한다.<br/><br/>
			</li>
		</ul>
	</div>	
	<!-- 
	<div id="sidebar">
		<ul>
			<li id="search">
				<h2><b class="text1">Search</b></h2>
				<form method="get" action="">
					<fieldset>
					<input type="text" id="s" name="s" value="" />
					<input type="submit" id="x" value="Search" />
					</fieldset>
				</form>
			</li>
			<li>
				<h2><b>Volutpat</b> Dolore</h2>
				<ul>
					<li><a href="#">Nec metus sed donec</a></li>
					<li><a href="#">Magna lacus bibendum mauris</a></li>
					<li><a href="#">Velit semper nisi molestie</a></li>
					<li><a href="#">Eget tempor eget nonummy</a></li>
					<li><a href="#">Nec metus sed donec</a></li>
					<li><a href="#">Magna lacus bibendum mauris</a></li>
					<li><a href="#">Velit semper nisi molestie</a></li>
				</ul>
			</li>
			<li>
				<h2><b>Volutpat</b> Dolore</h2>
				<ul>
					<li><a href="#">Nec metus sed donec</a></li>
					<li><a href="#">Magna lacus bibendum mauris</a></li>
					<li><a href="#">Velit semper nisi molestie</a></li>
					<li><a href="#">Eget tempor eget nonummy</a></li>
				</ul>
			</li>
		</ul>
	</div>
	-->
	<!-- end sidebar -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
</body>
</html>