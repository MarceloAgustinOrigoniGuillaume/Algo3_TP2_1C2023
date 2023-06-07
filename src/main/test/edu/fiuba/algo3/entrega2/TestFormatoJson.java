package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.moduloLector.ConvertidorMapa;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloLector.LectorEnemigo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestFormatoJson {
    @Test
    public void formatoValidoDeEnemigos() throws IOException, ParseException {

        //Lector lector = new LectorEnemigo("src/main/resorces/enemigos.json");
        Object obj = new JSONParser().parse(new FileReader("src/main/resorces/mapa.json"));


        ConvertidorMapa auxiliar1 = new ConvertidorMapa(((JSONArray) obj).iterator().next());
        JSONObject auxiliar2 = (JSONObject) auxiliar1;
    }
}
