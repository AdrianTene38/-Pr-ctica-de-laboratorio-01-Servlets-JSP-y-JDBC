<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Artículo</title>
</head>
<body>
<h1>Actualizar Artículo</h1>
	<form action="ControlaTelefono?action=Editar" method="post" >
		<table>
			<tr>
				<td><label>Codigo</label></td>
				<td><input type="text" name="codigom" value="<c:out value="${telefono.codigo}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Numero</label></td>
				<td><input type="text" name="numero" value='<c:out value="${telefono.numero}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Tipo</label></td>
				<td><input type="text" name="tipo" value='<c:out value="${telefono.tipo}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Operadora</label></td>
				<td><input type="text" name="operadora" value='<c:out value="${telefono.operadora}"></c:out>' ></td>
			</tr>
			
		</table>
	
		<input type="submit" name="registrar" value="Guardar"> 
	</form>

</body>
</html>