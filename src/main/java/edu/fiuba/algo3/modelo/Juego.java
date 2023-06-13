package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Defensas.Estructura;
import edu.fiuba.algo3.modelo.Estados.EstadoInicial;
import edu.fiuba.algo3.modelo.Estados.EstadoJuego;
import edu.fiuba.algo3.modelo.Estados.EstadoJugando;
import edu.fiuba.algo3.modelo.Estados.EstadoTerminado;
import edu.fiuba.algo3.modelo.Oleadas;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Juego {
    private EstadoJuego estadoDeJuego;
    private Mapa mapa;
    private Jugador jugador;
    private Oleadas oleadas;

    private boolean estaJugando;
    //La clase oleadas almacena un vector de enemigos.

    public Juego(String jsonMapa,String jsonEnemigos) throws IOException, ParseException {
        jugador = new Jugador();
        this.estadoDeJuego = new EstadoInicial(this,jsonMapa,jsonEnemigos);
        estadoDeJuego.ejecutarEstado();
    }

    public void iniciarJuego() {
        this.estadoDeJuego = new EstadoJugando(this);
        this.estaJugando = true;
    }

    public void terminarJuego() {
        this.estadoDeJuego = new EstadoTerminado(this);
        this.estaJugando = false;
    }



    public void asignarMapa(Mapa mapa){
        this.mapa = mapa;
    }

    public void asignarOleadas(Oleadas oleadas){

        this.oleadas = oleadas;

    }

    public Jugador obtenerJugador(){
        return jugador;
    }
    public Mapa obtenerMapa(){
        return mapa;
    }

    public Oleadas obtenerOleadas(){
        return oleadas;
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
        estadoDeJuego.ejecutarEstado();
    }
    public boolean estanEnJuego(){
        return estaJugando;
    }

    public boolean ganoJugador(){
        return !estanEnJuego() && !jugador.estaMuerto();
    }
}
