package edu.fiuba.algo3.entrega_1;


//import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloLector.LectorMapa;
import edu.fiuba.algo3.modeloNico.Defensas.TorrePlateada;
import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modelo.moduloLector.ConvertidorParcela;
import edu.fiuba.algo3.modeloNico.Celdas.Coordenada;

//import edu.fiuba.algo3.modelo.moduloEnemigos.Hormiga;
//import edu.fiuba.algo3.modelo.Jugador;
//import edu.fiuba.algo3.modelo.moduloLector.Lector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class mapaTest {
    
    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierra() {
        TorrePlateada torrePlateada = new TorrePlateada();
        //ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        assertEquals(true, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
    }
    
    @Test
    public void VerificarNoSePuedaConstruirDefensasSobreRoca() {
        TorrePlateada torrePlateada = new TorrePlateada();

        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Rocoso"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        assertEquals(false, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
        
    }    

    @Test
    public void VerificarNoSePuedaConstruirDefensasSobrePasarela() {
        TorrePlateada torrePlateada = new TorrePlateada();

        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        assertEquals(false, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
        
    }  


    

    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierraSoloUnaVez() {
        TorrePlateada torrePlateada = new TorrePlateada();
        //ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);
        unMapa.posicionar(new Coordenada(1,1),torrePlateada);

        assertEquals(false, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
    }


    /*

    @Test
    public void VerificarEnemigosSeMuevenPorPasarelas() {
        Lector mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorMapa("0","0","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","1","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","2","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","3","Tierra"));

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
        Lector mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorMapa("0","0","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","1","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","2","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","3","Tierra"));

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
        Lector mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorMapa("0","0","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","1","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","2","Pasarela"))
        											.thenReturn(new ConvertidorMapa("0","3","Tierra"));

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

     */
}