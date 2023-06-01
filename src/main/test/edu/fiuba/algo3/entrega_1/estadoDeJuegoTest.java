package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EstadoJuego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;
import edu.fiuba.algo3.modelo.moduloDefensas.TorreBlanca;
import edu.fiuba.algo3.modelo.moduloDefensas.TorrePlateada;
import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigo;
import edu.fiuba.algo3.modelo.moduloEnemigos.Hormiga;
import edu.fiuba.algo3.modelo.moduloLector.ElementoEnemigo;
import edu.fiuba.algo3.modelo.moduloLector.ElementoMapa;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigos;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.fiuba.algo3.modelo.moduloEnemigos.Spider;

public class estadoDeJuegoTest {

    @Test
    public void verificarEnemigosPuedenMatar(){
        Jugador jugador = new Jugador();
        Lector mockLector = mock(Lector.class);


        when(mockLector.siguienteElemento()).thenReturn(new ElementoEnemigo("Hormiga","0","20"));
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


        when(mockLector.siguienteElemento()).thenReturn(new ElementoEnemigo("Hormiga","0","4"));
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


        when(mockLector.siguienteElemento()).thenReturn(new ElementoEnemigo("Spider","0","0"));
        when(mockLector.haySiguiente()).thenReturn(true).thenReturn(false);
        Posicion pos = new Posicion(0, 0 );
        Enemigos enemigo = new Enemigos(mockLector, jugador, pos);
        EstadoJuego estadoJuego= new EstadoJuego(enemigo, jugador);
        assertEquals(true, estadoJuego.termino());
        assertEquals(true, estadoJuego.ganoJugador());
    }

}
