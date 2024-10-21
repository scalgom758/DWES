package com.app.Ejercicio2.Laboral;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.mariadb.jdbc.internal.util.OptionUtils;

import com.app.Ejercicio2.Excepciones.DatosNoCorrectosException;

/**
 * Clase main CalculaNominas
 */
public class CalculaNominas {

	/**
	 * Método principal que ejecuta el programa. Crea dos empleados, imprime sus
	 * detalles, incrementa los años de experiencia de uno, cambia la categoría de
	 * otro y vuelve a imprimir los detalles.
	 * 
	 * @param args Argumentos de línea de comandos.
	 * @throws DatosNoCorrectosException                               Si ocurre un
	 *                                                                 error por
	 *                                                                 datos
	 *                                                                 incorrectos
	 *                                                                 al modificar
	 *                                                                 la categoría
	 *                                                                 del empleado.
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws com.app.Practica1.Excepciones.DatosNoCorrectosException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, DatosNoCorrectosException,
			com.app.Ejercicio2.Excepciones.DatosNoCorrectosException {

//		String inputFile = "src\\main\\java\\com\\app\\Practica2\\Laboral\\empleados.txt";
//		String outputFile = "src\\main\\java\\com\\app\\Practica2\\Laboral\\sueldos.dat";
//		
//		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
//	             DataOutputStream binario = new DataOutputStream(new FileOutputStream(outputFile))) {
//	            
//	            String linea;
//	            
//	            while ((linea = br.readLine()) != null) {
//	                String[] datos = linea.split(",");
//	                
//	                String nombre = datos[0].trim();
//	                String dni = datos[1].trim();
//	                char sexo = datos[2].trim().charAt(0);
//	                int categoria = Integer.parseInt(datos[3].trim());
//	                int anyos = Integer.parseInt(datos[4].trim());
//	                
//	                Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);
//	                
//	                Nomina nomina = new Nomina();
//	                int sueldo = nomina.sueldo(emp);
//	                
//	                binario.writeUTF(dni);
//	                binario.writeInt(sueldo);
//	            }
//	            
//        } catch (IOException e) {
//        e.printStackTrace();
//        }

		final String USER = "root";
		final String PASS = "123456";
		final String DB_NAME = "practica";
		final String CONN_URL = "jdbc:mariadb://localhost:3306/" + DB_NAME;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(CONN_URL, USER, PASS);

			Scanner sc = new Scanner(System.in);
			int opc;
			do {
				System.out.println("Elige una opcion:\n" + "0 - Salir\n" + "1 - Mostrar informacion de los empleados\n"
						+ "2 - Mostrar salario por dni del empleado\n" + "3 - Modificar empleado\n"
						+ "4 - Recalcular y actualizar sueldo de un empleado\n"
						+ "5 - Recalcular y actualizar sueldo de todos los empleados\n" + "6 - Copia de seguridad\n"
						+ "7 - Dar de alta a un empleado\n" + "8 - Dar de alta a varios empleados\n" + "");
				opc = sc.nextInt();

				switch (opc) {
				case 0:
					System.out.println("Adios");
					break;

				case 1:
					leeEmpleados(conn);
					break;

				case 2:
					System.out.println("Introduce el DNI del empleado:");
					String dni = sc.next();
					mostrarSalarioPorDni(conn, dni);
					break;

				case 3:
					modificarEmpleado(conn);
					break;

				case 4:
					System.out.println("Introduce el DNI del empleado:");
					dni = sc.next();
					actualizarSueldoEmpleado(conn, dni);
					break;

				case 5:
					actualizarSueldos(conn);
					break;

				case 6:
					copiaSeguridad(conn);
					break;

				case 7:
					altaEmpleado(conn, new Empleado("Jesus Garcia", "32000033J", 'M', 4, 10));
					break;

				case 8:
					altaEmpleado(conn, "empleadosNuevos.txt");
					break;

				default:
					System.out.println("No existe la opcion\n" + "");
					break;
				}

			} while (opc != 0);

		} catch (SQLException ex) {
			System.out.println("Ocurrio una excepcion al conectarse a la BD" + ex.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("Ocurrio una excepcion al cerrar la BD");
			}
		}
	}

	private static void leeEmpleados(Connection conn) throws com.app.Ejercicio2.Excepciones.DatosNoCorrectosException {
		String consulta = "SELECT nombre, dni, sexo, categoria, anyos FROM empleados";

		try (PreparedStatement ps = conn.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				char sexo = rs.getString("sexo").charAt(0);
				int categoria = rs.getInt("categoria");
				int anyos = rs.getInt("anyos");

				System.out.println(nombre + " " + dni + " " + sexo + " " + categoria + " " + anyos);

			}
		} catch (SQLException ex) {
			System.out.println("Error al leer empleados");
		}
	}

	public static void altaEmpleado(Connection conn, Empleado empleado)
			throws SQLException, com.app.Ejercicio2.Excepciones.DatosNoCorrectosException {
		String query = "INSERT INTO empleados (nombre, dni, sexo, categoria, anyos, sueldo) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, empleado.nombre);
			ps.setString(2, empleado.dni);
			ps.setString(3, String.valueOf(empleado.sexo));
			ps.setInt(4, empleado.getCategoria());
			ps.setInt(5, empleado.anyos);

			Nomina nomina = new Nomina();
			int sueldo = nomina.sueldo(empleado);
			ps.setInt(6, sueldo);

			ps.executeUpdate();
			System.out.println("Se ha dado de alta al empleado con exito");
		} catch (SQLException ex) {
			System.out.println("Error al registrar el empleado");
		}
	}

	public static void altaEmpleado(Connection conn, String archivo) throws SQLException, FileNotFoundException,
			IOException, com.app.Ejercicio2.Excepciones.DatosNoCorrectosException {
		archivo = "src\\main\\java\\com\\app\\Practica2\\Laboral\\empleadosNuevos.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length == 5) {
					String nombre = datos[0].trim();
					String dni = datos[1].trim();
					char sexo = datos[2].trim().charAt(0);
					int categoria = Integer.parseInt(datos[3].trim());
					int anyos = Integer.parseInt(datos[4].trim());

					Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);
					altaEmpleado(conn, emp);
				}
			}
			System.out.println("Se han dado de alta a los empleados con exito");
		}
	}

	public static void mostrarSalarioPorDni(Connection conn, String dni) throws SQLException {
		String consulta = "SELECT sueldo FROM empleados WHERE dni = ?";

		try (PreparedStatement ps = conn.prepareStatement(consulta)) {
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int sueldo = rs.getInt("sueldo");
				System.out.println(sueldo);
			} else {
				System.out.println("No existe el empleado con ese DNI");
			}
		} catch (SQLException ex) {
			System.out.println("Ocurrio un error al obtener el salario.");
			throw ex;
		}
	}

	private static void modificarEmpleado(Connection conn) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el DNI del empleado a modificar: ");
		String dni = sc.nextLine();

		int subopc;
		do {
			System.out.println("Elige una opcion:\n" + "0 - Salir\n" + "1 - Cambiar nombre\n" + "2 - Cambiar dni\n"
					+ "3 - Cambiar sexo\n" + "4 - Cambiar categoria\n" + "5 - Cambiar años trabajados\n");
			subopc = sc.nextInt();
			sc.nextLine();

			String consulta = "";
			switch (subopc) {
			case 0:
				System.out.println("Volviendo al menu principal...\n");
				break;

			case 1:
				System.out.print("Introduce el nuevo nombre: ");
				String nuevoNombre = sc.nextLine();
				consulta = "UPDATE empleados SET nombre = ? WHERE dni = ?";
				try (PreparedStatement ps = conn.prepareStatement(consulta)) {
					ps.setString(1, nuevoNombre);
					ps.setString(2, dni);
					ps.executeUpdate();
					System.out.println("Se ha modificado el nombre");
				} catch (SQLException ex) {
					System.out.println("Error al modificar el nombre del empleado");
				}
				break;

			case 2:
				System.out.print("Introduce el nuevo DNI: ");
				String nuevoDNI = sc.nextLine();
				consulta = "UPDATE empleados SET dni = ? WHERE dni = ?";
				try (PreparedStatement ps = conn.prepareStatement(consulta)) {
					ps.setString(1, nuevoDNI);
					ps.setString(2, dni);
					ps.executeUpdate();
					System.out.println("Se ha modificado el DNI");
					dni = nuevoDNI;
				} catch (SQLException ex) {
					System.out.println("Error al modificar el DNI del empleado");
				}
				break;

			case 3:
				System.out.print("Introduce el nuevo sexo (M/F): ");
				char nuevoSexo = sc.nextLine().charAt(0);
				consulta = "UPDATE empleados SET sexo = ? WHERE dni = ?";
				try (PreparedStatement ps = conn.prepareStatement(consulta)) {
					ps.setString(1, String.valueOf(nuevoSexo));
					ps.setString(2, dni);
					ps.executeUpdate();
					System.out.println("Se ha modificado el sexo");
				} catch (SQLException ex) {
					System.out.println("Error al modificar el sexo del empleado");
				}
				break;

			case 4:
				System.out.print("Introduce la nueva categoria: ");
				int nuevaCategoria = sc.nextInt();
				consulta = "UPDATE empleados SET categoria = ? WHERE dni = ?";
				try (PreparedStatement ps = conn.prepareStatement(consulta)) {
					ps.setInt(1, nuevaCategoria);
					ps.setString(2, dni);
					ps.executeUpdate();
					System.out.println("Se ha modificado la categoria");
				} catch (SQLException ex) {
					System.out.println("Error al modificar la categoría del empleado");
				}
				break;

			case 5:
				System.out.print("Introduce los nuevos años trabajados: ");
				int nuevosAnios = sc.nextInt();
				consulta = "UPDATE empleados SET anyos = ? WHERE dni = ?";
				try (PreparedStatement ps = conn.prepareStatement(consulta)) {
					ps.setInt(1, nuevosAnios);
					ps.setString(2, dni);
					ps.executeUpdate();
					System.out.println("Se han modificado los años trabajados");
				} catch (SQLException ex) {
					System.out.println("Error al modificar los años trabajados del empleado");
				}
				break;

			default:
				System.out.println("No existe la opcion\n" + "");
				break;

			}

		} while (subopc != 0);
	}

	private static void actualizarSueldoEmpleado(Connection conn, String dni)
			throws SQLException, DatosNoCorrectosException, com.app.Ejercicio2.Excepciones.DatosNoCorrectosException {
		String consulta = "SELECT categoria, anyos FROM empleados WHERE dni = ?";
		PreparedStatement ps = conn.prepareStatement(consulta);
		ps.setString(1, dni);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int categoria = rs.getInt("categoria");
			int anyos = rs.getInt("anyos");
			Empleado emp = new Empleado("", dni, 'M', categoria, anyos);

			Nomina nomina = new Nomina();
			int nuevoSueldo = nomina.sueldo(emp);

			String actualizarSueldo = "UPDATE empleados SET sueldo = ? WHERE dni = ?";
			PreparedStatement psU = conn.prepareStatement(actualizarSueldo);
			psU.setInt(1, nuevoSueldo);
			psU.setString(2, dni);
			psU.executeUpdate();
		}
		System.out.println("Sueldo actualizado");
	}

	private static void actualizarSueldos(Connection conn)
			throws SQLException, DatosNoCorrectosException, com.app.Ejercicio2.Excepciones.DatosNoCorrectosException {
		String consulta = "SELECT dni, categoria, anyos FROM empleados";
		PreparedStatement ps = conn.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String dni = rs.getString("dni");
			int categoria = rs.getInt("categoria");
			int anyos = rs.getInt("anyos");

			Empleado emp = new Empleado("", dni, 'M', categoria, anyos);

			Nomina nomina = new Nomina();
			int nuevoSueldo = nomina.sueldo(emp);

			String actualizarSueldo = "UPDATE empleados SET sueldo = ? WHERE dni = ?";
			PreparedStatement psU = conn.prepareStatement(actualizarSueldo);
			psU.setInt(1, nuevoSueldo);
			psU.setString(2, dni);
			psU.executeUpdate();
		}
		System.out.println("Sueldos actualizados");
	}

	private static void copiaSeguridad(Connection conn) throws SQLException, IOException {
		String consulta = "SELECT nombre, dni, sexo, categoria, anyos, sueldo FROM empleados";
		PreparedStatement ps = conn.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();
		String outputFile = "src\\main\\java\\com\\app\\Practica2\\Laboral\\backup_empleados.txt";
		DataOutputStream backup = new DataOutputStream(new FileOutputStream(outputFile));

		while (rs.next()) {
			String nombre = rs.getString("nombre");
			String dni = rs.getString("dni");
			char sexo = rs.getString("sexo").charAt(0);
			int categoria = rs.getInt("categoria");
			int anyos = rs.getInt("anyos");
			int sueldo = rs.getInt("sueldo");

			backup.writeBytes(nombre + ", " + dni + ", " + sexo + ", " + categoria + ", " + anyos + ", " + sueldo + "\n");
		}
		System.out.println("Se ha realizado la copia de seguridad");
	}
}