package com.app.Ejercicio3.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.app.Ejercicio3.conexion.Conexion;
import com.app.Ejercicio3.model.DatosNoCorrectosException;
import com.app.Ejercicio3.model.Empleado;

public class EmpleadoDAO {
	private final String url = "jdbc:mariadb://localhost:3306/practica";
	private final String user = "root";
	private final String password = "123456";

	public List<Empleado> getAllEmpleados() {
		List<Empleado> empleados = new ArrayList<>();

		try (Connection conn = Conexion.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM empleados")) {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				char sexo = rs.getString("sexo").charAt(0);
				int categoria = rs.getInt("categoria");
				int anyos = rs.getInt("anyos");
				empleados.add(new Empleado(nombre, dni, sexo, categoria, anyos));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empleados;
	}

	public int getSalarioByDni(String dni) throws SQLException {
        String query = "SELECT sueldo FROM empleados WHERE dni = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("sueldo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al obtener el salario del empleado con DNI: " + dni);
        }
        return -1;
    }
	
	public List<Empleado> buscarEmpleados(String dni) throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT nombre, dni, sexo, categoria, anyos FROM empleados WHERE nombre LIKE ? OR dni LIKE ?";

        try (Connection conn = Conexion.getConnection(); PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, "%" + dni + "%");
            st.setString(2, "%" + dni + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
				String nombre = rs.getString("nombre");
				dni = rs.getString("dni");
				char sexo = rs.getString("sexo").charAt(0);
				int categoria = rs.getInt("categoria");
				int anyos = rs.getInt("anyos");
				empleados.add(new Empleado(nombre, dni, sexo, categoria, anyos));
			}
        }
        return empleados;
    }
	
	public boolean modificarEmpleado(String nombre, String dni, char sexo, int categoria, int anyos) {
        String query = "UPDATE empleados SET nombre = ?, sexo = ?, categoria = ?, anyos = ? WHERE dni = ?";

        try (Connection conn = Conexion.getConnection(); PreparedStatement st = conn.prepareStatement(query)) {

            st.setString(1, nombre);
            st.setString(2, String.valueOf(sexo));
            st.setInt(3, categoria);
            st.setInt(4, anyos);
            st.setString(5, dni);

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}