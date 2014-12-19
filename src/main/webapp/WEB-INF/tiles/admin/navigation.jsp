<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<nav class="accordion">
    <ul>
        <li>Navigation</li>
        <li class="collapsible">
            <p>Users</p>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/users/create">Create new user</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/users/list">List users</a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p>News</p>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/news/create">Create a news</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/news/list">List news</a></li>
            </ul>
        </li>
    </ul>
</nav>