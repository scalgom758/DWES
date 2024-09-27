package com.app.Practica2.Laboral;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.app.Practica1.Excepciones.DatosNoCorrectosException;

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
	 * @throws DatosNoCorrectosException Si ocurre un error por datos incorrectos al
	 *                                   modificar la categoría del empleado.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, DatosNoCorrectosException {

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

		} catch (SQLException ex) {
			System.out.println("Ocurrio una excepcion al conectarse a la BD");
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

	/**
	 * Imprime los detalles del empleado y su sueldo.
	 * 
	 * @param emp El objeto empleado cuyos detalles y sueldo se van a imprimir.
	 * @throws DatosNoCorrectosException Si la categoría del empleado es inválida al
	 *                                   calc.ular el sueldo.
	 */
	private static void escribe(Empleado emp) throws DatosNoCorrectosException {
		Nomina n = new Nomina();
		System.out.println(emp.imprime() + ", Sueldo: " + n.sueldo(emp));
	}

	private static void altaEmpleado() {

	}
}
