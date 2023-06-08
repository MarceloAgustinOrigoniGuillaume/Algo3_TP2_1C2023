package edu.fiuba.algo3.modeloNico.Celdas;

public interface Celda {    
    Coordenada posicion();
    boolean posicionar(Construccion construccion);
    boolean posicionar(Unidad unidad);
    //public abstract GameEntity obtener();
}
