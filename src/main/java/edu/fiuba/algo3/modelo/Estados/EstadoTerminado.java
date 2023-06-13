package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.modelo.Juego;

public class EstadoTerminado implements EstadoJuego {
    private Juego juego;
    public EstadoTerminado(Juego juego) {


        this.juego = juego;    
        //juego.asignarMapa(mapa);
    }

    @Override
    public void ejecutarEstado() {
    	// no hace nada por ahora , solo para saber que esta terminado
        //System.out.println("--------->Ejecutar estado, terminado");

    }
}
