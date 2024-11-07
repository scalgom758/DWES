<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Empleados</title>
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>

	<a href="index.jsp">Volver</a>

</body>
</html>
