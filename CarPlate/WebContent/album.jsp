<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.iver99.util.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>相册首页</title>
<link href="./css/style3.css" rel="stylesheet" type="text/css"
	media="all" />
<!--<link href='http://fonts.googleapis.com/css?family=Rambla' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Fauna+One' rel='stylesheet' type='text/css'>-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="./js/jquery.min1.js"></script>
<!----click-top---->
<script type="text/javascript" src="./js/move-top.js"></script>
<script type="text/javascript" src="./js/easing.js"></script>
<!----//click-top---->

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1200);
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<!---header--->
		<div class="header">
			<div class="logo">
				<a href="index.html"><img src="./images/logo1.png" alt="" /></a>
			</div>
			<div class="nav">
				<ul>
					<li class="active"><a href="album.jsp">网站首页</a></li>
					<li><a href="#aboutme" class="scroll">关于我们</a></li>
					<li><a href="#works" class="scroll">产品专区</a></li>
					<li><a href="version.html" class="scroll">版本更新</a></li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<!---banner--->
		<div class="banner" id="aboutme">
			<img src="./images/quote.png" alt="" />
			<p>欢迎光临——专业停车场系统设备服务企业。荣誉出品——车牌识别系统，智能停车场系统，车位诱导系统等。</p>
		</div>
		<img src="./images/line.png" alt="" />
		<!---content--->
		<%
			Connection conn=null;
			//ArrayList al=new ArrayList();
			conn=DBConnect.getConnection();
			String[] list=new String[12];
			Statement stmt=conn.createStatement();
			String sql="select * from license_plate_info limit 12";
			ResultSet rs=stmt.executeQuery(sql);
			int i=0;
			while(rs.next())
			{
				String picName=rs.getString(2);
				
				list[i]=picName;
				i++;
			}
			System.out.println("testing...."+list[0]);
			DBConnect.closeConnection(conn, stmt, rs);
		%>
		<div class="content" id="works">
			<div class="gallery">
				<h2><a href="uploadPicture.jsp">上传图片请点击</a></h2>
				<div class="section group">
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[0] %>"><img src="../uploadPic/<%=list[0] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[1] %>"><img src="../uploadPic/<%=list[1] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[2] %>"><img src="../uploadPic/<%=list[2] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[3] %>"><img src="../uploadPic/<%=list[3] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
				</div>
				<div class="section group">
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[4] %>"><img src="../uploadPic/<%=list[4] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[5] %>"><img src="../uploadPic/<%=list[5] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[6] %>"><img src="../uploadPic/<%=list[6] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[7] %>"><img src="../../uploadPic/<%=list[7] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
				</div>
				<div class="section group">
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[8] %>"><img src="../../uploadPic/<%=list[8] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[9] %>"><img src="../../uploadPic/<%=list[9] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[10] %>"><img src="../../uploadPic/<%=list[10] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
					<div class="grid_1_of_4 images_1_of_4">
						<a href="albumShowPicture.jsp?picName=<%=list[11] %>"><img src="../../uploadPic/<%=list[11] %>"></a>
						<br/><img src="/images/deleteButton.png"/>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>

</body>
</html>