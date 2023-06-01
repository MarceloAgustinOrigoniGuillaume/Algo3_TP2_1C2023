package edu.fiuba.algo3.modelo.moduloLector;

import edu.fiuba.algo3.modelo.moduloMapa.Posicion;

public class ElementoMapa extends Elemento{
    public ElementoMapa(String x,String y,String tipo){
        super();
        this.agregar("Coordenada_X",x);
        this.agregar("Coordenada_Y",y);
        this.agregar("tipo",tipo);
    }
}
