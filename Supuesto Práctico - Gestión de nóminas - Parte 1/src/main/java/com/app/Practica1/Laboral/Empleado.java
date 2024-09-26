package com.app.Practica1.Laboral;

import com.app.Practica1.Excepciones.DatosNoCorrectosException;

/**
 * Clase empleado que extiende de Persona
 */
public class Empleado extends Persona {


	/**
	 * Categoría profesional del empleado
	 */
	private int categoria;
	
	/**
	 * Años de experiencia del empleado
	 */
	public int anyos;
	
	/**
	 * Constructor de la clase Empleado. 
	 * Inicializa un empleado con un nombre, DNI y sexo, asignando
	 * por defecto la categoría a 1 y los años de experiencia a 0.
	 * 
	 * @param nombre	Nombre del empleado.
	 * @param dni	DNI del empleado.
	 * @param sexo	Género del empleado.
	 * 
	 */
	public Empleado(String nombre, String dni, char sexo) {
		super(nombre, dni, sexo);
		this.categoria = 1;
		this.anyos = 0;
	}

	/**
	 * Constructor de la clase Empleado.
	 * Inicializa un empleado con un nombre, DNI, sexo, categoría y años de experiencia. 
	 * 
	 * @param nombre		Nombre del empleado.
	 * @param dni			DNI del empleado.
	 * @param sexo			Género del empleado.
	 * @param categoria		Categoría profesional del empleado.
	 * @param anyos			Años de experiencia del empleado.
	 * 
	 */
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) {
		super(nombre, dni, sexo);
		this.categoria = categoria;
		this.anyos = anyos;
	}

	/**
	 * Obtiene la categoría del empleado.
	 * La categoría debe estar dentro del rango permitido (entre 1 y 10).
	 * 
	 * @return								La categoría del empleado.
	 * @throws	DatosNoCorrectosException	Cuando la categoría no está en el rango de 1 y 10.
	 */
	public int getCategoria() throws DatosNoCorrectosException {
		if(categoria < 1 || categoria > 10) {
			throw new DatosNoCorrectosException();
		}
		return categoria;
	}

	/**
	 * Establece la categoría del empleado.
	 * 
	 * @param categoria 	Categoría profesional del empleado.
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * Incrementa en uno los años de experiencia del empleado.
	 * 
	 * @throws DatosNoCorrectosException	Cuando los años son un número menor a 0.
	 */
	public void incrAnyo() throws DatosNoCorrectosException {
		if(anyos < 0) {
			throw new DatosNoCorrectosException();
		} else {
			anyos++;
		}
	}
	
	/**
	 * Imprime una representación en cadena del empleado.
	 * 
	 * @return Una cadena con el DNI, nombre, sexo, categoría y años de experiencia del empleado.
	 */
	public String imprime() {
		return "Dni: " + super.dni + ", Nombre: " + super.nombre + ", Sexo: " + super.sexo + ", Categoria: " + categoria + ", Años: " + anyos;
	}
	
}
