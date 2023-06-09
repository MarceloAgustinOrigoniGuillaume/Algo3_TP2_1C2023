package edu.fiuba.algo3.modelo.Enemigo;

import java.util.ArrayList;
import java.util.Map;

import edu.fiuba.algo3.modelo.Enemigo.instanciacion.Instanciador;

public class Oleada{

	public static final String HORMIGA_LABEL = "hormiga";
	public static final String ARANIA_LABEL = "arana";

	private ArrayList<Instanciador> aInstanciar;

	public Oleada(Map<String, Integer> instanciacion) throws Exception {

		aInstanciar = new ArrayList<>();
		if(!instanciacion.containsKey(HORMIGA_LABEL)){
			throw new Exception("No tenia label Hormiga");
		}
		if (!instanciacion.containsKey(ARANIA_LABEL)){
			throw new Exception("No tenia label Arania");
		}
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