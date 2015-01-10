<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div id="book">
    <div class="container">
        <div class="row">
            <div id="controls" class="col-sm-offset-4 col-sm-4">
                <h2>Some needed data</h2>
                <a class="btn btn-primary btn-lg" href="#">Use your account data</a>

                <p>or</p>
                <a class="btn btn-default btn-lg" href="#form">Fill the form bellow</a>
            </div>
        </div>
    </div>
</div>

<div id="book-form" class="container">
    <spring:form commandName="bookData" action="save" cssClass="form-horizontal">
        <div class="row">
            <div class="col-md-6">
                <fieldset>
                    <legend>Traveler info</legend>

                    <div class="form-group">
                        <spring:label path="firstName" cssClass="col-md-3 control-label">First name</spring:label>
                        <div class="col-md-9">
                            <spring:input path="firstName" class="form-control" type="text"
                                          placeholder="Your first name"
                                          required="true"/>
                            <spring:errors path="firstName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <spring:label path="lastName" cssClass="col-md-3 control-label">Last name</spring:label>
                        <div class="col-md-9">
                            <spring:input path="lastName" class="form-control" type="text"
                                          placeholder="Your last name"
                                          required="true"/>
                            <spring:errors path="lastName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <spring:label path="identification" cssClass="col-md-3 control-label">Identification
                        </spring:label>
                        <div class="col-md-4">
                            <spring:input path="identification" class="form-control" type="text"
                                          placeholder="Identification number"
                                          required="true"/>
                            <spring:errors path="identification" cssClass="validation-error"/>
                        </div>

                        <spring:label path="identificationType" cssClass="col-md-2 control-label">Type
                        </spring:label>
                        <div class="col-md-3">
                            <spring:select path="identificationType" cssClass="form-control"
                                           items="${identificationTypes}"/>
                            <spring:errors path="identificationType" cssClass="validation-error"/>
                        </div>
                    </div>
                </fieldset>
            </div>

            <div class="col-md-6">
                <fieldset>
                    <legend>Payment info</legend>

                    <div class="form-group">
                        <spring:label path="cardHolderName" cssClass="col-md-3 control-label">Holder's
                            name</spring:label>
                        <div class="col-md-9">
                            <spring:input path="cardHolderName" class="form-control" type="text"
                                          placeholder="The name on the card"
                                          required="true"/>
                            <spring:errors path="cardHolderName" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <spring:label path="cardNumber" cssClass="col-md-3 control-label">Card number</spring:label>
                        <div class="col-md-9">
                            <spring:input path="cardNumber" class="form-control" type="text"
                                          placeholder="The number of the card"
                                          required="true"/>
                            <spring:errors path="cardNumber" cssClass="validation-error"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <spring:label path="cardExpirationMonth" cssClass="col-md-3 control-label">Expiration
                            date</spring:label>

                        <div class="col-md-6">
                            <spring:select path="cardExpirationMonth" class="form-control">
                                <spring:option value="1">January</spring:option>
                                <spring:option value="2">February</spring:option>
                                <spring:option value="3">March</spring:option>
                                <spring:option value="4">April</spring:option>
                                <spring:option value="5">May</spring:option>
                                <spring:option value="6">June</spring:option>
                                <spring:option value="7">July</spring:option>
                                <spring:option value="8">August</spring:option>
                                <spring:option value="9">September</spring:option>
                                <spring:option value="10">October</spring:option>
                                <spring:option value="11">November</spring:option>
                                <spring:option value="12">December</spring:option>
                            </spring:select>
                            <spring:errors path="cardExpirationMonth" cssClass="validation-error"/>
                        </div>

                        <div class="col-md-3">
                            <spring:input path="cardExpirationYear" class="form-control" type="number" min="2015"
                                          max="2050" value="2015"
                                          required="true"/>
                            <spring:errors path="cardExpirationYear" cssClass="validation-error"/>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>

        <button type="submit" class="btn btn-primary center-block">Book your ticket</button>
    </spring:form>
</div>