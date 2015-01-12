<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="util" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.nav.authorities.list"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.authorities.listSystem"/>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th><i18n:message code="admin.authorities.id"/></th>
                    <th><i18n:message code="admin.authorities.name"/></th>
                    <th><i18n:message code="admin.authorities.description"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${authorities}" var="authority">
                    <tr>
                        <td>${authority.id}</td>
                        <td>${authority.name}</td>
                        <td>${authority.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
