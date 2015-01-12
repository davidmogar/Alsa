<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="i18n" %>

<tilesx:useAttribute name="active"/>

<header>
    <div id="quick-bar" class="row">
        <div class="container">
            <div class="col-md-4">
                <p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
                    <i18n:message code="alsa.phone" /></p>
            </div>
            <div class="col-md-8">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/users/profile">
                        <i18n:message code="site.header.account"/></a></li>
                    <li><span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        <a href="#"><i18n:message code="site.header.search" /></a></li>
                    <li><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                        <a href="#"><i18n:message code="site.header.help" /></a></li>
                </ul>
            </div>
        </div>
    </div>

    <tiles:insertAttribute name="navigation"/>

</header>