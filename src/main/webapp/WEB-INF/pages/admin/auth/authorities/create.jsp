<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.authorities"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.authorities.form"/>
        </div>

        <div class="panel-body">
            <spring:form commandName="authority" action="save">
                <div class="form-group">
                    <spring:label path="name"><i18n:message code="admin.authorities.name"/></spring:label>
                    <i18n:message code="admin.authorities.name.ph" var="namePlaceholder"/>
                    <spring:input path="name" class="form-control" Type="text"
                                  placeholder="${namePlaceholder}"
                                  required="true"/>
                    <spring:errors path="name" cssClass="validation-error"/>
                </div>

                <div class="form-group">
                    <spring:label path="description"><i18n:message code="admin.authorities.description"/></spring:label>
                    <i18n:message code="admin.authorities.description.ph" var="descriptionPlaceholder"/>
                    <spring:textarea path="description" class="form-control"
                                     placeholder="${descriptionPlaceholder}"
                                     required="true"/>
                    <spring:errors path="description" cssClass="validation-error"/>
                </div>

                <button type="submit" class="btn btn-primary"><i18n:message code="admin.submit"/></button>
            </spring:form>
        </div>
    </div>
</div>
