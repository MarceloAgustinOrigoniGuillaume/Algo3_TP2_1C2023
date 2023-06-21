package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Mapa.Mapa;


import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class DefensasTests {
    @Test
    public void verificarDefensaTardaEnContruirseLoQueDebePaseSerActivo() {
        TorrePlateada torrePlateada = new TorrePlateada();

        /*
        Posible separacion de test al verificar cada turno
        */

        assertEquals(torrePlateada.estaActiva(),false);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void vertificarNoEstaActivaPasoUnTurno() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);

        torrePlateada.accionar(unMapa, new Coordenada(1,1));
        assertEquals(torrePlateada.estaActiva(),false);


        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void vertificarEstaActivaPasoMultiplesTurnos() throws Exception {
        TorrePlateada torrePlateada = new TorrePlateada();
        LectorMapa mockLector = mock(LectorMapa.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorParcela(1,1,"Tierra"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);

        Mapa unMapa = new Mapa(mockLector,1,1);
        torrePlateada.accionar(unMapa, new Coordenada(1,1));
        torrePlateada.accionar(unMapa, new Coordenada(1,1));
        torrePlateada.accionar(unMapa, new Coordenada(1,1));

        assertEquals(torrePlateada.estaActiva(),true);
    }

    @Test
    public void verificarTorreAtacaAUnEnemigo() {
        TorreBlanca torreBlanca = new TorreBlanca();

        Arania mockEnemigo = mock(Arania.class);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);

        torreBlanca.atacar(enemigos);

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

        torreBlanca.atacar(enemigos);

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

        torreBlanca.atacar(enemigos);

        verify(mockEnemigo, times(1)).atacadoPorTorre(1);
        verify(mockEnemigo, times(0)).atacadoPorTrampa();

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }

    @Test
    public void verificarTrampaAtacaAUnEnemigoComoTrampa() {
        Trampa trampa = new Trampa();

        Arania mockEnemigo = mock(Arania.class);
        
        when(mockEnemigo.atacadoPorTrampa()).thenReturn(true);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);

        trampa.atacar(enemigos);

        verify(mockEnemigo, times(0)).atacadoPorTorre(1);
        verify(mockEnemigo, times(1)).atacadoPorTrampa();

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

        torreBlanca.atacar(enemigos);

        verify(mockEnemigo, times(1)).atacadoPorTorre(1);
        verify(mockEnemigo2, times(1)).atacadoPorTorre(1);

        /*
        Recien para despues lo del Mock, al verificar que esten operativas
        */
    }


    @Test
    public void verificarTrampaAtacaATodoEnemigo() {
        Trampa trampa = new Trampa();

        Topo mockEnemigo = mock(Topo.class);
        Arania mockEnemigo2 = mock(Arania.class);
        
        when(mockEnemigo.atacadoPorTrampa()).thenReturn(true);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);
        enemigos.add(mockEnemigo2);

        trampa.atacar(enemigos);

        verify(mockEnemigo, times(1)).atacadoPorTrampa();
        verify(mockEnemigo2, times(1)).atacadoPorTrampa();

    }

    @Test
    public void verificarTrampaAtacaATodoEnemigoAunqueNoPuedaConUno() {
        Trampa trampa = new Trampa();

        Lechuza mockEnemigo = mock(Lechuza.class);
        Arania mockEnemigo2 = mock(Arania.class);
        
        when(mockEnemigo.atacadoPorTrampa()).thenReturn(false);

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(mockEnemigo);
        enemigos.add(mockEnemigo2);

        trampa.atacar(enemigos);

        verify(mockEnemigo, times(1)).atacadoPorTrampa();
        verify(mockEnemigo2, times(1)).atacadoPorTrampa();

    }











}

//    @Test
//    public void VerificarQueAgregar1vez() {
//        SistemaConstruccion SistConstruccion = new SistemaConstruccion();
//        TorrePlateada torrePlateada = new TorrePlateada(new Posicion(0,0));
//
//        ConstruccionTentativa enContruccion = new ConstruccionTentativa(torrePlateada);
//
//        EstructurasActivas mock =  mock(EstructurasActivas.class);
//
//        SistConstruccion.agregarEnConstruccion(enContruccion);
//
//        for(int i = 0; i < 20; i++ ){
//            SistConstruccion.activarEstructuras(mock);
//        }
//
//        assertEquals(enContruccion.estaActiva(),true);
//        verify(mock,times(1)).agregar(torrePlateada);
//    }
//}
