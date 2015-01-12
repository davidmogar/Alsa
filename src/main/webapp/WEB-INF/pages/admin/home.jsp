<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.dashboard"/></h3>
</div>


<div id="page-content">
    <div class="row">
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-default panel-dashboard blue">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"/>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h4>${activeUsers}</h4>

                            <p><i18n:message code="admin.dashboard.active"/></p>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/admin/users/list"><i18n:message code="admin.dashboard.allUsers"/></a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="panel panel-default panel-dashboard green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <span class="glyphicon glyphicon-map-marker" aria-hidden="true"/>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h4>${places}</h4>

                            <p><i18n:message code="admin.dashboard.places"/></p>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/admin/places/list"><i18n:message code="admin.dashboard.allPlaces"/></a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="panel panel-default panel-dashboard orange">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <span class="glyphicon glyphicon-road" aria-hidden="true"/>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h4>${routes}</h4>

                            <p><i18n:message code="admin.dashboard.routes"/></p>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/admin/routes/list"><i18n:message
                            code="admin.dashboard.allRoutes"/></a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="panel panel-default panel-dashboard red">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <span class="glyphicon glyphicon-time" aria-hidden="true"/>
                        </div>
                        <div class="col-xs-9 text-right">
                            <h4>${schedules}</h4>

                            <p><i18n:message code="admin.dashboard.schedules"/></p>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/admin/schedules/list"><i18n:message
                            code="admin.dashboard.allSchedules"/></a>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-body">
            <p><i18n:message code="admin.dashboard.sessions" arguments="${sessions}"/></p>
        </div>
    </div>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.dashboard.recent"/>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th><i18n:message code="admin.dashboard.recent.date"/></th>
                    <th><i18n:message code="admin.dashboard.recent.change"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${changes}" var="change">
                    <tr>
                        <td>${change.date}</td>
                        <td>${change.text}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>