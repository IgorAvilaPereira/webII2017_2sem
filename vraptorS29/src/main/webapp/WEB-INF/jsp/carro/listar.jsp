<%-- 
    Document   : listar
    Created on : 03/04/2017, 14:48:09
    Author     : Ricardo Fonseca
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b> Lista de carros, cadastrados no revenda!</b></h5>
</header>

<table class="w3-table-all w3-centered w3-card-4">
    <tr>
        <td><b>Modelo</b></td>
        <td><b>Marca</b></td>
        <td><b>Ano</b></td>
        <td><b>Valor</b></td>
        <td><b>Operações</b></td>
    </tr>  
    <c:forEach items="${carroList}" var="carro">
        <tr>
            <td> ${carro.modelo} </td>
            <td> ${carro.marca} </td>
            <td> ${carro.ano} </td>
            <td> ${carro.valor} </td>
            <td> <img src="${pageContext.request.contextPath}/carro/imagem/${carro.id}"></td>
            <td> <a href="${pageContext.request.contextPath}/carro/excluir/${carro.id}" class="fa fa-trash">&nbsp;Excluir</a>
            &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/carro/tela_alterar/${carro.id}" class="fa fa-edit">&nbsp;Alterar</a></td> 
        </tr>
    </c:forEach>
</table>

<%@include file="./../footer.jsp" %>