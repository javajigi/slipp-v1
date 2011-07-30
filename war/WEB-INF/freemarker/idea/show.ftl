<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Sustainable People, Programming, Programmer</title>
<script type="text/javascript" src="/js/jquery.markitup.js"></script>
<script type="text/javascript" src="/js/idea-set.js"></script>
<link rel="stylesheet" type="text/css" href="/css/wiki-style.css" />
<link rel="stylesheet" type="text/css" href="/css/wiki-textile-style.css" />
<style type="text/css">
.markItUpEditor {
	height:70px;
}
</style>
<script type="text/javascript">
<!--
$(document).ready(function()	{
	$('#contents').markItUp(mySettings);
	
	$("#ideasForm").validate({
		rules: {
			contents: "required"
		},
		messages: {
			contents: "내용을 입력하세요."
		}
	});
});
-->
</script>
</head>
<body>
	<!-- start content -->
	<div id="content">
		<div class="idea-post">
		    <h3>${idea.createdDate?string("yyyy-MM-dd HH:mm:ss")}에 ${idea.nickname}님의 의견</h3>
			<div class="entry">
				${idea.displayContents?if_exists}
				연결된 의견수 : ${idea.linkCount}
			</div>
		</div>
		<br/><br/>
		<h2><b class="text1">연결된 의견</b></h2><br/>
		<#list linkedIdeas as linkedIdea>
		<div class="idea-post">
		    <h3>${linkedIdea.createdDate?string("yyyy-MM-dd HH:mm:ss")}에 ${linkedIdea.nickname}님의 의견</h3>
			<div class="entry">
				${linkedIdea.displayContents?if_exists}
			</div>
		</div>
		</#list>
		
		<#if isUserLoggedIn>
		<form id="ideasForm" action="/ideas/${idea.id?c}" method="post">
		<div class="form">
			<textarea id="contents" name="contents" cols="96" rows="3"></textarea>
		</div>
		<div class="button">
			<a href="/ideas">목록으로 가기</a>&nbsp;&nbsp;<input type="submit" value="의견 남기기"/>
		</div>
		</form>
		<#else>
		<a href="/signon/login">로그인</a>하면 의견을 남길 수 있습니다.
		</#if>
	</div>
	<!-- end content -->
</body>
</html>