<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.places.list"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.places.listSystem"/>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th><i18n:message code="admin.places.name"/></th>
                    <th><i18n:message code="admin.places.latitude"/></th>
                    <th><i18n:message code="admin.places.longitude"/></th>
                    <th><i18n:message code="admin.places.image"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${places}" var="place">
                    <tr>
                        <td>${place.name}</td>
                        <td>${place.latitude}</td>
                        <td>${place.longitude}</td>
                        <td><a href="<c:url value='${place.imagePath}' />"><i18n:message code="admin.places.viewImage"/></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
