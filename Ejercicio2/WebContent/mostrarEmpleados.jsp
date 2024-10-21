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
					<td>${empleados.nombre}</td>
					<td>${empleados.dni}</td>
					<td>${empleados.sexo}</td>
					<td>${empleados.categoria}</td>
					<td>${empleados.anyos}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>

	<a href="index.jsp">Volver</a>

</body>
</html>
