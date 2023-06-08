package edu.fiuba.algo3.modeloNico;

import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modeloNico.Estados.EstadoInicial;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJuego;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJugando;
import edu.fiuba.algo3.modeloNico.Estados.EstadoTerminado;
import edu.fiuba.algo3.modeloNico.Defensas.EstructurasActivas;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Juego {
    private EstadoJuego estadoDeJuego;
    private Mapa mapa;
    private Jugador jugador;
    private Oleadas oleadas; //La clase oleadas almacena un vector de enemigos.

    public Juego(String jsonMapa,String jsonEnemigos) throws IOException, ParseException {
        jugador = new Jugador();
        this.estadoDeJuego = new EstadoInicial(this,jsonMapa,jsonEnemigos);
        estadoDeJuego.ejecutarEstado();
    }

    public void iniciarJuego() {
        this.estadoDeJuego = new EstadoJugando(this);
        estadoDeJuego.ejecutarEstado();
    }

    public void terminarJuego() {
        this.estadoDeJuego = new EstadoTerminado(this);
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



}
