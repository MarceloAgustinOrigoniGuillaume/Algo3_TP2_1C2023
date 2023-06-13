package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Oleada;
import edu.fiuba.algo3.modelo.Lector.LectorEnemigo;

import java.util.ArrayList;

public class Oleadas {

	private ArrayList<Oleada> oleadas;

	private void agregarOleada(Oleada oleada){
		oleadas.add(oleada);
	}
	public Oleadas(LectorEnemigo lector) throws Exception {
		oleadas = new ArrayList();
    	// cargas lector
        while(lector.haySiguiente()){
        	agregarOleada((Oleada)(lector.siguienteElemento().obtener()));
        }


	}

	public ArrayList<Enemigo> instanciar(int turno){
		// el indice seria uno menos... turno 1 instancia oleada 0...
		if(noHayMasOleadas(turno)){
			return new ArrayList<>();
		}

		return oleadas.get(turno-1).instanciar();
	}

	public boolean noHayMasOleadas(int turno){
		return turno-1>= oleadas.size(); // not (turno-1 < size)
	}
}
