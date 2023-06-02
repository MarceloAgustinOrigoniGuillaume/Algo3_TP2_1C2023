package edu.fiuba.algo3.modelo.moduloDefensas;

import edu.fiuba.algo3.modelo.moduloMapa.Posicion;

public class TorreBlanca implements Defensa{

    public TorreBlanca(Posicion posicion) {
    }

    @Override
    public int turnoParaContruir() {
        return 1;
    }
    public int costoConstruccion(){
        return 10;
    }
}