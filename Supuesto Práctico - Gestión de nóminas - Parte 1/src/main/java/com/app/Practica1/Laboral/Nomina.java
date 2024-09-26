package com.app.Practica1.Laboral;

import com.app.Practica1.Excepciones.DatosNoCorrectosException;

/**
 * Clase Nomina
 */
public class Nomina {
	
	/**
     * Sueldos base para cada categoría de empleado.
     * La posición en el array corresponde a la categoría del empleado menos uno.
     */
	private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};
	
	/**
	 * Calcula el sueldo de un empleado en función de su categoría y años de experiencia.
	 * 
	 * @param emp							El objeto Empleado del cual se calculará el sueldo.
	 * @return								El sueldo calculado del empleado.
	 * @throws DatosNoCorrectosException	Si la categoría del empleado no está dentro del rango de 1 y 10.
	 */
	public int sueldo(Empleado emp) throws DatosNoCorrectosException {
		int sueldo = SUELDO_BASE[emp.getCategoria() - 1] + (5000*emp.anyos);
		return sueldo;
	}
}
