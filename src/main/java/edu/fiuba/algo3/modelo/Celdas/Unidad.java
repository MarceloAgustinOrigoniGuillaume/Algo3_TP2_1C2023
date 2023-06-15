package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Celdas.Ataque;
import edu.fiuba.algo3.modelo.Celdas.SistemaVida;

public interface Unidad extends Ataque, SistemaVida {
	int velocidad();
	void reducirVelocidad();
	int creditosDados();
}