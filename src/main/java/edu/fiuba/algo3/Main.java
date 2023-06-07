package edu.fiuba.algo3;

import edu.fiuba.algo3.modeloNico.Celdas.*;
import edu.fiuba.algo3.modeloNico.Mapa.Mapa;

public class Main {
    public static void main(String[] args) {
        App.main(args);


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

                if (matriz[i][j] == "Rocoso") {
                    matrizDeCeldas[i][j] = new Rocosa();
                }
                if (matriz[i][j] == "Tierra") {
                    matrizDeCeldas[i][j] = new Tierra();
                }
                if (matriz[i][j] == "Pasarela") {
                    if (esPrimeraCoordenada == false) {
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
        
    }
}


