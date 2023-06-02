package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.moduloLector.ElementoMapa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import edu.fiuba.algo3.modelo.moduloEnemigos.Hormiga;
import edu.fiuba.algo3.modelo.Jugador;

public class mapaTest {
    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierra() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = mock(Lector.class);


        when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector);

        assertEquals(unMapa.posicionar(enConstruccion),true);
        
    }

    @Test
    public void VerificarNoSePuedaConstruirDefensasSobreRoca() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = mock(Lector.class);

        when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","Rocoso"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector);

        assertEquals(unMapa.posicionar(enConstruccion),false);
        
    }    

    @Test
    public void VerificarNoSePuedaConstruirDefensasSobrePasarela() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = mock(Lector.class);

        when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector);

        assertEquals(unMapa.posicionar(enConstruccion),false);
        
    }    

    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierraSoloUnaVez() {
        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
        ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        Lector mockLector = mock(Lector.class);

        when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector);

        unMapa.posicionar(enConstruccion);

        assertEquals(unMapa.posicionar(enConstruccion),false);
        
    }




    @Test
    public void VerificarEnemigosSeMuevenPorPasarelas() {
        Lector mockLector = mock(Lector.class);

        when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","Pasarela"))
        											.thenReturn(new ElementoMapa("0","1","Pasarela"))
        											.thenReturn(new ElementoMapa("0","2","Pasarela"))
        											.thenReturn(new ElementoMapa("0","3","Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true)
        									   .thenReturn(true).thenReturn(false);


        Mapa unMapa = new Mapa(mockLector);


        Posicion inicio = unMapa.posicionInicio();
        Hormiga enemigo = new Hormiga(inicio, new Jugador());

        unMapa.posicionar(enemigo,inicio);


        Posicion posNueva =  unMapa.mover(enemigo,inicio,1);

        // posNueva
        assertEquals(posNueva.X(),0);
        assertEquals(posNueva.Y(),1);
        
        // inicio
        assertEquals(inicio.X(),0);
        assertEquals(inicio.Y(),0);
        

    }


    @Test
    public void VerificarEnemigosSeMuevenSoloPorPasarelasLlamadosSucesivos() {
        Lector mockLector = mock(Lector.class);

        when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","Pasarela"))
        											.thenReturn(new ElementoMapa("0","1","Pasarela"))
        											.thenReturn(new ElementoMapa("0","2","Pasarela"))
        											.thenReturn(new ElementoMapa("0","3","Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true)
        									   .thenReturn(true).thenReturn(false);


        Mapa unMapa = new Mapa(mockLector);


        Posicion inicio = unMapa.posicionInicio();
        Hormiga enemigo = new Hormiga(inicio, new Jugador());

        unMapa.posicionar(enemigo,inicio);


        Posicion posNueva =  unMapa.mover(enemigo,inicio,1);
        posNueva =  unMapa.mover(enemigo,posNueva,1);
        posNueva =  unMapa.mover(enemigo,posNueva,1);

        // posNueva
        assertEquals(posNueva.X(),0);
        assertEquals(posNueva.Y(),2);
        
        // inicio
        assertEquals(inicio.X(),0);
        assertEquals(inicio.Y(),0);
        

    }

    @Test
    public void VerificarEnemigosSeMuevenSoloPorPasarelas() {
        Lector mockLector = mock(Lector.class);

        when(mockLector.siguienteElemento()).thenReturn(new ElementoMapa("0","0","Pasarela"))
        											.thenReturn(new ElementoMapa("0","1","Pasarela"))
        											.thenReturn(new ElementoMapa("0","2","Pasarela"))
        											.thenReturn(new ElementoMapa("0","3","Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true)
        									   .thenReturn(true).thenReturn(false);


        Mapa unMapa = new Mapa(mockLector);


        Posicion inicio = unMapa.posicionInicio();
        Hormiga enemigo = new Hormiga(inicio, new Jugador());

        unMapa.posicionar(enemigo,inicio);


        Posicion posNueva =  unMapa.mover(enemigo,inicio,4);

        // posNueva
        assertEquals(posNueva.X(),0);
        assertEquals(posNueva.Y(),2);
        
        // inicio
        assertEquals(inicio.X(),0);
        assertEquals(inicio.Y(),0);
        

    }
}