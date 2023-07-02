package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
//import edu.fiuba.algo3.modeloNico.Oleadas;
import edu.fiuba.algo3.modelo.Turnos.Turno;

public class EstadoJugando implements EstadoJuego {
    Juego juego;
    Turno turno;
    public EstadoJugando(Juego juego) {
        this.juego = juego;
        turno = new Turno();
    }

    //Pre: -
    //Post: Devuelve true si los ultimos enemigos son capaces de hacer suficiente daño para eliminar al jugador.
    private boolean terminoElJuego(Juego juego, Jugador jugador, Turno turno, Mapa mapa ){
        return juego.obtenerOleadas().noHayMasOleadas(turno.turnoActual()) && mapa.cantidadDamagePosible() < jugador.obtenerVida();
    }

    @Override
    public void ejecutarEstado() {

        Logger.info("Se ejecuta el turno:",String.valueOf(turno.turnoActual()));

       //Obtengo el jugador y el mapa.
        Jugador jugador = juego.obtenerJugador();
        Mapa mapa =juego.obtenerMapa();

        // verificar si los enemigos actuales pueden eliminar al jugador.
        if(terminoElJuego(this.juego, jugador, this.turno, mapa)){
            Logger.info("----------------Finalizo el juego. Los enemigos restantes no pueden matar al jugador");
            try{
                juego.terminarJuego();
            } catch(Exception ex){
                Logger.err("----------------Error al finalizar juego",ex);
            }
            return;
        }
    	// jugar turno...
        if(!turno.jugarTurno(mapa,jugador, juego.obtenerOleadas())){
            Logger.info("----------------Finalizo el juego. Jugador murio");
            try{
                juego.terminarJuego();
            } catch(Exception ex){
                Logger.err("----------------Error al finalizar juego",ex);
            }
            return;
        }

        Logger.info("----------------Vida actual de jugador final de turno:",String.valueOf(jugador.obtenerVida()));
        juego.notificarCambioTurno(turno.turnoActual());
    }


}
