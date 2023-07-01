package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.descriptors.AttackDescriptor;
import edu.fiuba.algo3.modelo.Celdas.OnAttackListener;

import edu.fiuba.algo3.Logger;

import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Lector.Lector;
import edu.fiuba.algo3.modelo.Lector.LectorEnemigo;


import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import edu.fiuba.algo3.modelo.excepciones.mapa.CaminoInvalido;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;

import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import edu.fiuba.algo3.modelo.SistemaCreditos;


public class SupuestosTests {
    @Test
    public void verificarRangoTorreTieneFormaCuadrada() {
        TorrePlateada torrePlateada = new TorrePlateada();

        Coordenada mockDesde = mock(Coordenada.class);
        
        int x_pos = 6;
        int y_pos = 6;
        when(mockDesde.x()).thenReturn(x_pos);
        when(mockDesde.y()).thenReturn(y_pos);

        doCallRealMethod().when(mockDesde).iterarEnRango(any(Integer.class), any());
        int rango = 5;

        Mapa mockMapa = mock(Mapa.class);

        when(mockMapa.atacar(any(Coordenada.class), any(Defensa.class))).thenReturn(true);

        torrePlateada.accionar(mockMapa, mockDesde);
        torrePlateada.accionar(mockMapa, mockDesde); // dos turnos de activacion

        torrePlateada.accionar(mockMapa, mockDesde);// un accionar para atacar


        // solo ataca una vez cada una.
        for(int x = x_pos-rango; x<= x_pos+rango; x++){
	        for(int y = y_pos-rango; y<= y_pos+rango; y++){
		        verify(mockMapa, times(1)).atacar(new Coordenada(x,y), torrePlateada);
	        }        	
        }

        // no ataca mas casillas de las que debe.
        //(2*rango+1)*(2*rango+1) es la cantidad de casillas que estarian en rango
        verify(mockMapa, times((2*rango+1)*(2*rango+1))).atacar(any(Coordenada.class), any(Defensa.class));


    }

    @Test
    public void verificarTorreAtacaUnaVez() {
        TorrePlateada torrePlateada = new TorrePlateada();

        Coordenada mockDesde = mock(Coordenada.class);
        
        int x_pos = 6;
        int y_pos = 6;
        when(mockDesde.x()).thenReturn(x_pos);
        when(mockDesde.y()).thenReturn(y_pos);

        doCallRealMethod().when(mockDesde).iterarEnRango(any(Integer.class), any());
        int rango = 5;

        Mapa mockMapa = mock(Mapa.class);

        when(mockMapa.atacar(any(Coordenada.class), any(Defensa.class))).thenReturn(true);
        when(mockMapa.atacar(new Coordenada(3,3), torrePlateada)).thenReturn(false);

        torrePlateada.accionar(mockMapa, mockDesde);
        torrePlateada.accionar(mockMapa, mockDesde); // dos turnos de activacion

        torrePlateada.accionar(mockMapa, mockDesde);// un accionar para atacar


        // solo ataca una vez cada una.
		for(int y = y_pos-rango; y<= 2; y++){
	        for(int x = x_pos-rango; x<= x_pos+rango; x++){
		        verify(mockMapa, times(1)).atacar(new Coordenada(x,y), torrePlateada);
    	    }
	    }

		verify(mockMapa, times(1)).atacar(new Coordenada(1,3), torrePlateada);
		verify(mockMapa, times(1)).atacar(new Coordenada(2,3), torrePlateada);
		verify(mockMapa, times(1)).atacar(new Coordenada(3,3), torrePlateada);

        // no ataca mas casillas de las que debe.
        //(2*rango+1)*2 es la cantidad de casillas por dos filas, +3 por la coordenada x.
        verify(mockMapa, times((2*rango+1)*2 + 3)).atacar(any(Coordenada.class), any(Defensa.class));


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
    public void VerificarSalteErrorAlConstruirMapaSinUnCaminoDeDosDeLongitud() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        assertThrows(CaminoInvalido.class, () -> {

            Mapa unMapa = new Mapa(mockLector,1,1, new Jugador());

        });
    }


