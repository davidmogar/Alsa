<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="hero" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#hero" data-slide-to="0" class="active"></li>
        <li data-target="#hero" data-slide-to="1"></li>
        <li data-target="#hero" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">
        <div class="item active">
            <img src="<c:url value='/resources/img/hug.png'/>"/>
        </div>

        <div class="item">
            <img src="<c:url value='/resources/img/berlin.png'/>"/>
        </div>

        <div class="item">
            <img src="<c:url value='/resources/img/solar_panel.png'/>"/>
        </div>
    </div>
</div>

<div id="news" class="container">
    <h3><i18n:message code="site.home.news"/></h3>

    <c:forEach items="${news}" var="news">
        <div class="news-item">
            <h4>${news.title}</h4>
            <span>${news.publicationDate}</span>

            <p>${news.text}</p>
        </div>
    </c:forEach>
</div>

<div id="about-us">
    <div class="container">
        <p><i18n:message code="site.home.tour"/></p>
        <a class="btn btn-default" href="#"><i18n:message code="site.home.startTour"/></a>
    </div>
</div>