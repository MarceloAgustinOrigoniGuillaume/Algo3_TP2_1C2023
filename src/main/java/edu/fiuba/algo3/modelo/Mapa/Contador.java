package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Celdas.CeldaConEnemigos;

public class Contador implements Mapa.AccionadorEnemigos{
	int damageTotal;
	@Override
    public boolean accionarEn(CeldaConEnemigos celda, Coordenada coordenada) {
		this.damageTotal = celda.obtenerDamagePosible(damageTotal);
		return true;
	}
}