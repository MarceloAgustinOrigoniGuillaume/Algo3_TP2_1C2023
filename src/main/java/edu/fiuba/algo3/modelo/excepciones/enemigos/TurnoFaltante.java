package edu.fiuba.algo3.modelo.excepciones.enemigos;

public class TurnoFaltante extends Exception{
	public TurnoFaltante(String rationale){
		super("Error en los turnos del archivo: "+rationale);
	}
}
