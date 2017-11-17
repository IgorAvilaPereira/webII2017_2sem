<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VRaptor Blank Project</title>
    </head>
    <body>
        It works!! ${variable} ${linkTo[IndexController].index}

        <ul>
            <c:forEach items="${vetUsuario}" var="usuario">
                <li>
                    <a href="${pageContext.request.contextPath}/tchan/${usuario.id}"> Excluir </a>  
                    <a href="${pageContext.request.contextPath}/virguloides/${usuario.id}">Alterar</a>  
                    ${usuario.nome}
                </li>
           </c:forEach>
        </ul>
      <a href="${pageContext.request.contextPath}/aquaman"> Adicionar </a>  

    </body>
</html>