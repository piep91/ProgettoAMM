<%-- 
    Document   : profilo
    Created on : 30-apr-2017, 15.17.13
    Author     : Pierandrea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook - Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Pierandrea Spiga">
        <meta name="keywords" content="social nerd">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <c:if test="${accessDenied==true}">
            <div id="error">Accesso negato</div>
        </c:if>
        
        <c:if test="${accessDenied==null || accessDenied!=true}">
            <!--header-->
            <c:set var="id" value="title" scope="request"/>
            <jsp:include page="header.jsp"/>

            <div id="navBar">
                <nav>
                    <ol>
                        <li class="active"><a href="profilo.html">Profilo</a></li><!--
                        --><li><a href="bacheca.html">Bacheca</a></li>
                    </ol>
                    <div id="logout">
                        ${nerd.nome}
                        <a href="login.html?logout=1">Logout</a>
                    </div>
                </nav>
            </div>
            <div id="divBody">
                <!--barra laterale-->
                <jsp:include page="lat_col.jsp"/>

                <form action="profilo.html" method="post">
                    <div id="mod_profile">
                        <h2>Modifica profilo personale</h2>
                        <label for="name">Nome</label>
                        <input type="text" name="name" id="name"/><br>
                        <label for="surname">Cognome</label>
                        <input type="text" name="surname" id="surname"/><br>
                        <label for="img">Immagine profilo</label>
                        <input type="url" name="img" id="img"/><br>
                        <label for="pres">Frase di presentazione</label>
                        <textarea rows="3" cols="20" name="pres" id="pres"></textarea><br>
                        <label for="bday">Data di nascita</label>
                        <input type="date" name="bday" id="bday"/><br>
                        <label for="psw">Password</label>
                        <input type="password" name="psw" id="psw"/><br>
                        <label for="c_psw">Conferma password</label>
                        <input type="password" name="c_psw" id="c_psw"/><br>
                        <button type="submit">Applica</button>
                        <c:if test="${profileModified == true}">
                            <div id="confirm">Dati aggiornati</div>
                        </c:if>
                    </div>
                </form>
                <form action="profilo.html?delete=-1" method="post">
                    <div>
                        <button type="submit">Elimina Profilo</button>
                        <c:if test="${deleteError == true}">
                                <div id="dError">Errore</div>
                        </c:if>
                    </div>
                </form>
            </div>
        </c:if>
    </body>
</html>
