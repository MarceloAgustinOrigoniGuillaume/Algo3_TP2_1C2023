package edu.fiuba.algo3.modeloNico.Estados;

import edu.fiuba.algo3.modeloNico.Juego;

import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modeloNico.Oleadas;
import edu.fiuba.algo3.modeloNico.Turnos.Turno;
import edu.fiuba.algo3.modeloNico.Defensas.EstructurasActivas;


public class EstadoJugando implements EstadoJuego {
    Juego juego;
    Turno turno;
    public EstadoJugando(Juego juego) {
        this.juego = juego;
        turno = new Turno();
    }

    @Override
    public void ejecutarEstado() {
       // juego.ejecutarTurno();

    	// fase construccion
    	


    	// jugar turno...
    	turno.jugarTurno(
    		juego.obtenerMapa(),
    		juego.obtenerEstructuras(),
    		juego.obtenerOleadas()
    		);
    }
}
