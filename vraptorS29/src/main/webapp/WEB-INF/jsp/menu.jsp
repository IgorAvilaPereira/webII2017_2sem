<%-- 
    Document   : menu
    Created on : 11/03/2017, 23:37:32
    Author     : TADS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<nav class = "w3-sidebar w3-bar-block w3-collapse w3-card-2" style = "z-index:1;width:200px;" id = "mySidebar">
    <div><br>&nbsp;&nbsp;&nbsp;Thanks for playing</div><br>
    <a class = "w3-bar-item w3-button w3-hover-teal w3-hide-large w3-closenav w3-large" href = "javascript:void(0)" onclick = "w3_close()">Close <i class = "fa fa-remove"></i></a>
    <a class = "w3-bar-item w3-button w3-light-grey w3-medium" href="${pageContext.request.contextPath}/">Início</a>

    <div>
        <a class = "w3-bar-item w3-button" onclick = "myAccordion('demo')" href = "javascript:void(0)">Revenda de carros <i class = "fa fa-caret-down"></i></a>
        <div id = "demo" class="w3-hide">
            <a class = "w3-bar-item w3-button" href="${pageContext.request.contextPath}/carro/tela_adicionar">Cadastrar</a>
            <a class = "w3-bar-item w3-button" href="${pageContext.request.contextPath}/">Listar</a>
        </div>
    </div>

</nav>