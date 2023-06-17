package edu.fiuba.algo3.modelo.Celdas;

import java.util.Objects;
import java.util.ArrayList;
import java.lang.Math;


public class Coordenada {

    public interface Iterador{
        boolean actOn(Coordenada coord);
    }

    private final int coordenadaX;
    private final int coordenadaY;

    public Coordenada(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public void iterarEnRango(int rango, Iterador iterador){
        int x_inicial = Math.max(coordenadaX-rango, 0);
        int y_inicial = Math.max(coordenadaY-rango, 0);

        int x_final = coordenadaX + rango;
        int y_final = coordenadaY + rango;


        int x = x_inicial;
        int y = y_inicial;

        while(x <= x_final && y_inicial <= y_final && iterador.actOn(new Coordenada(x,y))){            
            x+=1;
            if(x > x_final){
                x = x_inicial;
                y+=1;
            }

        }
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
