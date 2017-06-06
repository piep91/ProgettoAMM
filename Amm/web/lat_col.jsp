<%-- 
    Document   : lat_col
    Created on : 30-apr-2017, 16.27.46
    Author     : Pierandrea
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="lat_col">
    <h2>Persone</h2>
    <div id="searchNerd">
        <input id="searchField" type="text" placeholder="cerca utente" value="">
        <button id="searchUser">Cerca</button>
    </div>
    <div id="usersList">
        <ul>
            <c:forEach var="nerd_b" items="${listaNerd}">
                <li><a href="bacheca.html?b_id=${nerd_b.id}">${nerd_b.nome} ${nerd_b.cognome}</a></li>
            </c:forEach>
        </ul>
    </div>
    <h2>Gruppi</h2>
    <ul>
        <li>Consolari</li>
        <li>PCisti</li>
    </ul>
</div>
