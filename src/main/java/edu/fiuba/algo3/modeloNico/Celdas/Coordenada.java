package edu.fiuba.algo3.modeloNico.Celdas;

import java.util.Objects;

public class Coordenada {

    private final int coordenadaX;
    private final int coordenadaY;

    public Coordenada(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada coordenada = (Coordenada) o;
        return Objects.equals(coordenadaX, coordenada.coordenadaX) && Objects.equals(coordenadaY, coordenada.coordenadaY);
    }

}
