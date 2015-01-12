<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="util" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.users.list"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.users.listSystem"/>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th><i18n:message code="admin.users.username"/></th>
                    <th><i18n:message code="admin.users.password"/></th>
                    <th><i18n:message code="admin.users.authority"/></th>
                    <th><i18n:message code="admin.users.enabled"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.content}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.authority}</td>
                        <td>${user.enabled}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
