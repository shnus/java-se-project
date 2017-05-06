<%@attribute name="title" rtexprvalue="true" required="true" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="i18n.home" var="home"/>
<html>
<head>
    <c:url var="jqui" value="/static/css/jquery-ui.min.css"/>
    <link rel="stylesheet" href="${jqui}" />

    <c:url var="jquery" value="/static/js/jquery-3.1.1.min.js"/>
    <script language="JavaScript" type="text/javascript" src="${jquery}"> </script>

    <c:url var="btsMain" value="/static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${btsMain}" />

    <c:url var="font" value="/static/css/font_awesome.min.css"/>
    <link rel="stylesheet" href="${font}" />

    <c:url var="btsTheme" value="/static/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="${btsTheme}" />

    <c:url var="flags" value="/static/flags/css/flag-icon.min.css"/>
    <link rel="stylesheet" href="${flags}">

    <c:url var="btsJs" value="/static/js/bootstrap.min.js"/>
    <script src="${btsJs}"> </script>

    <title>"${title}"</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only"><fmt:message bundle="${home}" key="home.toggle.navigation"/></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><fmt:message bundle="${home}" key="home.title"/></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <c:url var="newsPage" value="/news"/>
                <li><a href="${newsPage}"><fmt:message bundle="${home}" key="home.news"/></a></li>
                <c:url var="myPage" value="/myPage"/>
                <li><a href="${myPage}"><fmt:message bundle="${home}" key="home.my.page"/></a></li>
            </ul>
            <c:url var="localePage" value="/locale"/>
            <c:set var="currentUrl" value="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}"/>
            <form class="navbar-form navbar-right" action="${localePage}" method="post">
                <input type="hidden" name="locale" value="en">
                <input type="hidden" name="redirect_to" value="${currentUrl}"/>
                <div class="form-group">
                    <fmt:message var="enTitle" bundle="${home}" key="home.select.en"/>
                    <button type="submit" class="btn flag-icon flag-icon-gb-eng" title="${enTitle}"></button>
                </div>
            </form>
            <form class="navbar-form navbar-right" action="${localePage}" method="post">
                <input type="hidden" name="locale" value="ru">
                <input type="hidden" name="redirect_to" value="${currentUrl}"/>
                <div class="form-group">
                    <fmt:message var="ruTitle" bundle="${home}" key="home.select.ru"/>
                    <button type="submit" class="btn flag-icon flag-icon-ru" title="${ruTitle}"></button>
                </div>
            </form>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
    <jsp:doBody/>
</div>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

<!-- Where all the magic happens -->
<!-- LOGIN FORM -->

</body>
</html>
