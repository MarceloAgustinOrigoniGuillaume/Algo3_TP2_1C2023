package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.modelo.Billetera;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;


public class IntegracionTests {
    @Test
    public void verficarSeCreaJugadorCorrectamente() throws Exception {

        Juego juego = new Juego(Resources.getJsonPath("mapa"),Resources.getJsonPath("enemigos"));
        Jugador jugador = juego.obtenerJugador();

        assertEquals(100,jugador.obtenerCreditos());
        assertEquals(20,jugador.obtenerVida());

    }
    @Test
    public void verficarPasarTurnosMapaCatedra() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("mapa"),Resources.getJsonPath("enemigos"));
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
    public void verificarJuegoSoloSeIniciaCuandoSeInicia() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("mapa"),Resources.getJsonPath("enemigos"));
        juego.iniciarJuego();
        int i =0;
        
        assertEquals(true, juego.estanEnJuego());
        //TODO corregir el test para que termine el juego
    }


    @Test
    public void verificarPasarTurnoYCreaEnemigos() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        CeldaDescriptor unidadesInicio;
        Coordenada posActual = new Coordenada(2,1);
        int i =0;
        
        juego.pasarTurno();
        unidadesInicio = juego.obtenerMapa().obtenerInformacion(posActual);
        
        assertEquals(true, juego.estanEnJuego());
        assertEquals(4, unidadesInicio.cantidadEnemigos());

        //TODO corregir el test para que termine el juego
    }

    @Test
    public void verificarPasan2TurnosCreaYMueveEnemigos() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        CeldaDescriptor unidadesInicio;
        CeldaDescriptor unidadesSiguiente;
        Coordenada posActual = new Coordenada(2,1);
        Coordenada posSiguiente = new Coordenada(2,2);
        int i =0;
        
        juego.pasarTurno();
        juego.pasarTurno();
        unidadesInicio = juego.obtenerMapa().obtenerInformacion(posActual);
        unidadesSiguiente = juego.obtenerMapa().obtenerInformacion(posSiguiente);
        
        assertEquals(true, juego.estanEnJuego());
        assertEquals(2, unidadesInicio.cantidadEnemigos());
        assertEquals(4, unidadesSiguiente.cantidadEnemigos());

        //TODO corregir el test para que termine el juego
    }

    @Test
    public void verificarPasan6TurnosHormigasInicialesLleganFinal() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();
        //System.out.println("PASO DE 6 TURNOS");

        CeldaDescriptor unidadesFinal;
        Coordenada posSiguiente = new Coordenada(5,3);
        //int i =0;
        
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();
        juego.pasarTurno();

        unidadesFinal = juego.obtenerMapa().obtenerInformacion(posSiguiente);
        
        // llegaron 4 hormigas
        assertEquals(true, juego.estanEnJuego());
        assertEquals(16, juego.obtenerJugador().obtenerVida()); // dmg de 4 hormigas
        assertEquals(0,unidadesFinal.cantidadEnemigos());
        //System.out.println("T_----------------TEST 6 turnos");


        //TODO corregir el test para que termine el juego
    }


    @Test
    public void verificarPasan13TurnosEnemigosMatanJugador() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        CeldaDescriptor unidadesFinal;
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
    public void verificarPasan13ConUnaTorrePlateadaTurno2JugadorGana() throws Exception {

        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();
        System.out.println("PASO DE 12 TURNOS Juego termino, con defensa");

        CeldaDescriptor unidadesFinal;
        Coordenada posSiguiente = new Coordenada(5,3);
        try{

            juego.pasarTurno();
            juego.posicionar(new TorrePlateada(), new Coordenada(3,2));

            for(int i = 0; i<9 ; i++){
                juego.pasarTurno();
            }            
        } catch(Exception ex){
            ex.printStackTrace();
        }

        //System.out.println("------> TEST ESTE ... LA VIDA DEL JUGADOR ERA "+String.valueOf(juego.obtenerJugador().obtenerVida()));
        //System.out.println("-------> TESTE ESTE ... Creditos DEL JUGADOR ERAN "+String.valueOf(juego.obtenerJugador().obtenerCreditos()));
       // assertEquals(false, juego.estanEnJuego());
        //assertEquals(true, juego.ganoJugador());
        
        //assertEquals(0, juego.obtenerJugador().obtenerVida()); // dmg de 4 hormigas
        //TODO corregir el test para que termine el juego
        //System.out.println("T_----------------TEST 13 turnos");
    }



    @Test
    public void verificarPasanConUnaTorrePlateadaTurno2NoActivaPor2Turnos() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"), Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();
        //System.out.println("-------------------->Paso 2 con defensa");

        CeldaDescriptor unidadesFinal;
        Coordenada posSiguiente = new Coordenada(5,3);
        try{

            juego.pasarTurno();
            juego.posicionar(new TorrePlateada(), new Coordenada(3,2));
            juego.pasarTurno();

        } catch(Exception ex){
            ex.printStackTrace();
        }
        // hay hormigas en rango, por lo que si el jugador gano creditos o dmg maximo disminuyo 
        // alguien murio, defensa ataco, al ser hormigas moririan.
        
        assertEquals(true, juego.estanEnJuego());
        //System.out.println("T_----------------MAXIMO DMG "+String.valueOf(juego.obtenerMapa().cantidadDmgPosible()));
        assertEquals(80, juego.obtenerJugador().obtenerCreditos()); // creditos tras la compra
        assertEquals(6,juego.obtenerMapa().cantidadDamagePosible()); // dmg de 6 hormigas instanciadas
    }



}
