<%-- 
    Document   : bacheca
    Created on : 30-apr-2017, 15.11.13
    Author     : Pierandrea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook - Bacheca</title>
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
                        <li><a href="profilo.html">Profilo</a></li><!--
                        --><li class="active"><a href="bacheca.html">Bacheca</a></li>
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

                <div id="post">
                    <div>
                        <form action="bacheca.html" method="post">
                            <h3>Bacheca di ${user_bacheca.nome}</h3>
                            <h2>Pubblica un nuovo post</h2>
                            <textarea rows="3" cols="20" name="cont" id="pres"></textarea><br>
                            <button type="submit">Conferma</button>
                            <c:if test="${newPost == true}">
                                <p>Post pubblicato</p>
                            </c:if>
                        </form>
                    </div>
                    <c:forEach var="post" items="${posts}">
                        <div>
                            <div>
                                <img alt="immagine_profilo" class="img_pro" src="${post.utente.urlFotoProfilo}">
                                <h3>${post.utente.nome}</h3>
                            </div>
                            <c:if test="${post.tipoPost == 'TEXT'}">
                                <p>${post.content}</p>
                            </c:if>
                            <c:if test="${post.tipoPost == 'IMAGE'}">
                                <img alt="allegato" class="allegato" src="${post.urlImg}">
                            </c:if>
                            <c:if test="${post.tipoPost == 'T_AND_I'}">
                                <p>${post.content}</p>
                                <img alt="allegato" class="allegato" src="${post.urlImg}">
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>
    </body>
</html>
