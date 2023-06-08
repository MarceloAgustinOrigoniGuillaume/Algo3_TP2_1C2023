package edu.fiuba.algo3.modeloNico.Enemigo;

import java.util.ArrayList;
import java.util.Map;
import edu.fiuba.algo3.modeloNico.Jugador;
import java.util.Iterator;

import edu.fiuba.algo3.modeloNico.Enemigo.instanciacion.Instanciador;

public class Oleada{

	public static final String HORMIGA_LABEL = "hormiga";
	public static final String ARANIA_LABEL = "arana";

	private ArrayList<Instanciador> aInstanciar;

	public Oleada(Map<String, Integer> instanciacion){

		aInstanciar = new ArrayList<>();

		int cantidad = instanciacion.get(HORMIGA_LABEL);
		if(cantidad > 0){
			aInstanciar.add(new Instanciador(new Hormiga(), cantidad));
		}

		cantidad = instanciacion.get(ARANIA_LABEL);
		if(cantidad > 0){
			aInstanciar.add(new Instanciador(new Arania(), cantidad));
		}

	} 

	public ArrayList<Enemigo> instanciar(){
		ArrayList<Enemigo> instanciados = new ArrayList<>();
    	
    	for(Instanciador instanciando : aInstanciar){
    		instanciando.agregarInstancias(instanciados);
    	}

		return instanciados;
	}
}