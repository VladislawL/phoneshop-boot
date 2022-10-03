<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<common:page pageTitle="Phone details" showMenu="true">
<main class="container-fluid">
    <div class="row mb-3">
        <common:back/>
    </div>
    <div class="product-details">
        <div class="row">
            <div class="col-6">
                <div class="image">
                    <img src="https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/${phone.image}">
                </div>
                <div class="description">
                    <span class="font-weight-bold">Brand:</span>
                    <span><c:out value="${phone.brand}" /></span>
                </div>
                <div class="model">
                    <span class="font-weight-bold">Model:</span>
                    <span><c:out value="${phone.model}" /></span>
                </div>
                <div class="price">
                    <span>Price:</span>
                    <span><c:out value="${phone.price}" /></span>
                </div>
                <div class="description">
                    <span class="font-weight-bold">Description:</span>
                    <span><c:out value="${phone.description}" /></span>
                </div>
            </div>
        </div>
    </div>
</main>
</common:page>
