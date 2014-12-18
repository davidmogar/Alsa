<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="carousel" class="owl-carousel owl-theme">
    <div class="image item" style="background-image: url(<c:url value='/resources/img/hug.png'/>)">
        <div class="box bottom right">
            <h3>Una colección de abrazos</h3>
            <p>Alsa lleva reuniendo personas desde 1926. Descubre nuestra historia <a href="#">aquí</a>.</p>
        </div>
    </div>
    <div class="image item" style="background-image: url(<c:url value='/resources/img/berlin.png'/>)">
        <div class="box top left">
            <h3>¿Sabías que ALSA es internacional?</h3>
            <p>Luarca fue sólo el comienzo. Descubre todos nuestros destinos internacionales pusaldo <a href="#">aquí</a>.</p>
        </div>
    </div>
    <div class="image item" style="background-image: url(<c:url value='/resources/img/solar_panel.png'/>)">
        <div class="box bottom right">
            <h3>Somos verdes</h3>
            <p>Haz click <a href="#">aquí</a> y descubre nuestro compromiso social y medioambiental.</p>
        </div>
    </div>
</div>

<div id="news" class="container">
    <h3>Last news</h3>

    <div class="news-item">
        <h4>Esta Navidad vuelve a casa desde 5€</h4>
        <p>Compra tus billetes de autob'us con antelaci'on y viaja con los mejores precios todo el año. Tienes más
            de 100.000 plazas y más de 70 trayectos promocionados. Compra tus billetes <a href="#">aquí</a>.</p>
    </div>

    <div class="news-item">
        <h4>Esta Navidad vuelve a casa desde 5€</h4>
        <p>Compra tus billetes de autob'us con antelaci'on y viaja con los mejores precios todo el año. Tienes más
            de 100.000 plazas y más de 70 trayectos promocionados. Compra tus billetes <a href="#">aquí</a>.</p>
    </div>
</div>

<div id="about-us">
    <div class="container">
        <p>Take a tour to find out more about us.</p>
        <a class="button" href="#">Start tour</a>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#carousel").owlCarousel({
            autoPlay: true,
            paginationSpeed: 400,
            singleItem: true,
            slideSpeed: 300
        });
    });
</script>