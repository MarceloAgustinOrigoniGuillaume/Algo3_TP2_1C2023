package edu.fiuba.algo3.modelo.excepciones.mapa;

public class CaminoInvalido extends Exception{
	public CaminoInvalido(String rationale){
		super("Camino terrestre invalido: "+rationale);
	}
}