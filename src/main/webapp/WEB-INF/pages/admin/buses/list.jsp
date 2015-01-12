<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.buses.list"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.buses.listSystem"/>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th><i18n:message code="admin.buses.license"/></th>
                    <th><i18n:message code="admin.buses.type"/></th>
                    <th><i18n:message code="admin.buses.lastRevision"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${buses}" var="bus">
                    <tr>
                        <td>${bus.licensePlate}</td>
                        <td>${bus.type}</td>
                        <td><fmt:formatDate value="${bus.lastRevision}" pattern="MM/dd/yyyy"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
