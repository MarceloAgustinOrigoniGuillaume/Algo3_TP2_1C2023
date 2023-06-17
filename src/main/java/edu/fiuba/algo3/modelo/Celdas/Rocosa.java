package edu.fiuba.algo3.modelo.Celdas;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesTerreno;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class Rocosa extends Celda {

    public final static String ROCOSA_TYPE = "Rocosa";

    public Rocosa(Coordenada coordenada){
        super(coordenada, new HabitantesTerreno());
    }

    public ArrayList<Unidad> accionarEstructuras(Mapa mapa){
        return null;
    }

    @Override
    public String toString(){
        return ROCOSA_TYPE;
    }
}
