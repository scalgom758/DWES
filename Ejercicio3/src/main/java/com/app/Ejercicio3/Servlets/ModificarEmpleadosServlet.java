package com.app.Ejercicio3.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Ejercicio3.DAO.EmpleadoDAO;

@WebServlet("/modificarEmpleados")
public class ModificarEmpleadosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        String sexoStr = request.getParameter("sexo");
        char sexo = sexoStr.charAt(0);
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        int anyos = Integer.parseInt(request.getParameter("anyos"));
        
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        boolean success = empleadoDAO.modificarEmpleado(nombre, dni, sexo, categoria, anyos);

        if (success) {
            response.getWriter().write("Empleado actualizado con éxito.");
        } else {
            response.getWriter().write("Error al actualizar el empleado.");
        }
    }
}
