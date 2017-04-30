<%-- 
    Document   : descrizione
    Created on : 30-apr-2017, 15.22.03
    Author     : Pierandrea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook - Descrizione</title>
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
        
        <div id="description">
            <br><h1>Descrizione generale del sito</h1>
            <h2>Sommario</h2>
            <ol>
                <li><a href="#question_p1">Caratteristiche</a></li>
                <li><a href="#question_p2">Informazioni sulla registrazione</a></li>
                <li><a href="#question_p3">Funzionalità</a></li>
            </ol>
            <div id="question_p1">
                <h3>Quali sono le caratteristiche fondamentali del sito?</h3>
                <p id="p1">Nerdbook nasce come un social network che permette di conoscere e stringere amicizia con altri utenti nerd in tutta semplicità</p>
            </div>
            <div id="question_p2">
                <h3>La registrazione è gratuita?</h3>
                <p id="p2">La registrazione è completamente gratuita, basta compilare un semplice form d'iscrizione per iniziare a navigare su Nerdbook</p>
            </div>
            <div id="question_p3">
                <h3>Quali sono le principali funzioni che si possono effettuare sul sito?</h3>
                <p id="p3">Dopo la registrazione si potranno inserire le informazioni personali, stringere amicizia con altri utenti, creare e gestire gruppi, inserire post nella propria bacheca o in quella degli amici</p>
            </div>
        </div>
    </body>
</html>
