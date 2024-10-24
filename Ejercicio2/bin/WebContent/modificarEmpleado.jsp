<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Empleado</title>
</head>
<body>
    <h1>Modificar Datos de un Empleado</h1>
    <form action="ModificarEmpleado" method="post">
        <label for="dni">DNI del empleado:</label>
        <input type="text" name="dni" id="dni" required>
        <br><br>
        <label for="categoria">Nueva Categoría:</label>
        <input type="number" name="categoria" id="categoria">
        <br><br>
        <label for="anyos">Nuevos Años Trabajados:</label>
        <input type="number" name="anyos" id="anyos">
        <br><br>
        <button type="submit">Modificar</button>
    </form>
    <br>
    <a href="index.jsp">Volver</a>
</body>
</html>
