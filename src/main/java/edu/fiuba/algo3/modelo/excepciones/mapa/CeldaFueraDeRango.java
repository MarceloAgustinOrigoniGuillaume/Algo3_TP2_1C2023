package edu.fiuba.algo3.modelo.excepciones.mapa;

public class CeldaFueraDeRango extends Exception{
	public CeldaFueraDeRango(String rationale, int givenX, int givenY, int width, int height){
		super(rationale+"\nla fila, given: "+String.valueOf(givenY)+" tiene que estar entre 1 y "+String.valueOf(height)
			+"\nla columna, given: "+String.valueOf(givenX)+" tiene que estar entre 1 y "+String.valueOf(width));
	}
}