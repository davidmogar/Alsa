<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="page-header">
    <h3>Create a news</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            News creation form
        </div>

        <div class="panel-body">
            <spring:form commandName="news" action="save">
                <div class="form-group">
                    <spring:label path="title">Title</spring:label>
                    <spring:input path="title" class="form-control" type="text" placeholder="Title of the news"
                                  required="true"/>
                    <spring:errors path="title" cssClass="validation-error"/>
                </div>

                <div class="form-group">
                    <spring:label path="title">Text</spring:label>
                    <spring:textarea path="text" class="form-control" rows="5" placeholder="News text"
                                     required="true"/>
                    <spring:errors path="text" cssClass="validation-error"/>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </spring:form>
        </div>
    </div>
</div>
