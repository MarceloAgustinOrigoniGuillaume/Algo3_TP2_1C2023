package edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.instanciacion.Instanciador;
import edu.fiuba.algo3.modelo.Lector.LectorEnemigo;
import java.util.ArrayList;

public class Oleada {
	private ArrayList<ArrayList<Instanciador>> oleadas;

	private void agregaroleadas(ArrayList<Instanciador> instanciador){
		oleadas.add(instanciador);
	}
	public Oleada(LectorEnemigo lector) throws Exception {
		oleadas = new ArrayList();
		// cargas lector
		while(lector.haySiguiente()){
			agregaroleadas((ArrayList<Instanciador>)(lector.siguienteElemento().obtener()));
		}
	}
	public ArrayList<Enemigo> instanciar(int turno){
		if(noHayMasOleadas(turno)){
			return new ArrayList<>();
		}
		ArrayList<Enemigo> enemigosNuevos = new ArrayList<>();

		for(Instanciador instanciador : oleadas.get(turno-1)){
			instanciador.agregarInstanciasA(enemigosNuevos);
		}
		return enemigosNuevos;
	}
	public boolean noHayMasOleadas(int turno){
		return turno> oleadas.size();
	}
}
