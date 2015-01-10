<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-header">
    <h3>Create a bus</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            News bus form
        </div>

        <div class="panel-body">
            <spring:form commandName="bus" action="save">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="licensePlate">License plate</spring:label>
                            <spring:input path="licensePlate" class="form-control" type="text"
                                          placeholder="License plate of the bus"
                                          required="true"/>
                            <spring:errors path="licensePlate" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="type">Bus type</spring:label>
                            <spring:select path="type" cssClass="form-control" items="${busTypes}"/>
                            <spring:errors path="type" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group">
                            <spring:label path="lastRevision">Last revision</spring:label>
                            <spring:input path="lastRevision" class="form-control" type="text" placeholder="mm/dd/yyyy"
                                          required="true"/>
                            <spring:errors path="lastRevision" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </spring:form>
        </div>
    </div>
</div>
