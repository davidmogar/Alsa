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
            <spring:form commandName="news" action="save">
                <spring:input path="title" class="u-full-width" type="text" placeholder="Title of the news"
                              required="true"/>
                <spring:errors path="title" cssClass="validation-error"/>

                <spring:textarea path="text" class="u-full-width" placeholder="News text" required="true"/>
                <spring:errors path="text" cssClass="validation-error"/>

                <input class="button-primary" type="submit" value="Submit"/>
            </spring:form>
        </div>
    </div>
</div>
