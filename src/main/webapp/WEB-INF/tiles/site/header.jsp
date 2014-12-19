<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<tilesx:useAttribute name="active"/>

<header>
    <div id="quick-bar" class="row">
        <div class="container">
            <div class="four columns">
                <p><span class="flaticon-phone"></span> 902 42 22 42</p>
            </div>
            <div class="eight columns">
                <ul>
                    <li><a href="#">My Account</a></li>
                    <li><span class="flaticon-search"></span> <a href="#">Search</a></li>
                    <li><span class="flaticon-info"></span> <a href="#">Ayuda online</a></li>
                </ul>
            </div>
        </div>
    </div>

    <tiles:insertAttribute name="navigation"/>

</header>