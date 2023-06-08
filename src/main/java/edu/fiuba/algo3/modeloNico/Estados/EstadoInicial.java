package edu.fiuba.algo3.modeloNico.Estados;

import edu.fiuba.algo3.modelo.moduloLector.LectorMapa;
import edu.fiuba.algo3.modelo.moduloLector.ConvertidorParcela;
import edu.fiuba.algo3.modeloNico.Juego;
import org.json.simple.parser.ParseException;

import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modeloNico.Celdas.Celda;

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
    
        //juego.asignarMapa(mapa);
    }

    @Override
    public void ejecutarEstado() {
        //Crear turno? tiene mas sentido para mi pero bueno

        try{
	        LectorMapa lector = new LectorMapa(jsonMapa,WIDTH_MAP,HEIGHT_MAP);
	        Mapa mapa = new Mapa(lector, WIDTH_MAP,HEIGHT_MAP);        	
        } catch (Exception e){
        	System.out.println("ERROR "+e.toString());
        }


    }
}
