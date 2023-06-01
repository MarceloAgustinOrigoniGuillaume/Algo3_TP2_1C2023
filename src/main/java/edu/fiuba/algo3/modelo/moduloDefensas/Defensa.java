package edu.fiuba.algo3.modelo.moduloDefensas;

import edu.fiuba.algo3.modelo.moduloMapa.GameEntity;

public interface Defensa  extends GameEntity {
    int turnoParaContruir();
    int costoConstruccion();
}
