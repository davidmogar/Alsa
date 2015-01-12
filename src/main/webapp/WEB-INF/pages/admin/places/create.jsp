<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.places.create"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.places.form"/>
        </div>

        <div class="panel-body">
            <spring:form commandName="place" action="save" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <spring:label path="name"><i18n:message code="admin.places.name"/></spring:label>
                    <i18n:message code="admin.places.name.ph" var="namePlaceholder"/>
                    <spring:input path="name" class="form-control" Type="text" placeholder="${namePlaceholder}"
                                  required="true"/>
                    <spring:errors path="name" cssClass="validation-error"/>
                </div>

                <div class="form-group">
                    <spring:label path="description"><i18n:message code="admin.places.description"/></spring:label>
                    <i18n:message code="admin.places.description.ph" var="descriptionPlaceholder"/>
                    <spring:textarea path="description" class="form-control" rows="5" placeholder="${descriptionPlaceholder}"
                                     required="true"/>
                    <spring:errors path="description" cssClass="validation-error"/>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="latitude"><i18n:message code="admin.places.latitude"/></spring:label>
                            <i18n:message code="admin.places.latitude.ph" var="latitudePlaceholder"/>
                            <spring:input path="latitude" class="form-control" Type="text"
                                          placeholder="${latitudePlaceholder}"
                                          required="true"/>
                            <spring:errors path="latitude" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="longitude"><i18n:message code="admin.places.longitude"/></spring:label>
                            <i18n:message code="admin.places.longitude.ph" var="longitudePlaceholder"/>
                            <spring:input path="longitude" class="form-control" Type="text"
                                          placeholder="${longitudePlaceholder}"
                                          required="true"/>
                            <spring:errors path="longitude" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <spring:label path="imagePath"><i18n:message code="admin.places.image"/></spring:label>
                    <input name="image" type="file" accept="image/*" required="true"/>
                    <spring:errors path="imagePath" cssClass="validation-error"/>
                </div>

                <button type="submit" class="btn btn-primary"><i18n:message code="admin.submit"/></button>
            </spring:form>
        </div>
    </div>
</div>
