<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<common:page pageTitle="Admin panel" showMenu="false">
    <div class="row mb-3">
        <common:back/>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Username</th>
            <th scope="col">Location</th>
            <th scope="col">Company</th>
            <th scope="col">Avatar Url</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.location}"/></td>
                <td><c:out value="${user.company}"/></td>
                <td><c:out value="${user.avatarUrl}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</common:page>
