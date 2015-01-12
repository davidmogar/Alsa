<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="book">
    <div class="container">
        <div class="row">
            <div id="controls" class="col-sm-offset-4 col-sm-4">
                <h2><i18n:message code="site.book.data"/></h2>

                <p><i18n:message code="site.book.dataMessage"/></p>
            </div>
        </div>
    </div>
</div>

<div id="book-form" class="container">
    <spring:form commandName="reservation" action="${pageContext.request.contextPath}/journey/book/process"
                 cssClass="form-horizontal">
        <div class="row">
            <div class="col-md-6">
                <fieldset>
                    <legend><i18n:message code="site.book.traveler"/></legend>

                    <div class="form-group">
                        <i18n:message code="site.book.firstName.ph" var="firstNamePlaceholder"/>
                        <spring:label path="firstName"
                                      cssClass="col-md-3 control-label"><i18n:message
                                code="site.book.firstName"/></spring:label>
                        <div class="col-md-9">
                            <spring:input path="firstName" class="form-control" type="text"
                                          placeholder="${firstNamePlaceholder}"
                                          required="true"/>
                            <spring:errors path="firstName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <i18n:message code="site.book.lastName.ph" var="lastNamePlaceholder"/>
                        <spring:label path="lastName"
                                      cssClass="col-md-3 control-label"><i18n:message
                                code="site.book.lastName"/></spring:label>
                        <div class="col-md-9">
                            <spring:input path="lastName" class="form-control" type="text"
                                          placeholder="${lastNamePlaceholder}"
                                          required="true"/>
                            <spring:errors path="lastName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <i18n:message code="site.book.identification.ph" var="identificationPlaceholder"/>
                        <spring:label path="identification" cssClass="col-md-3 control-label"><i18n:message
                                code="site.book.identification"/>
                        </spring:label>
                        <div class="col-md-4">
                            <spring:input path="identification" class="form-control" type="text"
                                          placeholder="${identificationPlaceholder}"
                                          required="true"/>
                            <spring:errors path="identification" cssClass="validation-error"/>
                        </div>

                        <spring:label path="identificationType" cssClass="col-md-2 control-label"><i18n:message
                                code="site.book.type"/>
                        </spring:label>
                        <div class="col-md-3">
                            <spring:select path="identificationType" cssClass="form-control"
                                           items="${identificationTypes}"/>
                            <spring:errors path="identificationType" cssClass="validation-error"/>
                        </div>
                    </div>
                </fieldset>

                <fieldset>
                    <legend><i18n:message code="site.book.payment"/></legend>

                    <div class="form-group">
                        <i18n:message code="site.book.cardHolder.ph" var="cardHolderPlaceholder"/>
                        <spring:label path="cardHoldersName" cssClass="col-md-3 control-label"><i18n:message
                                code="site.book.cardHolder"
                                /></spring:label>
                        <div class="col-md-9">
                            <spring:input path="cardHoldersName" class="form-control" identificationType="text"
                                          placeholder="${cardHolderPlaceholder}"
                                          required="true"/>
                            <spring:errors path="cardHoldersName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <i18n:message code="site.book.cardNumber.ph" var="cardNumberPlaceholder"/>
                        <spring:label path="cardNumber"
                                      cssClass="col-md-3 control-label"><i18n:message
                                code="site.book.cardNumber"/></spring:label>
                        <div class="col-md-9">
                            <spring:input path="cardNumber" class="form-control" identificationType="text"
                                          placeholder="${cardNumberPlaceholder}"
                                          required="true"/>
                            <spring:errors path="cardNumber" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <spring:label path="cardExpirationMonth" cssClass="col-md-3 control-label"><i18n:message
                                code="site.book.expiration"/></spring:label>

                        <div class="col-md-6">
                            <spring:select path="cardExpirationMonth" class="form-control">
                                <spring:option value="1"><i18n:message code="month.january"/></spring:option>
                                <spring:option value="2"><i18n:message code="month.february"/></spring:option>
                                <spring:option value="3"><i18n:message code="month.march"/></spring:option>
                                <spring:option value="4"><i18n:message code="month.april"/></spring:option>
                                <spring:option value="5"><i18n:message code="month.may"/></spring:option>
                                <spring:option value="6"><i18n:message code="month.june"/></spring:option>
                                <spring:option value="7"><i18n:message code="month.july"/></spring:option>
                                <spring:option value="8"><i18n:message code="month.august"/></spring:option>
                                <spring:option value="9"><i18n:message code="month.september"/></spring:option>
                                <spring:option value="10"><i18n:message code="month.october"/></spring:option>
                                <spring:option value="11"><i18n:message code="month.november"/></spring:option>
                                <spring:option value="12"><i18n:message code="month.december"/></spring:option>
                            </spring:select>
                            <spring:errors path="cardExpirationMonth" cssClass="validation-error"/>
                        </div>

                        <div class="col-md-3">
                            <spring:input path="cardExpirationYear" class="form-control" identificationType="number"
                                          min="2015"
                                          max="2050" value="2015"
                                          required="true"/>
                            <spring:errors path="cardExpirationYear" cssClass="validation-error"/>
                        </div>
                    </div>
                </fieldset>

                <fieldset>
                    <legend><i18n:message code="site.book.services"/></legend>
                    <div class="form-group">
                        <spring:checkbox path="travelingWithBike" value="bike"/> <i18n:message
                            code="site.book.travelingBike"/>
                    </div>

                    <div class="form-group">
                        <spring:checkbox path="travelingWithPet" value="pet"/> <i18n:message
                            code="site.book.travelingPet"/>
                    </div>

                    <div class="form-group">
                        <spring:checkbox path="insuranceRequested" value="insurance"/> <i18n:message
                            code="site.book.insurance"/>
                    </div>
                </fieldset>
            </div>

            <div class="col-md-6">
                <div class="row">
                    <div class="col-sm-6">
                        <legend><i18n:message code="site.book.oneWaySeats"/></legend>
                        <div id="seat-map-one-way">
                            <div class="front-indicator"><i18n:message code="site.book.front"/></div>
                        </div>
                    </div>

                    <c:if test="${not empty returnSchedule}">
                        <div class="col-sm-6">
                            <legend><i18n:message code="site.book.returnSeats"/></legend>
                            <div id="seat-map-return">
                                <div class="front-indicator">Front</div>
                            </div>
                        </div>
                    </c:if>

                    <div class="col-sm-6">
                        <div class="booking-details">
                            <div id="legend"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <spring:input path="oneWaySeats" id="oneWaySeats" type="hidden"/>
        <spring:input path="returnSeats" id="returnSeats" type="hidden"/>

        <button type="submit" class="btn btn-primary center-block"><i18n:message code="site.book.book"/></button>
    </spring:form>
</div>

<div id="seatErrorModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"><i18n:message code="site.book.modal.title"/></h4>
            </div>
            <div class="modal-body">
                <div class="alert alert-danger" role="alert"><i18n:message code="site.book.modal.errorMessage"/></div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        <c:if test="${not empty oneWaySchedule}">
        initializeOneWaySeatMap(${oneWaySchedule.bus.type == "SUPRA"}, "${oneWaySeats}");
        </c:if>

        <c:if test="${not empty returnSchedule}">
        initializeReturnSeatMap(${oneWaySchedule.bus.type == "SUPRA"}, "${returnSeats}");
        </c:if>
    });
</script>