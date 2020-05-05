<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Telefonos</title>
</head>
<body>
	<h1>Lista Telefonos</h1>
	<table>
	</table>

	<table border="1" width="100%">
		<tr>
			<td>CODIGO</td>
			<td>NUMERO</td>
			<td>TIPO</td>
			<td>OPERADORA</td>
			<td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="telefono"  items="${lista}">
			<tr>
				<td><c:out value="${telefono.codigo}" /></td>
				<td><c:out value="${telefono.numero}" /></td>
				<td><c:out value="${telefono.tipo}" /></td>
				<td><c:out value="${telefono.operadora}" /></td>
				<td><a
					href="ControlaTelefono?action=editapr&id=<c:out value="${telefono.codigo}" />">Editar</a></td>
				<td><a
					href="ControlaTelefono?action=Eliminar&id=<c:out value="${telefono.codigo}" />">Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>'
	<form>
		<table border="0" align="center">
			<tr>
				<td> <a href='Buscar.jsp'>RegistrarTelefono</a></td>
			</tr>

		</table>
	</form>
</body>
</html>