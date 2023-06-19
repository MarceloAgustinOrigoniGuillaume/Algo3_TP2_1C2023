package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

public class Mapa {

    private interface EjecutarMetodoConCeldas{
       boolean ejecutarMetodoConCeldas(Celda celda);
    }

    private class Contador implements EjecutarMetodoConCeldas{
        int damageTotal;
        @Override
        public boolean ejecutarMetodoConCeldas(Celda celda) {
            this.damageTotal = celda.obtenerDamagePosible(damageTotal);
            return true;
        }
    }
    private Celda[][] matrizDeCeldas;
    private ArrayList<Coordenada> caminoTerrestre;
    private ArrayList<Coordenada> caminoAereo;
    private ArrayList<Coordenada> defensas;


    //Pre: -
    //Post: Es un iterador interno que se encarga de recorrer todas las coordenadas del camino terrestre y aereo.
    private void iteradorDeCeldas(EjecutarMetodoConCeldas visitarCelda){

        int indice = caminoTerrestre.size()-2; // ante ultima pasarela
        int indice2 = 0;
        Celda celdaActual;

        while(indice >= 0){
            celdaActual = obtenerCelda(caminoTerrestre.get(indice));
            if(!visitarCelda.ejecutarMetodoConCeldas(celdaActual)){
                return;
            }
            indice -=1;
        }
        while(indice2 < caminoAereo.size()){
            celdaActual = obtenerCelda(caminoAereo.get(indice));
            if(!visitarCelda.ejecutarMetodoConCeldas(celdaActual)){
                return;
            }
            indice2 += 1;
        }
    }

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

        if(hasta == posicionFinal()){
            Logger.Log("Enemigo "+unidad.toString()+" llego al final.. "+hasta.toString());
            // No se posiciona, ya que son "bombas"
            return;
        }
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
    public boolean moverEnCaminoTerrestre(Enemigo unidad, Coordenada desde, int cantidad){
        int index = indexarPasarela(desde);
        int indiceFinal = 0;

        if(index == -1){
            return false;
        }
        indiceFinal = moverIndex(index, cantidad);
        actualizarPosicionEnemigo(unidad, desde, caminoTerrestre.get(indiceFinal));
        return (indiceFinal == caminoTerrestre.size()-1);
    }

    //Pre: -
    //Post: Itera todas las posiciones en donde hay enemigos y les dice que se mueva.
    public void accionarEnemigos(Jugador jugador){
        iteradorDeCeldas((Celda celdaActual)->{
            celdaActual.moverUnidades(this, jugador);
            return true;}
        );
    }

    //Pre: -
    //Post: (Cuando la lechuza llega al jugador) saca la primera de las defensas creadas.
    public void atacarPrimeraTorre(){
        Coordenada coordenadaBuscada = defensas.get(0);
        Celda celdaBuscada = obtenerCelda(coordenadaBuscada);
        celdaBuscada.clear();
        defensas.remove(0);
    }

    public boolean atacar(Coordenada coordenada, Defensa ataque){
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
        return obtenerCelda(coordenada).describe();
    }
    
    public void posicionarInicio(Enemigo enemigo){
        Logger.info("Se posiciona "+enemigo.toString()+" en el inicio");
        obtenerCelda(caminoTerrestre.get(0)).posicionar(enemigo);
    }

    //Pre: -
    //Post: Le mandamos al iterador(interno) de celdas un contador para que almacene en el el daño de los enemigos.
    public int cantidadDamagePosible(){
        Contador contador = new Contador();
        iteradorDeCeldas(contador);

        return contador.damageTotal;
    }

    public String obtenerTerreno(int x, int y){
        return obtenerCelda(new Coordenada(x,y)).toString();
    }

    //Pre: -
    //Post: Imprime por pantalla el mapa.
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

    //Pre: -
    //Post: -
    public Coordenada posicionFinal(){
        return caminoTerrestre.get(caminoTerrestre.size()-1);
    }
}
