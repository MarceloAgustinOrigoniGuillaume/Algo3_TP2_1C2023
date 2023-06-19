package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesTierra;

public class Tierra extends Celda {

    public final static String TIERRA_TYPE = "Rocosa";
	
    public Tierra(Coordenada coordenada){
        super(coordenada, new HabitantesTierra());
    }

    @Override
    public String toString(){
        return TIERRA_TYPE;
    }

}
