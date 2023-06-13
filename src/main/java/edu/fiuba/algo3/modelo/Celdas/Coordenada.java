package edu.fiuba.algo3.modelo.Celdas;

import java.util.Objects;
import java.util.ArrayList;
import java.lang.Math;


public class Coordenada {

    private final int coordenadaX;
    private final int coordenadaY;

    public Coordenada(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public ArrayList<Coordenada> obtenerEnRango(ArrayList<Coordenada> coordenadas, int rango){
        ArrayList<Coordenada> enRango = new ArrayList<>();

        for (Coordenada coord: coordenadas){
            if(distanciaA(coord) <= rango){
                enRango.add(coord);
            }
        }
        return enRango;
    }

    public int distanciaA(Coordenada coord){
        int diffX = Math.abs(coord.x()- x());
        int diffY = Math.abs(coord.y()- y());

        return diffX+ diffY;
    }

    @Override
    public String toString() {
        return String.valueOf(x())+","+String.valueOf(y());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada coordenada = (Coordenada) o;
        return Objects.equals(coordenadaX, coordenada.coordenadaX) && Objects.equals(coordenadaY, coordenada.coordenadaY);
    }

    public int x(){
        return coordenadaX;
    }

    public int y(){
        return coordenadaY;
    }

}
