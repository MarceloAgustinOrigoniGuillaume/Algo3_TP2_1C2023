package edu.fiuba.algo3.celdas;


import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Enemigo.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.Arania;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabitantesTests {
	@Test
    public void verificarHabitantesPasarelaGuardaEnemigos() {

        
        Arania enemigo = new Arania();

        enemigo.recibirAtaque(1);

		assertEquals(enemigo.estaMuerto(),false);        
    }
}
