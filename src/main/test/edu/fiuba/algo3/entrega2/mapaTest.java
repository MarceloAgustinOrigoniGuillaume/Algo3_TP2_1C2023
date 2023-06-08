package edu.fiuba.algo3.entrega2;


//import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloLector.LectorMapa;
import edu.fiuba.algo3.modeloNico.Defensas.TorrePlateada;
import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modelo.moduloLector.ConvertidorParcela;
import edu.fiuba.algo3.modeloNico.Celdas.Coordenada;
import edu.fiuba.algo3.modeloNico.Celdas.Unidad;

import edu.fiuba.algo3.modeloNico.Enemigo.Hormiga;
import edu.fiuba.algo3.modeloNico.Jugador;
//import edu.fiuba.algo3.modelo.moduloLector.Lector;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        ArrayList<Unidad> unidades = unMapa.obtenerUnidades(new Coordenada(1,1));

        assertEquals(1, unidades.size());
        assertEquals(unidades.get(0), enemigo);        

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

        ArrayList<Unidad> unidadesInicio = unMapa.obtenerUnidades(new Coordenada(1,1));
        ArrayList<Unidad> unidadesDondeEstaria = unMapa.obtenerUnidades(new Coordenada(1,2));

        assertEquals(1, unidadesDondeEstaria.size());
        assertEquals(unidadesDondeEstaria.get(0), enemigo);

        assertEquals(0, unidadesInicio.size());
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

        ArrayList<Unidad> unidadesInicio = unMapa.obtenerUnidades(new Coordenada(1,2));
        ArrayList<Unidad> unidadesDondeEstaria = unMapa.obtenerUnidades(new Coordenada(1,3));

        assertEquals(1, unidadesDondeEstaria.size());
        assertEquals(unidadesDondeEstaria.get(0), enemigo);

        assertEquals(0, unidadesInicio.size());
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


        ArrayList<Unidad> unidadesInicio = unMapa.obtenerUnidades(new Coordenada(1,2));
        ArrayList<Unidad> unidadesDondeEstaria = unMapa.obtenerUnidades(new Coordenada(1,3));

        assertEquals(1, unidadesDondeEstaria.size());
        assertEquals(unidadesDondeEstaria.get(0), enemigo);

        assertEquals(0, unidadesInicio.size());
    }
}