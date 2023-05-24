<%-- 
    Document   : formularioClientes
    Created on : 09-may-2023, 17:58:30
    Author     : Alberturris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar Clientes</h1>
        
        <form:form action="insertarCliente" modelAttribute="cliente" method="POST">
            
            <form:hidden path="id" />
            
            <table>
                <tr>
                    <td>Nombre: </td>
                    <td><form:input path="nombre"/></td>
                    <td><form:errors path="nombre" style="color:red"/></td>
                </tr>
                <tr>
                    <td>Apellido: </td>
                    <td><form:input path="apellido"/></td>
                    <td><form:errors path="apellido" style="color:red"/></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><form:input path="email"/></td>
                    <td><form:errors path="email" style="color:red"/></td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Insertar">
        </form:form>
        
        
    </body>
</html>
