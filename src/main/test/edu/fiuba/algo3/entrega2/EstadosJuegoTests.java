package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.fiuba.algo3.modelo.excepciones.juego.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

public class EstadosJuegoTests {

	@Test
	public void testJuegoIniciarDosVecesTiraError() throws Exception{
        Juego juego = new Juego(Resources.getJsonPath("mapa"),Resources.getJsonPath("enemigos"));
        juego.iniciarJuego();
        
        assertThrows(CambioDeEstadoInvalido.class, () -> {
	        juego.iniciarJuego();
        });

	}

	@Test
	public void testJuegoTerminarJuegoSinIniciarTiraError() throws Exception {
        Juego juego = new Juego(Resources.getJsonPath("mapa"),Resources.getJsonPath("enemigos"));        
        assertThrows(CambioDeEstadoInvalido.class, () -> {
	        juego.terminarJuego();
        });

	}

	@Test
	public void testJuegoTerminarJuegoDosVecesTiraError() throws Exception{
        Juego juego = new Juego(Resources.getJsonPath("mapa"),Resources.getJsonPath("enemigos"));        
        juego.iniciarJuego();
        juego.terminarJuego();
        assertThrows(CambioDeEstadoInvalido.class, () -> {
	        juego.terminarJuego();
        });

	}


}