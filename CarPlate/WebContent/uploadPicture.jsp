<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/fonts.css" rel="stylesheet" type="text/css" media="all" />

</head>
<body>
<div id="wrapper">
	<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><a href="#">汽车牌照识别系统</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#" accesskey="1" title="">网站首页</a></li>
				<li><a href="#" accesskey="2" title="">我们的客户</a></li>
				<li><a href="#" accesskey="3" title="">产品专区</a></li>
				<li><a href="#" accesskey="4" title="">技术支持</a></li>
				<li><a href="version.html" accesskey="5" title="">版本更新</a></li>
			</ul>
		</div>
	</div>
	</div>
	<div id="banner">
		<div class="container">
			<div class="title">
				<h2>请选择要上传的图片</h2>
				<span class="byline">汽车牌照识别系统</span> </div>
		
			<form name="uploadForm" action="uploadPicture.do" 
			method="post" enctype="multipart/form-data">
			<label for="upload">上传图片:</label> 
			<input type="file" name="upload" >
			<br> <br> 
			<img src="images/uploadButton.jpg"
				 onclick="javascript:document.forms['uploadForm'].submit()";>
		</form>
		<script language="javascript">
		
		if(request.params['message']=="请选择文件!")
			alert("请选择上传文件")
		/* 未完成 */
		</script>
		
		</div>
	</div>
	
	</div>
	</body>
	</html>
