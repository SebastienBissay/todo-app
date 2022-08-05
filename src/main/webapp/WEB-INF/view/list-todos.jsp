<%-- 
    Document   : list-todos
    Created on : 5 août 2022, 12:17:03
    Author     : Sebastien Bissay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>TODO</title>
    </head>
    <body>
        <h1>Here are the tasks you have to do, <security:authentication property="principal.username" /></h1>
        <hr/>
        <table>
            <tr>
                <th>Target Date</th>
                <th>User</th>
                <th>Description</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="task" items="${todoList}">
                <tr>
                    <td><c:out value="${task.targetDate}" /></td>
                    <td><c:out value="${task.username}" /></td>
                    <td><c:out value="${task.description}" /></td>
                    <td>
                        <form:form action="/update-todo" method="GET" modelAttribute="todo">
                            <form:hidden path="id" value="${task.id}"/>
                            <input type="submit" value="Modify">
                        </form:form>
                    </td>
                    <td>
                        <form:form action="/update-todo" method="GET" modelAttribute="todo">
                            <form:hidden path="id" value="${task.id}"/>
                            <input type="submit" value="Delete">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
                <tr>
                    <td colspan="5">
                        <form:form action="/add-todo" method="GET">
                            <input type="submit" value ="Add new task to do" />
                        </form:form>
                        </td>
                </tr>
        </table>
    </body>
</html>
