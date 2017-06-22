<%-- 
    Document   : tela_alterar
    Created on : 24/05/2017, 20:32:45
    Author     : AsusRicardoFonseca
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="./../header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b> Atualizar cadastro</b></h5>
</header>

<div class="w3-container w3-white w3-padding-32">
    <div class="w3-row">
        <form class="w3-container w3-card-4 w3-light-grey" action="${pageContext.request.contextPath}/usuario/alterar" method="post">
            <p><label>Login:</label>
                <input class="w3-input w3-border" name="carro.modelo" type="text" value="${usuario.login}"></p>
            <p><label>Senha</label>
                <input class="w3-input w3-border" name="carro.marca" type="text" value="${usuario.senha}"></p>
                    <input type="hidden" name="usuario.id" value="${usuario.id}">
            <input type="submit" value="Atualizar" class="w3-btn w3-blue-grey"><br><br>
        </form>
    </div>
</div>

<%@include file="./../footer.jsp" %>