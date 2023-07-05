package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Enemigo.Oleada;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Estados.EstadoInicial;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;
import edu.fiuba.algo3.modelo.Estados.EstadoJugando;
import edu.fiuba.algo3.modelo.Estados.EstadoTerminado;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.excepciones.juego.CambioDeEstadoInvalido;

public class Juego {
    private EstadoJuego estadoDeJuego;
    private Mapa mapa;
    private Jugador jugador;
    private Oleada oleada;

    private ObserverTurno observerTurno= (String turno)->{};
    private boolean estaJugando;
    //La clase oleadas almacena un vector de enemigos.

    private String jsonMapaUsed;
    private String jsonEnemigosUsed;

    public Juego nuevoJuego() throws Exception{
        return new Juego(jsonMapaUsed,jsonEnemigosUsed);
    }

    public Juego(String jsonMapa,String jsonEnemigos) throws Exception {

        this.jsonMapaUsed = jsonMapa;
        this.jsonEnemigosUsed= jsonEnemigos;
        jugador = new Jugador();

        this.estadoDeJuego = new EstadoInicial(this,jsonMapa,jsonEnemigos);
        estadoDeJuego.ejecutarEstado();
    }

    public void iniciarJuego() throws CambioDeEstadoInvalido {
        if(estaJugando){
            throw new CambioDeEstadoInvalido("Juego YA habia sido iniciado");
        }

        Logger.info("Juego fue empezado");
        this.estadoDeJuego = new EstadoJugando(this);
        this.estaJugando = true;
    }

    public void terminarJuego() throws CambioDeEstadoInvalido {

        if(!estaJugando){
            throw new CambioDeEstadoInvalido("Juego YA habia sido terminado, pero quiso terminarse otra vez");
        }
        Logger.info("Juego fue terminado");
        this.estadoDeJuego = new EstadoTerminado(this);
        this.estaJugando = false;
    }

    public void asignarMapa(Mapa mapa){
        this.mapa = mapa;
    }

    public void asignarOleadas(Oleada oleada){

        this.oleada = oleada;
    }
    public Jugador obtenerJugador(){
        return jugador;
    }
    public Mapa obtenerMapa(){
        return mapa;
    }
    public Oleada obtenerOleadas(){

        return oleada;
    }
    public boolean posicionar(Defensa estructura, Coordenada pos){
        if(!jugador.puedeCostear(estructura)){
            return false;
        }
        if(!mapa.posicionar(pos, estructura)){
            return false;
        }
        jugador.costear(estructura);
        return true;
    }

    public void pasarTurno() {
        try{
            estadoDeJuego.ejecutarEstado();
        } catch(Exception ex){
            // ocurrio un error...
            Logger.err("at pasarTurno ",ex);
            ex.printStackTrace();
        }
    }
    public boolean estanEnJuego(){
        return estaJugando;
    }

    public boolean ganoJugador(){
        return !estanEnJuego() && !jugador.estaMuerto();
    }

    public interface ObserverTurno{
        void updateTurno(String turno);
    }

    public void setObserverTurno(ObserverTurno observerTurno) {
        if(observerTurno == null){
            this.observerTurno= (String turno)->{};
            return;
        }
        this.observerTurno = observerTurno;
    }
    public void notificarCambioTurno(int turno){
        this.observerTurno.updateTurno(String.valueOf(turno));
    }
}
