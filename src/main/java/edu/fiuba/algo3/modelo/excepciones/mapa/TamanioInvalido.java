package edu.fiuba.algo3.modelo.excepciones.mapa;

public class TamanioInvalido extends Exception{
	public TamanioInvalido(String rationale){
		super("TamanioInvalido: "+rationale);
	}
}