package com.app.Ejercicio3.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Ejercicio3.DAO.EmpleadoDAO;
import com.app.Ejercicio3.Laboral.Empleado;

@WebServlet("/buscarEmpleadoServlet")
public class BuscarEmpleadoServlet extends HttpServlet {
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