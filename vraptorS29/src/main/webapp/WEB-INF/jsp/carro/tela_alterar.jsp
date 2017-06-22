<%-- 
    Document   : tela_adicionar
    Created on : 03/05/2017, 20:03:41
    Author     : ricardo
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="./../header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b> Atualizar cadastro</b></h5>
</header>

<div class="w3-container w3-white w3-padding-32">
    <div class="w3-row">
        <form class="w3-container w3-card-4 w3-light-grey" action="${pageContext.request.contextPath}/carro/alterar" method="post">
            <p><label>Modelo:</label>
                <input class="w3-input w3-border" name="carro.modelo" type="text" value="${carro.modelo}"></p>
            <p><label>Marca:</label>
                <input class="w3-input w3-border" name="carro.marca" type="text" value="${carro.marca}"></p>
            <p><label>Ano:</label>
                <input class="w3-input w3-border" name="carro.ano" type="text" value="${carro.ano}"></p>
            <p><label>Valor (R$):</label>
                <input class="w3-input w3-border" name="carro.valor" type="text" value="<fmt:formatNumber value="${carro.valor}" minFractionDigits="2" type="number"/>"></p>

            <input type="hidden" name="carro.id" value="${carro.id}">
            <input type="submit" value="Atualizar" class="w3-btn w3-blue-grey"><br><br>
        </form>
    </div>
</div>

<%@include file="./../footer.jsp" %>