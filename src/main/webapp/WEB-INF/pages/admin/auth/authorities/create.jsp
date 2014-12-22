<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="page-header">
    <h3>Create an authority</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Authorities creation form
        </div>

        <div class="panel-body">
            <spring:form commandName="authority" action="save">
                <div class="form-group">
                    <spring:label path="name">Name</spring:label>
                    <spring:input path="name" class="form-control" type="text"
                                  placeholder="Name of the new authority"
                                  required="true"/>
                    <spring:errors path="name" cssClass="validation-error"/>
                </div>

                <div class="form-group">
                    <spring:label path="description">Description</spring:label>
                    <spring:textarea path="description" class="form-control"
                                     placeholder="Small description of privileges"
                                     required="true"/>
                    <spring:errors path="description" cssClass="validation-error"/>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </spring:form>
        </div>
    </div>
</div>
