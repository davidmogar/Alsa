<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.users.create"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.users.form"/>
        </div>

        <div class="panel-body">
            <spring:form commandName="user" action="save">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="firstname"><i18n:message code="admin.users.firstName"/></spring:label>
                            <i18n:message code="admin.users.firstName.ph" var="firstNamePlaceholder"/>
                            <spring:input path="firstname" class="form-control" type="text"
                                          placeholder="${firstNamePlaceholder}"
                                          required="true"/>
                            <spring:errors path="firstname" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="lastname"><i18n:message code="admin.users.lastName"/></spring:label>
                            <i18n:message code="admin.users.lastName.ph" var="lastNamePlaceholder"/>
                            <spring:input path="lastname" class="form-control" type="text" placeholder="${lastNamePlaceholder}"
                                          required="true"/>
                            <spring:errors path="lastname" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="username"><i18n:message code="admin.users.username"/></spring:label>
                            <i18n:message code="admin.users.username.ph" var="usernamePlaceholder"/>
                            <spring:input path="username" class="form-control" type="text" placeholder="${usernamePlaceholder}"
                                          required="true"/>
                            <spring:errors path="username" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="authority"><i18n:message code="admin.users.authority"/></spring:label>
                            <spring:select path="authority" cssClass="form-control" items="${authorities}"/>
                            <spring:errors path="authority" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="email"><i18n:message code="admin.users.email"/>s</spring:label>
                            <i18n:message code="admin.users.email.ph" var="emailPlaceholder"/>
                            <spring:input path="email" class="form-control" type="text" placeholder="${emailPlaceholder}"
                                          required="true"/>
                            <spring:errors path="email" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="identification"><i18n:message code="admin.users.identification"/>s
                            </spring:label>
                            <i18n:message code="admin.users.identification.ph" var="identificationlaceholder"/>
                            <spring:input path="identification" class="form-control" type="text" placeholder="${identificationlaceholder}"
                                          required="true"/>
                            <spring:errors path="identification" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <spring:label path="password"><i18n:message code="admin.users.password"/></spring:label>
                        <i18n:message code="admin.users.password.ph" var="passwordPlaceholder"/>
                        <spring:input path="password" class="form-control" type="password" placeholder="${passwordPlaceholder}"
                                      required="true"/>
                        <spring:errors path="password" cssClass="validation-error"/>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="repeatedPassword"><i18n:message code="admin.users.passwordAgain"/></spring:label>
                            <i18n:message code="admin.users.passwordAgain.ph" var="passwordAgainPlaceholder"/>
                            <spring:input path="repeatedPassword" class="form-control" type="password"
                                          placeholder="${passwordAgainPlaceholder}" required="true"/>
                            <spring:errors path="repeatedPassword" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="checkbox">
                    <label>
                        <spring:checkbox path="enabled"/> <i18n:message code="admin.users.enabled"/>
                    </label>
                </div>

                <button type="submit" class="btn btn-primary"><i18n:message code="admin.submit"/></button>
            </spring:form>
        </div>
    </div>
</div>
