package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.Resources;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.Defensas.TorrePlateada;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Celdas.Unidad;
import java.util.ArrayList;


public class TestsIntegracion {
    @Test
    public void verficarSeCreaJugadorCorrectamente() throws IOException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa"),Resources.getJsonPath("test/enemigos"));
        Jugador jugador = juego.obtenerJugador();
        assertEquals(100,jugador.obtenerCreditos());
        assertEquals(20,jugador.obtenerVida());

    }
    @Test
    public void verficarPasarTurnosMapaCatedra() throws IOException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa"),Resources.getJsonPath("test/enemigos"));
        juego.iniciarJuego();
        int i =0;
        while(juego.estanEnJuego() && i <100){
            juego.pasarTurno();
            i++;
        }

        //System.out.println("T_----------------MAXIMO DMG "+String.valueOf(juego.obtenerMapa().cantidadDmgPosible()));
        //System.out.println("T_----------------VIDA JUGADOR "+String.valueOf(juego.obtenerJugador().obtenerVida()));

        assertEquals(false, juego.estanEnJuego());
        //TODO corregir el test para que termine el juego
    }


    @Test
    public void verificarJuegoSoloSeIniciaCuandoSeInicia() throws IOException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa"),Resources.getJsonPath("test/enemigos"));
        juego.iniciarJuego();
        int i =0;
        
        assertEquals(true, juego.estanEnJuego());
        //TODO corregir el test para que termine el juego
    }


    @Test
    public void verificarPasarTurnoYCreaEnemigos() throws IOException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        ArrayList<Unidad> unidadesInicio;
        Coordenada posActual = new Coordenada(2,1);
        int i =0;
        
        juego.pasarTurno();
        unidadesInicio = juego.obtenerMapa().obtenerUnidades(posActual);
        
        assertEquals(true, juego.estanEnJuego());
        assertEquals(4, unidadesInicio.size());

        //TODO corregir el test para que termine el juego
    }

    @Test
    public void verificarPasan2TurnosCreaYMueveEnemigos() throws IOException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        ArrayList<Unidad> unidadesInicio;
        ArrayList<Unidad> unidadesSiguiente;
        Coordenada posActual = new Coordenada(2,1);
        Coordenada posSiguiente = new Coordenada(2,2);
        int i =0;
        
        juego.pasarTurno();
        juego.pasarTurno();
        unidadesInicio = juego.obtenerMapa().obtenerUnidades(posActual);
        unidadesSiguiente = juego.obtenerMapa().obtenerUnidades(posSiguiente);
        
        assertEquals(true, juego.estanEnJuego());
        assertEquals(2, unidadesInicio.size());
        assertEquals(4, unidadesSiguiente.size());

        //TODO corregir el test para que termine el juego
    }

    @Test
    public void verificarPasan6TurnosHormigasInicialesLleganFinal() throws IOException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();
        //System.out.println("PASO DE 6 TURNOS");

        ArrayList<Unidad> unidadesFinal;
        Coordenada posSiguiente = new Coordenada(5,3);
        //int i =0;
        
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();

        unidadesFinal = juego.obtenerMapa().obtenerUnidades(posSiguiente);
        
        // llegaron 4 hormigas
        assertEquals(true, juego.estanEnJuego());
        assertEquals(0,unidadesFinal.size());
        assertEquals(16, juego.obtenerJugador().obtenerVida()); // dmg de 4 hormigas
        //System.out.println("T_----------------TEST 6 turnos");


        //TODO corregir el test para que termine el juego
    }


    @Test
    public void verificarPasan13TurnosEnemigosMatanJugador() throws IOException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();
        //System.out.println("PASO DE 12 TURNOS Juego termino");

        ArrayList<Unidad> unidadesFinal;
        Coordenada posSiguiente = new Coordenada(5,3);
        try{
            for(int i = 0; i<12 ; i++){
                juego.pasarTurno();
            }            
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        assertEquals(false, juego.estanEnJuego());
        assertEquals(0, juego.obtenerJugador().obtenerVida()); // murio
        assertEquals(false,juego.ganoJugador()); 
        
        //TODO corregir el test para que termine el juego
        //System.out.println("T_----------------TEST 13 turnos");
    }


    @Test
    public void verificarPasan13ConUnaTorrePlateadaTurno2JugadorGana() throws IOException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();
        //System.out.println("PASO DE 12 TURNOS Juego termino, con defensa");

        ArrayList<Unidad> unidadesFinal;
        Coordenada posSiguiente = new Coordenada(5,3);
        try{

            juego.pasarTurno();
            juego.posicionar(new TorrePlateada(), new Coordenada(3,2));

            for(int i = 0; i<7 ; i++){
                juego.pasarTurno();
            }            
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        assertEquals(false, juego.estanEnJuego());
        //System.out.println("LA VIDA DEL JUGADOR ERA "+String.valueOf(juego.obtenerJugador().obtenerVida()));
        //System.out.println("Creditos DEL JUGADOR ERAN "+String.valueOf(juego.obtenerJugador().obtenerCreditos()));
        assertEquals(true, juego.ganoJugador()); 
        
        //assertEquals(0, juego.obtenerJugador().obtenerVida()); // dmg de 4 hormigas
        //TODO corregir el test para que termine el juego
        //System.out.println("T_----------------TEST 13 turnos");
    }



    @Test
    public void verificarPasanConUnaTorrePlateadaTurno2NoActivaPor2Turnos() throws IOException, ParseException, ParseException {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"), Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();
        //System.out.println("Paso 2 con defensa");

        ArrayList<Unidad> unidadesFinal;
        Coordenada posSiguiente = new Coordenada(5,3);
        try{

            juego.pasarTurno();
            //juego.posicionar(new TorrePlateada(), new Coordenada(3,2));
            juego.pasarTurno();

        } catch(Exception ex){
            ex.printStackTrace();
        }
        // hay hormigas en rango, por lo que si el jugador gano creditos o dmg maximo disminuyo 
        // alguien murio, defensa ataco, al ser hormigas moririan.
        
        assertEquals(true, juego.estanEnJuego());
        //System.out.println("T_----------------MAXIMO DMG "+String.valueOf(juego.obtenerMapa().cantidadDmgPosible()));
        //assertEquals(80, juego.obtenerJugador().obtenerCreditos()); // creditos tras la compra
        assertEquals(100, juego.obtenerJugador().obtenerCreditos()); // creditos tras la NO compra
        assertEquals(6,juego.obtenerMapa().cantidadDmgPosible()); // dmg de 6 hormigas instanciadas
    }



}
