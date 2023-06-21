package edu.fiuba.algo3.modelo.descriptors;


public class CeldaDescriptor{
	private String terreno;
	private int cantidadEnemigos;
	public CeldaDescriptor(String terreno, int cantidadEnemigos){
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