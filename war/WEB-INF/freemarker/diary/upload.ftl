<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Sustainable People, Programming, Programmer</title>
<link href="/css/default.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
<script type="text/javascript">
<!--
$(document).ready(function()	{
	$("#uploadForm").validate({
		rules: {
			file: "required"
		},
		messages: {
			file: "첨부할 파일을 선택하세요."
		}
	});
});
-->
</script>
</head>
<body>
<form id="uploadForm" action="${uploadUrl}" method="post" enctype="multipart/form-data">
  <input id="file" name="file" type="file"><br/>
  <input type="submit"/>
</form>
</body>
</html>
