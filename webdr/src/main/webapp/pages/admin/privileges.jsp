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
					<fmt:message key="label.admin.privileges.title"></fmt:message>
				</h2>
				<hr>
				<form:form method="post"
					action="${pageContext.request.contextPath}/admin/privileges/save"
					commandName="command">
					<table>
						<tr>
							<td>
								<form:errors path="*"/>
							</td>							
						</tr>
						<tr>
							<td><form:label path="active">
									<fmt:message key="label.admin.privileges.active"></fmt:message>
								</form:label></td>
							<td><form:checkbox path="active" /></td>
						</tr>
						<tr>
							<td><form:label path="privilegename">
									<fmt:message key="label.admin.privileges.privilegename"></fmt:message>
								</form:label></td>
							<td><form:input path="privilegename" /></td>
						</tr>
						<tr>
							<td><form:label path="description">
									<fmt:message key="label.admin.privileges.description"></fmt:message>
								</form:label></td>
							<td><form:input path="description" /></td>
						</tr>
						<tr>
							<td colspan="2"><form:input type="hidden" path="idPrivilege" />
								<input type="submit"
								value="<fmt:message key="button.admin.privileges.save"></fmt:message>" />
							</td>
						</tr>
					</table>
				</form:form>
				<h3>
					<fmt:message key="label.admin.privileges.table.title"></fmt:message>
				</h3>

				<display:table name="list" id="item" class="gridView"
					requestURI="/admin/privileges" excludedParams="*">
					<display:column titleKey="label.admin.privileges.table.header.active">
						<c:choose>
							<c:when test="${item.active}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</display:column>
					<display:column titleKey="label.admin.privileges.table.header.privilegename" property="privilegename" />
					<display:column titleKey="label.admin.privileges.table.header.description" property="description" />
					<display:column>
						<a href="${pageContext.request.contextPath}/admin/privileges/edit/${item.idPrivilege}"><fmt:message key="button.admin.privileges.table.button.edit"></fmt:message></a>
						<a href="${pageContext.request.contextPath}/admin/privileges/delete/${item.idPrivilege}"><fmt:message key="button.admin.privileges.table.button.delete"></fmt:message></a>						
					</display:column>
				</display:table>
			</div>

		</div>
		<div class="clear"></div>


	</tiles:putAttribute>
</tiles:insertDefinition>