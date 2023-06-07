package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LectorEnemigo  extends Lector{
    public LectorEnemigo(String filePath) throws IOException, ParseException {
        super(filePath);
    }

    @Override
    public Elemento siguienteElemento() {
        return null;
    }
}
