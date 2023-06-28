package edu.fiuba.algo3.modelo.descriptors;


import edu.fiuba.algo3.modelo.Defensas.Defensa;

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