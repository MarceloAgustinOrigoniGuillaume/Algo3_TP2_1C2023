package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class mapaTest {
    @Test
    public void VerificarSoloSePuedaConstruirDefensasSobreTierra() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enContruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = mock(Lector.class);
        Mapa unMapa = new Mapa(mockLector);

        assertEquals(unMapa.posicionar(enContruccion),true);

    }

}