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


    public static class jugadorTest {
        @Test
        public void verificarQueJugadorEmpiezaConVidaYCreditosCorrespondientes() {
            Jugador jugador = new Jugador();
            assertEquals(100,jugador.obtenerCreditos());
            assertEquals(20,jugador.obtenerVida());
        }

        @Test
        public void verificarQueSeDispongaDeCreditoParaRealizarConstrucciones() {
            Jugador jugador = new Jugador();
            TorreBlanca torreBlanca = new TorreBlanca();
            assertEquals(jugador.puedeCostear(torreBlanca),true);
        }
        @Test
        public void verificarQueNoSeDispongaDeCreditoParaRealizarConstrucciones() {
            Jugador jugador = new Jugador();
            TorreBlanca torreBlanca = new TorreBlanca();

            for (int i = 0; i < 10;i++){
                assertEquals(jugador.puedeCostear(torreBlanca),true);
                jugador.costear(torreBlanca);
            }
            assertEquals(jugador.puedeCostear(torreBlanca),false);
        }

        @Test
        public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarSpider() {
            Jugador jugador = new Jugador();

            jugador.ganoCreditos(10);

            assertTrue(jugador.obtenerCreditos() > 100);
            assertTrue(jugador.obtenerCreditos() <=110);

        }


    }
}
