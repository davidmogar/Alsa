<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="i18n" %>

<footer>
    <div id="footer-content" class="container">
        <div class="row">
            <div class="col-md-4">
                <h3><i18n:message code="site.footer.aboutUs" /></h3>

                <p><i18n:message code="site.footer.aboutUsText" /></p>
            </div>

            <div class="col-md-4">
                <h3><i18n:message code="site.footer.links" /></h3>

                <ul>
                    <li><a href="${pageContext.request.contextPath}/admin"><i18n:message code="site.footer.admin" /></a></li>
                    <li><a href="#"><i18n:message code="site.footer.policy" /></a></li>
                    <li><a href="#"><i18n:message code="site.footer.terms" /></a></li>
                    <li><a href="#"><i18n:message code="site.footer.jobs" /></a></li>
                    <li><a href="#"><i18n:message code="site.footer.map" /></a></li>
                    <li><a href="#"><i18n:message code="site.footer.advertising" /></a></li>
                </ul>
            </div>

            <div class="col-md-4">
                <h3><i18n:message code="site.footer.contact" /></h3>

                <ul>
                    <li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> <i18n:message code="alsa.phone"
                            /></li>
                    <li><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                        <a href="#"><i18n:message code="site.footer.help" /></a></li>
                    <li><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> <i18n:message
                            code="alsa.address" />
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div id="copyright">
        <div class="container">
            <p><i18n:message code="site.footer.copyright" /></p>
        </div>
    </div>
</footer>