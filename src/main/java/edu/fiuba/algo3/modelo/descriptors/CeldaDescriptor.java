package edu.fiuba.algo3.modelo.descriptors;


import edu.fiuba.algo3.modelo.Defensas.Defensa;

public class CeldaDescriptor{
	private String terreno;
	private int cantidadEnemigos;
	public CeldaDescriptor(String terreno, int cantidadEnemigos, DefensaDescriptor defensa){
		this.terreno = terreno;
		this.cantidadEnemigos = cantidadEnemigos;
	}

	public int cantidadEnemigos(){
		return cantidadEnemigos;
	}

	public String tipo(){
		return terreno;
	}
}