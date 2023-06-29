package edu.fiuba.algo3.entrega2;

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


import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class DefensasTests {
    @Test
    public void verificarDefensaTardaEnContruirseLoQueDebePaseSerActivo() {
        TorrePlateada torrePlateada = new TorrePlateada();

        /*
        Posible separacion de test al verificar cada turno
        */

        assertEquals(torrePlateada.estaActiva(), false);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void vertificarNoEstaActivaPasoUnTurno() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1, 1, "Tierra"))
        .thenReturn(new ConvertidorParcela(1, 2, "Pasarela")).thenReturn(new ConvertidorParcela(1, 3, "Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector, 1, 3, new Jugador());

        torrePlateada.accionar(unMapa, new Coordenada(1, 1));
        assertEquals(torrePlateada.estaActiva(), false);


        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void vertificarEstaActivaPasoMultiplesTurnos() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1, 1, "Tierra")).
        thenReturn(new ConvertidorParcela(1,2,"Pasarela")).thenReturn(new ConvertidorParcela(1,3,"Pasarela"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector, 1, 3, new Jugador());
        torrePlateada.accionar(unMapa, new Coordenada(1, 1));
        torrePlateada.accionar(unMapa, new Coordenada(1, 1));
        torrePlateada.accionar(unMapa, new Coordenada(1, 1));

        assertEquals(torrePlateada.estaActiva(), true);
    }

    @Test
    public void verificarTorreAtacaAUnEnemigo() {
        TorreBlanca torreBlanca = new TorreBlanca();

        Arania mockEnemigo = mock(Arania.class);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);

        torreBlanca.atacar(enemigos, (AttackDescriptor atk)->{});

        verify(mockEnemigo, times(1)).atacadoPorTorre(1);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }


    @Test
    public void verificarTorreAtacaAUnEnemigoYSoloUnEnemigo() {
        TorreBlanca torreBlanca = new TorreBlanca();

        Arania mockEnemigo = mock(Arania.class);
        Arania mockEnemigo2 = mock(Arania.class);

        when(mockEnemigo.atacadoPorTorre(1)).thenReturn(true);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);
        enemigos.add(mockEnemigo2);

        torreBlanca.atacar(enemigos,(AttackDescriptor atk)->{});

        verify(mockEnemigo, times(1)).atacadoPorTorre(1);
        verify(mockEnemigo2, times(0)).atacadoPorTorre(1);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void verificarTorreAtacaAUnEnemigoComoTorre() {
        TorreBlanca torreBlanca = new TorreBlanca();

        Arania mockEnemigo = mock(Arania.class);

        when(mockEnemigo.atacadoPorTorre(1)).thenReturn(true);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);

        torreBlanca.atacar(enemigos,(AttackDescriptor atk)->{});

        verify(mockEnemigo, times(1)).atacadoPorTorre(1);
        verify(mockEnemigo, times(0)).atacadoPorTrampa();

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }



    @Test
    public void verificarTorrePlateadaAtacaAUnEnemigoComoTorre() {
        TorrePlateada torre = new TorrePlateada();

        Arania mockEnemigo = mock(Arania.class);

        when(mockEnemigo.atacadoPorTorre(1)).thenReturn(true);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);

        torre.atacar(enemigos,(AttackDescriptor atk)->{});

        verify(mockEnemigo, times(1)).atacadoPorTorre(2);
        verify(mockEnemigo, times(0)).atacadoPorTrampa();

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }


    @Test
    public void verificarTorrePlateadaAtacaAUnEnemigoDe3PrimeroEsTopo() {
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
    public void verificarTorreAtacaAUnEnemigoYSoloUnoPeroPrimeroNoEsAtacable() {
        TorreBlanca torreBlanca = new TorreBlanca();

        Topo mockEnemigo = mock(Topo.class);
        Arania mockEnemigo2 = mock(Arania.class);

        when(mockEnemigo.atacadoPorTorre(1)).thenReturn(false);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);
        enemigos.add(mockEnemigo2);

        torreBlanca.atacar(enemigos,(AttackDescriptor atk)->{});

        verify(mockEnemigo, times(1)).atacadoPorTorre(1);
        verify(mockEnemigo2, times(1)).atacadoPorTorre(1);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }



    private abstract class MockListener implements OnAttackListener{
        public void onAttack(AttackDescriptor desc){

        }
    }


    @Test
    public void verificarTorreAtacaAUnEnemigoYAvisaAlListener() {
        TorreBlanca torreBlanca = new TorreBlanca();
        MockListener listener = mock(MockListener.class);
        Topo mockEnemigo = mock(Topo.class);
        Arania mockEnemigo2 = mock(Arania.class);

        when(mockEnemigo.atacadoPorTorre(1)).thenReturn(false);
        when(mockEnemigo2.atacadoPorTorre(1)).thenReturn(true);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);
        enemigos.add(mockEnemigo2);

        torreBlanca.atacar(enemigos,listener);

        verify(mockEnemigo, times(1)).atacadoPorTorre(1);
        verify(mockEnemigo2, times(1)).atacadoPorTorre(1);

        verify(listener, times(1)).onAttack(any(AttackDescriptor.class));

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }


    @Test
    public void verificarTorrePlateadaAtacaAUnEnemigoDe3PrimeroEsTopoYAvisa() {
        TorrePlateada torre = new TorrePlateada();

        Topo mockEnemigo = mock(Topo.class);
        Arania mockEnemigo2 = mock(Arania.class);
        Arania mockEnemigo3 = mock(Arania.class);
        MockListener listener = mock(MockListener.class);

        when(mockEnemigo.atacadoPorTorre(2)).thenReturn(false);
        when(mockEnemigo2.atacadoPorTorre(2)).thenReturn(true);
        when(mockEnemigo3.atacadoPorTorre(2)).thenReturn(true);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);
        enemigos.add(mockEnemigo2);
        enemigos.add(mockEnemigo3);

        torre.atacar(enemigos,listener);

        verify(mockEnemigo, times(1)).atacadoPorTorre(2);
        verify(mockEnemigo2, times(1)).atacadoPorTorre(2);
        verify(mockEnemigo3, times(0)).atacadoPorTorre(2);

        verify(listener, times(1)).onAttack(any(AttackDescriptor.class));

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }


    // integracion con Coordenada

    @Test
    public void verificarTorreAccionarNoAtacaCoordenadasEnRangoNoActiva() {
        TorreBlanca torreBlanca = new TorreBlanca();

        Coordenada origen = new Coordenada(1, 1);

        Mapa mockMapa = mock(Mapa.class);

        when(mockMapa.atacar(any(Coordenada.class), any(Defensa.class))).thenReturn(true);

        torreBlanca.accionar(mockMapa, origen);

        verify(mockMapa, times(0)).atacar(any(Coordenada.class), any(Defensa.class));
    }



    @Test
    public void verificarFuncionIterarDeCoordenada(){
        TorrePlateada torrePlateada = new TorrePlateada();

        Coordenada origen = new Coordenada(6, 6);
        int rango = 2;

        Mapa mockMapa = mock(Mapa.class);

        when(mockMapa.atacar(any(Coordenada.class), any(Defensa.class))).thenReturn(true);
        origen.iterarEnRango(rango, (Coordenada atacada)->{
            return mockMapa.atacar(atacada, torrePlateada);
        });


        // dist = 0
        verify(mockMapa, times(1)).atacar(new Coordenada(6,6), torrePlateada);

        // dist = 1
        verify(mockMapa, times(1)).atacar(new Coordenada(7,6), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(6,7), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(5,6), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(6,5), torrePlateada);

        // dist = 2
        verify(mockMapa, times(1)).atacar(new Coordenada(8,6), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(7,7), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(7,5), torrePlateada);

        verify(mockMapa, times(1)).atacar(new Coordenada(6,8), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(5,7), torrePlateada);

        verify(mockMapa, times(1)).atacar(new Coordenada(4,6), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(5,5), torrePlateada);

        verify(mockMapa, times(1)).atacar(new Coordenada(6,4), torrePlateada);

        // total
        verify(mockMapa, times((2*rango+1)*(2*rango+1))).atacar(any(Coordenada.class), any(Defensa.class));


    }



    @Test
    public void verificarFuncionIterarDeCoordenadaEnBorde(){
        TorrePlateada torrePlateada = new TorrePlateada();

        Coordenada origen = new Coordenada(1, 1);
        int rango = 2;

        Mapa mockMapa = mock(Mapa.class);

        when(mockMapa.atacar(any(Coordenada.class), any(Defensa.class))).thenReturn(true);

        origen.iterarEnRango(rango, (Coordenada atacada)->{
            return mockMapa.atacar(atacada, torrePlateada);
        });


        // singularmente

        // dist = 0
        verify(mockMapa, times(1)).atacar(new Coordenada(1,1), torrePlateada);

        // dist = 1
        verify(mockMapa, times(1)).atacar(new Coordenada(2,1), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(1,2), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(0,1), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(1,0), torrePlateada);

        // dist = 2
        verify(mockMapa, times(1)).atacar(new Coordenada(3,1), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(2,2), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(2,0), torrePlateada);

        verify(mockMapa, times(1)).atacar(new Coordenada(1,3), torrePlateada);
        verify(mockMapa, times(1)).atacar(new Coordenada(0,2), torrePlateada);

        verify(mockMapa, times(1)).atacar(new Coordenada(0,0), torrePlateada);

        // total
        verify(mockMapa, times((2*rango+1)*(2*rango+1) - 9)).atacar(any(Coordenada.class), any(Defensa.class));


    }


    @Test
    public void verificarTorreIteraCoordenadasEnRangoActivaTorrePlateada() {
        TorrePlateada torrePlateada = new TorrePlateada();

        Coordenada mockDesde = mock(Coordenada.class);
        int rango = 5;

        Mapa mockMapa = mock(Mapa.class);

        torrePlateada.accionar(mockMapa, mockDesde);
        torrePlateada.accionar(mockMapa, mockDesde); // dos turnos de activacion
        torrePlateada.accionar(mockMapa, mockDesde);

        //assert
        verify(mockDesde, times(1)).iterarEnRango(any(Integer.class), any());


    }

    @Test
    public void verificarTorreNoIteraCoordenadasEnRangoNoActivaTorrePlateada() {
        TorrePlateada torrePlateada = new TorrePlateada();

        Coordenada mockDesde = mock(Coordenada.class);
        int rango = 5;

        Mapa mockMapa = mock(Mapa.class);

        torrePlateada.accionar(mockMapa, mockDesde);
        torrePlateada.accionar(mockMapa, mockDesde); // dos turnos de activacion

        //assert
        verify(mockDesde, times(0)).iterarEnRango(any(Integer.class), any());


    }

    @Test
    public void verificarTorreAccionarAtacaCoordenadasEnRangoActivaTorrePlateada() {
        TorrePlateada torrePlateada = new TorrePlateada();

        Coordenada mockDesde = mock(Coordenada.class);
        
        when(mockDesde.x()).thenReturn(6);
        when(mockDesde.y()).thenReturn(6);

        doCallRealMethod().when(mockDesde).iterarEnRango(any(Integer.class), any());
        int rango = 5;

        Mapa mockMapa = mock(Mapa.class);

        when(mockMapa.atacar(any(Coordenada.class), any(Defensa.class))).thenReturn(true);

        torrePlateada.accionar(mockMapa, mockDesde);
        torrePlateada.accionar(mockMapa, mockDesde); // dos turnos de activacion
        torrePlateada.accionar(mockMapa, mockDesde);


        // dx + dy<= rango = 4
        // dx tiene 2*rango+1 posibilidades, -2,-1,0,1,2..rango
        // dy tiene rango-abs(dx) posibilidades 2 3 4 3 2
        // cada posibilidad de dy anterior se 
        // dividiria 2 para + y -. +1 por el no hacer cambio
        // osea dy tendria (rango-abs(dx))*2 + 1  para un dx, donde dx va de -rango a rango, que 
        // podemos decir es 2((rango-dx)*2 + 1) con dx de 1 a rango, + 2rango+1 por dx = 0

        //total = 2*rango+1; // dx = 0

        //for(int dx = 1; dx<= rango; dx++){
        //    total+= 2((rango-dx)*2 + 1);
        //}
        // total =  
        // total = 4*rango - 4 dx + 2
        // 4*rango+2, con dx de 1 a rango
        // suma 2*rango*(2rango+1), a esto le restas 2*rango(rango+1) del dx
        // 2*rango( 2rango +1 - rango-1) = 2 *rango * rango + 2*rango+1
        // total = 2rango(rango+1) +1
        verify(mockMapa, times((2*rango+1)*(2*rango+1))).atacar(any(Coordenada.class), any(Defensa.class));


    }




    @Test
    public void verificarTorreAccionarAtacaCoordenadasEnRangoActivaTorreBlanca() {
        TorreBlanca torreBlanca = new TorreBlanca();

        Coordenada mockDesde = mock(Coordenada.class);
        int rango = 3;

        Mapa mockMapa = mock(Mapa.class);

        when(mockMapa.atacar(any(Coordenada.class), any(Defensa.class))).thenReturn(true);

        torreBlanca.accionar(mockMapa, mockDesde); // un turno de activacion
        torreBlanca.accionar(mockMapa, mockDesde);

        //assert
        verify(mockDesde, times(1)).iterarEnRango(any(Integer.class), any());

    }








}
