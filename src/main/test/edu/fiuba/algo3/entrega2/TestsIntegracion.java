package edu.fiuba.algo3.entrega2;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsIntegracion {
    @Test
    public void verficarSeCreaJugadorCorrectamente() throws IOException, ParseException {
        Juego juego = new Juego("src/main/resorces/mapa.json","src/main/resorces/enemigos.json");
        Jugador jugador = juego.obtenerJugador();
        assertEquals(100,jugador.obtenerCreditos());
        assertEquals(20,jugador.obtenerVida());

    }
    @Test
    public void verficarPasarTurno() throws IOException, ParseException {
        Juego juego = new Juego("src/main/resorces/mapa.json","src/main/resorces/enemigos.json");
        juego.iniciarJuego();
        int i =0;
        while(juego.estanEnJuego() && i >20){
            juego.pasarTurno();
            i++;
        };
//        assertEquals(juego.estanEnJuego(),false);
        //TODO corregir el test para que termine el juego
    }




}
