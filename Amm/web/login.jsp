<%-- 
    Document   : login
    Created on : 30-apr-2017, 15.16.18
    Author     : Pierandrea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook - Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Pierandrea Spiga">
        <meta name="keywords" content="social nerd">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <!--header-->
        <c:set var="id" value="title_login" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <div id="divBody">
            <c:if test="${invalidData == true}">
                    <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
            </c:if>
            
            <form action="servlet.java" method="post">
                <div id="formLogin">
                    <label for="user_id">Nome Utente</label>
                    <input type="text" name="user_id" id="user_id"/>
                    <label for="psw">Password</label>
                    <input type="password" name="psw" id="psw"/><br>
                    <button type="submit">Accedi</button>
                </div>
            </form>
        </div>
    </body>
</html>