    @Test
    public void VerificarSalteErrorAlConstruirMapaSinUnCaminoContinuo() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"),new ConvertidorParcela(1,3,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        assertThrows(CaminoInvalido.class, () -> {

            Mapa unMapa = new Mapa(mockLector,1,3, new Jugador());

        });


    }

    @Test
    public void VerificarNoSalteErrorAlConstruirMapaConUnCaminoValido() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"),new ConvertidorParcela(1,2,"Pasarela"),new ConvertidorParcela(1,3,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        assertThrows(CaminoInvalido.class, () -> {

            Mapa unMapa = new Mapa(mockLector,1,3, new Jugador());

        });

        
    }


    @Test
    public void formatoInvalidoEnemigosFaltaTurno() throws Exception {
		assertThrows(Exception.class, ()->{Lector lector = new LectorEnemigo(Resources.getJsonPath("test/formato/enemigosFaltaTurno"));
			int cantidad = 0;
			while(lector.haySiguiente()){

               Object element = lector.siguienteElemento().obtener();

               cantidad+=1;
           }
       });
    }


    @Test
    public void formatoInvalidoEnemigosOrdenIncorrecto() throws Exception {
		assertThrows(Exception.class, ()->{Lector lector = new LectorEnemigo(Resources.getJsonPath("test/formato/enemigosOrdenIncorrecto"));
			int cantidad = 0;
			while(lector.haySiguiente()){

               Object element = lector.siguienteElemento().obtener();

               cantidad+=1;
           }
       });
    }

    @Test
    public void verificarTrampaNoBajaVelocidadDeUno(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo hormiga = new Hormiga();
        Coordenada origen = new Coordenada(0,0);
        hormiga.atacadoPorTrampa();
        when(mockMapa.moverEnCaminoTerrestre(hormiga,origen, 1)).thenReturn(false);
        assertEquals(1, hormiga.velocidad());
        hormiga.accionar(mockMapa,new Jugador(), origen);
        verify(mockMapa,times(1)).moverEnCaminoTerrestre(hormiga,origen,1);
    }


    @Test
    public void verificarEfectoTrampaEsParaSiempre(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo arania = new Arania();
        assertEquals(2, arania.velocidad());
        Coordenada origen = new Coordenada(0,0);
        arania.atacadoPorTrampa();
        when(mockMapa.moverEnCaminoTerrestre(arania,origen, 1)).thenReturn(false);
        assertEquals(1, arania.velocidad());
        arania.accionar(mockMapa,new Jugador(), origen);
        verify(mockMapa,times(1)).moverEnCaminoTerrestre(arania,origen,1);
        
        arania.accionar(mockMapa,new Jugador(), origen);
        verify(mockMapa,times(2)).moverEnCaminoTerrestre(arania,origen,1);
    }


    @Test
    public void verificarEfectoTrampaTruncaLaVelocidad(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo topo = new Topo(1);
        Coordenada origen = new Coordenada(0,0);
        for(int i = 0; i<=11 ; i++) {
            topo.accionar(mockMapa, new Jugador(), origen);
        }
        assertEquals(3, topo.velocidad());
        topo.atacadoPorTrampa();
        when(mockMapa.moverEnCaminoTerrestre(topo,origen, 1)).thenReturn(false);
        assertEquals(1, topo.velocidad());
        topo.accionar(mockMapa, new Jugador(), origen);
        verify(mockMapa,times(5)).moverEnCaminoTerrestre(topo,origen,1);
    }


    @Test
    public void verificarTopoRestableceSuVelocidadIgnorandoEfectoTrampa(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo topo = new Topo(1);
        Coordenada origen = new Coordenada(0,0);
        Jugador jugador = new Jugador(); 
        for(int i = 0; i< 6; i++) {
            topo.accionar(mockMapa, jugador, origen);
        }

        topo.atacadoPorTrampa(); 
        // velocidad fue reducida, test de que eso pase en otro test en EnemigosTests


        for(int i = 6; i<=11 ; i++) {
            topo.accionar(mockMapa, jugador, origen);
        }

        assertEquals(3, topo.velocidad());
        // se ignoro el efecto de la trampa anterior.
    }


    @Test
    public void verificarLechuzaNoDeCreditos() {

        Enemigo enemigo = new Lechuza();
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(0)).acreditarHormiga(any(Integer.class));
        verify(mockCreditosJugador, times(0)).acreditarArania(any(Integer.class));

    }

    @Test
    public void verificarTopoNoDeCreditos() {

        Enemigo enemigo = new Topo(1);
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(0)).acreditarHormiga(any(Integer.class));
        verify(mockCreditosJugador, times(0)).acreditarArania(any(Integer.class));
        
    }
    @Test
    public void verificarTopoNoEsAtacaPorTorres() {

        Enemigo enemigo = new Topo(1);
        assertEquals(false, enemigo.atacadoPorTorre(2));
    }


    @Test
    public void verificarTorrePlateadaAtacaAUnEnemigoIgnorandoTopo() {
        TorrePlateada torre = new TorrePlateada();

        Topo mockEnemigo = mock(Topo.class);
        Arania mockEnemigo2 = mock(Arania.class);
        Arania mockEnemigo3 = mock(Arania.class);

        when(mockEnemigo.atacadoPorTorre(2)).thenReturn(false);
        when(mockEnemigo2.atacadoPorTorre(2)).thenReturn(true);
        when(mockEnemigo3.atacadoPorTorre(2)).thenReturn(true);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);
        enemigos.add(mockEnemigo2);
        enemigos.add(mockEnemigo3);

        torre.atacar(enemigos,(AttackDescriptor atk)->{});

        verify(mockEnemigo, times(1)).atacadoPorTorre(2);
        verify(mockEnemigo2, times(1)).atacadoPorTorre(2);
        verify(mockEnemigo3, times(0)).atacadoPorTorre(2);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }


    @Test
    public void verificarEnemigosAtaquenUnaVez() throws Exception {
        LectorMapa mockLector = mock(LectorMapa.class);
        Jugador mockJugador = mock(Jugador.class);

        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,2,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,3,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,4,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,5,"Pasarela"))
                                                    .thenReturn(new ConvertidorParcela(1,6,"Tierra"));

        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true)
        							   .thenReturn(true).thenReturn(true)
                                       .thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,6,mockJugador);
        Enemigo enemigo = new Hormiga();//new Jugador()


        unMapa.posicionarInicio(enemigo);

        unMapa.accionarEnemigos(mockJugador);
        enemigo = new Arania();//new Jugador()
        unMapa.posicionarInicio(enemigo);

        unMapa.accionarEnemigos(mockJugador);

        int cantidad_enemigos = 0;
        for(int i=1; i<=5; i++){
        	cantidad_enemigos += unMapa.obtenerInformacion(new Coordenada(1,i)).cantidadEnemigos();
        }

        assertEquals(2, cantidad_enemigos);


        unMapa.accionarEnemigos(mockJugador); // llega Arania


        cantidad_enemigos = 0;
        for(int i=1; i<=5; i++){
        	cantidad_enemigos += unMapa.obtenerInformacion(new Coordenada(1,i)).cantidadEnemigos();
        }

        assertEquals(1, cantidad_enemigos);
        verify(mockJugador, times(1)).recibirAtaque(2);


        unMapa.accionarEnemigos(mockJugador); // llega Hormiga
        // verificar arania ataco

        cantidad_enemigos = 0;
        for(int i=1; i<=5; i++){
        	cantidad_enemigos += unMapa.obtenerInformacion(new Coordenada(1,i)).cantidadEnemigos();
        }

        assertEquals(0, cantidad_enemigos);
        verify(mockJugador, times(1)).recibirAtaque(1);
        // verificar hormiga ataco

        unMapa.accionarEnemigos(mockJugador); // no hay mas enemigos
        unMapa.accionarEnemigos(mockJugador);

        // verificar no hubo mas llamados a recibirAtaque
        verify(mockJugador, times(2)).recibirAtaque(any(Integer.class));
    }

}