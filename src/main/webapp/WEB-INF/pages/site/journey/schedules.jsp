<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="schedules" class="container">
    <c:if test="${not empty oneWayRoute}">
        <div id="route" class="row">
            <div class="col-xs-6 place">
                <h2>${oneWayRoute.origin.name}</h2>

                <div class="progress">
                    <div class="progress-bar"></div>
                </div>
                <span class="dot"></span>
            </div>

            <div class="col-xs-6 place">
                <h2>${oneWayRoute.destination.name}</h2>

                <div class="progress">
                    <div class="progress-bar"></div>
                </div>
                <span class="dot"></span>
            </div>
        </div>
    </c:if>

    <c:choose>
        <c:when test="${empty oneWaySchedules}">
            <div class="panel panel-default">
                <div class="panel-body">
                    <p><i18n:message code="site.schedules.noschedules"/></p>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <table id="oneWaySchedulesTable"
                   class="table table-bordered table-striped table-responsive tablesorter schedules">
                <thead>
                <tr>
                    <th><i18n:message code="site.schedules.origin"/></th>
                    <th><i18n:message code="site.schedules.destination"/></th>
                    <th class="sortable"><i18n:message code="site.schedules.departure"/></th>
                    <th class="sortable"><i18n:message code="site.schedules.hours"/></th>
                    <th class="sortable"><i18n:message code="site.schedules.service"/></th>
                    <th class="sortable"><i18n:message code="site.schedules.price"/></th>
                    <th><i18n:message code="site.schedules.book"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${oneWaySchedules}" var="schedule" varStatus="status">
                    <c:set var="now" value="${schedule.date}"/>
                    <tr>
                        <td>${schedule.route.origin.name}</td>
                        <td>${schedule.route.destination.name}</td>
                        <td><fmt:formatDate type="both" value="${now}"/></td>
                        <td>${schedule.hours}</td>
                        <td>${fn:toLowerCase(schedule.bus.type)}</td>
                        <td>${schedule.price}</td>
                        <td><input type="radio" name="oneWaySchedule" checked="${status.first}"
                                   value="${schedule.id}"></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:if test="${not empty returnSchedules}">
                <c:if test="${not empty returnRoute}">
                    <div id="route" class="row">
                        <div class="col-xs-6 place">
                            <h2>${returnRoute.origin.name}</h2>

                            <div class="progress">
                                <div class="progress-bar"></div>
                            </div>
                            <span class="dot"></span>
                        </div>

                        <div class="col-xs-6 place">
                            <h2>${returnRoute.destination.name}</h2>

                            <div class="progress">
                                <div class="progress-bar"></div>
                            </div>
                            <span class="dot"></span>
                        </div>
                    </div>
                </c:if>

                <table id="returnSchedulesTable"
                       class="table table-bordered table-striped table-responsive tablesorter schedules">
                    <thead>
                    <tr>
                        <th><i18n:message code="site.schedules.origin"/></th>
                        <th><i18n:message code="site.schedules.destination"/></th>
                        <th class="sortable"><i18n:message code="site.schedules.departure"/></th>
                        <th class="sortable"><i18n:message code="site.schedules.hours"/></th>
                        <th class="sortable"><i18n:message code="site.schedules.service"/></th>
                        <th class="sortable"><i18n:message code="site.schedules.price"/></th>
                        <th><i18n:message code="site.schedules.book"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${returnSchedules}" var="schedule" varStatus="status">
                        <c:set var="now" value="${schedule.date}"/>
                        <tr>
                            <td>${schedule.route.origin.name}</td>
                            <td>${schedule.route.destination.name}</td>
                            <td><fmt:formatDate type="both" value="${now}"/></td>
                            <td>${schedule.hours}</td>
                            <td>${fn:toLowerCase(schedule.bus.type)}</td>
                            <td>${schedule.price}</td>
                            <td><input type="radio" name="returnSchedule" checked="${status.first}"
                                       value="${schedule.id}"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <button type="button" id="scheduleSelectionButton" class="btn btn-primary center-block"><i18n:message
                    code="site.schedules.continue"/></button>
        </c:otherwise>
    </c:choose>
</div>