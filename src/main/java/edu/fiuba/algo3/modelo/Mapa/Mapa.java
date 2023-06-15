package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Celdas.Unidad;
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

            Logger.info("Se mueve enemigo a posicion: "+String.valueOf(pos.x())+","+String.valueOf(pos.y()));

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

        //System.out.println("--->EN FINAL HABIA MOVIDO  : "+String.valueOf(cant)); DEBBUGEAR
        cant = obtenerPasarela(camino.get(camino.size()-2)).obtenerUnidades().size();
        //System.out.println("--->Ante ultima TIENE  : "+String.valueOf(cant)); DEBUGGEAR

    }

    //Pre: -
    //Post: (Cuando la lechuza llega al jugador) saca la primera de las defensas creadas.
    public void atacarPrimeraTorre(){

        Coordenada coordenadaBuscada = defensas.get(0);
        Celda celdaBuscada = obtenerCelda(coordenadaBuscada);
        celdaBuscada.sacarTodos();
        defensas.remove(0);

    }

    public ArrayList<Unidad> accionarDefensas(){
        int indice = 0; // ultima defensa
        Tierra celdaActual;
        Pasarela pasarelaTarget;
        ArrayList<Coordenada> enRango;
        ArrayList<Unidad> enemigosMuertos = new ArrayList<>();
        while(indice < defensas.size()){

            // ES IDEAL este casteo
            celdaActual = (Tierra) obtenerCelda(defensas.get(indice));

            Logger.info("La defensa de la posicion: "+celdaActual.posicion().toString()+"\n" );

            enRango = celdaActual.obtenerEnRango(camino);

            for (Coordenada target: enRango){
                pasarelaTarget = obtenerPasarela(target);
                for(Unidad enemigo: pasarelaTarget.obtenerUnidades()){
                    Logger.info("Ataca a enemigo en: "+target.toString()+"\n");
                    celdaActual.atacar(enemigo, this);

                    if(enemigo.estaMuerto()){
                        pasarelaTarget.sacar(enemigo);
                        enemigosMuertos.add(enemigo);
                    }
                }
            }

            indice+=1;
        }
        Logger.info("Murieron un total de "+String.valueOf(enemigosMuertos.size())+" ENEMIGOS");
        return enemigosMuertos;
    }

    public ArrayList<Unidad> obtenerUnidades(Coordenada coordenada){
        if(indexarPasarela(coordenada) == -1){
            return new ArrayList<>();
        }
        return obtenerPasarela(coordenada).obtenerUnidades();
    }
    
    public void posicionarInicio(Unidad enemigo){
        Logger.info("Se posiciona "+enemigo.toString()+" en el inicio");
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
                dmg += unidad.ataque(this);
            }
            indice-=1;
        }
        return dmg;
    }

    @Override
    public String toString(){

        String columna = "{";
        for(int y = 0; y < 15; y++){

            String fila = "{";
            for(int x = 0; x < 15; x++){

                fila += matrizDeCeldas[y][x].toString();
                fila += " ";
            }
            fila += "}";
            columna += fila+"\n";

        }
        return columna;
    }

}
