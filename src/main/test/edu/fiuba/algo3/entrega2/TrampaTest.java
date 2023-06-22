package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class TrampaTest {

    @Test
    public void verificarDestruccionTrampa(){
        Mapa mockMapa = mock(Mapa.class);
        Defensa trampa = new Trampa();

        trampa.accionar(mockMapa,new Coordenada(1,1));
        trampa.accionar(mockMapa,new Coordenada(1,1));
        verify(mockMapa,times(0)).removerConstruccion(new Coordenada(0,0));
        trampa.accionar(mockMapa,new Coordenada(1,1));
        trampa.accionar(mockMapa,new Coordenada(1,1));
        verify(mockMapa, times(1)).removerConstruccion(new Coordenada(1,1));
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

}
