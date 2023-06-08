package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modeloNico.Defensas.TorreBlanca;
import edu.fiuba.algo3.modeloNico.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JugadorTest {
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
