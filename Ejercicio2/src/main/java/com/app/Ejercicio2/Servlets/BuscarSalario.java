package com.app.Ejercicio2.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Ejercicio2.DAO.EmpleadoDAO;

import java.io.IOException;

@WebServlet("/buscarSalario")
public class BuscarSalario extends HttpServlet {
	EmpleadoDAO empDAO = new EmpleadoDAO();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dni = req.getParameter("dni");
        int salario = 0;

        try {
            salario = empDAO.getSalarioByDni(dni);
            req.setAttribute("sueldo", salario);
            req.getRequestDispatcher("/mostrarSalario.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
