package edu.fiuba.algo3.modelo.Enemigo;

import java.util.ArrayList;
import java.util.Map;

import edu.fiuba.algo3.modelo.Enemigo.instanciacion.Instanciador;

public class Oleada{

	public static final String HORMIGA_LABEL = "hormiga";
	public static final String ARANIA_LABEL = "arana";
	public static final String TOPO_LABEL = "topo";

	private ArrayList<Instanciador> aInstanciar;

	public Oleada(Map<String, Integer> instanciacion, int turnoActual) throws Exception {

		aInstanciar = new ArrayList<>();
		if(!instanciacion.containsKey(HORMIGA_LABEL)){
			throw new Exception("No tenia label 'hormiga' para Hormigas");
		}
		if (!instanciacion.containsKey(ARANIA_LABEL)){
			throw new Exception("No tenia el label 'arana' para Aranias");
		}

		//if (!instanciacion.containsKey(TOPO_LABEL)){

			//throw new Exception("No tenia label 'Topo' para topos");
		//}

		int cantidad = instanciacion.get(HORMIGA_LABEL);
		if(cantidad > 0){
			aInstanciar.add(new Instanciador(new Hormiga(), cantidad));
		}

		cantidad = instanciacion.get(ARANIA_LABEL);
		if(cantidad > 0){
			aInstanciar.add(new Instanciador(new Arania(), cantidad));
		}

		cantidad = instanciacion.containsKey(TOPO_LABEL)? instanciacion.get(TOPO_LABEL) : 0;
		if(cantidad > 0){
			aInstanciar.add(new Instanciador(new Topo(turnoActual), cantidad));
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