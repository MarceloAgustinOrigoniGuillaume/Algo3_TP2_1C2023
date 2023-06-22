package edu.fiuba.algo3.modelo.descriptors;


import edu.fiuba.algo3.modelo.Defensas.Defensa;

public class CeldaDescriptor{
	private String terreno;
	private int cantidadEnemigos;
	private DefensaDescriptor defensa;

	public CeldaDescriptor(String terreno, int cantidadEnemigos, DefensaDescriptor defensa){
		this.terreno = terreno;
		this.cantidadEnemigos = cantidadEnemigos;
		this.defensa = defensa;
	}

	public int cantidadEnemigos(){
		return cantidadEnemigos;
	}

	public String rel_image(){

		if(defensa != null){
			String res = defensa.rel_image();
			if(res != ""){ // no habia defensa
				return res;
			}			
		} else{
			System.out.println("LA DEFENSA ERA NULL WTF??? "+terreno);
		}

		return "terrenos/"+terreno+".jpg";
	}
	public String tipo(){
		return terreno;
	}
}