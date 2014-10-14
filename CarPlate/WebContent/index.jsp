<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>汽车牌照识别系统</title>
<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'> -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<!-- -->
<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
<script src="/js/jquery.min.js"></script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	
});
</script>
</head>
<body>
<!-- contact-form -->	
<div class="message warning">
<div class="contact-form"">
	<div class="logo">
		<h1>汽车牌照识别系统用户登陆</h1>
	</div>	
<!--- form --->
<form class="form" action="login.do" method="post" name="contact_form">
	<ul>
		<li>
			 <label><img src="images/contact.png" alt=""></label>
			 <input name="username" type="email" class="email" placeholder="info@w3layouts.com" required />		            
		 </li>
		 <li>
			 <label><img src="images/lock.png" alt=""></label>
			 <input type="Password" name="password" placeholder="Password" required />		         
		 </li>
		 <p><a href="#">忘记用户名或密码？</a></p>
		 <li class="style">
		     <input type="Submit" value="登陆">
		 </li>
	</ul>	
	<div class="clear"></div>	   	
</form>
</div>
<div class="alert-close"></div>
</div>
<div class="clear"></div>
<!--- footer --->
<div class="footer">
	
</div>
</body>
</html>