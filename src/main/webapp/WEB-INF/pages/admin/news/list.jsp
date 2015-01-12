<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="i18n" uri="http://www.springframework.org/tags" %>

<div id="page-header">
    <h3><i18n:message code="admin.news.list"/></h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <i18n:message code="admin.news.listSystem"/>
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th><i18n:message code="admin.news.title"/></th>
                    <th><i18n:message code="admin.news.publication"/></th>
                    <th><i18n:message code="admin.news.text"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${news}" var="news">
                    <tr>
                        <td>${news.title}</td>
                        <td>${news.publicationDate}</td>
                        <td>${news.text}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
