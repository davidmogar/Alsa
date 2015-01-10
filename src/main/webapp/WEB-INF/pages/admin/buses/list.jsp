<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-header">
    <h3>List buses</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            List of buses in the system
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th>License plate</th>
                    <th>Type</th>
                    <th>Last revision</th>
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
