package edu.fiuba.algo3.entrega_1;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloDefensas.TorreBlanca;
import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class enemigoTest {
	@Test
    public void verificarQueEnemigoRecibaDamageCorrectamenteNoMuere() {
        Jugador jugador = new Jugador();

        Spider enemigo = new Spider(new Posicion(0,0),jugador);

        enemigo.recibirDamage(1);

		assertEquals(enemigo.estaMuerto(),false);        
    }

	@Test
    public void verificarQueEnemigoRecibaDamageCorrectamenteMuere() {
        Jugador jugador = new Jugador();

        Spider enemigo = new Spider(new Posicion(0,0),jugador);

        enemigo.recibirDamage(1);
        enemigo.recibirDamage(1);

		assertEquals(enemigo.estaMuerto(),true);        
    }


    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarEnemigo() {
        Jugador jugador = new Jugador();

        Hormiga enemigo = new Hormiga(new Posicion(0,0),jugador);

        enemigo.recibirDamage(1);

		assertEquals(enemigo.estaMuerto(),true);        
    }
}
