package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Celdas.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        App.main(args);

        /*
        Juego juego = new Juego();


        //Mapa unMapa = new Mapa();

        String[][] matriz = {
                {"Rocoso", "Pasarela", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Rocoso", "Rocoso", "Rocoso", "Rocoso", "Rocoso"},
                {"Tierra", "Pasarela", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Rocoso", "Rocoso", "Rocoso", "Rocoso", "Rocoso"},
                {"Tierra", "Pasarela", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Rocoso", "Rocoso", "Rocoso", "Rocoso", "Rocoso"},
                {"Tierra", "Pasarela", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Rocoso", "Rocoso", "Rocoso", "Rocoso", "Rocoso"},
                {"Tierra", "Pasarela", "Rocoso", "Rocoso", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Tierra", "Pasarela", "Rocoso", "Rocoso", "Tierra", "Tierra", "Tierra", "Rocoso", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Tierra", "Pasarela", "Pasarela", "Pasarela", "Pasarela", "Pasarela", "Pasarela", "Pasarela", "Pasarela", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Pasarela", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Pasarela", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Pasarela", "Rocoso", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Pasarela", "Pasarela", "Pasarela", "Pasarela", "Pasarela", "Pasarela", "Pasarela"},
                {"Rocoso", "Rocoso", "Rocoso", "Rocoso", "Rocoso", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Rocoso", "Rocoso", "Rocoso", "Rocoso", "Rocoso", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Rocoso", "Rocoso", "Rocoso", "Rocoso", "Rocoso", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"},
                {"Rocoso", "Rocoso", "Rocoso", "Rocoso", "Rocoso", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra", "Tierra"}
        };
        Celda[][] matrizDeCeldas = new Celda[15][15];

        Coordenada coordenadaInicial = new Coordenada(0, 0);
        Coordenada coordenadaFinal = new Coordenada(0, 0);
        boolean esPrimeraCoordenada = false;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {

                System.out.print(matriz[i][j]);

                if (matriz[i][j].equals("Rocoso")) {
                    matrizDeCeldas[i][j] = new Rocosa();
                }
                if (matriz[i][j].equals("Tierra")) {
                    matrizDeCeldas[i][j] = new Tierra();
                }
                if (matriz[i][j].equals("Pasarela")) {
                    if (!esPrimeraCoordenada) {
                        coordenadaInicial = new Coordenada(i,j);
                        esPrimeraCoordenada = true;
                    }
                    matrizDeCeldas[i][j] = new Pasarela();
                    coordenadaFinal = new Coordenada(i,j);
                }
            }
            System.out.print("\n");
        }

        Mapa mapa = new Mapa(matrizDeCeldas, coordenadaInicial, coordenadaFinal);
        System.out.print(matriz[0][0]);
        System.out.print(matriz[5][5]);
        System.out.print(matriz[10][14]);

        Enemigo[][] oleadas = new Enemigo[12][2];

        oleadas[0][0] = new Hormiga();
        oleadas[0][1] = new Arania();
        oleadas[0][0].establecerCantidad(1);
        oleadas[0][1].establecerCantidad(0);

        oleadas[1][0] = new Hormiga();
        oleadas[1][1] = new Arania();
        oleadas[1][0].establecerCantidad(1);
        oleadas[1][1].establecerCantidad(1);

        oleadas[2][0] = new Hormiga();
        oleadas[2][1] = new Arania();
        oleadas[2][0].establecerCantidad(2);
        oleadas[2][1].establecerCantidad(1);

        oleadas[3][0] = new Hormiga();
        oleadas[3][1] = new Arania();
        oleadas[3][0].establecerCantidad(0);
        oleadas[3][1].establecerCantidad(1);

         oleadas[4][0] = new Hormiga();
         oleadas[4][1] = new Arania();
         oleadas[4][0].establecerCantidad(1);
         oleadas[4][1].establecerCantidad(1);

        oleadas[5][0] = new Hormiga();
        oleadas[5][1] = new Arania();
        oleadas[5][0].establecerCantidad(1);
        oleadas[5][1].establecerCantidad(2);

        oleadas[6][0] = new Hormiga();
        oleadas[6][1] = new Arania();
        oleadas[6][0].establecerCantidad(0);
        oleadas[6][1].establecerCantidad(1);

        oleadas[7][0] = new Hormiga();
        oleadas[7][1] = new Arania();
        oleadas[7][0].establecerCantidad(1);
        oleadas[7][1].establecerCantidad(0);

        oleadas[8][0] = new Hormiga();
        oleadas[8][1] = new Arania();
        oleadas[8][0].establecerCantidad(1);
        oleadas[8][1].establecerCantidad(0);

        oleadas[9][0] = new Hormiga();
        oleadas[9][1] = new Arania();
        oleadas[9][0].establecerCantidad(2);
        oleadas[9][1].establecerCantidad(0);

        oleadas[10][0] = new Hormiga();
        oleadas[10][1] = new Arania();
        oleadas[10][0].establecerCantidad(0);
        oleadas[10][1].establecerCantidad(1);

        oleadas[11][0] = new Hormiga();
        oleadas[11][1] = new Arania();
        oleadas[11][0].establecerCantidad(1);
        oleadas[11][1].establecerCantidad(2);
        */
    }
}


