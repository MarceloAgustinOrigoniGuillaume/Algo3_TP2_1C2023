package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TestMovientos {
    @Test
    public void verificarQueLechuzaVaPorCatetos(){
        Mapa mockMapa = mock(Mapa.class);

        Lechuza lechuza = new Lechuza();
        when(mockMapa.posicionFinal()).thenReturn(new Coordenada(15 , 15));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(0,0));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(0,0),new Coordenada(5,0));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(5,0));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(5,0),new Coordenada(10,0));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(10,0));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(10,0),new Coordenada(15,0));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(15,0));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(15,0),new Coordenada(15,5));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(15,5));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(15,5),new Coordenada(15,10));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(15,10));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(15,10),new Coordenada(15,15));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(15,15));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(15,15),new Coordenada(15,15));

    }

    @Test
    public void verificarQueLechuzaSeMuevaEnDiagonal(){
        Mapa mockMapa = mock(Mapa.class);

        Lechuza lechuza = new Lechuza();
        when(mockMapa.posicionFinal()).thenReturn(new Coordenada(15 , 15));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(0,0));
        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(5,0));

        lechuza.atacadoPorTorre(3);
        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(10,0));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(10,0),new Coordenada(15,5));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(15,5));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(15,5),new Coordenada(15,10));

    }

    @Test
    public void verificarDiagonalLechuzaDesdeArranque(){
        Mapa mockMapa = mock(Mapa.class);

        Lechuza lechuza = new Lechuza();
        when(mockMapa.posicionFinal()).thenReturn(new Coordenada(15 , 15));
        lechuza.atacadoPorTorre(3);

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(0,0));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(0,0),new Coordenada(5,5));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(5,5));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(5,5),new Coordenada(10,10));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(10,10));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(10,10),new Coordenada(15,15));

        lechuza.accionar(mockMapa, new Jugador(), new Coordenada(15,15));
        verify(mockMapa,times(1)).moverEnCaminoAereo(lechuza, new Coordenada(15,15),new Coordenada(15,15));

    }


}
