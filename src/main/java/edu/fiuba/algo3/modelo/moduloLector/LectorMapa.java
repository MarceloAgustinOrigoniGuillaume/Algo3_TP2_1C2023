package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LectorMapa extends Lector{
    public LectorMapa(String filePath) throws IOException, ParseException {
        super(filePath);
    }

    @Override
    public Elemento siguienteElemento() {
        return null;
    }


}
