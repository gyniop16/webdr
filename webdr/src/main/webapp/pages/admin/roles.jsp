<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="right_section">
			<div class="common_content">
				<h2>
					<fmt:message key="label.admin.roles.title"></fmt:message>
				</h2>
				<hr>
				<form:form method="post"
					action="${pageContext.request.contextPath}/admin/roles/save"
					commandName="command">
					<table>
						<tr>
							<td>
								<form:errors path="*"/>
							</td>							
						</tr>
						<tr>
							<td><form:label path="active">
									<fmt:message key="label.admin.roles.active"></fmt:message>
								</form:label></td>
							<td><form:checkbox path="active" /></td>
						</tr>
						<tr>
							<td><form:label path="rolename">
									<fmt:message key="label.admin.roles.rolename"></fmt:message>
								</form:label></td>
							<td><form:input path="rolename" /></td>
						</tr>
						<tr>
							<td><form:label path="description">
									<fmt:message key="label.admin.roles.description"></fmt:message>
								</form:label></td>
							<td><form:input path="description" /></td>
						</tr>
						<tr>
							<td colspan="2"><form:input type="hidden" path="idRole" />
								<input type="submit"
								value="<fmt:message key="button.admin.roles.save"></fmt:message>" />
							</td>
						</tr>
					</table>
				</form:form>
				<h3>
					<fmt:message key="label.admin.roles.table.title"></fmt:message>
				</h3>

				<display:table name="list" id="item" class="gridView"
					requestURI="/admin/roles" excludedParams="*">
					<display:column titleKey="label.admin.roles.table.header.active">
						<c:choose>
							<c:when test="${item.active}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</display:column>
					<display:column titleKey="label.admin.roles.table.header.rolename" property="rolename" />
					<display:column titleKey="label.admin.roles.table.header.description" property="description" />
					<display:column>
						<a href="${pageContext.request.contextPath}/admin/roles/edit/${item.idRole}"><fmt:message key="button.admin.roles.table.button.edit"></fmt:message></a>
						<a href="${pageContext.request.contextPath}/admin/roles/delete/${item.idRole}"><fmt:message key="button.admin.roles.table.button.delete"></fmt:message></a>						
					</display:column>
				</display:table>
			</div>

		</div>
		<div class="clear"></div>


	</tiles:putAttribute>
</tiles:insertDefinition>