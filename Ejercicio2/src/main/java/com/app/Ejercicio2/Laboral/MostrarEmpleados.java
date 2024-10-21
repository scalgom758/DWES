package com.app.Ejercicio2.Laboral;

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

@WebServlet("/mostrarEmpleados")
public class MostrarEmpleados extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String USER = "root";
		final String PASS = "123456";
		final String DB_NAME = "practica";
		final String CONN_URL = "jdbc:mariadb://localhost:3306/" + DB_NAME;
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONN_URL, USER, PASS);
			ps = conn.prepareStatement("SELECT nombre, dni, sexo, categoria, anyos FROM empleados");
			rs = ps.executeQuery();

			List<Empleado> empleados = new ArrayList<>();
			while (rs.next()) {
				Empleado empleado = new Empleado(rs.getString("nombre"), rs.getString("dni"),
						rs.getString("sexo").charAt(0), rs.getInt("categoria"), rs.getInt("anyos"));
				empleados.add(empleado);
			}
			req.setAttribute("empleados", empleados);
			req.getRequestDispatcher("/mostrarEmpleados.jsp").forward(req, res);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
