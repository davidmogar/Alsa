<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<div class="journey">
    <div class="container">
        <spring:form commandName="journeyData" action="${pageContext.request.contextPath}/journey/search">
            <h3>Plan a Journey</h3>

            <div class="form-group">
                <spring:label path="origin">Origin</spring:label>
                <spring:input id="origin" path="origin" type="text" class="form-control" placeholder="From"
                              required="true" autofocus="true"/>
                <spring:errors path="origin" cssClass="validation-error"/>
            </div>

            <div class="form-group">
                <spring:label path="destination">Destination</spring:label>
                <spring:input id="destination" path="destination" type="text" class="form-control" placeholder="To"
                              required="true"/>
                <spring:errors path="destination" cssClass="validation-error"/>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <div class="form-group">
                        <spring:label path="day">Day</spring:label>
                        <spring:input id="datepicker" path="day" type="text" class="form-control" required="true"/>
                        <spring:errors path="day" cssClass="validation-error"/>
                    </div>
                </div>

                <div class="col-xs-4">
                    <div class="form-group">
                        <spring:label path="hour">Hour</spring:label>
                        <spring:select path="hour" class="form-control">
                            <spring:option value="00:00">00:15</spring:option>
                            <spring:option value="00:30">00:30</spring:option>
                            <spring:option value="01:00">01:00</spring:option>
                            <spring:option value="01:30">01:30</spring:option>
                            <spring:option value="02:00">02:00</spring:option>
                            <spring:option value="02:30">02:30</spring:option>
                            <spring:option value="03:00">03:00</spring:option>
                            <spring:option value="03:30">03:30</spring:option>
                            <spring:option value="04:00">04:00</spring:option>
                            <spring:option value="04:30">04:30</spring:option>
                            <spring:option value="05:00">05:00</spring:option>
                            <spring:option value="05:30">05:30</spring:option>
                            <spring:option value="06:00">06:00</spring:option>
                            <spring:option value="06:30">06:30</spring:option>
                            <spring:option value="07:00">07:00</spring:option>
                            <spring:option value="07:30">07:30</spring:option>
                            <spring:option value="08:00">08:00</spring:option>
                            <spring:option value="08:30">08:30</spring:option>
                            <spring:option value="09:00">09:00</spring:option>
                            <spring:option value="09:30">09:30</spring:option>
                            <spring:option value="10:00">10:00</spring:option>
                            <spring:option value="10:30">10:30</spring:option>
                            <spring:option value="11:00">11:00</spring:option>
                            <spring:option value="11:30">11:30</spring:option>
                            <spring:option value="12:00">12:00</spring:option>
                            <spring:option value="12:30">12:30</spring:option>
                            <spring:option value="13:00">13:00</spring:option>
                            <spring:option value="13:30">13:30</spring:option>
                            <spring:option value="14:00">14:00</spring:option>
                            <spring:option value="14:30">14:30</spring:option>
                            <spring:option value="15:00">15:00</spring:option>
                            <spring:option selected="selected" value="15:30">15:30</spring:option>
                            <spring:option value="16:00">16:00</spring:option>
                            <spring:option value="16:30">16:30</spring:option>
                            <spring:option value="17:00">17:00</spring:option>
                            <spring:option value="17:30">17:30</spring:option>
                            <spring:option value="18:00">18:00</spring:option>
                            <spring:option value="18:30">18:30</spring:option>
                            <spring:option value="19:00">19:00</spring:option>
                            <spring:option value="19:30">19:30</spring:option>
                            <spring:option value="20:00">20:00</spring:option>
                            <spring:option value="20:30">20:30</spring:option>
                            <spring:option value="21:00">21:00</spring:option>
                            <spring:option value="21:30">21:30</spring:option>
                            <spring:option value="22:00">22:00</spring:option>
                            <spring:option value="22:30">22:30</spring:option>
                            <spring:option value="23:00">23:00</spring:option>
                            <spring:option value="23:30">23:30</spring:option>
                        </spring:select>
                    </div>
                </div>
            </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Plan my journey</button>
        </spring:form>
    </div>
</div>