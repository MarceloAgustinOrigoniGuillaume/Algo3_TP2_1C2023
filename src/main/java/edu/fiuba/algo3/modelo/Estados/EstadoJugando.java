package edu.fiuba.algo3.modelo.Estados;

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
        //System.out.println("--------->Ejecutar estado, jugando, turno "+String.valueOf(turno.turnoActual()));

       // verificar si puede matar a jugador
        Jugador jugador = juego.obtenerJugador();
        Mapa mapa =juego.obtenerMapa();

        // verificar si no pueden hacer suficiente dmg?
        if(juego.obtenerOleadas().noHayMasOleadas(turno.turnoActual())
            && mapa.cantidadDmgPosible()< jugador.obtenerVida()){ 
            //System.out.println("--------->Juego finalizo, enemigos no podian matar jugador");
            
            juego.terminarJuego();

            return;
        }


    	// jugar turno...
    	turno.jugarTurno(mapa,jugador,
    		juego.obtenerOleadas()
    		);

        //System.out.println("--------->REVISANDO ENEMIGOS FINAL");
        ArrayList<Unidad> enemigos = mapa.popUnidadesFinal();
        int ind = 0;

        while(!jugador.estaMuerto() && ind < enemigos.size()){

            jugador.recibirAtaque(enemigos.get(ind).ataque());
            ind+=1;
        }
        //System.out.println("--------->REVISANDO ENEMIGOS FINAL--> muerto? "+String.valueOf(jugador.obtenerVida()));

        if(jugador.estaMuerto()){
            //System.out.println("--------->Juego finalizo, jugador murio");
            juego.terminarJuego();
        }
    }
}
