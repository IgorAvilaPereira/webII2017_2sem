<%-- 
    Document   : tela_adicionar
    Created on : 13/10/2017, 20:51:28
    Author     : iapereira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/convidado/editar" method="post">
            Nome:   <input type="text" name="convidado.nome" value="${convidado.nome}">
            Fantasia: <input type="text" name="convidado.fantasia" value="${convidado.fantasia}">            
            <input type="hidden" name="convidado.id" value="${convidado.id}">
            <input type="submit">            
        </form>
    </body>
</html>
