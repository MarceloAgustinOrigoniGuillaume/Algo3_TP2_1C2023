package edu.fiuba.algo3.modelo.Estados;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Oleadas;




import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Lector.LectorEnemigo;
import org.json.simple.parser.ParseException;


import java.io.IOException;

public class EstadoInicial implements EstadoJuego {
    private Juego juego;

    private final static int WIDTH_MAP = 15;
    private final static int HEIGHT_MAP = 15;

    private String jsonMapa;
    private String jsonEnemigos;

    public EstadoInicial(Juego juego, String jsonMapa,String jsonEnemigos) throws IOException, ParseException {

        this.juego = juego;
        this.jsonMapa = jsonMapa;
        this.jsonEnemigos = jsonEnemigos;

    }

    @Override
    public void ejecutarEstado() {

        try{

            // reinicia el estado de Juego
	        LectorMapa lector = new LectorMapa(jsonMapa,WIDTH_MAP,HEIGHT_MAP);
            juego.asignarMapa(new Mapa(lector, WIDTH_MAP,HEIGHT_MAP));
            LectorEnemigo lectorEnemigos = new LectorEnemigo(jsonEnemigos);
            juego.asignarOleadas(new Oleadas(lectorEnemigos));

            Logger.info(juego.obtenerMapa().toString());

        } catch (Exception e){
        	System.out.println("ERROR "+e.toString());
        }


    }
}
