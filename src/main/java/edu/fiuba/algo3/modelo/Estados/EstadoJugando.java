package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
//import edu.fiuba.algo3.modeloNico.Oleadas;
import edu.fiuba.algo3.modelo.Turnos.Turno;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.Unidad;

public class EstadoJugando implements EstadoJuego {
    Juego juego;
    Turno turno;
    public EstadoJugando(Juego juego) {
        this.juego = juego;
        turno = new Turno();
    }

    @Override
    public void ejecutarEstado() {
        Logger.info("Se ejecuta el turno: "+String.valueOf(turno.turnoActual()));

       // verificar si puede matar a jugador
        Jugador jugador = juego.obtenerJugador();
        Mapa mapa =juego.obtenerMapa();

        // verificar si no pueden hacer suficiente dmg?
        if(juego.obtenerOleadas().noHayMasOleadas(turno.turnoActual())
            && mapa.cantidadDmgPosible()< jugador.obtenerVida()){
            Logger.info("Finalizo el juegos. Los enemigos restantes no pueden matar al jugador");
            
            juego.terminarJuego();

            return;
        }

    	// jugar turno...
    	turno.jugarTurno(mapa,jugador, juego.obtenerOleadas());

        //System.out.println("--------->REVISANDO ENEMIGOS FINAL"); DEBBUGUEAR
        /*
        ArrayList<Unidad> enemigos = mapa.popUnidadesFinal();
        int ind = 0;

        while(!jugador.estaMuerto() && ind < enemigos.size()){

            jugador.recibirAtaque(enemigos.get(ind).ataque());
            ind+=1;
        }
        */
        
        Logger.info("Vida actual de jugador: "+String.valueOf(jugador.obtenerVida()));

        if(jugador.estaMuerto()){
            Logger.info("Los enemigos mataron al jugador. Fin del juego");
            juego.terminarJuego();
        }
    }
}
