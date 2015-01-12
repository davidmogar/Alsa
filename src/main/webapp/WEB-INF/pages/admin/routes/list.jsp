<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.routes.list"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.routes.listSystem"/>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th><i18n:message code="admin.routes.name"/></th>
                    <th><i18n:message code="admin.routes.origin"/></th>
                    <th><i18n:message code="admin.routes.destination"/></th>
                    <th><i18n:message code="admin.routes.distance"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${routes}" var="route">
                    <tr>
                        <td>${route.name}</td>
                        <td>${route.origin.name}</td>
                        <td>${route.destination.name}</td>
                        <td>${route.distance}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
