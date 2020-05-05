<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRARSE</title>
</head>
<body>
	<h1>Registrate Ahora</h1>
	<form action="ControlaUsuario?action=Registrarse" method="post">
		<table border="1" align="center">
			<tr>
				<td>Cédula:</a></td>
				<td><input type="text" name="cedula" /></td>
			</tr>
			<tr>
				<td>Nombre:</a></td>
				<td><input type="text" name="nombre" /></td>
			</tr>
			<tr>
				<td>Apellido:</a></td>
				<td><input type="text" name="apellido" /></td>
			</tr>
			<tr>
				<td>Correo:</a></td>
				<td><input type="text" name="correo" /></td>
			</tr>
			<tr>
				<td>Contra:</a></td>
				<td><input type="text" name="contra" /></td>
			</tr>

		</table>
		<br>
		<table border="0" align="center">
			<tr>
				<td><input type="submit" value="Agregar" name="agrega"></td>
			</tr>
		</table>
	</form>
</body>
</html>