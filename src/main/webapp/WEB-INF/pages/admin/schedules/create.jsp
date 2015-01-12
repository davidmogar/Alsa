<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.schedules.create"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.schedules.form"/>
        </div>

        <div class="panel-body">
            <spring:form commandName="schedule" action="save" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label
                                    path="routeName"><i18n:message code="admin.schedules.route"/></spring:label>
                            <i18n:message code="admin.schedules.route.ph" var="routePlaceholder"/>
                            <spring:input id="route" path="routeName" class="form-control" Type="text"
                                          placeholder="${routePlaceholder}"
                                          required="true"/>
                            <spring:errors path="routeName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="busLicense"><i18n:message code="admin.schedules.bus"/></spring:label>
                            <i18n:message code="admin.schedules.bus.ph" var="busPlaceholder"/>
                            <spring:input id="bus" path="busLicense" class="form-control" Type="text"
                                          placeholder="${busPlaceholder}"
                                          required="true"/>
                            <spring:errors path="busLicense" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="date"><i18n:message code="admin.schedules.date"/></spring:label>
                            <spring:input path="date" class="form-control" type="text" placeholder="MM/dd/yyyy HH:mm"
                                          required="true"/>
                            <spring:errors path="date" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="hours"><i18n:message code="admin.schedules.hours"/></spring:label>
                            <i18n:message code="admin.schedules.hours.ph" var="hoursPlaceholder"/>
                            <spring:input path="hours" class="form-control" type="text" placeholder="${hoursPlaceholder}"
                                          required="true"/>
                            <spring:errors path="hours" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="price"><i18n:message code="admin.schedules.price"/></spring:label>
                            <i18n:message code="admin.schedules.price.ph" var="pricePlaceholder"/>
                            <spring:input path="price" class="form-control" type="text" placeholder="${pricePlaceholder}"
                                          required="true"/>
                            <spring:errors path="price" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary"><i18n:message code="admin.submit"/></button>
            </spring:form>
        </div>
    </div>
</div>
