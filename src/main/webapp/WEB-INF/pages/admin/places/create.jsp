<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="page-header">
    <h3>Create a place</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Place creation form
        </div>

        <div class="panel-body">
            <spring:form commandName="place" action="save" enctype="multipart/form-data">
                <div class="form-group">
                    <spring:label path="name">Name</spring:label>
                    <spring:input path="name" class="form-control" type="text" placeholder="Name of the place"
                                  required="true"/>
                    <spring:errors path="name" cssClass="validation-error"/>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="latitude">Latitude</spring:label>
                            <spring:input path="latitude" class="form-control" type="text"
                                          placeholder="Latitude of the place"
                                          required="true"/>
                            <spring:errors path="latitude" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="longitude">Longitude</spring:label>
                            <spring:input path="longitude" class="form-control" type="text"
                                          placeholder="Longitude of the place"
                                          required="true"/>
                            <spring:errors path="longitude" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <spring:label path="imagePath">Image</spring:label>
                    <input name="image" type="file" accept="image/*" required="true"/>
                    <spring:errors path="imagePath" cssClass="validation-error"/>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </spring:form>
        </div>
    </div>
</div>
