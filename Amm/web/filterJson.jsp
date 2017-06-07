<%-- 
    Document   : filterJson
    Created on : 7-giu-2017, 15.20.41
    Author     : Pierandrea
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="nerd" items="${listaNerd}">
        <json:object>
            <json:property name="nome" value="${nerd.nome}"/>
            <json:property name="cognome" value="${nerd.cognome}"/>
            <json:property name="id" value="${nerd.id}"/>
            <json:property name="pres" value="${nerd.pres}"/>
            <json:property name="password" value="${nerd.password}"/>
            <json:property name="urlFotoProfilo" value="${nerd.urlFotoProfilo}"/>
        </json:object>
    </c:forEach>
</json:array>
