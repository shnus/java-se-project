<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="i18n.login" var="log" />
<fmt:message var="title" bundle="${log}" key="login.title"/>
<tags:page title="${title}">
    <c:url var="login" value="/login"/>

    <fmt:message bundle="${log}" key="login.log.in" var="log_in" />
    <fmt:message bundle="${log}" key="login.login" var="login"/>
    <fmt:message bundle="${log}" key="login.password" var="password"/>
    <fmt:message bundle="${log}" key="login.sign.in" var="sign_in"/>
    <div class="container" style="padding:50px 400px">
        <form class="form-signin" action="${login}" method="post">
            <h2 class="form-signin-heading">${sign_in}</h2>
            <label for="name" class="sr-only">${login}</label>
            <input  type="email" id="name" class="form-control" placeholder="${login}" name="login" required autofocus>
            <label for="pwd" class="sr-only">${password}</label>
            <input type="password" id="pwd" class="form-control" placeholder="${password}" name="password" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit" >${log_in}</button>
        </form>
    </div>

</tags:page>


