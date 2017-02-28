<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="i18n.login" var="log" />
<fmt:message var="title" bundle="${log}" key="login.title"/>
<jsp:useBean id="validation" class="com.nusrat.java.drive_club.service.Validation" scope="request"/>
<tags:page title="${title}">


    <c:url var="loginPath" value="/login"/>
    <c:out value="${login}"/>

    <fmt:message bundle="${log}" key="login.log.in" var="log_in" />
    <fmt:message bundle="${log}" key="login.login" var="login"/>
    <fmt:message bundle="${log}" key="login.password" var="password"/>
    <fmt:message bundle="${log}" key="login.sign.in" var="sign_in"/>
    <fmt:message bundle="${log}" key="login.log.in.invalid" var="log_in_invalid"  />
    <div class="container" style="padding:50px 400px">
        <h2 class="form-signin-heading">${sign_in}</h2>
        <c:if test="${validation.valid.INVALID_CREDENTIALS}">
            <div class="alert alert-danger">
                <c:out value="${log_in_invalid}"/>
            </div>
        </c:if>
        <form class="form-signin" action="${loginPath}" method="post">
            <label for="name" class="sr-only">${login}</label>
            <input  type="email" id="name" class="form-control" placeholder="${login}" name="login" required autofocus>
            <label for="pwd" class="sr-only">${password}</label>
            <input type="password" id="pwd" class="form-control" placeholder="${password}" name="password" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit" >${log_in}</button>
        </form>
    </div>

</tags:page>


