<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="page-header">
    <h3>List places</h3>
</div>

<div id="page-content">
    <div class="panel">
        <div class="panel-heading">
            List of places in the system
        </div>

        <div class="panel-content">
            <table class="u-full-width">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
                    <th>Image</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${places}" var="place">
                    <tr>
                        <td>${place.name}</td>
                        <td>${place.latitude}</td>
                        <td>${place.longitude}</td>
                        <td><a href="<c:url value='${place.imagePath}' />">View image</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
