package edu.fiuba.algo3.modelo.excepciones.mapa;

public class CeldaNoExistia extends Exception{
	public CeldaNoExistia(String rationale){
		super("CeldaNoExistia: "+rationale);
	}
}