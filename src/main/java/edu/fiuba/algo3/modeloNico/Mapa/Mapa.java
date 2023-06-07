package edu.fiuba.algo3.modeloNico.Mapa;

import edu.fiuba.algo3.modeloNico.Celdas.*;

public class Mapa {

    private Celda[][] matrix15;
    private Coordenada posicionInicial;
    private Coordenada posicionFinal;

    public Mapa(Celda[][] matriz, Coordenada posInicial, Coordenada posFinal) {
        this.matrix15 = matriz;
        this.posicionInicial = posInicial;
        this.posicionFinal = posFinal;
    }

}
