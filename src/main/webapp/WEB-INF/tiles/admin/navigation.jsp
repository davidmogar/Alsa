<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<tilesx:useAttribute name="current"/>
<nav class="accordion">
    <ul>
        <li><i18n:message code="admin.nav.navigation"/></li>
        <li><p><span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span><a
                href="${pageContext.request.contextPath}/admin"><i18n:message code="admin.nav.dashboard"/></a></p></li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-lock" aria-hidden="true"></span><i18n:message
                    code="admin.nav.authorities"/></p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'authorities' ? 'active' : ''}">
                <li><a
                        href="${pageContext.request.contextPath}/admin/authorities/create"><i18n:message
                        code="admin.nav.authorities.create"/></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/authorities/list"><i18n:message
                        code="admin.nav.authorities.list"/></a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span><i18n:message code="admin.nav.buses"/>
            </p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'buses' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/buses/create"><i18n:message
                        code="admin.nav.buses.create"/></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/buses/list"><i18n:message
                        code="admin.nav.buses.list"/></a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span><i18n:message
                    code="admin.nav.news"/></p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'news' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/news/create"><i18n:message
                        code="admin.nav.news.create"/></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/news/list"><i18n:message
                        code="admin.nav.news.list"/></a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span><i18n:message
                    code="admin.nav.places"/></p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'places' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/places/create"><i18n:message
                        code="admin.nav.places.create"/></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/places/list"><i18n:message
                        code="admin.nav.places.list"/></a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span><i18n:message
                    code="admin.nav.routes"/></p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'routes' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/routes/create"><i18n:message
                        code="admin.nav.routes.create"/></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/routes/list"><i18n:message
                        code="admin.nav.routes.list"/></a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span><i18n:message
                    code="admin.nav.schedules"/></p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'schedules' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/schedules/create"><i18n:message
                        code="admin.nav.schedules.create"/></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/schedules/list"><i18n:message
                        code="admin.nav.schedules.list"/></a></li>
            </ul>
        </li>
        <li class="collapsible">
            <p><span class="glyphicon glyphicon-user" aria-hidden="true"></span><i18n:message code="admin.nav.users"/>
            </p>
            <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
            <ul class="${current == 'users' ? 'active' : ''}">
                <li><a href="${pageContext.request.contextPath}/admin/users/create"><i18n:message
                        code="admin.nav.users.create"/></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/users/list"><i18n:message
                        code="admin.nav.users.list"/></a></li>
            </ul>
        </li>
        <li><p><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span><a
                href="${pageContext.request.contextPath}/logout"><i18n:message code="admin.nav.logout"/></a></p></li>
    </ul>
</nav>