package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesPasarela;

import java.util.ArrayList;

public class Pasarela extends Celda{

    public final static String PASARELA_TYPE = "Pasarela";

    public Pasarela(Coordenada coordenada){
        super(coordenada, new HabitantesPasarela());
    }

    public ArrayList<Unidad> accionarEstructuras(Mapa mapa){
        return habitantes.accionarEstructuras(mapa, this.posicion());
    }


    @Override
    public String toString(){
        return PASARELA_TYPE;
    }

}
