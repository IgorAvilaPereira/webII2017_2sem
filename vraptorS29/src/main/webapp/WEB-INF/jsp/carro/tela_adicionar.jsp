<%-- 
    Document   : tela_adicionar
    Created on : 03/05/2017, 20:03:41
    Author     : ricardo
--%>

<%@include file="./../header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b> Cadastrar Carro</b></h5>
</header>

<div class="w3-container w3-white w3-padding-32">
    <div class="w3-row">
        <form class="w3-container w3-card-4 w3-light-grey" action="${pageContext.request.contextPath}/carro/adicionar" method="post" enctype="multipart/form-data">
            <p><label>Modelo:</label>
                <input class="w3-input w3-border" name="carro.modelo" type="text"></p>
            <p><label>Marca:</label>
                <input class="w3-input w3-border" name="carro.marca" type="text"></p>
            <p><label>Ano:</label>
                <input class="w3-input w3-border" name="carro.ano" type="text"></p>
            <p><label>Valor (R$):</label>
                <input class="w3-input w3-border" name="carro.valor" type="text"></p>
            <p><label>Imagem:</label>
                <input class="w3-input w3-border" name="file" type="file"></p>
            <input type="submit" value="Cadastrar" class="w3-btn w3-blue-grey"><br><br> 
        </form>
    </div>
</div>

<%@include file="./../footer.jsp" %>