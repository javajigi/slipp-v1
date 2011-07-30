<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Sustainable People, Programming, Programmer</title>
<script type="text/javascript" src="/js/jquery.markitup.js"></script>
<script type="text/javascript" src="/js/diary-set.js"></script>
<link rel="stylesheet" type="text/css" href="/css/wiki-style.css" />
<link rel="stylesheet" type="text/css" href="/css/wiki-textile-style.css" />
<script type="text/javascript">
<!--
$(document).ready(function()	{
	$('#contents').markItUp(mySettings);
	
	$('.add').click(function() {
 		$.markItUp( { 	openWith:'<opening tag>',
						closeWith:'<\/closing tag>',
						placeHolder:"New content"
					}
				);
 		return false;
	});
	
	$('.toggle').click(function() {
		if ($("#markItUp.markItUpEditor").length === 1) {
 			$("#markItUp").markItUpRemove();
			$("span", this).text("get markItUp! back");
		} else {
			$('#markItUp').markItUp(mySettings);
			$("span", this).text("remove markItUp!");
		}
 		return false;
	});
	
	$("#diariesForm").validate({
		rules: {
			title: "required",
			contents: "required"
		},
		messages: {
			title: "제목을 입력하세요.",
			contents: "내용을 입력하세요."
		}
	});
	
	$('#uploadFile').click(function(e) {
		window.open('/diaries/${diary.id?if_exists}/upload/form', 'uploadForm', 'width=500, height=100');
		return false;
	});	
});
-->
</script>
</head>
<body>
<div id="page">
	<div id="content">
		<div class="form">
		<form id="diariesForm" action="/diaries" method="post">
		<input type="hidden" name="id" value="${diary.id?if_exists}"/>
		<#if diary.id?has_content>
		<input type="hidden" name="_method" value="put"/>
		<#else>
		<input type="hidden" name="_method" value="post"/>
		</#if>	
		제목: <input type="text" id="title" name="title" size="90" value="${diary.title?if_exists}"/><br/>
		<textarea id="contents" name="contents" cols="75" rows="20">${diary.contents?if_exists}</textarea>
		글쓴 날짜: <input type="text" id="createdDate" name="createdDate" size="20" value="${diary.createdDate?if_exists}"/>(2011-03-01)&nbsp;&nbsp;
		<input type="text" name="createdHour" size="3" value="${diary.createdHour?if_exists}"/>&nbsp;&nbsp;
		<input type="text" name="createdMinute" size="3" value="${diary.createdMinute?if_exists}"/>
		<br/>
		<div class="button">
			<#if diary.id?has_content>
			<a id="uploadFile" href="">파일 첨부하기</a>&nbsp;&nbsp;
			</#if>
			<input type="submit" value="개발일지 쓰기"/>
		</div>
		</form>
		</div>
		<#list attachFiles as attachFile>
		Blob Key : ${attachFile.blobKey}
		<img src="/show/images/${attachFile.blobKey}"/><br/>
		</#list>
	</div>
</div>
</body>
</html>
