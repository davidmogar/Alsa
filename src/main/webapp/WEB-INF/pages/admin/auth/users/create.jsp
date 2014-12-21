<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="page-header">
    <h3>Create new user</h3>
</div>

<div id="page-content">
    <div class="panel">
        <div class="panel-heading">
            User creation form
        </div>

        <div class="panel-content">
            <spring:form commandName="user" action="save">
                <div class="row">
                    <div class="six columns">
                        <spring:label path="firstname">First name</spring:label>
                        <spring:input path="firstname" class="u-full-width" type="text" placeholder="User first name"
                                      required="true"/>
                        <spring:errors path="firstname" cssClass="validation-error"/>
                    </div>

                    <div class="six columns">
                        <spring:label path="lastname">Last name</spring:label>
                        <spring:input path="lastname" class="u-full-width" type="text" placeholder="User last name"
                                      required="true"/>
                        <spring:errors path="lastname" cssClass="validation-error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="six columns">
                        <spring:label path="username">User name</spring:label>
                        <spring:input path="username" class="u-full-width" type="text" placeholder="User name"
                                      required="true"/>
                        <spring:errors path="username" cssClass="validation-error"/>
                    </div>

                    <div class="six columns">
                        <spring:label path="authority">Authority</spring:label>
                        <spring:select path="authority" cssClass="u-full-width" items="${authorities}"/>
                        <spring:errors path="authority" cssClass="validation-error"/>
                    </div>
                </div>

                <spring:label path="email">Email address</spring:label>
                <spring:input path="email" class="u-full-width" type="text" placeholder="A valid email address"
                              required="true"/>
                <spring:errors path="email" cssClass="validation-error"/>

                <div class="row">
                    <div class="six columns">
                        <spring:label path="password">Password</spring:label>
                        <spring:input path="password" class="u-full-width" type="text" placeholder="User password"
                                      required="true"/>
                        <spring:errors path="password" cssClass="validation-error"/>
                    </div>

                    <div class="six columns">
                        <spring:label path="repeatedPassword">Password again</spring:label>
                        <spring:input path="repeatedPassword" class="u-full-width" type="text"
                                      placeholder="User password again" required="true"/>
                        <spring:errors path="repeatedPassword" cssClass="validation-error"/>
                    </div>
                </div>

                <spring:label path="enabled">
                    <spring:checkbox path="enabled"/>
                    <span class="label-body">Enabled?</span>
                </spring:label>

                <input class="button-primary" type="submit" value="Submit"/>
            </spring:form>
        </div>
    </div>
</div>
