package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;

public interface OnEnemiesDiedListener{
	void acreditarMuertos(ArrayList<Enemigo> muertos);
}