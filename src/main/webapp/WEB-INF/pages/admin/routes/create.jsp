<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.routes.create"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.routes.form"/>
        </div>

        <div class="panel-body">
            <spring:form commandName="route" action="save" method="post">
                <div class="form-group">
                    <spring:label path="name"><i18n:message code="admin.routes.name"/></spring:label>
                    <i18n:message code="admin.routes.name" var="namePlaceholder"/>
                    <spring:input path="name" class="form-control" Type="text" placeholder="${namePlaceholder}"
                                  required="true"/>
                    <spring:errors path="name" cssClass="validation-error"/>
                </div>

                <div class="form-group">
                    <spring:label path="description"><i18n:message code="admin.routes.description"/></spring:label>
                    <i18n:message code="admin.routes.description.ph" var="descriptionPlaceholder"/>
                    <spring:textarea path="description" class="form-control" rows="5" placeholder="${descriptionPlaceholder}"
                                     required="true"/>
                    <spring:errors path="description" cssClass="validation-error"/>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="originName"><i18n:message code="admin.routes.origin"/></spring:label>
                            <i18n:message code="admin.routes.origin.ph" var="originPlaceholder"/>
                            <spring:input id="origin" path="originName" class="form-control" Type="text"
                                          placeholder="${originPlaceholder}"
                                          required="true"/>
                            <spring:errors path="originName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="destinationName"><i18n:message
                                    code="admin.routes.destination"/></spring:label>
                            <i18n:message code="admin.routes.destination.ph" var="destinationPlaceholder"/>
                            <spring:input id="destination" path="destinationName" class="form-control" Type="text"
                                          placeholder="${destinationPlaceholder}"
                                          required="true"/>
                            <spring:errors path="destinationName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="distance"><i18n:message code="admin.routes.distance"/></spring:label>
                            <i18n:message code="admin.routes.distance.ph" var="distancePlaceholder"/>
                            <spring:input path="distance" class="form-control" Type="text" placeholder="${distancePlaceholder}"
                                          required="true"/>
                            <spring:errors path="distance" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary"><i18n:message code="admin.submit"/></button>
            </spring:form>
        </div>
    </div>
</div>
