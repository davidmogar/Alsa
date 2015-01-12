<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.schedules.list"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.schedules.listSystem"/>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th><i18n:message code="admin.schedules.route"/></th>
                    <th><i18n:message code="admin.schedules.bus"/></th>
                    <th><i18n:message code="admin.schedules.date"/></th>
                    <th><i18n:message code="admin.schedules.hours"/></th>
                    <th><i18n:message code="admin.schedules.price"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${schedules}" var="schedule">
                    <tr>
                        <td>${schedule.route.name}</td>
                        <td>${schedule.bus.licensePlate}</td>
                        <td>${schedule.date}</td>
                        <td>${schedule.hours}</td>
                        <td>${schedule.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
