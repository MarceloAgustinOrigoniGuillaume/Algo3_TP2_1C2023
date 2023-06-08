package edu.fiuba.algo3.modeloNico;

import java.util.ArrayList;
import edu.fiuba.algo3.modeloNico.Enemigo.Enemigo;
import edu.fiuba.algo3.modeloNico.Enemigo.Oleada;
import edu.fiuba.algo3.modelo.moduloLector.LectorEnemigo;
public class Oleadas {

	private ArrayList<Oleada> oleadas;

	private void agregarOleada(Oleada oleada){
		oleadas.add(oleada);
	}
	public Oleadas(LectorEnemigo lector){
		oleadas = new ArrayList();
    	// cargas lector
        while(lector.haySiguiente()){
        	agregarOleada((Oleada)(lector.siguienteElemento().obtener()));
        }


	}

	public ArrayList<Enemigo> instanciar(int turno){
		if(noHayMasOleadas(turno)){
			return new ArrayList<>();
		}

		return oleadas.get(turno).instanciar();
	}

	public boolean noHayMasOleadas(int turno){
		return turno>= oleadas.size();
	}
}
