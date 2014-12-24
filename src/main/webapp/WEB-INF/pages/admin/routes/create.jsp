<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="page-header">
    <h3>Create a route</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Route creation form
        </div>

        <div class="panel-body">
            <spring:form commandName="route" action="save" method="post">
                <div class="form-group">
                    <spring:label path="name">Name</spring:label>
                    <spring:input path="name" class="form-control" type="text" placeholder="Name of the route"
                                  required="true"/>
                    <spring:errors path="name" cssClass="validation-error"/>
                </div>

                <div class="form-group">
                    <spring:label path="description">Description</spring:label>
                    <spring:textarea path="description" class="form-control" rows="5" placeholder="Short description"
                                     required="true"/>
                    <spring:errors path="description" cssClass="validation-error"/>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="origin">Origin</spring:label>
                            <spring:input path="origin" class="form-control" type="text"
                                          placeholder="Origin place of the route"
                                          required="true"/>
                            <spring:errors path="origin" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="destination">Destination</spring:label>
                            <spring:input path="destination" class="form-control" type="text"
                                          placeholder="Destination place of the route"
                                          required="true"/>
                            <spring:errors path="destination" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <spring:label path="distance">Name</spring:label>
                    <spring:input path="distance" class="form-control" type="text" placeholder="Distance in kilometers"
                                  required="true"/>
                    <spring:errors path="distance" cssClass="validation-error"/>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </spring:form>
        </div>
    </div>
</div>
