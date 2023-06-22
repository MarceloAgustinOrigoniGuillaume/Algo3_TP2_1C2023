package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Defensas.Construccion;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;

// posicionar
public class Mapa {

    // interfaces externas para notificar cambios.
    public interface OnEnemiesDiedListener{
        void acreditarMuertos(ArrayList<Enemigo> muertos);
    }

    public interface OnHabitantesChangedListener {
        void cambio(Coordenada coordenada, CeldaDescriptor celda);
    }



    // interfaces internas para contar dmg.
    private interface EjecutarMetodoConCeldas{
       boolean ejecutarMetodoConCeldas(Celda celda);
    }
    private class Contador implements EjecutarMetodoConCeldas{
        int damageTotal;
        @Override
        public boolean ejecutarMetodoConCeldas(Celda celda) {
            this.damageTotal = celda.enemigos().obtenerDamagePosible(damageTotal);
            return true;
        }
    }


    // referencias de coordenadas para accionar segun lo debido
    private ArrayList<Coordenada> caminoTerrestre;
    private ArrayList<Coordenada> caminoAereo;
    private ArrayList<Coordenada> defensas;

    private Integer width;

    private Integer height;

    private Celda[][] matrizDeCeldas;


    private OnEnemiesDiedListener acreditadorMuertos;
    private OnHabitantesChangedListener listenerCambios = null;


    public void setListenerCambiosCeldas(OnHabitantesChangedListener listenerCambios){
            this.listenerCambios = listenerCambios;
    }

    public Mapa(LectorMapa lector ,int width, int height, OnEnemiesDiedListener acreditador) throws Exception {
        // inicializas
        acreditadorMuertos = acreditador;
        matrizDeCeldas = new Celda[height][width];
        caminoTerrestre = new ArrayList();
        caminoAereo = new ArrayList<>();
        defensas = new ArrayList();

        this.width = width;
        this.height = height;

        // cargas lector
        while(lector.haySiguiente()){
            agregarCelda((ConvertidorParcela)(lector.siguienteElemento()));
        }
    }


    //Pre: -
    //Post: Es un iterador interno que se encarga de recorrer todas las coordenadas del camino terrestre y aereo.
    private void iteradorDeCeldas(EjecutarMetodoConCeldas visitarCelda){

        int indice = caminoTerrestre.size()-2; // ante ultima pasarela
        int indice2 = 0;
        Celda celdaActual;


        for(Coordenada posicion: new ArrayList<>(caminoAereo)){
            /*
            // nunca deberia pasar, ya que se chequea.
            if(caminoTerrestre.contains(posicion)){
                caminoAereo.remove(posicion);
                continue;
            }
            */

            celdaActual = obtenerCelda(posicion);

            if(!visitarCelda.ejecutarMetodoConCeldas(celdaActual)){
                return;
            }
        }


        while(indice >= 0){
            celdaActual = obtenerCelda(caminoTerrestre.get(indice));
            if(!visitarCelda.ejecutarMetodoConCeldas(celdaActual)){
                return;
            }
            indice -=1;
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
        if(construccion.posicionarEn(obtenerCelda(coordenada))){
            defensas.add(coordenada);

            notificarCeldaCambio(coordenada);
            return true;
        }
        return false;
    }

    //Pre: -
    //Post: Actualiza los habitantes de las coordenadas recibidas.
    private void actualizarPosicionEnemigo(Enemigo unidad, Coordenada desde, Coordenada hasta){
        obtenerCelda(desde).enemigos().sacar(unidad);

        if(hasta == posicionFinal()){
            Logger.Log("Enemigo "+unidad.toString()+" llego al final.. "+hasta.toString());
            // No se posiciona, ya que son "bombas"
            return;
        }

        unidad.posicionarEn(obtenerCelda(hasta));
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

        notificarCeldaCambio(desde);
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
            celdaActual.accionarEnemigos(this, jugador);
            return true;}
        );

        // hagamosla sencilla para notificar, por ahora almenos
        iteradorDeCeldas((Celda celdaActual)->{
            notificarCeldaCambio(celdaActual);
            return true;
        });

    }

    //Pre: -
    //Post: (Cuando la lechuza llega al jugador) saca la primera de las defensas creadas.
    public void atacarPrimeraTorre(){

        int indice =0;
        Celda celdaBuscada;

        // buscas primer torre.
        while (indice < defensas.size()){
            celdaBuscada = obtenerCelda(defensas.get(indice));
            if(celdaBuscada.defensas().recibirAtaqueLechuza()){ // trampa devolveria false, no se puede quitar.
                
                Logger.Log("-------->Defensa atacada... posicion: "+defensas.get(indice).toString());
                defensas.remove(indice);
                notificarCeldaCambio(celdaBuscada);

                return; // solo una torre.
            }
            indice+=1;
        }

    }

    private void notificarCeldaCambio(Celda celda){
        if(listenerCambios != null){
            listenerCambios.cambio(celda.posicion(), celda.describe());
        }

    }

    // publico para que alguien externo... defensa avise si termino
    // la construccion
    public void notificarCeldaCambio(Coordenada coordenada){
        notificarCeldaCambio(obtenerCelda(coordenada));
    }

    public void notificarInicioCambio(){
        notificarCeldaCambio(caminoTerrestre.get(0));
    }


    public void removerConstruccion(Coordenada coordenada){
        
        obtenerCelda(coordenada).defensas().clear();
        notificarCeldaCambio(coordenada);
        return;
    }

    //Pre: -
    //Post: Desde las defenses se le dice a mapa que quiere atacar a determinada coordenada.
    public boolean atacar(Coordenada coordenada, Defensa defensa){
        //Logger.info(defensa.toString()+" atacando a : "+coordenada.toString());
        if(coordenada.x()<1 || coordenada.x()>this.width|| coordenada.y()<1 || coordenada.y()> height) {
            return true;
        }
        Celda celda = obtenerCelda(coordenada);
        boolean seguirAtacando = celda.enemigos().recibirAtaque(defensa);

        ArrayList<Enemigo> muertos= celda.enemigos().popMuertos();

        if(muertos.size() > 0){


            acreditadorMuertos.acreditarMuertos(muertos);
            
            // notify observers celda cambio.
            notificarCeldaCambio(coordenada);
        }

        return seguirAtacando;
    }

    public void accionarDefensas(){
        for(Coordenada posDefensa: defensas){
            Logger.info("Se acciono defensa de la posicion: "+posDefensa.toString());
            obtenerCelda(posDefensa).accionarEstructuras(this);
        }
    }

    public CeldaDescriptor obtenerInformacion(Coordenada coordenada){
        return obtenerCelda(coordenada).describe();
    }
    
    public void posicionarInicio(Enemigo enemigo){
        //Logger.info("Se posiciona "+enemigo.toString()+" en el inicio");
        enemigo.posicionarEn(obtenerCelda(caminoTerrestre.get(0)));
    }

    //Pre: -
    //Post: Le mandamos al iterador(interno) de celdas un contador para que almacene en el el daño de los enemigos.
    public int cantidadDamagePosible(){
        Contador contador = new Contador();
        iteradorDeCeldas(contador);
        return contador.damageTotal;
    }

    //Pre: -
    //Post: Devuelve una matriz de celdas (El mapa).
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
