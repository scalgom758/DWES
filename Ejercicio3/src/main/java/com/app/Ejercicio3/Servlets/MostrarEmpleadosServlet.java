package com.app.Ejercicio3.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Ejercicio3.DAO.EmpleadoDAO;
import com.app.Ejercicio3.Laboral.Empleado;

@WebServlet("/mostrarEmpleadosServlet")
public class MostrarEmpleadosServlet extends HttpServlet {
    private EmpleadoDAO empDAO = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Empleado> empleados = empDAO.getAllEmpleados();
            
            req.setAttribute("empleados", empleados);
            req.getRequestDispatcher("/mostrarEmpleados.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
