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

public class EstadoTerminado implements EstadoJuego {
    private Juego juego;
    public EstadoTerminado(Juego juego) {


        this.juego = juego;    
        //juego.asignarMapa(mapa);
    }

    @Override
    public void ejecutarEstado() {
    	// no hace nada por ahora , solo para saber que esta terminado

    }
}
