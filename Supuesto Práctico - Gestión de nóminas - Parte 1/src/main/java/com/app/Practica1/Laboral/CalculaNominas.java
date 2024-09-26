package com.app.Practica1.Laboral;

import com.app.Practica1.Excepciones.DatosNoCorrectosException;

/**
 * Clase main CalculaNominas
 */
public class CalculaNominas {

	/**
	 * Método principal que ejecuta el programa.
	 * Crea dos empleados, imprime sus detalles, incrementa los años de experiencia de uno,
	 * cambia la categoría de otro y vuelve a imprimir los detalles.
	 * 
	 * @param args Argumentos de línea de comandos.
	 * @throws DatosNoCorrectosException Si ocurre un error por datos incorrectos al modificar la categoría del empleado.
	 */
	public static void main(String[] args) throws DatosNoCorrectosException {
		Empleado e1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
		Empleado e2 = new Empleado("Ada Lovelace", "32000031R", 'F');
		
		try {
			escribe(e1);
			escribe(e2);
			
			e2.incrAnyo();
			
			e1.setCategoria(9);
			
			escribe(e1);
			escribe(e2);
		} catch (DatosNoCorrectosException e) {
			System.out.println("Datos no correctos");
		}
	}
	
	/**
	 * Imprime los detalles del empleado y su sueldo.
	 * 
	 * @param emp							El objeto empleado cuyos detalles y sueldo se van a imprimir.
	 * @throws DatosNoCorrectosException 	Si la categoría del empleado es inválida al calc.ular el sueldo.
	 */
	private static void escribe(Empleado emp) throws DatosNoCorrectosException {
		Nomina n = new Nomina();
		System.out.println(emp.imprime() +", Sueldo: "+ n.sueldo(emp));
	}
}
