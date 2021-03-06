<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title><tiles:insertAttribute name="title" ignore="true" /></title>

  <meta name="description" content="">
  <meta name="author" content="David Moreno García">

  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Fonts -->
  <link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700' rel='stylesheet' type='text/css'>
  <link href='//fonts.googleapis.com/css?family=Raleway:400,300,600' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.min.css'/>" type="text/css"/>
  <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>" type="text/css"/>
  <link rel="stylesheet" href="<c:url value='/resources/css/admin.css'/>" type="text/css"/>

  <!-- Favicon -->
  <link rel="icon" type="image/png" href="<c:url value='/resources/img/favicon.ico'/>"/>
</head>
<body>
  <tiles:insertAttribute name="header" />

  <div id="wrapper" class="row">
    <div id="left-panel" class="col-md-3">
      <tiles:insertAttribute name="navigation"/>
    </div>

    <div id="right-panel" class="col-md-9">
      <tiles:insertAttribute name="content"/>
    </div>
  </div>

  <script src="<c:url value='/resources/js/jquery-1.11.1.min.js'/>"></script>
  <script src="<c:url value='/resources/js/jquery-ui.min.js'/>"></script>
  <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/resources/js/admin.js'/>"></script>
  <script>var ctx = "${pageContext.request.contextPath}"</script>
</body>
</html>
