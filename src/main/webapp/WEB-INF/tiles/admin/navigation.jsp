<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<tilesx:useAttribute name="current"/>
<nav class="accordion">
    <ul>
        <li>Navigation</li>
        <li><p><span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span><a
                href="${pageContext.request.contextPath}/admin">Dashboard</a></p></li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-lock" aria-hidden="true"></span>Authorities</p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'authorities' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/authorities/create">Create an authority</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/authorities/list">List authorities</a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>Buses</p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'buses' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/buses/create">Create a bus</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/buses/list">List buses</a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>News</p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'news' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/news/create">Create a news</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/news/list">List news</a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-user" aria-hidden="true"></span>Users</p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'users' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/users/create">Create new user</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/users/list">List users</a></li>
            </ul>
        </li>

        <li class="collapsible">
            <p><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>Places</p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'places' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/places/create">Create new place</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/places/list">List places</a></li>
            </ul>
        </li>
        <li><p><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span><a
                href="${pageContext.request.contextPath}/logout">Log out</a></p></li>
    </ul>
</nav>