package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modeloNico.Defensas.TorreBlanca;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.fiuba.algo3.modeloNico.Juego;
import edu.fiuba.algo3.modeloNico.Jugador;

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






}
