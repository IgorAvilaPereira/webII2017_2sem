<%-- 
    Document   : tela_alterar
    Created on : 17/11/2017, 20:10:24
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
        <h1>Hello World!</h1>
        <form action="${pageContext.request.contextPath}/charliebrown" method="post">
            Nome: <input name="usuario.nome" type="text" value="${usuario.nome}">
            
            <input type="hidden" name="usuario.id" value="${usuario.id}">
            
            <input type="submit">
        </form>   
    </body>
</html>
