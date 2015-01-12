<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.nav.buses.create"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.buses.form"/>
        </div>

        <div class="panel-body">
            <spring:form commandName="bus" action="save">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="licensePlate"><i18n:message code="admin.buses.license"/></spring:label>
                            <i18n:message code="admin.buses.license.ph" var="licensePlacePlaceholder"/>
                            <spring:input path="licensePlate" class="form-control" type="text"
                                          placeholder="${licensePlacePlaceholder}"
                                          required="true"/>
                            <spring:errors path="licensePlate" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="type"><i18n:message code="admin.buses.type"/></spring:label>
                            <spring:select path="type" cssClass="form-control" items="${busTypes}"/>
                            <spring:errors path="type" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="lastRevision"><i18n:message code="admin.buses.lastRevision"/></spring:label>
                            <spring:input path="lastRevision" class="form-control" type="text" placeholder="mm/dd/yyyy"
                                          required="true"/>
                            <spring:errors path="lastRevision" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary"><i18n:message code="admin.submit"/></button>
            </spring:form>
        </div>
    </div>
</div>
