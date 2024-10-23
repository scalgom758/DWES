package com.app.Ejercicio2.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.app.Ejercicio2.Laboral.Empleado;
import com.aprendec.conexion.Conexion;

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
}