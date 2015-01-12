<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="i18n" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="tickets">
    <div class="container">
        <div class="row">
            <div id="controls" class="col-sm-offset-4 col-sm-4">
                <h2><i18n:message code="site.tickets.title"/></h2>

                <p><i18n:message code="site.tickets.message"/></p>
            </div>
        </div>
    </div>
</div>

<div id="tickets-forms" class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">Query tickets</div>
                <div class="panel-body">
                    <spring:form commandName="ticketData" action="${pageContext.request.contextPath}/tickets/search"
                                 cssClass="form-horizontal">
                        <div class="form-group">
                            <spring:label path="code" cssClass="col-md-3 control-label"><i18n:message
                                    code="site.tickets.code"/></spring:label>
                            <div class="col-md-9">
                                <i18n:message code="site.tickets.code.ph" var="codePlaceholder"/>
                                <spring:input path="code" class="form-control" type="text"
                                              placeholder="${codePlaceholder}"
                                              required="true"/>
                                <spring:errors path="code" cssClass="validation-error"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit"
                                        class="btn btn-primary"><i18n:message code="site.tickets.search"/></button>
                            </div>
                        </div>
                    </spring:form>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">Cancel tickets</div>
                <div class="panel-body">
                    <spring:form commandName="ticketData" action="${pageContext.request.contextPath}/tickets/cancel"
                                 cssClass="form-horizontal">
                        <div class="form-group">
                            <spring:label path="code" cssClass="col-md-3 control-label"><i18n:message
                                    code="site.tickets.code"/></spring:label>
                            <div class="col-md-9">
                                <i18n:message code="site.tickets.code.ph" var="codePlaceholder"/>
                                <spring:input path="code" class="form-control" type="text"
                                              placeholder="${codePlaceholder}"
                                              required="true"/>
                                <spring:errors path="code" cssClass="validation-error"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <spring:label path="identification" cssClass="col-md-3 control-label"><i18n:message
                                    code="site.tickets.identification"/></spring:label>
                            <div class="col-md-9">
                                <i18n:message code="site.tickets.identification.ph" var="identificationPlaceholder"/>
                                <spring:input path="identification" class="form-control" type="text"
                                              placeholder="${identificationPlaceholder}"
                                              required="true"/>
                                <spring:errors path="identification" cssClass="validation-error"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit"
                                        class="btn btn-primary"><i18n:message code="site.tickets.cancel"/></button>
                            </div>
                        </div>
                    </spring:form>
                </div>
            </div>
        </div>
    </div>
</div>