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
                    Pieppo
                    <a href="login.html?logout=1">Logout</a>
                </div>
            </nav>
        </div>
        <div id="divBody">
            <!--barra laterale-->
            <jsp:include page="lat_col.jsp"/>
            
            <div id="post">
                <div>
                    <div>
                        <img alt="immagine_profilo" class="img_pro" src="img/Profile01.png">
                        <h3>Gigi</h3>
                    </div>
                    <p>Primo post in assoluto su Nerdbook!</p>
                </div>
                <div>
                    <div>
                        <img alt="immagine_profilo" class="img_pro" src="img/Profile02.jpg">
                        <h3>Wowo</h3>
                    </div>
                    <p>Sono arrivato tardi</p>
                    <img alt="allegato" class="allegato" src="img/allegato_post.jpg">
                </div>
                <div>
                    <div>
                        <img alt="immagine_profilo" class="img_pro" src="img/Profile03.png">
                        <h3>Gianni</h3>
                    </div>
                    <p>Iscrivetevi a questo sito di cashback!</p>
                    <a href="http://it.beruby.com/promocode/uVjKCl" target="_blank">http://it.beruby.com/promocode/uVjKCl</a>
                </div>
            </div>
        </div>
    </body>
</html>
