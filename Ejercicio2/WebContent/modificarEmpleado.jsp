<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Empleado</title>
</head>
<body>
    <h1>Modificar Datos de un Empleado</h1>
    <form action="modificarEmpleado" method="post">
        <label for="dni">DNI del empleado:</label>
        <input type="text" name="dni" id="dni" required>
        <br><br>
        
        <label for="categoria">Nuevo Nombre:</label>
        <input type="text" name="nombre" id="nombre">
        <br><br>
        
        <label for="sexo">Nuevo Sexo:</label>
        <br>
        
        <input type="radio" name="sexo" id="masc">
        <label for ="sexo">Masculino</label>
        <br>
        <input type="radio" name="sexo" id="fem">
		<label for="sexo">Femenino</label>
        <br><br>
        
        <label for="categoria">Nueva Categoría:</label>
        <input type="number" name="categoria" id="categoria">
        <br><br>
        
        <label for="anyos">Nuevos Años Trabajados:</label>
        <input type="number" name="anyos" id="anyos">
        <br><br>
        
        <button type="submit">Modificar</button>
        <input type="reset" value="Reset">
    </form>
    <br>
    <a href="index.jsp">Volver</a>
</body>
</html>
