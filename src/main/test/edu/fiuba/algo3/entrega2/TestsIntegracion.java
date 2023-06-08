package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.moduloLector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.moduloLector.LectorMapa;
import edu.fiuba.algo3.modeloNico.Defensas.TorreBlanca;
import edu.fiuba.algo3.modeloNico.Defensas.TorrePlateada;
import edu.fiuba.algo3.modeloNico.Enemigo.Arania;
import edu.fiuba.algo3.modeloNico.Enemigo.Hormiga;
import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.fiuba.algo3.modeloNico.Juego;
import edu.fiuba.algo3.modeloNico.Jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    public static class sistemaConstruccionTest {
        @Test
        public void verificarDefensaTardaEnContruirseLoQueDebePaseSerActivo() {
            TorrePlateada torrePlateada = new TorrePlateada();

            /*
            Posible separacion de test al verificar cada turno
            */

            assertEquals(torrePlateada.finalizoContruccion(),false);

            /*
            Recien para despues lo del Mock, al verificar que esten operativas
            */
        }

        @Test
        public void PasoUnTurno() throws Exception {
            TorrePlateada torrePlateada = new TorrePlateada();
            LectorMapa mockLector = mock(LectorMapa.class);


            when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
            when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

            Mapa unMapa = new Mapa(mockLector,1,1);

            torrePlateada.accionar(unMapa);
            assertEquals(torrePlateada.finalizoContruccion(),false);


            /*
            Recien para despues lo del Mock, al verificar que esten operativas
            */
        }

        @Test
        public void MultiplesTurno() throws Exception {
            TorrePlateada torrePlateada = new TorrePlateada();
            LectorMapa mockLector = mock(LectorMapa.class);


            when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
            when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

            Mapa unMapa = new Mapa(mockLector,1,1);

            torrePlateada.accionar(unMapa);
            torrePlateada.accionar(unMapa);
            torrePlateada.accionar(unMapa);


            assertEquals(torrePlateada.finalizoContruccion(),true);
        }}

    public static class enemigoTest {
        @Test
        public void verificarQueEnemigoRecibaDamageCorrectamenteNoMuere() {


            Arania enemigo = new Arania();

            enemigo.recibirAtaque(1);

            assertEquals(enemigo.estaMuerto(),false);
        }

        @Test
        public void verificarQueEnemigoRecibaDamageCorrectamenteMuere() {

            Arania enemigo = new Arania();

            enemigo.recibirAtaque(2);

            assertEquals(enemigo.estaMuerto(),true);
        }


        @Test
        public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarEnemigo() {

            Hormiga enemigo = new Hormiga();

            enemigo.recibirAtaque(1);

            assertEquals(enemigo.estaMuerto(),true);
        }
        @Test
        public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarSpider() {
            Jugador jugador = new Jugador();

            Arania enemigo = new Arania();

            enemigo.recibirAtaque(2);
            jugador.ganoCreditos(enemigo.creditosDados());
            assertTrue(jugador.obtenerCreditos() > 100);
            assertTrue(jugador.obtenerCreditos() <=110);

        }
        @Test
        public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarHormifa() {
            Jugador jugador = new Jugador();

            Hormiga enemigo = new Hormiga();

            enemigo.recibirAtaque(1);
            jugador.ganoCreditos(enemigo.creditosDados());
            assertTrue(jugador.obtenerCreditos() ==101);

        }


    }
}
