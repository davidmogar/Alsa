<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="page-header">
    <h3>Dashboard</h3>
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
                            <h4>${users}</h4>

                            <p>Users</p>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/admin/users/list">View details</a>
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

                            <p>Places</p>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/admin/places/list">View details</a>
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
                            <h4>${users}</h4>

                            <p>Routes</p>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/admin/users/list">View details</a>
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
                            <h4>${places}</h4>

                            <p>Schedules</p>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <a href="${pageContext.request.contextPath}/admin/places/list">View details</a>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-primary">
        <div class="panel-heading">
            Recent changes
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Change</th>
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