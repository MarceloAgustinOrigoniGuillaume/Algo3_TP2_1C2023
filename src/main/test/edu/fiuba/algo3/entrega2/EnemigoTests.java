package edu.fiuba.algo3.entrega2;


import edu.fiuba.algo3.modelo.Billetera;
import edu.fiuba.algo3.modelo.Jugador;
//import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
//import edu.fiuba.algo3.modelo.moduloDefensas.TorreBlanca;
//import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarSpider() {

        Jugador jugador = new Jugador();
        Arania enemigo = new Arania();

        enemigo.recibirAtaque(2);
        //assertTrue(jugador.obtenerCreditos() > 100);
        //assertTrue(jugador.obtenerCreditos() <=110);

    }
    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarHormifa() {

        Billetera billetera = Billetera.getInstance();
        billetera.restablecerCreditos();

        Jugador jugador = new Jugador();

        Hormiga enemigo = new Hormiga();

        enemigo.recibirAtaque(1);
        assertTrue(jugador.obtenerCreditos() ==101);

    }


}
