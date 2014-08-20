<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>.:: WEBDR ::.</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="Alejandro Mejía">
<link rel="StyleSheet" href="<c:url value="/resources/css/style.css" />"
	type="text/css">
</head>
<body>
	<div id="wrapper">
		<tiles:insertAttribute name="header" />
		<div id="page_content">
			<tiles:insertAttribute name="menu" />
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />
		</div>
		
	</div>
</body>
</html>