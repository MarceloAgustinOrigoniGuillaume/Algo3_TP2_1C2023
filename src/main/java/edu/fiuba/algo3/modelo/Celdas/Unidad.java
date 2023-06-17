package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Celdas.Ataque;
import edu.fiuba.algo3.modelo.Celdas.SistemaVida;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;

public interface Unidad extends Ataque, SistemaVida, Posicionable {
	int velocidad();
	void reducirVelocidad();
	int creditosDados();
}