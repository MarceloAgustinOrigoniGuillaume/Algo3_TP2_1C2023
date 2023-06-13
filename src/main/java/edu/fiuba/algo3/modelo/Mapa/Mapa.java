package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Celdas.*;


import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;

import java.util.ArrayList;


public class Mapa {

    private Celda[][] matrizDeCeldas;
    private ArrayList<Coordenada> camino;
    private ArrayList<Coordenada> defensas;


    private void agregarCelda(ConvertidorParcela convertidor) throws Exception {
       	// [y == height][x == width]
    	Celda celda = (Celda)convertidor.obtener();
        matrizDeCeldas[convertidor.fila()-1][convertidor.columna()-1] = celda;



        if (convertidor.esCaminable()){
        	camino.add(celda.posicion());
            //System.out.println("SE AGREGO CAMINO ... pos : "+String.valueOf(celda.posicion().x())+","+String.valueOf(celda.posicion().y()));
            //System.out.println("(*Pasarela SET MAPA "+String.valueOf(convertidor.columna())+","+String.valueOf(convertidor.fila())+" == "+celda.getClass());
        } else{
	        //System.out.println("->(CELDA SET MAPA "+String.valueOf(convertidor.columna())+","+String.valueOf(convertidor.fila())+" == "+celda.getClass());
        }

    }

    private Celda obtenerCelda(Coordenada coordenada){
        //System.out.println("-->SE OBTUVO "+String.valueOf(coordenada.x())+","+String.valueOf(coordenada.y())+" == "+(matrizDeCeldas[coordenada.y()-1][coordenada.x()-1]).getClass());

        return matrizDeCeldas[coordenada.y()-1][coordenada.x()-1];

    }



    public Mapa(LectorMapa lector ,int width, int height) throws Exception {
        

    	// inicializas
    	matrizDeCeldas = new Celda[height][width];
        camino = new ArrayList();
        defensas = new ArrayList();

    	// cargas lector
        while(lector.haySiguiente()){
        	agregarCelda((ConvertidorParcela)(lector.siguienteElemento()));
        }

        //System.out.println("Total camino length "+String.valueOf(camino.size()));

    }

    public boolean posicionar(Coordenada coordenada, Construccion construccion){
        if(obtenerCelda(coordenada).posicionar(construccion)){
            defensas.add(coordenada);
            return true;
        }

        return false;
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
        Coordenada pos = camino.get(indice);
        while(indice >= 0){

            pos = camino.get(indice);
            
            //System.out.println("--->MOVIENDO ENEMIGOS DE  ... pos : "+String.valueOf(pos.x())+","+String.valueOf(pos.y()));


            pasarela = obtenerPasarela(camino.get(indice));
            unidadesPasarela = pasarela.obtenerUnidades();
            pasarela.sacarTodos();

            for (Unidad unidad: unidadesPasarela){
                obtenerPasarela(
                    camino.get(moverIndex(indice,unidad.velocidad()))).posicionar(unidad);
            }
            indice-=1;
        }


        int cant = obtenerPasarela(camino.get(camino.size()-1)).obtenerUnidades().size();

        //System.out.println("--->EN FINAL HABIA MOVIDO  : "+String.valueOf(cant));
        cant = obtenerPasarela(camino.get(camino.size()-2)).obtenerUnidades().size();
        //System.out.println("--->Ante ultima TIENE  : "+String.valueOf(cant));

    }


    public ArrayList<Unidad> accionarDefensas(){
        int indice = 0; // ultima defensa
        Tierra celdaActual;
        Pasarela pasarelaTarget;
        ArrayList<Coordenada> enRango;
        ArrayList<Unidad> enemigosMuertos = new ArrayList<>();
        while(indice < defensas.size()){

            // no es ideal este casteo ja...
            celdaActual = (Tierra) obtenerCelda(defensas.get(indice));


            enRango = celdaActual.obtenerEnRango(camino);

            for (Coordenada target: enRango){
                pasarelaTarget = obtenerPasarela(target);
                for(Unidad enemigo: pasarelaTarget.obtenerUnidades()){
                    celdaActual.atacar(enemigo);

                    if(enemigo.estaMuerto()){
                        pasarelaTarget.sacar(enemigo);
                        enemigosMuertos.add(enemigo);
                    }
                }
            }

            indice+=1;
        }

        //System.out.println("-->MURIERON Un total de "+String.valueOf(enemigosMuertos.size())+"ENEMIGOS");

        return enemigosMuertos;
    }



    public ArrayList<Unidad> obtenerUnidades(Coordenada coordenada){
        if(indexarPasarela(coordenada) == -1){
            return new ArrayList<>();
        }

        return obtenerPasarela(coordenada).obtenerUnidades();
    }
    
    public void posicionarInicio(Unidad enemigo){
        //System.out.println("SE ESTA POSICIONANDO ENEMIGO INICIO "+enemigo.toString());
        obtenerCelda(camino.get(0)).posicionar(enemigo);
    }

    public ArrayList<Unidad> popUnidadesFinal(){
        Pasarela pos_final = obtenerPasarela(camino.get(camino.size()-1));

        ArrayList<Unidad> unidadesPasarela = pos_final.obtenerUnidades();

        pos_final.sacarTodos();

        /*
        if(unidadesPasarela.size() >0){
            System.out.println("SE PIDIO SACAR ENEMIGOS FINAL HABIA: "+String.valueOf(unidadesPasarela.size()));            
        } else{
            Coordenada cord = camino.get(camino.size()-1);
            System.out.println("SE PIDIO SACAR ENEMIGOS FINAL HABIA:0 , nadie... pos : "+String.valueOf(cord.x())+","+String.valueOf(cord.y()));
        }
        */

        return unidadesPasarela;
    }

    public int cantidadDmgPosible(){
        int dmg = 0;
        int indice = camino.size()-2;

        while(indice >= 0){

            for(Unidad unidad : obtenerPasarela(camino.get(indice)).obtenerUnidades()){
                dmg += unidad.ataque();
            }
            indice-=1;
        }

        return dmg;

    }




}
