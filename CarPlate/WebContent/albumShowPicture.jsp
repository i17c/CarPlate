<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Car</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="./css/style1.css" rel="stylesheet" type="text/css" media="all" />
<!-- <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed' rel='stylesheet' type='text/css'> 
<link href='http://fonts.googleapis.com/css?family=Merienda' rel='stylesheet' type='text/css'> -->
</head>
<body>
<div class="header-bg" height="95" width="1349">
<div class="wrap">
<!-- 此处为图片-->
<div class="logo">
	<a href="index.html"><img src="./images/logo.png" alt=""></a>
</div>
<div class="nav">
        <ul>
          <li class="#"><a href="album.jsp">网页首页</a></li>
          <li><a href="#">客户</a></li>
           <li><a href="#">产品专区</a></li>
            <li><a href="#">技术支持</a></li>
           <li><a href="version.html">版本更新</a></li>
        </ul>
       
</div>
	<div class="clear"></div>
</div>
</div>  
	<div class="clear"></div>
<div class="header-bg-btm">
<div class="wrap" style="width:1000px;height:550px">
<div class="header-banner">
		<!--  <img src="./images/banner.png" alt="" >  -->
		<!-- 本地测试图片有问题 -->
		<%  String picName=request.getParameter("picName");System.out.println("picName--"+picName); 
			session.setAttribute("pictureName", picName);
			session.setAttribute("originalPictureName", picName);
		%>
		 <img src="../uploadPic/<%=session.getAttribute("pictureName") %>" alt="" >
		
</div>
<div class="header-para" >
		<div class="nav">
        <ul>
            <form name="form1" id="form1" action="gray.do" method="post">
            <input type="hidden" value="<%=session.getAttribute("pictureName") %>"/>
           <!--  <li><input type="submit" value="灰度化"/></li> -->
           <li><a href="#" onclick="javascript:document.forms['form1'].submit();" >灰度化</a></li>
            </form>
        </ul>
		<ul>
           <form name="form2" id="form2" action="binary.do" method="post">
            <input type="hidden" value="<%=session.getAttribute("pictureName") %>"/>
            <!-- <li><input type="submit" value="二值化"/></li> -->
            <li><a href="#" onclick="javascript:document.forms['form2'].submit();" >二值化</a></li>
            </form>
        </ul>
		<ul>
           <form name="form3" id="form3" action="sobel.do" method="post">
            <input type="hidden" value="<%=session.getAttribute("pictureName") %>"/>
            <!-- <li><input type="submit" value="二值化"/></li> -->
            <li><a href="#" onclick="javascript:document.forms['form3'].submit();" >sobel算法</a></li>
            </form>
        </ul>
		<ul>
           <form name="form4" id="form4" action="originalPic.do" method="post">
            <input type="hidden" value="<%=session.getAttribute("pictureName") %>"/>
            <!-- <li><input type="submit" value="二值化"/></li> -->
            <li><a href="#" onclick="javascript:document.forms['form4'].submit();" >原图</a></li>
       		</form>
        </ul>
		<!-- <ul>
            <li><a href="#">步骤五</a></li>
        </ul> -->
		
		</div>
</div>
	<div class="clear"></div>
</div>
</div>

</body>
</html>