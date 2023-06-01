package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito;

public class mapaTest {
    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierra() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = Mockito.mock(Lector.class);

        Mockito.when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","tierra"));
        Mockito.when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector);

        assertEquals(unMapa.posicionar(enConstruccion),true);
        
    }

    @Test
    public void VerificarNoSePuedaConstruirDefensasSobreRoca() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = Mockito.mock(Lector.class);

        Mockito.when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","roca"));
        Mockito.when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector);

        assertEquals(unMapa.posicionar(enConstruccion),false);
        
    }    

    @Test
    public void VerificarNoSePuedaConstruirDefensasSobreRoca() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = Mockito.mock(Lector.class);

        Mockito.when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","pasarela"));
        Mockito.when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector);

        assertEquals(unMapa.posicionar(enConstruccion),false);
        
    }    

    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierraSoloUnaVez() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = Mockito.mock(Lector.class);

        Mockito.when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("1","2","tierra"));
        Mockito.when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector);

        unMapa.posicionar(enConstruccion)

        assertEquals(unMapa.posicionar(enConstruccion),false);
        
    }


}