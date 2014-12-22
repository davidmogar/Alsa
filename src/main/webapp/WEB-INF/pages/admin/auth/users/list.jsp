<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="util" %>

<div id="page-header">
    <h3>List users</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            List of users in the system
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Passwrod</th>
                    <th>Authority</th>
                    <th>Enabled</th>
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
