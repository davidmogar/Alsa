<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="page-header">
    <h3>Create new user</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            User creation form
        </div>

        <div class="panel-body">
            <spring:form commandName="user" action="save">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="firstname">First name</spring:label>
                            <spring:input path="firstname" class="form-control" type="text"
                                          placeholder="User first name"
                                          required="true"/>
                            <spring:errors path="firstname" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="lastname">Last name</spring:label>
                            <spring:input path="lastname" class="form-control" type="text" placeholder="User last name"
                                          required="true"/>
                            <spring:errors path="lastname" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="username">User name</spring:label>
                            <spring:input path="username" class="form-control" type="text" placeholder="User name"
                                          required="true"/>
                            <spring:errors path="username" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="authority">Authority</spring:label>
                            <spring:select path="authority" cssClass="form-control" items="${authorities}"/>
                            <spring:errors path="authority" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <spring:label path="email">Email address</spring:label>
                    <spring:input path="email" class="form-control" type="text" placeholder="A valid email address"
                                  required="true"/>
                    <spring:errors path="email" cssClass="validation-error"/>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <spring:label path="password">Password</spring:label>
                        <spring:input path="password" class="form-control" type="password" placeholder="User password"
                                      required="true"/>
                        <spring:errors path="password" cssClass="validation-error"/>
                    </div>

                    <div class="col-md-6">
                        <div class="form-group">
                            <spring:label path="repeatedPassword">Password again</spring:label>
                            <spring:input path="repeatedPassword" class="form-control" type="password"
                                          placeholder="User password again" required="true"/>
                            <spring:errors path="repeatedPassword" cssClass="validation-error"/>
                        </div>
                    </div>
                </div>

                <div class="checkbox">
                    <label>
                        <spring:checkbox path="enabled"/> Enabled?
                    </label>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </spring:form>
        </div>
    </div>
</div>
