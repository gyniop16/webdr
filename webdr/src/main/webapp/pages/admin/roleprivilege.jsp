<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="right_section">
			<div class="common_content">
				<h2>
					<fmt:message key="label.admin.roleprivilege.title"></fmt:message>
				</h2>
				<hr>
				<form:form method="post"
					action="${pageContext.request.contextPath}/admin/rolesprivileges/save"
					commandName="command">
				<table>
						<tr>
							<td>
								<form:errors path="*"/>
							</td>							
						</tr>
					<thead>
						<tr>
							<th></th>
							<c:set var="privilegeList" value=""></c:set> 
							<c:forEach items="${ roles }" var="role">
								<th><c:out value="${ role.rolename }"></c:out></th>
								<c:forEach items="${ role.privileges }" var="itmPriv">
								 	<c:set var="privilegeList" value="${ privilegeList }|${ role.idRole }_${itmPriv.idPrivilege}|"></c:set>  
								</c:forEach>
							</c:forEach>
							<c:out value="${ privilegeList }"></c:out>
						</tr>
					</thead>


					<c:forEach items="${ privileges }" var="privilege">
						<tr>
							<th><c:out value="${ privilege.privilegename }"></c:out></th>
							<c:forEach items="${ roles }" var="role">
							    <c:set var="privilegeItem" value="|${role.idRole}_${privilege.idPrivilege}|"></c:set>
								<td>
									<input type="checkbox" name="roleprivilege" value="${role.idRole}_${privilege.idPrivilege}" 
									<c:if test="${fn:contains( privilegeList, privilegeItem) }">checked="checked"</c:if>>
								</td>
							</c:forEach>
						</tr>
					</c:forEach>
						<tr>
							<td>
								<input type="submit"
								value="<fmt:message key="button.admin.rolesprivileges.save"></fmt:message>" />
							</td>
						</tr>
				</table>
				</form:form>
			</div>

		</div>
		<div class="clear"></div>


	</tiles:putAttribute>
</tiles:insertDefinition>