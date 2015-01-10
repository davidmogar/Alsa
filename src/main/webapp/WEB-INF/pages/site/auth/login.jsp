<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="lock">
    <div class="container">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <form name="login" class="form-signin" role="form" method="post"
              action="${pageContext.request.contextPath}/login">
            <h3 class="form-signin-heading">Please sign in</h3>
            <label for="username" class="sr-only">Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Your username"
                   required="true" autofocus="true"/>

            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Your password"
                   required="true"/>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>

            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
</div>