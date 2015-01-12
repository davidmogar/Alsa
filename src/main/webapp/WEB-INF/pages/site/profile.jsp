<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="profile">
    <div class="container">
        <div class="row">
            <div id="controls" class="col-sm-offset-4 col-sm-4">
                <h2><i18n:message code="site.users.profile.hello" arguments="${firstName}"/></h2>

                <p><i18n:message code="site.users.profile.message"/></p>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <c:choose>
        <c:when test="${empty reservations}">
            <div class="panel panel-default">
                <div class="panel-body">
                    <i18n:message code="site.user.profile.noReservations"/>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <table id="returnSchedulesTable"
                   class="table table-bordered table-striped table-responsive">
                <thead>
                <tr>
                    <th><i18n:message code="site.users.profile.reservation.origin"/></th>
                    <th><i18n:message code="site.users.profile.reservation.destination"/></th>
                    <th><i18n:message code="site.users.profile.reservation.type"/></th>
                    <th><i18n:message code="site.users.profile.reservation.price"/></th>
                    <th><i18n:message code="site.users.profile.reservation.code"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${reservations}" var="reservation">
                    <tr>
                        <td>${reservation.oneWayScheduleDto.route.origin.name}</td>
                        <td>${reservation.oneWayScheduleDto.route.destination.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${not empty reservation.returnScheduleDto.route.destination.name}">
                                    <i18n:message code="site.users.profile.reservation.return"/>
                                </c:when>
                                <c:otherwise>
                                    <i18n:message code="site.users.profile.reservation.oneWay"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${reservation.totalPrice}€</td>
                        <td>${reservation.code}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>