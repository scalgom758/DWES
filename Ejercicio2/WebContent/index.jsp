<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gestión de Empleados</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: white;
	margin: 0;
	padding: 0;
}

h1 {
	text-align: center;
	color: #023E8A;
	margin-top: 30px;
}

ul {
	list-style-type: none;
	padding: 0;
	text-align: center;
}

li {
	margin: 10px 0;
}

a {
	text-decoration: none;
	color: #023E8A;
	background-color: white;
	border: 2px solid #023E8A;
	border-radius: 5px;
	transition: background-color 0.3s;
	display: block;
    margin: 5px auto;
	width: 20%;
    padding: 10px;
}

a:hover {
color: #CAF0F8;
	background-color: #023E8A;
}

</style>
</head>
<body>
	<h1>Menú Principal</h1>
	<ul>
		<li><a href="mostrarEmpleados">Mostrar información de los
				empleados</a></li>
		<li><a href="buscarSalario.jsp">Buscar salario de un empleado</a></li>
		<li><a href="buscarEmpleado.jsp">Buscar un empleado</a></li>
	</ul>
</body>
</html>