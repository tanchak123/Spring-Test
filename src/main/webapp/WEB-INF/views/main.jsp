    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 21.07.2020
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/"><h1>MAIN</h1></a>
    <a href="${pageContext.request.contextPath}/hello"><h1>HELLO</h1></a>
    <form action="#" method="get" id="abc" ><h1 >${abc}</h1></form>
    <form action="#" method="get"></form>
        <form action="#" method="get">
            <label for="fname">First name:</label>
            <input type="text" id="fname" name="fname"><br><br>
            <label for="lname">Last name:</label>
            <input type="text" id="lname" name="lname"><br><br>
            <input type="submit" value="Submit">
            <c:set var = "fname" scope = "session" value = "${param.fname}"/>
            <c:if test = "${fname != null}">
            <p>My salary is:  <c:out value = "${fname}"/><p>
            </c:if>
                <c:set var = "salary" scope = "session" value = "${2000*2}"/>
                <c:if test = "${salary > 2000}">
            <p>My salary is:  <c:out value = "${salary}"/><p>
            </c:if>
        </form>
</body>
</html>
