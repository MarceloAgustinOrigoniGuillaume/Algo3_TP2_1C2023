package edu.fiuba.algo3.entrega2;


//import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
//import edu.fiuba.algo3.modelo.moduloLector.Lector;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

public class mapaTest {
    
    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierra() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        //ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        assertEquals(true, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
    }
    
    @Test
    public void VerificarNoSePuedaConstruirDefensasSobreRoca() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();

        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Rocoso"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        assertEquals(false, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
        
    }    

    @Test
    public void VerificarNoSePuedaConstruirDefensasSobrePasarela() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();

        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        assertEquals(false, unMapa.posicionar(new Coordenada(1,1),torrePlateada));
        
    }  


    

    @Test
    public void VerificarSePuedaConstruirDefensasSobreTierraSoloUnaVez() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        //ConstruccionTentativa enConstruccion = new ConstruccionTentativa(torrePlateada);
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);
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

        Mapa unMapa = new Mapa(mockLector,1,4);
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

        Mapa unMapa = new Mapa(mockLector,1,4);
        Hormiga enemigo = new Hormiga();//new Jugador()


        unMapa.posicionarInicio(enemigo);

        unMapa.moverEnemigos();

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

        Mapa unMapa = new Mapa(mockLector,1,4);
        Hormiga enemigo = new Hormiga();//new Jugador()


        unMapa.posicionarInicio(enemigo);

        unMapa.moverEnemigos();
        unMapa.moverEnemigos();

        CeldaDescriptor unidadesInicio = unMapa.obtenerInformacion(new Coordenada(1,2));
        CeldaDescriptor unidadesDondeEstaria = unMapa.obtenerInformacion(new Coordenada(1,3));

        assertEquals(1, unidadesDondeEstaria.cantidadEnemigos());
        // assertEquals(unidadesDondeEstaria.get(0), enemigo);

        assertEquals(0, unidadesInicio.cantidadEnemigos());
    }

    @Test
    public void VerificarEnemigosSeMuevenSoloPorPasarelasHastaElFinal() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,2,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,3,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,4,"Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true)
                                               .thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,4);
        Hormiga enemigo = new Hormiga();//new Jugador()


        unMapa.posicionarInicio(enemigo);

        unMapa.moverEnemigos();
        unMapa.moverEnemigos();
        unMapa.moverEnemigos();
        unMapa.moverEnemigos();
        unMapa.moverEnemigos();
        unMapa.moverEnemigos();


        CeldaDescriptor unidadesInicio = unMapa.obtenerInformacion(new Coordenada(1,2));
        CeldaDescriptor unidadesDondeEstaria = unMapa.obtenerInformacion(new Coordenada(1,3));

        assertEquals(1, unidadesDondeEstaria.cantidadEnemigos());
        // assertEquals(unidadesDondeEstaria.get(0), enemigo);

        assertEquals(0, unidadesInicio.cantidadEnemigos());
    }
}