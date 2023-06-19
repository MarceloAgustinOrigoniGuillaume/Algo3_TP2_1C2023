package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Posicionable;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.Celdas.Ataque;

public class Mapa {

    private Celda[][] matrizDeCeldas;
    private ArrayList<Coordenada> caminoTerrestre;
    private ArrayList<Coordenada> caminoAereo;
    private ArrayList<Coordenada> defensas;



    private void agregarCelda(ConvertidorParcela convertidor) throws Exception {

    	Celda celda = (Celda)convertidor.obtener();
        matrizDeCeldas[convertidor.fila()-1][convertidor.columna()-1] = celda;

        if (convertidor.esCaminable()){
        	caminoTerrestre.add(celda.posicion());
            //Logger.info("Se agrego camino, en posicion:"+String.valueOf(celda.posicion().x())+","+String.valueOf(celda.posicion().y()));
            //Logger.info("Se agrega pasarela al mapa, en posicion: "+String.valueOf(convertidor.columna())+","+String.valueOf(convertidor.fila())+" u la celda es "+celda.toString());
        } else {
            //Logger.info("Coloco la celda en el mapa, en posicion: "+String.valueOf(convertidor.columna())+","+String.valueOf(convertidor.fila())+" y la celda es "+celda.toString());
        }
    }

    private Celda obtenerCelda(Coordenada coordenada){
        return matrizDeCeldas[coordenada.y()-1][coordenada.x()-1];
    }


    public Mapa(LectorMapa lector ,int width, int height) throws Exception {

    	// inicializas
    	matrizDeCeldas = new Celda[height][width];
        caminoTerrestre = new ArrayList();
        caminoAereo = new ArrayList<>();
        defensas = new ArrayList();

    	// cargas lector
        while(lector.haySiguiente()){
        	agregarCelda((ConvertidorParcela)(lector.siguienteElemento()));
        }
    }

    private int indexarPasarela(Coordenada coordenada){
        int i = 0;
        while(i < caminoTerrestre.size()){
            if(caminoTerrestre.get(i).equals(coordenada)){
                return i;
            }
            i+=1;
        }
        return -1;
    }
    // mover
    private int moverIndex(int index, int cantidad){
        index+= cantidad;
        if(index>=caminoTerrestre.size()){
            index = caminoTerrestre.size()-1;
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

    //Pre: -
    //Post: Actualiza los habitantes de las coordenadas recibidas.
    private void actualizarPosicionEnemigo(Enemigo unidad, Coordenada desde, Coordenada hasta){
        obtenerCelda(desde).sacar(unidad);
        obtenerCelda(hasta).posicionar(unidad);
    }

    //Pre: -
    //Post: Obtiene la coordenada en la que te moverias segun el camino y delega el actualizar la coordenada.
    public void moverEnCaminoAereo(Enemigo unidad, Coordenada desde,Coordenada hasta){

        if(caminoAereo.contains(desde)){
            caminoAereo.remove(desde);
        }
        if(!caminoTerrestre.contains(hasta)){
            caminoAereo.add(hasta);
        }
        actualizarPosicionEnemigo(unidad, desde, hasta);
    }

    //Pre: -
    //Post: Obtiene la coordenada en la que te moverias segun el camino y delega el actualizar la coordenada.
    public void moverEnCaminoTerrestre(Enemigo unidad, Coordenada desde, int cantidad){
        int index = indexarPasarela(desde);
        if(index == -1){
            return;
        }
        actualizarPosicionEnemigo(unidad, desde, caminoTerrestre.get(moverIndex(index, cantidad)));
    }

    //Pre: -
    //Post: Itera todas las posiciones en donde hay enemigos y les dice que se mueva.
    public void moverEnemigos(){
        int indice = caminoTerrestre.size()-2; // ante ultima pasarela
        int indice2 = 0;

        while(indice >= 0){
            obtenerCelda(caminoTerrestre.get(indice)).moverUnidades(this);
            indice -=1;
        }
        while(indice2 < caminoAereo.size()){
            obtenerCelda(caminoAereo.get(indice)).moverUnidades(this);
            indice2 += 1;
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

    public void accionarDefensas(){
        //ArrayList<Enemigo> muertos = new ArrayList<Enemigo>();

        for(Coordenada posDefensa: defensas){
            Logger.info("Se acciono defensa de la posicion: "+posDefensa.toString()+"\n" );
            obtenerCelda(posDefensa).accionarEstructuras(this);
        }
        //return muertos;
    }

    public CeldaDescriptor obtenerInformacion(Coordenada coordenada){
        //if(indexarPasarela(coordenada) == -1){
            //return new ArrayList<>();
        //}
        //return obtenerPasarela(coordenada).obtenerUnidades();
        return obtenerCelda(coordenada).describe();
    }
    
    public void posicionarInicio(Enemigo enemigo){
        Logger.info("Se posiciona "+enemigo.toString()+" en el inicio");
        obtenerCelda(caminoTerrestre.get(0)).posicionar(enemigo);
    }

    public int cantidadDmgPosible(){
        /*
        int dmg = 0;
        int indice = caminoTerrestre.size()-2;

        while(indice >= 0){

            for(Unidad unidad : obtenerPasarela(caminoTerrestre.get(indice)).obtenerUnidades()){
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

    public Coordenada posicionFinal(){
        return caminoTerrestre.get(caminoTerrestre.size()-1);
    }
}
