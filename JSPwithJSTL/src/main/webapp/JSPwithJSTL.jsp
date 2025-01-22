<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="error.jsp" %>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Input Example with JSTL</title>
</head>
<body>

    <h1>User Input Form</h1>

    <form action="" method="post">
        <label for="name">Name: </label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="password">Password: </label>
        <input type="password" id="password" name="password"><br><br>

        <input type="submit" value="Submit">
    </form>

    <!-- Set the 'name' and 'password' parameters -->
    <c:set var="name" value="${param.name}" />
    <c:set var="password" value="${param.password}" />

    <c:choose>
        <!-- Check if both name and password are not empty -->
        <c:when test="${not empty name and not empty password}">
            <h2>Login Successfully</h2>
            <p><b>Name: </b>${name}</p>
            <p><b>Password: </b>${password}</p>

            <!-- JSTL forEach Example to display table of squares -->
            <p>Table of Squares: </p>
            <table border="1">
                <tr>
                    <th>Number</th>
                    <th>Square</th>
                </tr>

                <c:forEach var="i" begin="1" end="5">
                    <tr>
                        <td>${i}</td>
                        <td>${i*i}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <c:otherwise>
            <!-- Check if the name and password are not 'sarthak' and '1234' -->
            <c:if test="${not (name == 'sarthak' && password == '1234')}">
                <c:redirect url="error.jsp" />
            </c:if>

            <!-- If name or password is empty -->
            <c:if test="${empty name or empty password}">
                <p>Please enter your information above!</p>
            </c:if>
        </c:otherwise>

    </c:choose>

</body>
</html>
