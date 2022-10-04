<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib prefix="phone" tagdir="/WEB-INF/tags/phone" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<common:page pageTitle="Phone list" showMenu="true">
    <div class="row justify-content-center font-italic mb-3">
        <form method="get">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input id="query" name="query" type="text" placeholder="Search..." class="search-box" value="${searchParameter.query}">
            <input id="fromPrice" name="fromPrice" type="text" placeholder="" class="search-box" value="${searchParameter.fromPrice}">
            <input id="toPrice" name="toPrice" type="text" placeholder="" class="search-box" value="${searchParameter.toPrice}">
            <button type="submit" class="btn">Search</button>
        </form>
        Found <c:out value="${phones.totalElements}"/> results!
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Image</th>
            <th scope="col">Brand <util:sorting field="brand"/></th>
            <th scope="col">Model <util:sorting field="model"/></th>
            <th scope="col">Price <util:sorting field="price"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="phone" items="${phones.content}">
            <phone:tile phone="${phone}"/>
        </c:forEach>
        </tbody>
    </table>
    <util:pagination searchParameter="${searchParameter}"
                    page="${phones}"
                    numberOfPages="${numberOfPages}"/>
</common:page>