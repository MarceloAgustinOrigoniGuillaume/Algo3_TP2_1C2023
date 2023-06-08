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
        //System.out.println("-->SE OBTUVO "+String.valueOf(coordenada.x())+","+String.valueOf(coordenada.y())+" == "+(matrizDeCeldas[coordenada.y()-1][coordenada.x()-1]).getClass());

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

    public boolean posicionar(Coordenada coordenada,Construccion construccion){
        return obtenerCelda(coordenada).posicionar(construccion);
    }

    private Pasarela obtenerPasarela(Coordenada coord){
        return (Pasarela) obtenerCelda(coord);
    }

    private int indexarPasarela(Coordenada coordenada){
        int i = 0;
        while(i < camino.size()){
            if(camino.get(i).equals(coordenada)){
                return i;
            }
            i+=1;
        }

        return -1;
    }



    // mover
    private int moverIndex(int index, int cantidad){
        index+= cantidad;
        if(index>=camino.size()){
            index = camino.size()-1;
        }
        return index;
    }

    public void moverEnemigos(){
        ArrayList<Unidad> unidadesPasarela;
        Pasarela pasarela;
        int indice = camino.size()-2; // ante ultima pasarela

        while(indice >= 0){
            pasarela = obtenerPasarela(camino.get(indice));
            unidadesPasarela = pasarela.obtenerUnidades();
            pasarela.sacarTodos();

            for (Unidad unidad: unidadesPasarela){
                obtenerPasarela(
                    camino.get(moverIndex(indice,unidad.velocidad()))).posicionar(unidad);
            }
            indice-=1;
        }
    }

    public ArrayList<Unidad> obtenerUnidades(Coordenada coordenada){
        if(indexarPasarela(coordenada) == -1){
            return new ArrayList<>();
        }

        return obtenerPasarela(coordenada).obtenerUnidades();
    }
    
    public void posicionarInicio(Unidad enemigo){
        obtenerCelda(camino.get(0)).posicionar(enemigo);
    }

    public ArrayList<Unidad> popUnidadesFinal(){
        Pasarela pos_final = obtenerPasarela(camino.get(camino.size()-1));

        ArrayList<Unidad> unidadesPasarela = pos_final.obtenerUnidades();

        pos_final.sacarTodos();

        return unidadesPasarela;
    }


}
