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
	<form action="ControlaTelefono?action=BuscaCedula" method="post">
		<table>

			<tr>
				<td>Ingrese Cedula:</a></td>
				<td><input type="text" name="cedulita" /></td>
			</tr>


		</table>

		<table border="1" width="100%">
			<tr>
				<td>NOMBRE</td>
				<td>APELLIDO</td>
				<td>NUMERO</td>
				<td>TIPO</td>
				<td>OPERADORA</td>
				<td colspan=2>ACCIONES</td>
			</tr>
			<c:forEach var="persona" items="${lista1}">
				<c:forEach var="telefono" items="${lista}">
					<tr>
						<td><c:out value="${persona.nombre}" /></td>
						<td><c:out value="${persona.apellido}" /></td>
						<td><c:out value="${telefono.numero}" /></td>
						<td><c:out value="${telefono.tipo}" /></td>
						<td><c:out value="${telefono.operadora}" /></td>
						<td><a
							href="mailto:<c:out value="${nombre.correo}" />">Enviar Correo</a></td>
						<td><a
							href="tel:<c:out value="${telefono.numero}" />">Llamar</a>
						</td>

					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<br>'

	</form>
</body>
</html>