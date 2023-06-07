package edu.fiuba.algo3.modeloNico.Celdas;

public abstract class Celda {
    private Coordenada coordenada;

    private String tipoCelda;

    private void asignarCoordenda(int fila, int columna){
        this.coordenada = new Coordenada(fila, columna);
    }

    public String imprimirTipo() {
        return tipoCelda;
    };
}
