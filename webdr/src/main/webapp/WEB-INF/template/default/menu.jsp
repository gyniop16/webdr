<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="navigation">
	<ul>
		<li><a href="${pageContext.request.contextPath}/admin/users">Users</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/roles">Roles</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/privileges">Privileges</a></li>		
	</ul>
</div>

<div class="left_side_bar">

	<div class="col_1">
		<h1>Main Menu</h1>
		<div class="box">
			<ul>
				<li><spring:url value="/home" var="homeUrl" htmlEscape="true" />
					<a href="${homeUrl}">Home</a></li>
				<li><spring:url value="/about" var="aboutUrl" htmlEscape="true" />
					<a href="${aboutUrl}">About</a></li>
			</ul>
		</div>
	</div>

	<div class="col_1">
		<h1>Block</h1>
		<div class="box">
			<p>Enter Block content here...</p>
			<br>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
				Aenean commodo Lorem ipsum dolor sit amet, consectetuer adipiscing
				elit. Aenean commodo</p>
		</div>
	</div>

</div>

