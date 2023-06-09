package edu.fiuba.algo3.modelo.Lector;


public interface  Lector {
    Convertidor siguienteElemento() throws Exception;
    boolean haySiguiente();
}
