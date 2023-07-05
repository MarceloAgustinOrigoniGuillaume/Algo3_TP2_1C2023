package edu.fiuba.algo3.modelo.descriptors;


public class CeldaDescriptor{
	private String terreno;
	private DefensaDescriptor defensa;
	private EnemigosDescriptor enemigos;

	public CeldaDescriptor(String terreno, DefensaDescriptor defensa, EnemigosDescriptor enemigos){
		this.terreno = terreno;
		this.defensa = defensa;
		this.enemigos = enemigos;
	}

	public CeldaDescriptor(String terreno, EnemigosDescriptor enemigos){
		this.terreno = terreno;
		this.defensa = new DefensaDescriptor();
		this.enemigos = enemigos;
	}


	public int cantidadEnemigos(){
		return enemigos.cantidadEnemigos();
	}

	public DefensaDescriptor defensa(){
		return defensa;
	}

	public EnemigosDescriptor enemigos(){
		return enemigos;
	}


	public String rel_image(){
		return "terrenos/"+terreno+".jpg";
	}

	public String defensa_image(){
		return defensa.rel_image();
	}

	public String tipo(){
		return terreno;
	}
}