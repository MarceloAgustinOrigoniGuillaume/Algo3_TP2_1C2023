package edu.fiuba.algo3.modeloNico.Mapa;

import edu.fiuba.algo3.modeloNico.Celdas.*;
import edu.fiuba.algo3.modeloNico.Enemigo.Enemigo;


import edu.fiuba.algo3.modelo.moduloLector.LectorMapa;
import edu.fiuba.algo3.modelo.moduloLector.ConvertidorParcela;

import java.util.ArrayList;


public class Mapa {

    private Celda[][] matrizDeCeldas;
    private ArrayList<Coordenada> camino;


    private void agregarCelda(ConvertidorParcela convertidor){
       	// [y == height][x == width]
    	Celda celda = (Celda)convertidor.obtener();
        matrizDeCeldas[convertidor.fila()-1][convertidor.columna()-1] = celda;



        if (convertidor.esCaminable()){
        	camino.add(celda.posicion());
	        //System.out.println("(*Pasarela SET MAPA "+String.valueOf(convertidor.columna())+","+String.valueOf(convertidor.fila())+" == "+celda.getClass());
        } else{
	        //System.out.println("->(CELDA SET MAPA "+String.valueOf(convertidor.columna())+","+String.valueOf(convertidor.fila())+" == "+celda.getClass());
        }

    }

    private Celda obtenerCelda(Coordenada coordenada){
    	return matrizDeCeldas[coordenada.y()-1][coordenada.x()-1];
    }



    public Mapa(LectorMapa lector ,int width, int height) {
        

    	// inicializas
    	matrizDeCeldas = new Celda[height][width];
    	camino = new ArrayList();

    	// cargas lector
        while(lector.haySiguiente()){
        	agregarCelda((ConvertidorParcela)(lector.siguienteElemento()));
        }

        //System.out.println("Total camino length "+String.valueOf(camino.size()));

    }

    public void moverEnemigos(){


    }
    
    public void posicionarInicio(Enemigo enemigo){
    	//obtenerCelda(camino.first()).posicionar(enemigo);
    }
}
