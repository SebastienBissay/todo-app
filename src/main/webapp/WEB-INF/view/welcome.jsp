<%-- 
    Document   : welcome
    Created on : 5 août 2022, 12:04:17
    Author     : Sebastien Bissay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>TODO</title>
        </head>
        <body>
            <p>
                Welcome <security:authentication property="principal.username" />! <a href="list-todos">Click here</a> to manage your todo's.
            </p>
        </body>
    </html>
