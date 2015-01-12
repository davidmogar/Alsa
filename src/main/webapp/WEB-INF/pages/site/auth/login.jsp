<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div class="lock">
    <div class="container">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <form name="login" class="form-signin" role="form" method="post"
              action="${pageContext.request.contextPath}/login">
            <h3 class="form-signin-heading"><i18n:message code="site.login.title"/></h3>
            <label for="username" class="sr-only"><i18n:message code="site.login.username"/></label>
            <i18n:message code="site.login.username.ph" var="usernamePlaceholder"/>
            <input type="text" id="username" name="username" class="form-control" placeholder="${usernamePlaceholder}"
                   required="true" autofocus="true"/>

            <label for="password" class="sr-only"><i18n:message code="site.login.password"/></label>
            <i18n:message code="site.login.password.ph" var="passwordPlaceholder"/>
            <input type="password" id="password" name="password" class="form-control" placeholder="${passwordPlaceholder}"
                   required="true"/>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> <i18n:message code="site.login.remember"/>
                </label>
            </div>

            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit"><i18n:message code="site.login.signin"/></button>
        </form>
    </div>
</div>