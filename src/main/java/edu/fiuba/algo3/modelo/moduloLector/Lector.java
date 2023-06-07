package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public abstract class  Lector {
    JSONArray jsonArray;
    JSONObject actual;
    protected Iterator iterador;
    public Lector(String filePath) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(filePath));
        this.jsonArray = (JSONArray) obj;
        this.iterador = jsonArray.iterator();
    }
    public abstract Elemento siguienteElemento();
    public boolean haySiguiente() {

        return iterador.hasNext();
    }
}
