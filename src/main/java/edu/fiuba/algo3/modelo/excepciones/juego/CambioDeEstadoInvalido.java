package edu.fiuba.algo3.modelo.excepciones.juego;

public class CambioDeEstadoInvalido extends Exception{
	public CambioDeEstadoInvalido(String rationale){
		super("CambioDeEstadoInvalido: "+rationale);
	}
}

