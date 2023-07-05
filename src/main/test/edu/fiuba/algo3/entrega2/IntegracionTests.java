package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import static org.junit.jupiter.api.Assertions.*;


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
    }

    @Test
    public void verificarPasan6TurnosHormigasInicialesLleganFinal() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        CeldaDescriptor unidadesFinal;
        Coordenada posSiguiente = new Coordenada(5,3);
        
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
    }


    @Test
    public void verificarPasan13ConUnaTorrePlateadaYUnaTorreBlancaTurno2JugadorGana() throws Exception {

        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        juego.posicionar(new TorrePlateada(), new Coordenada(1,3));
        juego.posicionar(new TorreBlanca(), new Coordenada(3,2));

        assertEquals(70,juego.obtenerJugador().obtenerCreditos());

        for (int i = 0; i < 8; i++) {
            juego.pasarTurno();
        }

        assertEquals(78, juego.obtenerJugador().obtenerCreditos());


        assertEquals(false,juego.estanEnJuego());
        assertEquals(true, juego.ganoJugador());
    }

    @Test
    public void verificarSeCreanConstruccionesLejanasYJugadorPierde() throws Exception {

        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        juego.posicionar(new TorrePlateada(), new Coordenada(15,15));
        juego.posicionar(new TorreBlanca(), new Coordenada(14,14));
        juego.posicionar(new Trampa(), new Coordenada(5,3));

        assertEquals(45,juego.obtenerJugador().obtenerCreditos());

        for (int i = 0; i < 10; i++) {
            juego.pasarTurno();
        }

        assertEquals(11, juego.obtenerJugador().obtenerVida());

        juego.pasarTurno();
        juego.pasarTurno();

        assertEquals(false, juego.ganoJugador());
        assertEquals(false,juego.estanEnJuego());
    }


    @Test
    public void verificarSeCreanConstruccionesLejanasRepetitivamenteUnaYJugadorPierde() throws Exception {

        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        juego.posicionar(new TorrePlateada(), new Coordenada(15,15));
        juego.posicionar(new Trampa(), new Coordenada(5,3));

        assertEquals(55,juego.obtenerJugador().obtenerCreditos());

        int contador =0;
        for (int i = 0; i < 10; i++) {
            juego.pasarTurno();
            if(juego.posicionar(new TorreBlanca(), new Coordenada(14,14))){
                contador++;
            }
        }

        assertEquals(1, contador); // solo la construyo una vez.

        assertEquals(11, juego.obtenerJugador().obtenerVida());

        juego.pasarTurno();
        juego.pasarTurno();

        assertEquals(false, juego.ganoJugador());
        assertEquals(false,juego.estanEnJuego());
    }

    @Test
    public void verificaQueNoSePuedenConstruirMasTorresPorQueNoTieneCreditos() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("test/mapa_sencillo"),Resources.getJsonPath("test/enemigos_sencillo_no_mata"));
        juego.iniciarJuego();

        assertEquals(true,juego.posicionar(new TorrePlateada(), new Coordenada(15,15)));
        assertEquals(true,juego.posicionar(new TorreBlanca(), new Coordenada(14,14)));
        assertEquals(false,juego.posicionar(new TorrePlateada(), new Coordenada(15,15)));

        for (int i = 2; i < 9; i++) {
            assertEquals(true,juego.posicionar(new TorreBlanca(), new Coordenada(1,i)));
        }
        assertEquals(0, juego.obtenerJugador().obtenerCreditos());
        assertEquals(false,juego.posicionar(new TorrePlateada(), new Coordenada(1,10)));
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
