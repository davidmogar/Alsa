<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="page-header">
    <h3>List news</h3>
</div>

<div id="page-content">
    <div class="panel panel-primary">
        <div class="panel-heading">
            List of news in the system
        </div>

        <div class="panel-body">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Publication date</th>
                    <th>Text</th>
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
