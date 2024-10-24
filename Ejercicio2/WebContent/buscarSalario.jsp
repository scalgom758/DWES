<!DOCTYPE html>
<html>
<head>
<title>Buscar Salario</title>
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

form {
    padding-left: 20px;
}

label {
    display: block;
    margin-bottom: 10px;
}

input[type="text"] {
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
	<h1>Buscar Salario de un Empleado</h1>
	<form action="buscarSalario" method="post">
		<label for="dni">DNI del empleado:</label> <input type="text"
			name="dni" id="dni" required>
		<button type="submit">Buscar</button>
	</form>
	<br>
	<a href="index.jsp">Volver</a>
</body>
</html>
