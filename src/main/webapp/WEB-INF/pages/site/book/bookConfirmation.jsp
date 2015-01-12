<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="book">
    <div class="container">
        <div class="row">
            <div id="controls" class="col-sm-offset-4 col-sm-4">
                <h2><i18n:message code="site.confirmation.price" arguments="${totalPrice}"/></h2>
                <p><i18n:message code="site.confirmation.message" /></p>
            </div>
        </div>
    </div>
</div>

<div id="bookConfirmation" class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading"><i18n:message code="site.confirmation.oneway" /></div>
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <dt><i18n:message code="site.confirmation.origin" /></dt>
                        <dd>${reservation.oneWayScheduleDto.route.origin.name}</dd>
                        <dt><i18n:message code="site.confirmation.destination" /></dt>
                        <dd>${reservation.oneWayScheduleDto.route.destination.name}</dd>
                        <dt><i18n:message code="site.confirmation.departure" /></dt>
                        <dd>${reservation.oneWayScheduleDto.date}</dd>
                        <dt><i18n:message code="site.confirmation.busType" /></dt>
                        <dd>${reservation.oneWayScheduleDto.bus.type}</dd>
                        <dt><i18n:message code="site.confirmation.seats" /></dt>
                        <dd>${reservation.oneWaySeats}</dd>
                    </dl>
                </div>
            </div>
        </div>

        <c:if test="${not empty reservation.returnScheduleDto}">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading"><i18n:message code="site.confirmation.return" /></div>
                    <div class="panel-body">
                        <dl class="dl-horizontal">
                            <dt><i18n:message code="site.confirmation.origin" /></dt>
                            <dd>${reservation.returnScheduleDto.route.origin.name}</dd>
                            <dt><i18n:message code="site.confirmation.destination" /></dt>
                            <dd>${reservation.returnScheduleDto.route.destination.name}</dd>
                            <dt><i18n:message code="site.confirmation.departure" /></dt>
                            <dd>${reservation.returnScheduleDto.date}</dd>
                            <dt><i18n:message code="site.confirmation.busType" /></dt>
                            <dd>${reservation.returnScheduleDto.bus.type}</dd>
                            <dt><i18n:message code="site.confirmation.seats" /></dt>
                            <dd>${reservation.returnSeats}</dd>
                        </dl>
                    </div>
                </div>
            </div>
        </c:if>

        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading"><i18n:message code="site.confirmation.purchase" /></div>
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <dt><i18n:message code="site.confirmation.oneWaySeats" arguments="${oneWaySeats}"/></dt>
                        <dd>${oneWaySeatsPrice}€ (${oneWaySeats} x ${reservation.oneWayScheduleDto.price})</dd>
                        <c:if test="${not empty reservation.returnScheduleDto}">
                            <dt><i18n:message code="site.confirmation.returnSeats" arguments="${returnSeats}"/></dt>
                            <dd>${returnSeatsPrice}€ (${returnSeats} x ${reservation.returnScheduleDto.price})</dd>
                        </c:if>
                    </dl>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading"><i18n:message code="site.confirmation.services" /></div>
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <dt><i18n:message code="site.confirmation.administrative" /></dt>
                        <dd>2.6€</dd>
                        <c:if test="${reservation.travelingWithBike}">
                            <dt><i18n:message code="site.confirmation.travelingBike" /></dt>
                            <dd>10€</dd>
                        </c:if>
                        <c:if test="${reservation.travelingWithPet}">
                            <dt><i18n:message code="site.confirmation.travelingPet" /></dt>
                            <dd>+50% <i18n:message code="site.confirmation.finalPrice" /></dd>
                        </c:if>
                        <c:if test="${reservation.insuranceRequested}">
                            <dt><i18n:message code="site.confirmation.insurance" /></dt>
                            <dd>1€</dd>
                        </c:if>
                    </dl>
                </div>
            </div>
        </div>
    </div>

    <div id="confirmButtons" class="row">
        <a href="${pageContext.request.contextPath}/journey" class="btn btn-default"><i18n:message code="site.confirmation.cancel" /></a>
        <a href="${pageContext.request.contextPath}/journey/book/confirm" class="btn btn-primary"><i18n:message
                code="site.confirmation.confirm" />
            reservation</a>
    </div>
</div>