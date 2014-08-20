<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="right_section">
			<div class="common_content">
				<h2>
					<fmt:message key="label.admin.users.title"></fmt:message>
				</h2>
				<hr>
				<form:form method="post"
					action="${pageContext.request.contextPath}/admin/users/save"
					commandName="command">
					<table>
						<tr>
							<td>
								<form:errors path="*"/>
							</td>							
						</tr>
						<tr>
							<td><form:label path="active">
									<fmt:message key="label.admin.users.active"></fmt:message>
								</form:label></td>
							<td><form:checkbox path="active" /></td>
						</tr>
						<tr>
							<td><form:label path="username">
									<fmt:message key="label.admin.users.username"></fmt:message>
								</form:label></td>
							<td><form:input path="username" /></td>
						</tr>
						<tr>
							<td><form:label path="password">
									<fmt:message key="label.admin.users.password"></fmt:message>
								</form:label></td>
							<td><form:password path="password" showPassword="true"/></td>
						</tr>
						<tr>
							<td><form:label path="password2">
									<fmt:message key="label.admin.users.password2"></fmt:message>
								</form:label></td>
							<td><form:password path="password2" showPassword="true"/></td>
						</tr>						
						<tr>
							<td><form:label path="roles">
									<fmt:message key="label.admin.users.roles"></fmt:message>
								</form:label></td>
							<td>
								<c:forEach items="${command.roles}" var="ur">
            						<c:set var="urList" value="${urList} |${ur.idRole}|"/>
            					</c:forEach>
								<c:forEach items="${roleList }" var="role">
									<c:set var="roleId" value="|${role.idRole}|"/>
									<input type="checkbox" name="roles" value="${ role.idRole }" <c:if test="${ fn:containsIgnoreCase(urList, roleId) }">checked</c:if>><c:out value="${ role.rolename }"></c:out>  							
									
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td colspan="2"><form:input type="hidden" path="idUser" />
								<input type="submit"
								value="<fmt:message key="button.admin.users.save"></fmt:message>" />
							</td>
						</tr>
					</table>
				</form:form>
				<h3>
					<fmt:message key="label.admin.users.table.title"></fmt:message>
				</h3>

				<display:table name="list" id="item" class="gridView"
					requestURI="/admin/users" excludedParams="*">
					<display:column titleKey="label.admin.users.table.header.active">
						<c:choose>
							<c:when test="${item.active}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</display:column>
					<display:column titleKey="label.admin.users.table.header.username" property="username" />
					<display:column titleKey="label.admin.users.table.header.roles">
						<c:forEach items="${item.roles }" var="role">
							<c:out value="${role.rolename }"></c:out> <br />							
						</c:forEach>
					</display:column>
					<display:column>
						<a href="${pageContext.request.contextPath}/admin/users/edit/${item.idUser}"><fmt:message key="button.admin.users.table.button.edit"></fmt:message></a>
						<a href="${pageContext.request.contextPath}/admin/users/delete/${item.idUser}"><fmt:message key="button.admin.users.table.button.delete"></fmt:message></a>						
					</display:column>
				</display:table>
			</div>

		</div>
		<div class="clear"></div>


	</tiles:putAttribute>
</tiles:insertDefinition>