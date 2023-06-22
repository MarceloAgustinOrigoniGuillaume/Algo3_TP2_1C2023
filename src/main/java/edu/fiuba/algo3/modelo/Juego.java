package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Defensas.Estructura;
import edu.fiuba.algo3.modelo.Estados.EstadoInicial;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;
import edu.fiuba.algo3.modelo.Estados.EstadoJugando;
import edu.fiuba.algo3.modelo.Estados.EstadoTerminado;
import org.json.simple.parser.ParseException;
import edu.fiuba.algo3.Logger;

import java.io.IOException;

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

    public void iniciarJuego() {
        Logger.Log("Juego fue iniciado!!");
        this.estadoDeJuego = new EstadoJugando(this);
        this.estaJugando = true;
    }

    public void terminarJuego() {

        if(this.estaJugando == false){
            Logger.Log("Juego YA habia sido terminado, pero quiso terminarse otra vez");
            return;
        }
        Logger.Log("Juego fue terminado!!");
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
    public boolean posicionar(Estructura estructura, Coordenada pos){
        if(!jugador.puedeCostear(estructura)){
            return false;
        }

        if(!mapa.posicionar(pos, estructura)){
            return false;
        }

        jugador.costear(estructura);
        //System.out.println("-->Posiciono defensa "+pos.toString()+" creditos jugador "+String.valueOf(jugador.obtenerCreditos()));
        return true;
    }

    public void pasarTurno() {
        //System.out.println("JUEGO PASAR TURNO, EJECUTANDO ESTADO");
        try{
            estadoDeJuego.ejecutarEstado();
        } catch(Exception ex){
            // ocurrio un error...
            Logger.Log("Error at pasarTurno "+ex.toString());
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
