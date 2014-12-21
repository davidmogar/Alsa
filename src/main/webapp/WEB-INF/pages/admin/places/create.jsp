<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="page-header">
    <h3>Create a news</h3>
</div>

<div id="page-content">
    <div class="panel">
        <div class="panel-heading">
            News creation form
        </div>

        <div class="panel-content">
            <spring:form commandName="place" action="save" enctype="multipart/form-data">
                <spring:label path="name">Name</spring:label>
                <spring:input path="name" class="u-full-width" type="text" placeholder="Name of the place"
                              required="true"/>
                <spring:errors path="name" cssClass="validation-error"/>

                <div class="row">
                    <div class="six columns">
                        <spring:label path="latitude">Latitude</spring:label>
                        <spring:input path="latitude" class="u-full-width" type="text"
                                      placeholder="Latitude of the place"
                                      required="true"/>
                        <spring:errors path="latitude" cssClass="validation-error"/>
                    </div>

                    <div class="six columns">
                        <spring:label path="longitude">Longitude</spring:label>
                        <spring:input path="longitude" class="u-full-width" type="text"
                                      placeholder="Longitude of the place"
                                      required="true"/>
                        <spring:errors path="longitude" cssClass="validation-error"/>
                    </div>
                </div>

                <spring:label path="imagePath">Image</spring:label>
                <input name="image" class="u-full-width" type="file" accept="image/*" required="true"/>
                <spring:errors path="imagePath" cssClass="validation-error"/>

                <input class="button-primary" type="submit" value="Submit"/>
            </spring:form>
        </div>
    </div>
</div>
