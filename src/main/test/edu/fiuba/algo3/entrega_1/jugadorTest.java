package edu.fiuba.algo3.entrega_1;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloDefensas.TorreBlanca;
import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class jugadorTest {
    @Test
    public void verificarQueJugadorEmpiezaConVidaYCreditosCorrespondientes() {
        Jugador jugador = new Jugador();
        assertEquals(100,jugador.obtenerCreditos());
        assertEquals(20,jugador.obtenerVida());
    }

    @Test
    public void verificarQueSeDispongaDeCreditoParaRealizarConstrucciones() {
        Jugador jugador = new Jugador();
        TorreBlanca torreBlanca = new TorreBlanca(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torreBlanca);

        assertEquals(jugador.puedeCostear(enConstruccion),true);
    }
    @Test
    public void verificarQueNoSeDispongaDeCreditoParaRealizarConstrucciones() {
        Jugador jugador = new Jugador();
        TorreBlanca torreBlanca = new TorreBlanca(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torreBlanca);

        for (int i = 0; i < 10;i++){
            assertEquals(jugador.puedeCostear(enConstruccion),true);
            jugador.costear(enConstruccion);
        }
        assertEquals(jugador.puedeCostear(enConstruccion),false);
    }

    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarEnemigo() {
        Jugador jugador = new Jugador();

        Spider enemigo = new Spider(new Posicion(0,0),jugador);

        enemigo.recibirDamage(1);
        enemigo.recibirDamage(1);

        assertTrue(jugador.obtenerCreditos() > 100);
        assertTrue(jugador.obtenerCreditos() <=110);
        
    }

    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesSoloAlMatarEnemigo() {
        Jugador jugador = new Jugador();

        Spider enemigo = new Spider(new Posicion(0,0),jugador);

        enemigo.recibirDamage(1);

        assertEquals(jugador.obtenerCreditos(),100);        
        
    }


    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarEnemigo() {
        Jugador jugador = new Jugador();

        Hormiga enemigo = new Hormiga(new Posicion(0,0),jugador);

        enemigo.recibirDamage(1);

        assertEquals(jugador.obtenerCreditos(),101);        
    }


}