<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="i18n" %>

<nav class="row">
    <div class="container">
        <div class="col-md-4">
            <h1><a href="${pageContext.request.contextPath}/"><i18n:message code="alsa.title" /></a></h1>

            <h2><i18n:message code="alsa.slogan" /></h2>
        </div>
        <div class="col-md-8">
            <ul>
                <li><a href="${pageContext.request.contextPath}/journey">
                    <i18n:message code="site.nav.journey" /></a></li>
                <li><a href="${pageContext.request.contextPath}/tickets">
                    <i18n:message code="site.nav.tickets" /></a></li>
                <li><a href="#"><i18n:message code="site.nav.popular" /></a></li>
                <li><a href="#"><i18n:message code="site.nav.aboutUs" /></a></li>
                <li><a href="?locale=en">en</a> | <a href="?locale=es">es</a></li>
            </ul>
        </div>
    </div>
</nav>
