<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jquery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet"> --%>
<title>EkartFrontModule</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
</head>
<%@ include file="header.jsp" %>
<body>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
<!-- Indicators -->
<ol class="carousel-indicators">
	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	<li data-target="#myCarousel" data-slide-to="1" class="active"></li>
	<li data-target="#myCarousel" data-slide-to="2" class="active"></li>
	</ol>
<!-- Wrapper for slides -->
<div class="carousel-inner">
<div class="item-active">
<img src="resources/download.jpg" alt="Los Angeles" style="width:100%">
</div>

<div class="item">
<img src="resources/download11.jpg" alt="Chicago" style="width:100%">
</div>

<div class="item">
<img src="resources/download12.jpg" alt="NewYork" style="width:100%">
</div>
<!-- Left and right controls -->

<a class="left carousel-control" href="#myCarousel" data-slide="prev">
	<span class="glyphicon glyphicon-chevron-left"></span>
	<span class="sr-only"></span>
</a>

<a class="right carousel-control" href="#mycarousel" data-slide="next">
	<span class="glyphicon glyphicon-chevron-right"></span>
	<span class="sr-only"></span>
</a>
</div>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>