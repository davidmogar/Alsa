<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="util" %>

<div id="page-header">
    <h3>List authorities</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            List of authorities in the system
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${authorities}" var="authority">
                    <tr>
                        <td>${authority.id}</td>
                        <td>${authority.name}</td>
                        <td>${authority.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
