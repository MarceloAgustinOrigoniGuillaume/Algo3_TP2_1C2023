package edu.fiuba.algo3.modelo.moduloDefensas;

import edu.fiuba.algo3.modelo.moduloMapa.Posicion;

public class TorrePlateada implements Defensa {
    public TorrePlateada(Posicion posicion) {
    }

    @Override
    public int turnoParaContruir() {
        return 2;
    }

    @Override
    public int costoConstruccion() {
        return 20;
    }
}
