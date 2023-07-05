package edu.fiuba.algo3.entrega2;


//import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

import edu.fiuba.algo3.modelo.Celdas.Celda;

import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
//import edu.fiuba.algo3.modelo.moduloLector.Lector;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.excepciones.mapa.*;

public class MapaTests {
    
    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierra() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();

        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"))
        .thenReturn(new ConvertidorParcela(1,2,"Pasarela")).thenReturn(new ConvertidorParcela(1,3,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,3, new Jugador());

        assertEquals(true, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
    }

    @Test
    public void VerificarSePosicioneLaDefensaAlPosicionar() throws Exception {
        Defensa mockDefensa = mock(Defensa.class);
        //ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"))
        .thenReturn(new ConvertidorParcela(1,2,"Pasarela")).thenReturn(new ConvertidorParcela(1,3,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,3, new Jugador());

        unMapa.posicionar(new Coordenada(1,1),mockDefensa);
        verify(mockDefensa, times(1)).posicionarEn(any(Celda.class));
    }

    @Test
    public void VerificarSalteErrorAlConstruirMapaSinUnCamino() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        assertThrows(CaminoInvalido.class, () -> {

            Mapa unMapa = new Mapa(mockLector,1,1, new Jugador());

        });
    }


    @Test
    public void VerificaMapaTiraErrorCuandoSeAgregaCeldaFueraDeRango() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"))
        .thenReturn(new ConvertidorParcela(1,2,"Pasarela")).thenReturn(new ConvertidorParcela(1,3,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(false);
        assertThrows(CeldaFueraDeRango.class, () -> {

            Mapa unMapa = new Mapa(mockLector,1,1, new Jugador());

        });
    }

    @Test
    public void VerificarNoSePuedaConstruirDefensasSobreRoca() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();

        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Rocoso"))
        .thenReturn(new ConvertidorParcela(1,2,"Pasarela")).thenReturn(new ConvertidorParcela(1,3,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,3,new Jugador());

        assertEquals(false, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
        
    }    

    @Test
    public void VerificarNoSePuedaConstruirDefensasSobrePasarela() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();

        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"))
        .thenReturn(new ConvertidorParcela(1,2,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,3,new Jugador());

        assertEquals(false, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
        
    }  

    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierraSoloUnaVez() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        //ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"))
        .thenReturn(new ConvertidorParcela(2,1,"Pasarela")).thenReturn(new ConvertidorParcela(3,1,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,3,1,new Jugador());
        unMapa.posicionar(new Coordenada(1,1),torrePlateada);

        assertEquals(false, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
    }


    

    @Test
    public void VerificarEnemigosSePosicionanAlInicio() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,2,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,3,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,4,"Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true)
                                               .thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,4,new Jugador());
        Hormiga enemigo = new Hormiga();//new Jugador()


        unMapa.posicionarInicio(enemigo);

        CeldaDescriptor unidades = unMapa.obtenerInformacion(new Coordenada(1,1));

        assertEquals(1, unidades.cantidadEnemigos());
        // assertEquals(unidades.get(0), enemigo);        

    }

    @Test
    public void VerificarEnemigosSeMuevenPorPasarelas() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,2,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,3,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,4,"Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true)
                                               .thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,4,new Jugador());
        Hormiga enemigo = new Hormiga();//new Jugador()


        unMapa.posicionarInicio(enemigo);

        Jugador jugador = new Jugador();

        unMapa.accionarEnemigos(jugador);

        CeldaDescriptor unidadesInicio = unMapa.obtenerInformacion(new Coordenada(1,1));
        CeldaDescriptor unidadesDondeEstaria = unMapa.obtenerInformacion(new Coordenada(1,2));

        assertEquals(1, unidadesDondeEstaria.cantidadEnemigos());
        // assertEquals(unidadesDondeEstaria.get(0), enemigo);

        assertEquals(0, unidadesInicio.cantidadEnemigos());
    }

    @Test
    public void VerificarEnemigosSeMuevenSoloPorPasarelasLlamadosSucesivos() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,2,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,3,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,4,"Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true)
                                               .thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,4,new Jugador());
        Hormiga enemigo = new Hormiga();//new Jugador()


        unMapa.posicionarInicio(enemigo);

        Jugador mockJugador = mock(Jugador.class);

        unMapa.accionarEnemigos(mockJugador);
        unMapa.accionarEnemigos(mockJugador);

        CeldaDescriptor unidadesInicio = unMapa.obtenerInformacion(new Coordenada(1,2));
        CeldaDescriptor unidadesDondeEstaria = unMapa.obtenerInformacion(new Coordenada(1,3));


        verify(mockJugador, times(1)).recibirAtaque(1);
        assertEquals(0, unidadesDondeEstaria.cantidadEnemigos());
        // assertEquals(unidadesDondeEstaria.get(0), enemigo);

        assertEquals(0, unidadesInicio.cantidadEnemigos());
    }



    @Test
    public void VerificarAccionarEstructurasAccioneLasEstructurasUnaVez() throws Exception{

        Defensa mockDefensa = mock(Defensa.class);

        // necesitamos lo llame al posicionar.
        doCallRealMethod().when(mockDefensa).posicionarEn(any(Celda.class));       

        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"))
        .thenReturn(new ConvertidorParcela(1,2,"Pasarela")).thenReturn(new ConvertidorParcela(2,2,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,2,2, new Jugador());
        Coordenada desde =new Coordenada(1,1);
        unMapa.posicionar(desde,mockDefensa);

        unMapa.accionarDefensas();


        verify(mockDefensa, times(1)).accionar(unMapa, desde);

    }


    @Test
    public void VerificarEnemigosSeMuevenSoloPorPasarelasHastaElFinal() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);
        Jugador mockJugador = mock(Jugador.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,2,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,3,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,4,"Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true)
                                               .thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,4,mockJugador);
        Hormiga enemigo = new Hormiga();//new Jugador()


        unMapa.posicionarInicio(enemigo);

        unMapa.accionarEnemigos(mockJugador);
        enemigo = new Hormiga();//new Jugador()
        unMapa.posicionarInicio(enemigo);

        unMapa.accionarEnemigos(mockJugador);
        unMapa.accionarEnemigos(mockJugador);
        unMapa.accionarEnemigos(mockJugador);
        unMapa.accionarEnemigos(mockJugador);
        unMapa.accionarEnemigos(mockJugador);

        CeldaDescriptor unidadesInicio = unMapa.obtenerInformacion(new Coordenada(1,2));
        CeldaDescriptor unidadesDondeEstaria = unMapa.obtenerInformacion(new Coordenada(1,3));


        verify(mockJugador, times(2)).recibirAtaque(1);

        assertEquals(0, unidadesDondeEstaria.cantidadEnemigos());
        assertEquals(0, unidadesInicio.cantidadEnemigos());
    }
}