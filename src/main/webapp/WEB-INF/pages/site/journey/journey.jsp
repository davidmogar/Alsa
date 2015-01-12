<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="i18n" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div class="journey">
    <div class="container">
        <spring:form commandName="journeyData" action="${pageContext.request.contextPath}/journey/search">
            <h3><i18n:message code="site.journey.title"/></h3>

            <div class="form-group">
                <i18n:message code="site.journey.origin.ph" var="originPlaceholder"/>
                <spring:label path="origin"><i18n:message code="site.journey.origin"/></spring:label>
                <spring:input id="origin" path="origin" Type="text" class="form-control"
                              placeholder="${originPlaceholder}"
                              required="true" autofocus="true"/>
                <spring:errors path="origin" cssClass="validation-error"/>
            </div>

            <div class="form-group">
                <i18n:message code="site.journey.destination.ph" var="destinationPlaceholder"/>
                <spring:label path="destination"><i18n:message code="site.journey.destination"/></spring:label>
                <spring:input id="destination" path="destination" Type="text" class="form-control"
                              placeholder="${destinationPlaceholder}"
                              required="true"/>
                <spring:errors path="destination" cssClass="validation-error"/>
            </div>

            <div class="form-group text-center">
                <label class="radio-inline">
                    <spring:radiobutton path="journeyType" name="journeyType" id="oneWayRadio"
                                  value="ONE_WAY"
                           checked="true"/>
                    <i18n:message code="site.journey.oneWayTicket"/>
                </label>
                <label class="radio-inline">
                    <spring:radiobutton path="journeyType" name="journeyType" id="returnRadio"
                                  value="RETURN"/>
                    <i18n:message
                            code="site.journey.returnTicket"/>
                </label>
                <spring:errors path="journeyType" cssClass="validation-error"/>
            </div>

            <div class="row">
                <div class="col-xs-6">
                    <div class="form-group">
                        <spring:label path="departureDate"><i18n:message code="site.journey.departure"/></spring:label>
                        <spring:input path="departureDate" Type="text" class="datepicker form-control"
                                      required="true"/>
                        <spring:errors path="departureDate" cssClass="validation-error"/>
                    </div>
                </div>

                <div class="col-xs-6">
                    <div class="form-group">
                        <spring:label path="returnDate"><i18n:message code="site.journey.return"/></spring:label>
                        <spring:input id="returnDate" path="returnDate" Type="text" class="datepicker form-control"
                                      disabled="true"/>
                        <spring:errors path="returnDate" cssClass="validation-error"/>
                    </div>
                </div>
            </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit"><i18n:message
                    code="site.journey.plan"/></button>
        </spring:form>
    </div>
</div>

<div id="popular" class="container">
    <h3>Popular destinations</h3>

    <div class="row">
        <c:forEach items="${popularPlaces}" var="place" varStatus="status">
            <div class="col-sm-4 col-md-4">
                <div class="thumbnail">
                    <img src="<c:url value='${place.imagePath}' />">
                    <div class="caption">
                        <h4>${place.name}</h4>
                        <p>${place.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>