<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.nav.news.create"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.news.form"/>
        </div>

        <div class="panel-body">
            <spring:form commandName="news" action="save">
                <div class="form-group">
                    <spring:label path="title"><i18n:message code="admin.news.title"/></spring:label>
                    <i18n:message code="admin.news.title.ph" var="titlePlaceholder"/>
                    <spring:input path="title" class="form-control" Type="text" placeholder="${titlePlaceholder}"
                                  required="true"/>
                    <spring:errors path="title" cssClass="validation-error"/>
                </div>

                <div class="form-group">
                    <spring:label path="title"><i18n:message code="admin.news.text"/></spring:label>
                    <i18n:message code="admin.news.text.ph" var="textPlaceholder"/>
                    <spring:textarea path="text" class="form-control" rows="5" placeholder="${textPlaceholder}"
                                     required="true"/>
                    <spring:errors path="text" cssClass="validation-error"/>
                </div>

                <button type="submit" class="btn btn-primary"><i18n:message code="admin.submit"/></button>
            </spring:form>
        </div>
    </div>
</div>
