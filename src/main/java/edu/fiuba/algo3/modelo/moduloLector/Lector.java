package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public interface  Lector {
    Convertidor siguienteElemento();
    boolean haySiguiente();
}
