package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.moduloLector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloLector.LectorEnemigo;
import edu.fiuba.algo3.modelo.moduloLector.LectorMapa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import edu.fiuba.algo3.modeloNico.Juego;
import edu.fiuba.algo3.modeloNico.Jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsIntegracion {
    @Test
    public void verficarSeCreaJugadorCorrectamente() throws IOException, ParseException {
        Juego juego = new Juego("src/main/resorces/mapa.json","src/main/resorces/enemigos.json");

        Jugador jugador = juego.obtenerJugador();
        assertEquals(100,jugador.obtenerCreditos());
        assertEquals(20,jugador.obtenerVida());

    }



}
