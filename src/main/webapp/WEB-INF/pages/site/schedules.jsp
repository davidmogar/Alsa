<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<div class="container">
    <c:if test="${not empty route}">
        <div id="route" class="row">
            <div class="col-xs-6 place">
                <h2>${route.origin.name}</h2>

                <div class="progress">
                    <div class="progress-bar"></div>
                </div>
                <span class="dot"></span>
            </div>

            <div class="col-xs-6 place">
                <h2>${route.destination.name}</h2>

                <div class="progress">
                    <div class="progress-bar"></div>
                </div>
                <span class="dot"></span>
            </div>
        </div>
    </c:if>


    <div id="schedules">
        <c:choose>
            <c:when test="${empty oneWaySchedules}">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <p>No schedules for that route</p>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <h3>One way schedules</h3>
                <table id="oneWaySchedulesTable"
                       class="table table-bordered table-striped table-responsive tablesorter schedules">
                    <thead>
                    <tr>
                        <th>Origin</th>
                        <th>Destination</th>
                        <th class="sortable">Departure</th>
                        <th class="sortable">Hours</th>
                        <th class="sortable">Service</th>
                        <th class="sortable">Price</th>
                        <th>Book</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${oneWaySchedules}" var="schedule" varStatus="status">
                        <c:set var="now" value="${schedule.date}"/>
                        <tr>
                            <td>${schedule.route.origin.name}</td>
                            <td>${schedule.route.destination.name}</td>
                            <td><fmt:formatDate type="both" value="${now}"/></td>
                            <td></td>
                            <td>${fn:toLowerCase(schedule.bus.type)}</td>
                            <td></td>
                            <td><input type="radio" name="oneWaySchedule" checked="${status.first}"
                                       value="${schedule.id}"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <c:if test="${not empty returnSchedules}">
                    <h3>Return schedules</h3>
                    <table id="returnSchedulesTable"
                           class="table table-bordered table-striped table-responsive tablesorter schedules">
                        <thead>
                        <tr>
                            <th>Origin</th>
                            <th>Destination</th>
                            <th class="sortable">Departure</th>
                            <th class="sortable">Hours</th>
                            <th class="sortable">Service</th>
                            <th class="sortable">Price</th>
                            <th>Book</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${returnSchedules}" var="schedule" varStatus="status">
                            <c:set var="now" value="${schedule.date}"/>
                            <tr>
                                <td>${schedule.route.origin.name}</td>
                                <td>${schedule.route.destination.name}</td>
                                <td><fmt:formatDate type="both" value="${now}"/></td>
                                <td></td>
                                <td>${fn:toLowerCase(schedule.bus.type)}</td>
                                <td></td>
                                <td><input type="radio" name="returnSchedule" checked="${status.first}" value="${schedule.id}"></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <button type="button" id="scheduleSelectionButton" class="btn btn-primary center-block">Continue
                </button>
            </c:otherwise>
        </c:choose>
    </div>
</div>