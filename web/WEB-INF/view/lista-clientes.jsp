<%-- 
    Document   : listaClientes
    Created on : 08-may-2023, 19:17:01
    Author     : Alberturris
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
        <title>Lista de Clientes</title>
    </head>
    <body>
        <h1>Esta es la lista de clientes:</h1>
        
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Modificar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="clienteAux" items="${clientes}">
                
                <!-- Link para actualizar -->
                <c:url var="linkActualizar" value="/controlador/muestraFormularioActualizar">
                    <c:param name="clienteId" value="${clienteAux.getId()}"/>    
                </c:url>
                
                <!-- Link para eliminar -->
                <c:url var="linkEliminar" value="/controlador/eliminar">
                    <c:param name="clienteId" value="${clienteAux.getId()}"/>    
                </c:url>
                
                <tr>
                    <td>${clienteAux.nombre}</td>
                    <td>${clienteAux.apellido}</td>
                    <td>${clienteAux.email}</td>
                    <td><a href="${linkActualizar}"><input type="button" value="Modificar"/></a></td>
                    <td><a href="${linkEliminar}">
                            <input type="button" value="Eliminar" 
                                                    onclick="if(!(confirm('Vas a eliminar un registro. ¿Estás seguro?'))) return false"/>
                        </a></td>
                </tr>
            </c:forEach>
            
        </table>
        
        <br/>
        
        <input type="button" class="styledButton" value="Agregar" onclick="window.location.href='agregarCliente';return false;" />
        
    </body>
</html>
