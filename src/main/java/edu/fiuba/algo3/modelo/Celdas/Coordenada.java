package edu.fiuba.algo3.modelo.Celdas;

import java.util.Objects;
import java.util.ArrayList;
import java.lang.Math;


public class Coordenada {
    public interface Iterador{
        boolean actOn(Coordenada coord);
    }
    private int coordenadaX;
    private int coordenadaY;

    public Coordenada(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
    }


    // la resta de coordenadas nomas se define como distancia
    // es un supuesto, hay que hacer un test de esto.
    public int distanciaA(Coordenada coordenada){
        return Math.abs(coordenada.x()-x()) + Math.abs(coordenada.y()- y());
    }

    public void iterarEnRango(int rango, Iterador iterador){
        int x_inicial = Math.max(x()-rango, 0);
        int y_inicial = Math.max(y()-rango, 0);

        int x_final = x() + rango;
        int y_final = y() + rango;


        int x = x_inicial;
        int y = y_inicial;

        while(x <= x_final && y <= y_final && iterador.actOn(new Coordenada(x,y))){
            x+=1;
            if(x > x_final){
                x = x_inicial;
                y+=1;
            }

        }
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
        return Objects.equals(x(), coordenada.x()) && Objects.equals(y(), coordenada.y());
    }
    public int x(){
        return coordenadaX;
    }

    public int y(){
        return coordenadaY;
    }

    public void setX(int x){
        coordenadaX = x;
    }

    public void setY(int y){
        coordenadaY = y;
    }

}
