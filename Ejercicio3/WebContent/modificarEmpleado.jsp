<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Modificar Empleado</title>
<style>
/* Aquí puedes agregar el mismo estilo que tienes en tu archivo anterior */
body {
	font-family: Arial, sans-serif;
	background-color: white;
	margin: 0;
	padding: 0;
}

h1 {
	color: #023E8A;
	margin-top: 30px;
	text-align: left;
	padding-left: 20px;
}

form {
	padding-left: 20px;
}

label {
	display: block;
	margin-bottom: 10px;
}

input[type="text"],
input[type="number"] {
	padding: 10px;
	width: 300px;
	border: 1px solid #023E8A;
	border-radius: 5px;
	margin-bottom: 10px;
}

button {
	background-color: #023E8A;
	color: white;
	border: none;
	border-radius: 5px;
	padding: 10px 15px;
	cursor: pointer;
}

button:hover {
	background-color: #CAF0F8;
}

a {
	text-decoration: none;
	color: #023E8A;
	border: 2px solid #023E8A;
	border-radius: 5px;
	padding: 10px;
	display: inline-block;
	margin-top: 20px;
	margin-left: 20px;
}

a:hover {
	color: #CAF0F8;
	background-color: #023E8A;
}
</style>
</head>
<body>

<h1>Modificar Empleado</h1>

<%-- Mostrar los datos del empleado --%>
<%
    String nombre = (String) request.getAttribute("nombre");
    String dni = (String) request.getAttribute("dni");
    String sexo = (String) request.getAttribute("sexo");
    
    Integer categoria = (Integer) request.getAttribute("categoria");
    Integer anyos = (Integer) request.getAttribute("anyos");

    if (categoria == null) {
        categoria = 0;
    }
    if (anyos == null) {
        anyos = 0;
    }
%>

<form action="modificarEmpleados" method="post">
    <label for="dni">DNI del empleado:</label>
    <input type="text" name="dni" id="dni" value="<%= dni %>" readonly required>

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" id="nombre" value="<%= nombre %>" required>

    <label for="sexo">Sexo:</label>
    <input type="text" name="sexo" id="sexo" value="<%= sexo %>" required>

    <label for="categoria">Categoría:</label>
    <input type="number" name="categoria" id="categoria" value="<%= categoria %>" required>

    <label for="anyos">Años de experiencia:</label>
    <input type="number" name="anyos" id="anyos" value="<%= anyos %>" required>

    <button type="submit">Modificar</button>
</form>

<a href="index.jsp">Volver</a>

</body>
</html>
