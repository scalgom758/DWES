package com.app.Ejercicio3.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Ejercicio3.dao.EmpleadoDAO;
import com.app.Ejercicio3.model.Empleado;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/empleado" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	private EmpleadoDAO empDAO = new EmpleadoDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = req.getParameter("opcion");

		if (opcion.equals("mostrarEmpleados")) {

			try {
				List<Empleado> empleados = empDAO.getAllEmpleados();

				req.setAttribute("empleados", empleados);
				req.getRequestDispatcher("/mostrarEmpleados.jsp").forward(req, res);
			} catch (Exception e) {
				System.out.println(e);
			}

		} else if (opcion.equals("buscarSalario")) {
			String dni = req.getParameter("dni");
			int salario = 0;
			
			try {
				salario = empDAO.getSalarioByDni(dni);
				req.setAttribute("sueldo", salario);
				req.getRequestDispatcher("/buscarSalario.jsp").forward(req, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		} else if (opcion.equals("buscarEmpleado")) {
			req.getRequestDispatcher("/buscarEmpleado.jsp").forward(req, res);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = req.getParameter("opcion");

		if (opcion.equals("mostrarSalario")) {
			String dni = req.getParameter("dni");
			int salario = 0;

			try {
				salario = empDAO.getSalarioByDni(dni);
				req.setAttribute("sueldo", salario);
				req.getRequestDispatcher("/mostrarSalario.jsp").forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else if (opcion.equals("mostrarEmpleado")) {
			String dni = req.getParameter("dni");
			
			try {
				List<Empleado> empleados = empDAO.buscarEmpleados(dni);
				req.setAttribute("empleados", empleados);
				req.getRequestDispatcher("/mostrarEmpleados.jsp").forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}