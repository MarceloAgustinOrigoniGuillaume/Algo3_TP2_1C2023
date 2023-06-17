package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.Celdas.Ataque;

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
            //Logger.info("Se agrego camino, en posicion:"+String.valueOf(celda.posicion().x())+","+String.valueOf(celda.posicion().y()));
            //Logger.info("Se agrega pasarela al mapa, en posicion: "+String.valueOf(convertidor.columna())+","+String.valueOf(convertidor.fila())+" u la celda es "+celda.toString());
        } else {
            //Logger.info("Coloco la celda en el mapa, en posicion: "+String.valueOf(convertidor.columna())+","+String.valueOf(convertidor.fila())+" y la celda es "+celda.toString());
        }
    }

    private Celda obtenerCelda(Coordenada coordenada){
        //Logger.info("Se obtuvo"+String.valueOf(coordenada.x())+","+String.valueOf(coordenada.y())+" == "+(matrizDeCeldas[coordenada.y()-1][coordenada.x()-1]).getClass()); DEBUGGEAR

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
        //Logger.info("Cantidad de Pasarelas Actual"+String.valueOf(camino.size())); DEBBUGEAR
    }

    //private Pasarela obtenerPasarela(Coordenada coord){
    //    return (Pasarela) obtenerCelda(coord);
    //}

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


    public boolean posicionar(Coordenada coordenada, Construccion construccion){
        if(obtenerCelda(coordenada).posicionar(construccion)){
            defensas.add(coordenada);
            return true;
        }
        return false;
    }


    public void mover(Posicionable posicionable, Coordenada desde, Coordenada hasta){
        obtenerCelda(desde).sacar(posicionable);
        obtenerCelda(hasta).posicionar(posicionable);

    }



    public void moverEnemigos(){

        int indice = camino.size()-2; // ante ultima pasarela
        while(indice >= 0){
            obtenerCelda(camino.get(indice)).accionarUnidades(this);
            indice -=1;
        }

    }

    //Pre: -
    //Post: (Cuando la lechuza llega al jugador) saca la primera de las defensas creadas.
    public void atacarPrimeraTorre(){

        Coordenada coordenadaBuscada = defensas.get(0);
        Celda celdaBuscada = obtenerCelda(coordenadaBuscada);
        celdaBuscada.clear();
        defensas.remove(0);

    }


    public boolean atacar(Coordenada coordenada, Ataque ataque){
        return obtenerCelda(coordenada).recibirAtaque(ataque);
    }

    public ArrayList<Unidad> accionarDefensas(){
        ArrayList<Unidad> muertos = new ArrayList<Unidad>();

        for(Coordenada posDefensa: defensas){
            Logger.info("La defensa de la posicion: "+posDefensa.toString()+"\n" );
            muertos.addAll(obtenerCelda(posDefensa).accionarEstructuras(this));
        }
        Logger.info("Murieron un total de "+String.valueOf(muertos.size())+" ENEMIGOS");
        return muertos;
    }

    public CeldaDescriptor obtenerInformacion(Coordenada coordenada){
        //if(indexarPasarela(coordenada) == -1){
            //return new ArrayList<>();
        //}
        //return obtenerPasarela(coordenada).obtenerUnidades();
        return obtenerCelda(coordenada).describe();
    }
    
    public void posicionarInicio(Unidad enemigo){
        Logger.info("Se posiciona "+enemigo.toString()+" en el inicio");
        obtenerCelda(camino.get(0)).posicionar(enemigo);
    }

    public int cantidadDmgPosible(){
        /*
        int dmg = 0;
        int indice = camino.size()-2;

        while(indice >= 0){

            for(Unidad unidad : obtenerPasarela(camino.get(indice)).obtenerUnidades()){
                dmg += unidad.ataque();
            }
            indice-=1;
        }*/
        return 20;
    }

    public String obtenerTerreno(int x, int y){
        return obtenerCelda(new Coordenada(x,y)).toString();
    }

    @Override
    public String toString(){

        String columna = "{";
        for(int y = 0; y < 15; y++){

            String fila = String.valueOf(y)+" {";
            for(int x = 0; x < 15; x++){

                fila += matrizDeCeldas[y][x].toString();
                fila += " ";
            }
            fila += "}";
            columna += fila+"\n";

        }
        return columna;
    }


    public void mover(Unidad unidad, Coordenada desde,Coordenada hasta){
        obtenerCelda(desde).sacar(unidad);
        obtenerCelda(hasta).posicionar(unidad);
    }

    public void moverEnCamino(Unidad unidad, Coordenada desde, int cantidad){

        int index = indexarPasarela(desde);
        if(index == -1){
            return; // throw new Exception("Intento mover en camino, desde fuera del camino...");
        }

        mover(unidad, desde , camino.get(moverIndex(index, cantidad)));
    }


    public Coordenada posicionFinal(){
        return camino.get(camino.size()-1);
    }

}
