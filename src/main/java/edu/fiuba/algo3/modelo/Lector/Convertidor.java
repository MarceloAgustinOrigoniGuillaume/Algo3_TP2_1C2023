package edu.fiuba.algo3.modelo.Lector;

public interface Convertidor {
    <T extends Object> T obtener() throws Exception;
}
