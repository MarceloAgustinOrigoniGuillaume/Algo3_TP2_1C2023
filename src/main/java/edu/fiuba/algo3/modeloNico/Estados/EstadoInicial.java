package edu.fiuba.algo3.modeloNico.Estados;

import edu.fiuba.algo3.modeloNico.Mapa.Mapa;
import edu.fiuba.algo3.modeloNico.Celdas.Celda;

import edu.fiuba.algo3.modeloNico.Juego;
import edu.fiuba.algo3.modeloNico.Oleadas;




import edu.fiuba.algo3.modelo.moduloLector.LectorMapa;
import edu.fiuba.algo3.modelo.moduloLector.LectorEnemigo;
import edu.fiuba.algo3.modelo.moduloLector.ConvertidorParcela;
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
    
        //juego.asignarMapa(mapa);
    }

    @Override
    public void ejecutarEstado() {

        try{
            // reinicia el estado de Juego
	        LectorMapa lector = new LectorMapa(jsonMapa,WIDTH_MAP,HEIGHT_MAP);

            juego.asignarMapa(new Mapa(lector, WIDTH_MAP,HEIGHT_MAP));
            
            LectorEnemigo lectorEnemigos = new LectorEnemigo(jsonEnemigos);

            juego.asignarOleadas(new Oleadas( juego.obtenerJugador(), lectorEnemigos));


        } catch (Exception e){
        	System.out.println("ERROR "+e.toString());
        }


    }
}
