package com.app.Practica1.Excepciones;

/**
 * Excepción que se lanza cuando los datos no son correctos.
 */
public class DatosNoCorrectosException extends Exception {

	/**
     * Crea una excepcion sin mensaje.
     */
	public DatosNoCorrectosException() {
		super();
	}

	/**
     * Crea una excepcion con un mensaje detallado.
     * 
     * @param message El mensaje que describe el error.
     */
	public DatosNoCorrectosException(String message) {
		super(message);
	}
	
}
