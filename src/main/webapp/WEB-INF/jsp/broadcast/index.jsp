<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <c:url var="jqui" value="/static/css/jquery-ui.min.css"/>
    <link rel="stylesheet" href="${jqui}" />

    <c:url var="jquery" value="/static/js/jquery-3.1.1.min.js"/>
    <script language="JavaScript" type="text/javascript" src="${jquery}"> </script>
</head>

<script>
    $(document).ready(function() {
        $("but").click(function () {
            $.post("broadcast",
                {
                    name: "Donald Duck",
                    city: "Duckburg"
                },
                function (data, status) {
                    alert("Data: " + data.toString() + "\nStatus: " + status);
                });
        });
    });

    var obj = '{'
        +'"input" : "Nusrat"'
        +'}';

    $.ajax({
        type: "POST",
        url: "broadcast",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: window.alert("inside aJax statement")
    });

</script>
<body>
<div id="result">

    <form>
        <input  name="hui" placeholder="Put message here"/>
        <input  name="hui2" placeholder="Put message here"/>
        <input type="submit" value="OK"/>
    </form>

    <button id="but">Send an HTTP POST request to a page and get the result back</button>

</div>
</body>
