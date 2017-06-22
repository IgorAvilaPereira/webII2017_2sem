<%-- 
    Document   : tela_adicionar
    Created on : 24/05/2017, 20:32:30
    Author     : AsusRicardoFonseca
--%>

<%@include file="./../header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b> Cadastrar Usuário</b></h5>
</header>

<div class="w3-container w3-white w3-padding-32">
    <div class="w3-row">
        <form class="w3-container w3-card-4 w3-light-grey" action="${pageContext.request.contextPath}/usuario/adicionar" method="post">
            <p><label>Nome</label>
                <input class="w3-input w3-border" name="usuario.modelo" type="text"></p>
            <p><label>Senha:</label>
                <input class="w3-input w3-border" name="usuario.marca" type="text"></p>
            <input type="submit" value="Cadastrar" class="w3-btn w3-blue-grey"><br><br> 
        </form>
    </div>
</div>

<%@include file="./../footer.jsp" %>