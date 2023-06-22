package edu.fiuba.algo3.entrega2;


import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.SistemaCreditos;
//import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
//import edu.fiuba.algo3.modelo.moduloDefensas.TorreBlanca;
//import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;


public class EnemigoTests {
	@Test
    public void verificarQueEnemigoRecibaDamageCorrectamenteNoMuere() {


        Arania enemigo = new Arania();

        enemigo.recibirAtaque(1);

		assertEquals(false, enemigo.estaMuerto());        
    }

	@Test
    public void verificarQueEnemigoRecibaDamageCorrectamenteMuere() {

        Arania enemigo = new Arania();

        enemigo.recibirAtaque(2);

		assertEquals(enemigo.estaMuerto(),true);        
    }


    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarEnemigo() {

        Hormiga enemigo = new Hormiga();

        enemigo.recibirAtaque(1);

		assertEquals(enemigo.estaMuerto(),true);        
    }


    @Test
    public void verificarQueJugadorNoGaneCreditosMatarLechuza() {

        Enemigo enemigo = new Lechuza();
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(0)).acreditarHormiga(any(Integer.class));
        verify(mockCreditosJugador, times(0)).acreditarArania(any(Integer.class));

    }


    @Test
    public void verificarQueJugadorNoGaneCreditosMatarTopo() {

        Enemigo enemigo = new Topo(1);
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(0)).acreditarHormiga(any(Integer.class));
        verify(mockCreditosJugador, times(0)).acreditarArania(any(Integer.class));

    }



    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarHormiga() {

        Enemigo enemigo = new Hormiga();
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(1)).acreditarHormiga(1);
        verify(mockCreditosJugador, times(0)).acreditarArania(any(Integer.class));

    }


    @Test
    public void verificarQueJugadorGaneCreditosCorrespondientesAlMatarArania() {

        Enemigo enemigo = new Arania();
        SistemaCreditos mockCreditosJugador = mock(SistemaCreditos.class);
        

        enemigo.acreditarseEn(mockCreditosJugador);

        verify(mockCreditosJugador, times(0)).acreditarHormiga(1);
        verify(mockCreditosJugador, times(1)).acreditarArania(any(Integer.class));

    }

    @Test
    public void verificarDanioTopoTurnoImpar(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo topo = new Topo(1);
        Jugador mockJugador = mock(Jugador.class);
        when(mockMapa.moverEnCaminoTerrestre(any(Topo.class),any(Coordenada.class), any(Integer.class))).thenReturn(false).thenReturn(true);

        topo.accionar(mockMapa,mockJugador, new Coordenada(10,10));
        topo.accionar(mockMapa,mockJugador, new Coordenada(11,10));

        verify(mockJugador,times(1)).recibirAtaque(2);
    }

    @Test
    public void verificarDanioTopoTurnoPar(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo topo = new Topo(2);
        Jugador mockJugador = mock(Jugador.class);
        when(mockMapa.moverEnCaminoTerrestre(any(Topo.class),any(Coordenada.class), any(Integer.class))).thenReturn(false).thenReturn(true);

        topo.accionar(mockMapa,mockJugador, new Coordenada(10,10));
        topo.accionar(mockMapa,mockJugador, new Coordenada(11,10));

        verify(mockJugador,times(1)).recibirAtaque(5);
    }

    @Test
    public void verificarVelocidadTopoPrimerCambio(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo topo = new Topo(2);
        Coordenada origen = new Coordenada(0,0);
        when(mockMapa.moverEnCaminoTerrestre(topo,origen, 1)).thenReturn(false);
        topo.accionar(mockMapa,new Jugador(), origen);
        topo.accionar(mockMapa,new Jugador(), origen);
        topo.accionar(mockMapa,new Jugador(), origen);
        topo.accionar(mockMapa,new Jugador(), origen);
        topo.accionar(mockMapa,new Jugador(), origen);
        verify(mockMapa,times(5)).moverEnCaminoTerrestre(topo,origen,1);
        topo.accionar(mockMapa,new Jugador(), origen);
        verify(mockMapa,times(1)).moverEnCaminoTerrestre(topo,origen,2);

    }

    @Test
    public void verificarModificacionDeVelocidadDeHormigaPorTrampa(){
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
    public void verificarModificacionDeVelocidadDeTopoPorTrampaenVelocidad1(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo topo = new Topo(1);
        assertEquals(1, topo.velocidad());
        Coordenada origen = new Coordenada(0,0);
        topo.atacadoPorTrampa();
        when(mockMapa.moverEnCaminoTerrestre(topo,origen, 1)).thenReturn(false);
        assertEquals(1, topo.velocidad());
        topo.accionar(mockMapa,new Jugador(), origen);
        verify(mockMapa,times(1)).moverEnCaminoTerrestre(topo,origen,1);
    }

    @Test
    public void verificarModificacionDeVelocidadDeTopoPorTrampaenVelocidad2(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo topo = new Topo(1);
        Coordenada origen = new Coordenada(0,0);
        for(int i = 0; i< 6; i++) {
            topo.accionar(mockMapa, new Jugador(), origen);
        }
        assertEquals(2, topo.velocidad());
        topo.atacadoPorTrampa();
        when(mockMapa.moverEnCaminoTerrestre(topo,origen, 1)).thenReturn(false);
        assertEquals(1, topo.velocidad());
        topo.accionar(mockMapa, new Jugador(), origen);
        verify(mockMapa,times(5)).moverEnCaminoTerrestre(topo,origen,1);
    }

    @Test
    public void verificarModificacionDeVelocidadDeTopoPorTrampaenVelocidad3(){
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
    public void verificarModificacionDeVelocidadDeAraniaPorTrampa(){
        Mapa mockMapa = mock(Mapa.class);
        Enemigo arania = new Arania();
        assertEquals(2, arania.velocidad());
        Coordenada origen = new Coordenada(0,0);
        arania.atacadoPorTrampa();
        when(mockMapa.moverEnCaminoTerrestre(arania,origen, 1)).thenReturn(false);
        assertEquals(1, arania.velocidad());
        arania.accionar(mockMapa,new Jugador(), origen);
        verify(mockMapa,times(1)).moverEnCaminoTerrestre(arania,origen,1);
    }
    @Test
    public void verificarNoSeModificaVelocidadDeLechuzaPorTrampa(){
        Mapa mockMapa = mock(Mapa.class);
        when(mockMapa.posicionFinal()).thenReturn(new Coordenada(15 , 15));
        Enemigo lechuza = new Lechuza();
        assertEquals(5, lechuza.velocidad());
        Coordenada origen = new Coordenada(0,0);
        lechuza.atacadoPorTrampa();
        assertEquals(5, lechuza.velocidad());
        lechuza.accionar(mockMapa,new Jugador(), origen);
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(0,0),new Coordenada(5,0));

    }
}
