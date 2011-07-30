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
	
	$('#commentsForm').validate({
		rules: {
			contents: "required"
		},
		messages: {
			contents: "내용을 입력하세요."
		}
	});
	
	$('#uploadFile').click(function(e) {
		window.open('${diary.url}/upload/form', 'uploadForm', 'width=500, height=100');
		return false;
	});
});
-->
</script>
</head>
<body>
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
			<h2>${diary.title}</h2>
		    <h3>
		    	${diary.createdDate?string("yyyy-MM-dd HH:mm:ss")}에 쓴 글&nbsp;&nbsp;
				<#if isUserAdmin>
				<a href="${diary.url}/form">수정하기</a>&nbsp;&nbsp;<a id="uploadFile" href="#">파일 첨부하기</a>
				</#if>		    
		    </h3>
			<div class="entry">
				${diary.displayContents?if_exists}
				댓글수 : ${diary.commentCount}
			</div>
		</div>
		<br/><br/>
		<div class="link">
			<#list diaries as beforeDiary>
			<a href="${beforeDiary.url}">${beforeDiary.title}</a>&nbsp;&nbsp;${beforeDiary.createdDate?string("yyyy-MM-dd HH:mm:ss")}에 쓴 글<br/>
			</#list>
		</div>
		<br/><br/>
		<h2><b class="text1">댓글</b></h2>
		<#list comments as comment>
		<div class="idea-post">
		    <h3>${comment.createdDate?string("yyyy-MM-dd HH:mm:ss")}에 ${comment.nickname}님의 의견</h3>
			<div class="entry">
				${comment.displayContents?if_exists}
			</div>
		</div>
		</#list>		
		<#if isUserLoggedIn>
		<form id="commentsForm" action="${diary.url}/comments" method="post">
		<div class="form">
			<textarea id="contents" name="contents" cols="96" rows="3"></textarea>
		</div>
		<div class="button">
			<a href="/ideas">목록으로 가기</a>&nbsp;&nbsp;<input type="submit" value="댓글 남기기"/>
		</div>
		</form>
		<#else>
		<a href="/signon/login">로그인</a>하면 댓글을 남길 수 있습니다.
		</#if>
		<br/><br/>
	</div>
	<!-- end content -->
</div>
</body>
</html>