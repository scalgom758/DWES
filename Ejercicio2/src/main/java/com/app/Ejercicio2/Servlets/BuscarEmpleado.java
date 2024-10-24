package com.app.Ejercicio2.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Ejercicio2.DAO.EmpleadoDAO;
import com.app.Ejercicio2.Laboral.Empleado;

@WebServlet("/buscarEmpleado")
public class BuscarEmpleado extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmpleadoDAO empDAO = new EmpleadoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dni = req.getParameter("dni");
        try {
            List<Empleado> empleados = empDAO.buscarEmpleados(dni);
            req.setAttribute("empleados", empleados);
            req.getRequestDispatcher("/mostrarEmpleados.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}