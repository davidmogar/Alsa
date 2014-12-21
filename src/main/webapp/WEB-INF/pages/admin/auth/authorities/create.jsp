<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="page-header">
    <h3>Create an authority</h3>
</div>

<div id="page-content">
    <div class="panel">
        <div class="panel-heading">
            Authorities creation form
        </div>

        <div class="panel-content">
            <spring:form commandName="authority" action="save">
                <spring:label path="name">Name</spring:label>
                <spring:input path="name" class="u-full-width" type="text" placeholder="Name of the new authority"
                              required="true"/>
                <spring:errors path="name" cssClass="validation-error"/>

                <spring:label path="description">Description</spring:label>
                <spring:textarea path="description" class="u-full-width" placeholder="Small description of privileges"
                                 required="true"/>
                <spring:errors path="description" cssClass="validation-error"/>

                <input class="button-primary" type="submit" value="Submit"/>
            </spring:form>
        </div>
    </div>
</div>
