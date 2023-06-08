package edu.fiuba.algo3.modeloNico.Enemigo;

import java.util.ArrayList;
import java.util.Map;
import edu.fiuba.algo3.modeloNico.Jugador;
import java.util.Iterator;

public class Oleada{

	private Map<String, Integer> aInstanciar;
	public Oleada(Map<String, Integer> instanciacion){
		aInstanciar = instanciacion;
	} 

	public ArrayList<Enemigo> instanciar(Jugador jugador){
		ArrayList<Enemigo> lista = new ArrayList<>();
    	
		// instanciar
    	Iterator keys = aInstanciar.keySet().iterator();
    	String key;
    	while(keys.hasNext()){
    		key = keys.next().toString();

			for (int i = 0; i< aInstanciar.get(key); i++){
				//lista.add()
			}
			
		}

		return lista;
	}
}