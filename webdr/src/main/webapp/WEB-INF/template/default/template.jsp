<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>.:: WEBDR ::.</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="Alejandro Mejía">
<link rel="StyleSheet" href="<c:url value="/resources/css/style.css" />" type="text/css">
<link rel="StyleSheet" href="<c:url value="/resources/css/jquery.dataTables.css" />" type="text/css">
<link rel="StyleSheet" href="<c:url value="/resources/css/jquery-ui.css" />" type="text/css">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js" />"></script>

<tiles:insertAttribute name="head" />

</head>
<body>
	<header id="header">
		<tiles:insertAttribute name="header" />
		<div id='cssmenu'>
			<tiles:insertAttribute name="menu" />
		</div>
	</header>
	
	<div id="container">

		<div id="center" class="column">
			<tiles:insertAttribute name="body" />								
		</div>

		<nav id="left" class="column">
			<div id="cssmenuver">
				<tiles:insertAttribute name="submenu" />
			</div>
		</nav>	
	</div>
	
	<div id="footer-wrapper">
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
</html>