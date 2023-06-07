package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EstadoJuego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloLector.ConvertidorEnemigo;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class estadoDeJuegoTest {

    @Test
    public void verificarEnemigosPuedenMatar(){
        Jugador jugador = new Jugador();
        Lector mockLector = mock(Lector.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorEnemigo("Hormiga","0","20"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        Posicion pos = new Posicion(0, 0 );
        Enemigos enemigo = new Enemigos(mockLector, jugador,pos);
        EstadoJuego estadoJuego= new EstadoJuego(enemigo, jugador);

        assertEquals(true, enemigo.puedeMatar(jugador));
    }

    @Test
    public void verificarEnemigosNoPuedenMatar(){
        Jugador jugador = new Jugador();
        Lector mockLector = mock(Lector.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorEnemigo("Hormiga","0","4"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        Posicion pos = new Posicion(0, 0 );
        Enemigos enemigo = new Enemigos(mockLector, jugador,pos);
        EstadoJuego estadoJuego= new EstadoJuego(enemigo, jugador);

        assertEquals(false, enemigo.puedeMatar(jugador));
    }
    @Test
    public void verificarSinMasEnemigosGana(){
        Jugador jugador = new Jugador();
        Lector mockLector = mock(Lector.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorEnemigo("Spider","0","0"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        Posicion pos = new Posicion(0, 0 );
        Enemigos enemigo = new Enemigos(mockLector, jugador, pos);
        EstadoJuego estadoJuego= new EstadoJuego(enemigo, jugador);
        assertEquals(true, estadoJuego.termino());
        assertEquals(true, estadoJuego.ganoJugador());
    }

    @Test
    public void verificarConPocosEnemigosGana(){
        Jugador jugador = new Jugador();
        Lector mockLector = mock(Lector.class);


        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorEnemigo("Spider","0","4"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        Posicion pos = new Posicion(0, 0 );
        Enemigos enemigo = new Enemigos(mockLector, jugador, pos);
        EstadoJuego estadoJuego= new EstadoJuego(enemigo, jugador);
        assertEquals(true, estadoJuego.termino());
        assertEquals(true, estadoJuego.ganoJugador());
    }

    @Test
    public void verificarJugadorPierde(){
        Jugador jugador = new Jugador();
        Lector mockLector = mock(Lector.class);
        when(mockLector.siguienteElemento()).thenReturn(new ConvertidorEnemigo("Spider","0","20"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        Posicion pos = new Posicion(0, 0 );
        Enemigos enemigo = new Enemigos(mockLector, jugador, pos);
        jugador.recibirAtaque(20);
        EstadoJuego estadoJuego= new EstadoJuego(enemigo, jugador);
        assertEquals(true, estadoJuego.termino());
        assertEquals(false, estadoJuego.ganoJugador());
    }
}
