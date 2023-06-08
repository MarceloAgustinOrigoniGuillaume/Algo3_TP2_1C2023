package edu.fiuba.algo3.modeloNico;

import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modeloNico.Estados.EstadoInicial;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJuego;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJugando;
import edu.fiuba.algo3.modeloNico.Defensas.EstructurasActivas;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Juego {
    private EstadoJuego estadoDeJuego;
    private Mapa mapa;
    private Jugador jugador;
    private EstructurasActivas estructuras;
    private Oleadas oleadas; //La clase oleadas almacena un vector de enemigos.

    public Juego(String jsonMapa,String jsonEnemigos) throws IOException, ParseException {
        this.estadoDeJuego = new EstadoInicial(this,jsonMapa,jsonEnemigos);
        estadoDeJuego.ejecutarEstado();
    }

    public void iniciarJuego() {
        this.estadoDeJuego = new EstadoJugando(this);
        estadoDeJuego.ejecutarEstado();
    }


    public void asignarMapa(Mapa mapa){
        this.mapa = mapa;
    }

    public void asignarOleadas(Oleadas oleadas){

        this.oleadas = oleadas;

    }


    public void resetEstructurasActivas(){

        /*
        if( estructuras != null){
            // clean mapa 
        }
        */

        estructuras = new EstructurasActivas();
    }


    public Jugador obtenerJugador(){
        return jugador;
    }

    public EstructurasActivas obtenerEstructuras(){
        return estructuras;
    }

    public Mapa obtenerMapa(){
        return mapa;
    }

    public Oleadas obtenerOleadas(){
        return oleadas;
    }



}
