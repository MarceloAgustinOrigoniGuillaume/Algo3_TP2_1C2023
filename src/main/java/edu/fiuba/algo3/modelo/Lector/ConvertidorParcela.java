package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Celdas.Pasarela;
import edu.fiuba.algo3.modelo.Celdas.Rocosa;
import edu.fiuba.algo3.modelo.Celdas.Tierra;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.excepciones.mapa.CeldaNoExistia;


public class ConvertidorParcela implements Convertidor {
    private final static String TIPO_TIERRA = "Tierra";
    private final static String TIPO_ROCA = "Rocoso";
    private final static String TIPO_PASARELA = "Pasarela";

    private int x;
    private int y;
    private String tipo;

    public ConvertidorParcela(int x, int y, String tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    private CeldaConEnemigos instanciarParcela() throws Exception {

        if (TIPO_TIERRA.equals(tipo)){
            return new Tierra();
        }

        if (TIPO_ROCA.equals(tipo)){
            return new Rocosa();
        }        

        if (TIPO_PASARELA.equals(tipo)){
            return new Pasarela();
        }

        throw new CeldaNoExistia("Tipo de parcela '"+tipo+"' es invalido ");
    }

    public <T extends Object> T obtener() throws Exception {
        return (T)instanciarParcela();
    }

    public int fila(){
        return y;
    }

    public int columna(){
        return x;
    }

    public boolean esCaminable(){
        return TIPO_PASARELA.equals(tipo);
    }

    public boolean esConstruible(){
        return !TIPO_ROCA.equals(tipo);
    }

}
