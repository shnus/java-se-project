<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="i18n.logon" var="log_on" />
<fmt:setBundle basename="i18n.login" var="log" />
<fmt:message var="title" bundle="${log_on}" key="logon.title"/>
<jsp:useBean id="validation" class="com.nusrat.java.drive_club.service.Validation" scope="request"/>
<tags:page title="${title}">
    <script>
        var $image_b64;

        $(document).ready(function() {
            $("#update").click(function () {
                sendProfile();
            });
        });

        console.log("ready");

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                console.log(document.getElementById("file").value)
                reader.onload = function (e) {
                    $('#image')
                        .attr('src', e.target.result)
                        .width(300)
                        .height(300);
                    $image_b64 = e.target.result;
                };

                reader.readAsDataURL(input.files[0]);
            }
        }

        function sendProfile() {

            var obj = '{'
                +'"login" : "'+$("#login").val()+'",'
                +'"password" : "'+$("#password").val()+'",'
                +'"firstName" : "'+$("#First_name").val()+'",'
                +'"lastName" : "'+$("#Last_name").val()+'",'
                +'"birthDate" : "'+$("#profile_date_year").val()+'-'
                +$("#profile_date_month").val()+'-'+$("#profile_date_day").val()+'",'
                +'"image_b64" : "'+$image_b64+'",'
                +'"location" : "'+$("#location").val()+'",'
                +'"gender" : "'+$("#gender").val()+'"'
                +'}';

            alert(obj);

            $.ajax({
                type: "POST",
                url: "logon",
                contentType: "application/json",
                data: obj,
                success: function (msg, status, jqXHR) {
                    document.open();
                    document.write(msg);
                    document.close();
                }
            });

            $image_b64="";
        }
    </script>


    <fmt:message var="create_profile" bundle="${log_on}" key="logon.create.profile"/>
    <fmt:message var="your_name" bundle="${log_on}" key="logon.your.name"/>
    <fmt:message var="first_name" bundle="${log_on}" key="logon.first.name"/>
    <fmt:message var="ext_prof" bundle="${log_on}" key="logon.extended.profile"/>
    <fmt:message var="last_name" bundle="${log_on}" key="logon.last.name"/>
    <fmt:message var="photo" bundle="${log_on}" key="logon.photo"/>
    <fmt:message var="location" bundle="${log_on}" key="logon.location"/>
    <fmt:message var="gender" bundle="${log_on}" key="logon.gender"/>
    <fmt:message var="birthday" bundle="${log_on}" key="logon.birthday"/>
    <fmt:message var="male" bundle="${log_on}" key="logon.male"/>
    <fmt:message var="female" bundle="${log_on}" key="logon.female"/>
    <fmt:message var="cancel" bundle="${log_on}" key="logon.cancel"/>
    <fmt:message var="place" bundle="${log_on}" key="logon.place"/>
    <fmt:message var="login" bundle="${log}" key="login.login"/>
    <fmt:message var="password" bundle="${log}" key="login.password"/>
    <fmt:message var="credentials" bundle="${log}" key="login.credentials"/>
    <fmt:message var="invalid" bundle="${log_on}" key="logon.invalid"/>
    <fmt:message var="invalidEmail" bundle="${log_on}" key="logon.invalid.email"/>
    <fmt:message var="userExist" bundle="${log_on}" key="logon.user.exist"/>

    <div class="mainbody container-fluid">
        <div class="row" align="center" >
            <div style="width: 50%;">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h1 class="panel-title pull-left" style="font-size:30px;">
                            <c:out value="${create_profile}"/>
                        </h1>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="panel-title pull-left">
                            <c:out value="${credentials}"/>
                        </h3>
                        <br><br>
                        <c:if test="${validation.valid.USER_EXIST}">
                            <div class="alert alert-danger">
                                <c:out value="${userExist}"/>
                            </div>
                        </c:if>
                        <c:if test="${validation.valid.INVALID_EMAIL}">
                            <div class="alert alert-danger">
                                <c:out value="${invalidEmail}"/>
                            </div>
                        </c:if>
                        <label for="name" class="sr-only">${login}</label>
                        <input  type="email" id="login" class="form-control" placeholder="${login}" name="login" required autofocus>
                        <label for="pwd" class="sr-only">${password}</label>
                        <input type="password" id="password" class="form-control" placeholder="${password}" name="password" required>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="panel-title pull-left">
                            <c:out value="${your_name}"/>
                        </h3>
                        <br><br>
                        <c:if test="${validation.valid.INVALID_NAME}">
                            <div class="alert alert-danger">
                                <c:out value="${invalid}"/>
                            </div>
                        </c:if>
                        <form class="form-horizontal">
                            <input type="text" class="form-control" id="First_name" placeholder="${first_name}">
                            <input type="email" class="form-control" id="Last_name" placeholder="${last_name}">
                        </form>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="panel-title pull-left">
                            <c:out value="${photo}"/>
                        </h3>
                        <br><br>
                        <div align="center">
                            <div class="col-lg-12 col-md-12">
                                <img id="image" class="img-thumbnail img-responsive" src="https://lut.im/7JCpw12uUT/mY0Mb78SvSIcjvkf.png" width="300px" height="300px">
                            </div>
                            <div class="col-lg-12 col-md-12">
                                <input type="file" name="file" id="file" class="inputfile" accept="image/gif, image/jpeg, image/png"  onchange="readURL(this);" />
                                <label for="file" class="btn btn-primary">Upload a profile photo!</label>
                                <style>
                                    .inputfile {
                                        width: 0.1px;
                                        height: 0.1px;
                                        opacity: 0;
                                        overflow: hidden;
                                        position: absolute;
                                        z-index: -1;
                                    }
                                </style>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="panel-title pull-left"><c:out value="${ext_prof}"/></h3>
                        <br/>
                        <br/>
                        <form class="form-horizontal">
                            <label for="location">
                                <c:out value="${location}"/>
                            </label>
                            <input type="text" class="form-control" id="location" placeholder="${place}">
                            <br>
                            <label for="gender">
                                <c:out value="${gender}"/>
                            </label>
                            <select id="gender" name="gender" class="form-control">
                                <option value="Male" selected>
                                    <c:out value="${male}"/>
                                </option>
                                <option value="Female">
                                    <c:out value="${female}"/>
                                </option>
                            </select>
                            <br>
                            <label>
                                <c:out value="${birthday}"/>
                            </label>
                            <div class="form-inline" id="birth-date">
                                <select id="profile_date_year" name="profile[date][year]" class="form-control">
                                    <option value="!" selected="selected">Year</option>
                                    <option value="2003">2003</option>
                                    <option value="2002">2002</option>
                                    <option value="2001">2001</option>
                                    <option value="2000">2000</option>
                                    <option value="1999">1999</option>
                                    <option value="1998">1998</option>
                                    <option value="1997">1997</option>
                                    <option value="1996">1996</option>
                                    <option value="1995">1995</option>
                                    <option value="1994">1994</option>
                                    <option value="1993">1993</option>
                                    <option value="1992">1992</option>
                                    <option value="1991">1991</option>
                                    <option value="1990">1990</option>
                                    <option value="1989">1989</option>
                                    <option value="1988">1988</option>
                                    <option value="1987">1987</option>
                                    <option value="1986">1986</option>
                                    <option value="1985">1985</option>
                                    <option value="1984">1984</option>
                                    <option value="1983">1983</option>
                                    <option value="1982">1982</option>
                                    <option value="1981">1981</option>
                                    <option value="1980">1980</option>
                                    <option value="1979">1979</option>
                                    <option value="1978">1978</option>
                                    <option value="1977">1977</option>
                                    <option value="1976">1976</option>
                                    <option value="1975">1975</option>
                                    <option value="1974">1974</option>
                                    <option value="1973">1973</option>
                                    <option value="1972">1972</option>
                                    <option value="1971">1971</option>
                                    <option value="1970">1970</option>
                                    <option value="1969">1969</option>
                                    <option value="1968">1968</option>
                                    <option value="1967">1967</option>
                                    <option value="1966">1966</option>
                                    <option value="1965">1965</option>
                                    <option value="1964">1964</option>
                                    <option value="1963">1963</option>
                                    <option value="1962">1962</option>
                                    <option value="1961">1961</option>
                                    <option value="1960">1960</option>
                                    <option value="1959">1959</option>
                                    <option value="1958">1958</option>
                                    <option value="1957">1957</option>
                                    <option value="1956">1956</option>
                                    <option value="1955">1955</option>
                                    <option value="1954">1954</option>
                                    <option value="1953">1953</option>
                                    <option value="1952">1952</option>
                                    <option value="1951">1951</option>
                                    <option value="1950">1950</option>
                                    <option value="1949">1949</option>
                                    <option value="1948">1948</option>
                                    <option value="1947">1947</option>
                                    <option value="1946">1946</option>
                                    <option value="1945">1945</option>
                                    <option value="1944">1944</option>
                                    <option value="1943">1943</option>
                                    <option value="1942">1942</option>
                                    <option value="1941">1941</option>
                                    <option value="1940">1940</option>
                                    <option value="1939">1939</option>
                                    <option value="1938">1938</option>
                                    <option value="1937">1937</option>
                                    <option value="1936">1936</option>
                                    <option value="1935">1935</option>
                                    <option value="1934">1934</option>
                                    <option value="1933">1933</option>
                                    <option value="1932">1932</option>
                                    <option value="1931">1931</option>
                                    <option value="1930">1930</option>
                                    <option value="1929">1929</option>
                                    <option value="1928">1928</option>
                                    <option value="1927">1927</option>
                                    <option value="1926">1926</option>
                                    <option value="1925">1925</option>
                                    <option value="1924">1924</option>
                                    <option value="1923">1923</option>
                                    <option value="1922">1922</option>
                                    <option value="1921">1921</option>
                                    <option value="1920">1920</option>
                                    <option value="1919">1919</option>
                                    <option value="1918">1918</option>
                                    <option value="1917">1917</option>
                                    <option value="1916">1916</option>
                                    <option value="1915">1915</option>
                                    <option value="1914">1914</option>
                                    <option value="1913">1913</option>
                                    <option value="1912">1912</option>
                                    <option value="1911">1911</option>
                                    <option value="1910">1910</option>
                                    <option value="1909">1909</option>
                                    <option value="1908">1908</option>
                                    <option value="1907">1907</option>
                                    <option value="1906">1906</option>
                                    <option value="1905">1905</option>
                                    <option value="1904">1904</option>
                                    <option value="1903">1903</option>
                                    <option value="1902">1902</option>
                                    <option value="1901">1901</option>
                                    <option value="1900">1900</option>
                                    <option value="1899">1899</option>
                                    <option value="1898">1898</option>
                                    <option value="1897">1897</option>
                                    <option value="1896">1896</option>
                                    <option value="1895">1895</option>
                                    <option value="1894">1894</option>
                                    <option value="1893">1893</option>
                                    <option value="1892">1892</option>
                                    <option value="1891">1891</option>
                                </select>
                                <select id="profile_date_month" name="profile[date][month]" class="form-control">
                                    <option value="!" selected="selected">Month</option>
                                    <option value="01">January</option>
                                    <option value="02">February</option>
                                    <option value="03">March</option>
                                    <option value="04">April</option>
                                    <option value="05">May</option>
                                    <option value="06">June</option>
                                    <option value="07">July</option>
                                    <option value="08">August</option>
                                    <option value="09">September</option>
                                    <option value="10">October</option>
                                    <option value="11">November</option>
                                    <option value="12">December</option>
                                </select>
                                <select id="profile_date_day" name="profile[date][day]" class="form-control">
                                    <option value="!" selected="selected">Day</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                </select>
                            </div>
                        </form>
                    </div>
                </div>
                        <button id="cancel" class="btn btn-default"><i class="fa fa-fw fa-times" aria-hidden="true"></i>
                            <c:out value="${cancel}"/>
                        </button>
                        <button id="update" class="btn btn-primary"><i class="fa fa-fw fa-check" aria-hidden="true"></i>
                            <c:out value="${create_profile}"/>
                        </button>
                <br/>
                <br/>


            </div>
        </div>
    </div>
</tags:page>