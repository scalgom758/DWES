<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Salario del Empleado</title>
	<style>
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

p {
    color: #000;
    padding-left: 20px;
}

a {
    text-decoration: none;
    color: #023E8A;
    border: 2px solid #023E8A;
    border-radius: 5px;
    padding: 10px;
    display: inline-block;
    margin-left: 20px;
}

a:hover {
    color: #CAF0F8;
    background-color: #023E8A;
}
		
	</style>
</head>
<body>
    <h1>Salario del Empleado</h1>
    <p>El salario del empleado es: ${sueldo}</p>
    <br>
    <a href="buscarSalario.jsp">Volver</a>
</body>
</html>
