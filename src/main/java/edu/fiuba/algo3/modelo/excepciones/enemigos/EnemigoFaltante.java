package edu.fiuba.algo3.modelo.excepciones.enemigos;

public class EnemigoFaltante extends Exception{
	public EnemigoFaltante(String rationale){
		super("Error en los enemigos del turno: "+rationale);
	}
}
