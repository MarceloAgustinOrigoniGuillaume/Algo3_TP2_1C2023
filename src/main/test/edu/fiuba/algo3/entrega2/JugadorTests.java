package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.SistemaCreditos;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;



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
       public void verificarQueJugadorDelegeAEnemigoElAcreditarse() {
            Jugador jugador = new Jugador();
            Arania mockEnemigo = mock(Arania.class);

            ArrayList<Enemigo> muertos = new ArrayList<>();
            muertos.add(mockEnemigo);

            jugador.acreditarMuertos(muertos);

            verify(mockEnemigo, times(1)).acreditarseEn(any(SistemaCreditos.class));
        }


       @Test
       public void verificarQueJugadorDelegeAEnemigoElAcreditarseConVarios() {
            Jugador jugador = new Jugador();
            Arania mockEnemigo = mock(Arania.class);
            Topo mockEnemigo2 = mock(Topo.class);

            ArrayList<Enemigo> muertos = new ArrayList<>();
            muertos.add(mockEnemigo);
            muertos.add(mockEnemigo2);

            jugador.acreditarMuertos(muertos);

            verify(mockEnemigo, times(1)).acreditarseEn(any(SistemaCreditos.class));
            verify(mockEnemigo2, times(1)).acreditarseEn(any(SistemaCreditos.class));
        }




        // otros










        // Generales, mas de integracion
        @Test
        public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarSpider() {

            Jugador jugador = new Jugador();


            ArrayList<Enemigo> muertos = new ArrayList<>();

            muertos.add(new Arania());
            jugador.acreditarMuertos(muertos);

            assertTrue(jugador.obtenerCreditos() > 100);
            assertTrue(jugador.obtenerCreditos() <= 110);
        }





        @Test
        public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarHormiga() {

            Jugador jugador = new Jugador();


            ArrayList<Enemigo> muertos = new ArrayList<>();

            muertos.add(new Hormiga());
            jugador.acreditarMuertos(muertos);

            assertEquals(101, jugador.obtenerCreditos());
        }


        @Test
        public void verificarQueJugadorGaneCreditosCorrespondientesAlMatar3Hormigas() {

            Jugador jugador = new Jugador();


            ArrayList<Enemigo> muertos = new ArrayList<>();

            for(int i = 0; i<3; i++){
                muertos.add(new Hormiga());
            }

            jugador.acreditarMuertos(muertos);

            assertEquals(103, jugador.obtenerCreditos());
        }


        @Test
        public void verificarQueJugadorGaneCreditosCorrespondientesAlMatar20Hormigas() {

            Jugador jugador = new Jugador();


            ArrayList<Enemigo> muertos = new ArrayList<>();

            for(int i = 0; i<20; i++){
                muertos.add(new Hormiga());
            }

            jugador.acreditarMuertos(muertos);

            // 9 van a darte solo 1
            // 11 te van a dar 2. 11*2 + 9 == 31 + 100 = 131
            assertEquals(131, jugador.obtenerCreditos());
        }


        @Test
        public void verificarQueJugadorNoGaneCreditosPorTopoOLechuza() {

            Jugador jugador = new Jugador();


            ArrayList<Enemigo> muertos = new ArrayList<>();
            muertos.add(new Topo(1));
            muertos.add(new Lechuza());

            jugador.acreditarMuertos(muertos);

            assertEquals(100, jugador.obtenerCreditos());
        }




}
