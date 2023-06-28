package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

public interface OnHabitantesChangedListener {
	void cambio(Coordenada coordenada, CeldaDescriptor celda);
}
