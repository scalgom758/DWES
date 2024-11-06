package com.app.Ejercicio3.Laboral;

/**
 * Clase Persona
 */
public class Persona {
	
	/**
	 * Nombre de la persona
	 * DNI de la persona
	 */
	public String nombre, dni;
	
	/**
	 * Género de la persona
	 */
	public char sexo;
	
	/**
	 * Constructor de la clase Persona
	 * Inicializa una nueva instancia de Persona con el nombre, DNI y sexo proporcionados.
	 * 
	 * @param nombre	El nombre de la persona.
	 * @param dni		El DNI de la persona.
	 * @param sexo		El género de la persona representado como un carácter ('M' para masculino, 'F' para femenino).
	 */
	public Persona(String nombre, String dni, char sexo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}
	
	/**
	 * Constructor de la clase Persona.
	 * Inicializa una nueva instancia de Persona con el nombre y sexo proporcionados.
	 * 
	 * @param nombre	El nombre de la persona.
	 * @param sexo		El género de la persona representado como un carácter ('M' para masculino, 'F' para femenino).
	 */
	public Persona(String nombre, char sexo) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Imprime una representación en cadena de la persona.
	 * 
	 * @return Una cadena con el DNI y nombre de la persona.
	 */
	public String imprime() {
		return "Dni: " + dni + ", Nombre: " + nombre;
	}
	
	
}
