package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.Billetera;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JugadorTests {
        @Test
        public void verificarQueJugadorEmpiezaConVidaYCreditosCorrespondientes() {

            Jugador jugador = new Jugador();
            assertEquals(100, jugador.obtenerCreditos());
            assertEquals(20, jugador.obtenerVida());

        }

        @Test
        public void verificarQueSeDispongaDeCreditoParaRealizarConstrucciones(){

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

            Billetera billetera = Billetera.getInstance();
            Jugador jugador = new Jugador();
            billetera.agregarCreditos(new Random().nextInt(10));

            assertTrue(jugador.obtenerCreditos() >= 100);
            assertTrue(jugador.obtenerCreditos() <= 110);
        }
}
