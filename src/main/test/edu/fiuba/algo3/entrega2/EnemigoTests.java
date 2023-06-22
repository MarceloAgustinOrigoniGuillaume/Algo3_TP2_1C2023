package edu.fiuba.algo3.entrega2;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.SistemaCreditos;
//import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
//import edu.fiuba.algo3.modelo.moduloDefensas.TorreBlanca;
//import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;


public class EnemigoTests {
	@Test
    public void verificarQueEnemigoRecibaDamageCorrectamenteNoMuere() {


        Arania enemigo = new Arania();

        enemigo.recibirAtaque(1);

		assertEquals(false, enemigo.estaMuerto());        
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
    public void verificarQueJugadorNoGaneCreditosMatarLechuza() {

        Enemigo enemigo = new Lechuza();
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(0)).acreditarHormiga(any(Integer.class));
        verify(mockCreditosJugador, times(0)).acreditarArania(any(Integer.class));

    }


    @Test
    public void verificarQueJugadorNoGaneCreditosMatarTopo() {

        Enemigo enemigo = new Topo(1);
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(0)).acreditarHormiga(any(Integer.class));
        verify(mockCreditosJugador, times(0)).acreditarArania(any(Integer.class));

    }



    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarHormiga() {

        Enemigo enemigo = new Hormiga();
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(1)).acreditarHormiga(1);
        verify(mockCreditosJugador, times(0)).acreditarArania(any(Integer.class));

    }


    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarArania() {

        Enemigo enemigo = new Arania();
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(0)).acreditarHormiga(1);
        verify(mockCreditosJugador, times(1)).acreditarArania(any(Integer.class));

    }


}
