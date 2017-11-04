<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mesa ayuda CGTI</title>
</head>
<body>
    <h1>Lista  Artículos</h1>
    <table>
        <tr>
            <td><a href="usuario?action=index" >Ir al menú</a> </td>
        </tr>
    </table>

    <table border="1" width="100%">
        <tr>
            <td>USUARIO</td>
            <td>CONTRASEÑA</td>
            <td colspan=2>OPCIONES</td>
        </tr>
        <c:forEach var="usuario" items="${lista}">
            <tr>
                <td><c:out value="${usuario.usuario}"/></td>
                <td><c:out value="${usuario.contrasenia}"/></td>
                <td><a href="usuario?action=showedit&id=<c:out value="${usuario.usuario}" />">Editar</a></td>
                <td><a href="usuario?action=eliminar&id=<c:out value="${usuario.usuario}"/>">Eliminar</a> </td>				
            </tr>
        </c:forEach>
    </table>
</body>
</html>