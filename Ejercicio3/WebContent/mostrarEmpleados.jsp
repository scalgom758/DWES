<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Empleados</title>
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

table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
}

th, td {
    padding: 10px;
    border: 1px solid #023E8A;
    text-align: left;
}

th {
    background-color: #CAF0F8;
    color: #023E8A;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

form {
    padding: 0;
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

	<h1>Información de los Empleados</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>DNI</th>
				<th>Sexo</th>
				<th>Categoría</th>
				<th>Años Trabajados</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="empleado" items="${empleados}">
				<tr>
					<td>${empleado.nombre}</td>
					<td>${empleado.dni}</td>
					<td>${empleado.sexo}</td>
					<td>${empleado.categoria}</td>
					<td>${empleado.anyos}</td>
					<td>
						<form action="controladorServlet" method="post">
							<button>Modificar</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>

	<a href="index.jsp">Volver</a>

</body>
</html>
