<%-- 
    Document   : add-todo
    Created on : 5 août 2022, 13:58:13
    Author     : Sebastien Bissay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>TODO</title>
    </head>
    <body>
        <h1>Create of update a task to do</h1>
        <hr/>
        <form:form method="POST"  action="/add-todo" modelAttribute="todo">
            <form:hidden path="id" />
            <table>
                <tr>
                    <td><label for = "targetDate">Target date (yyyy-MM-dd)</label></td>
                    <td><input type="date" name="targetDate" value="${todo.targetDate}" id="targetDate"/></td>
                </tr>
                <form:errors path="targetDate" />
                <tr>
                    <td><form:label path = "username">User</form:label></td>
                    <td><form:input path = "username" /></td>
                </tr>
                <tr>
                    <td><form:label path = "description">Description</form:label></td>
                    <td><form:textarea path = "description" /></td>
                </tr>
                <tr>
                    <td colspan = "3">
                        <input type ="submit" value ="Submit" />
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
