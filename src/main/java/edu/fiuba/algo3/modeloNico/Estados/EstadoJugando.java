package edu.fiuba.algo3.modeloNico.Estados;

import edu.fiuba.algo3.modeloNico.Juego;
import edu.fiuba.algo3.modeloNico.Jugador;

import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
//import edu.fiuba.algo3.modeloNico.Oleadas;
import edu.fiuba.algo3.modeloNico.Turnos.Turno;
import edu.fiuba.algo3.modeloNico.Defensas.EstructurasActivas;

import java.util.ArrayList;
import edu.fiuba.algo3.modeloNico.Celdas.Unidad;

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

        Jugador jugador = juego.obtenerJugador();
        ArrayList<Unidad> enemigos = juego.obtenerMapa().popUnidadesFinal();
        int ind = 0;

        while(!jugador.estaMuerto() && ind < enemigos.size()){

            enemigos.get(ind).atacar(jugador);
            ind+=1;
        }

        if(jugador.estaMuerto()){
            juego.terminarJuego();
        }
    }
}
