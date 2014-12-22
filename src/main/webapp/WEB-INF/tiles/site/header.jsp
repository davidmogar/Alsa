<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<tilesx:useAttribute name="active"/>

<header>
    <div id="quick-bar" class="row">
        <div class="container">
            <div class="col-md-4">
                <p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 902 42 22 42</p>
            </div>
            <div class="col-md-8">
                <ul>
                    <li><a href="#">My Account</a></li>
                    <li><span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        <a href="#">Search</a></li>
                    <li><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                        <a href="#">Ayuda online</a></li>
                </ul>
            </div>
        </div>
    </div>

    <tiles:insertAttribute name="navigation"/>

</header>