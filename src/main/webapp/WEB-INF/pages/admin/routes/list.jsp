<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="page-header">
    <h3>List routes</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            List of routes in the system
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Distance</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${routes}" var="route">
                    <tr>
                        <td>${route.name}</td>
                        <td>${route.origin}</td>
                        <td>${route.destination}</td>
                        <td>${route.distance}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
