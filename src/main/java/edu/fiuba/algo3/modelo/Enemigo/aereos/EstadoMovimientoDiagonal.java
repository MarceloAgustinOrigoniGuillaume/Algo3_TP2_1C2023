package edu.fiuba.algo3.modelo.Enemigo.aereos;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class EstadoMovimientoDiagonal implements EstadoMovimiento{
    private EnemigoAereo enemigo;
    public EstadoMovimientoDiagonal(EnemigoAereo enemigo){
        this.enemigo = enemigo;
    }
    @Override
    public boolean ejecutarEstado(Mapa mapa, Coordenada posicion) {

        Coordenada meta = mapa.posicionFinal();
        Coordenada desde = posicion;
        Coordenada hasta = meta;

        int x_nuevo = desde.x();
        int y_nuevo = desde.y();

        int x_final = hasta.x();
        int y_final = hasta.y();

        int restantePorMover = (this.enemigo).velocidad();

        while(restantePorMover >= 1 && x_nuevo < x_final && y_nuevo < y_final){
                restantePorMover-=1; //(ARREGLAR) El movimiento diagonal consume un movimiento, no 2 por ser en forma de L.
                x_nuevo+=1;
                y_nuevo+=1;
            }

        while(restantePorMover>0 && x_nuevo < x_final){
            restantePorMover-=1;
            x_nuevo+=1;
        }

        while(restantePorMover>0 && y_nuevo < y_final){
            restantePorMover-=1;
            y_nuevo+=1;
        }
        Coordenada coordenadaEsperada =  new Coordenada(x_nuevo,y_nuevo);
        mapa.moverEnCaminoAereo(this.enemigo, posicion, coordenadaEsperada);

        return(meta.equals(coordenadaEsperada));
    }
}
