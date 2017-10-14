<%-- 
    Document   : listar
    Created on : 13/10/2017, 20:21:26
    Author     : iapereira
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${mensagem}
        <ul>
            <c:forEach items="${convidadoList}" var="convidado">
                <li>
                    <a href="${pageContext.request.contextPath}/convidado/excluir/${convidado.id}"> Excluir </a> 
                    <a href="${pageContext.request.contextPath}/convidado/tela_editar/${convidado.id}"> Editar </a> 
                    ${convidado.nome} - ${convidado.fantasia} 
                </li>            
            </c:forEach>
        </ul>
        <a href="${pageContext.request.contextPath}/convidado/tela_adicionar">Adicionar </a>
    </body>
</html>
