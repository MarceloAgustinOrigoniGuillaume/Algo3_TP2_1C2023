package edu.fiuba.algo3.modelo;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AlgoDefence {

    Juego juego;

    public AlgoDefence(String jsonMapa,String jsonEnemigos) throws IOException, ParseException {
        this.juego = new Juego(jsonMapa,jsonEnemigos);
    }
}
