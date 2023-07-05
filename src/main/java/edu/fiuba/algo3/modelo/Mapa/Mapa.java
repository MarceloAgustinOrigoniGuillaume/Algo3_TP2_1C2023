package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Defensas.Construccion;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.AttackDescriptor;


import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.excepciones.mapa.*;

import edu.fiuba.algo3.modelo.Celdas.OnAttackListener;


import edu.fiuba.algo3.modelo.excepciones.mapa.CaminoInvalido;
//obtenerCelda
public class Mapa {

    // variables

    // listeners externos para eventos
    private OnEnemiesDiedListener acreditadorMuertos;
    private OnHabitantesChangedListener listenerCambios = null;
    private OnAttackListener listenerAtaques = (AttackDescriptor atk)->{};

    // dimensiones del mapa, sea para la matriz de celdas o la de enemigos
    private Integer width;
    private Integer height;

    // se tiene dos matrices para separar el contrato
    // de los tipos de celdas que tienen construccion de los que no.
    private Celda[][] matrizDeCeldas;
    private CeldaConEnemigos[][] matrizCeldaEnemigos;


    // referencias de coordenadas para accionar segun lo debido
    private ArrayList<Coordenada> caminoTerrestre;
    private ArrayList<Coordenada> caminoAereo;
    private ArrayList<Coordenada> defensas;


    // interfaz para iterar celdas.
    public interface AccionadorEnemigos{
        boolean accionarEn(CeldaConEnemigos celda, Coordenada coordenada);
    }

    // constructor, escencialmente inicializa
    public Mapa(LectorMapa lector ,int width, int height, OnEnemiesDiedListener acreditador) throws Exception {

        // inicializas dimensiones
        this.width = width;
        this.height = height;
        
        // inicializas matrices
        matrizDeCeldas = new Celda[height][width];
        matrizCeldaEnemigos = new CeldaConEnemigos[height][width];
        
        // inicializas caminos
        caminoTerrestre = new ArrayList();
        caminoAereo = new ArrayList<>();
        defensas = new ArrayList();

        // inicializas el acreditador.
        acreditadorMuertos = acreditador;


        // cargas lector
        while(lector.haySiguiente()){
            agregarCelda((ConvertidorParcela)(lector.siguienteElemento()));
        }


        //validacion de camino sencilla.
        validarCaminoMapa();
    }

    private void validarCaminoMapa() throws CaminoInvalido{
        if(caminoTerrestre.size() < 2){
            throw new CaminoInvalido("No se detecto un camino en el mapa, se necesitan minimo dos pasarelas.");
        }
        Coordenada anterior = caminoTerrestre.get(0);
        Coordenada actual;
        int indice = 1;
        while(indice < caminoTerrestre.size()){
            actual = caminoTerrestre.get(indice);
            if(anterior.distanciaA(actual) >1){
                // no son celdas contiguas...
                throw new CaminoInvalido("Camino no era un continuo, fue de "+anterior.toString()+" a "+actual.toString());
            }

            anterior = actual;
            indice++;
        }        
    }

    // metodo para agregar celda.
    private void agregarCelda(ConvertidorParcela convertidor) throws Exception {
    
        //validacion posicion
        if(convertidor.fila() < 1 || convertidor.columna() < 1 ||
        convertidor.fila() > height || convertidor.columna() > width){
            throw new CeldaFueraDeRango("Al agregar celda ",convertidor.columna(), convertidor.fila(), width, height);
        }


        // verificas a quien debes agregar        
        if(convertidor.esConstruible()){
            matrizDeCeldas[convertidor.fila()-1][convertidor.columna()-1] = convertidor.obtener();
        } else{
            matrizCeldaEnemigos[convertidor.fila()-1][convertidor.columna()-1] = convertidor.obtener();
        }

        // agregas para el tema del posible camino.
        if (convertidor.esCaminable()){

            // columna es la x.... f1[ c1 c2 c3 c4 c5],
            //                     f2[ c1 c2 c3 c4 c5]
            // fila es la y.
            int x = convertidor.columna();
            int y = convertidor.fila();
            Coordenada coordenada = new Coordenada(x,y);
            caminoTerrestre.add(coordenada);
        }
    }

    //Pre: -
    //Post: Es un iterador interno que se encarga de recorrer todas las coordenadas del camino terrestre y aereo.
    private void iteradorDeCeldas(AccionadorEnemigos visitarCelda){

        int indice = caminoTerrestre.size()-2; // ante ultima pasarela
        CeldaConEnemigos celdaActual;
        Coordenada coordenada;

        for(Coordenada posicion: new ArrayList<>(caminoAereo)){
            celdaActual = obtenerCeldaEnemigos(posicion);
            coordenada = posicion;
            //Logger.dbg("La coordenada actual de CAMINO AEREO es:",posicion);
            if(!visitarCelda.accionarEn(celdaActual, posicion)){
                return;
            }
        }
        while(indice >= 0){
            celdaActual = obtenerCeldaEnemigos(caminoTerrestre.get(indice));
            coordenada = caminoTerrestre.get(indice);
            //Logger.dbg("La coordenada actual de CAMINO TERRESTRE es:",caminoTerrestre.get(indice));
            if(!visitarCelda.accionarEn(celdaActual, caminoTerrestre.get(indice))){
                return;
            }
            indice -=1;
        }
    }
    //throws CeldaNoExistia
    // obtener celda que puede tener construccion, null en caso de no existir 
    private Celda obtenerCelda(Coordenada coordenada){
        return matrizDeCeldas[coordenada.y()-1][coordenada.x()-1];
    }

    private CeldaConEnemigos obtenerCeldaEnemigos(Coordenada coordenada){
        CeldaConEnemigos celda = matrizCeldaEnemigos[coordenada.y()-1][coordenada.x()-1];

        // en caso de no esta aca agarra la que puede tener construccion
        // porque tambien tienen enemigos.
        if(celda == null){ 
            celda = obtenerCelda(coordenada);
        }

        return celda;
    }

    //#### Accionadores

    //Pre: -
    //Post: Itera todas las posiciones en donde hay defensas y les dice que se accionen.
    public void accionarDefensas(){
        Logger.info("Accionando defensas",defensas);

        for(Coordenada posDefensa: defensas){
            Logger.info("Se acciono defensa de la posicion: ",posDefensa);
            
            //REFACTORED-ROCOSO?
            obtenerCelda(posDefensa).accionarEstructuras(this, posDefensa);
        }
    }

    //Pre: -
    //Post: Itera todas las posiciones en donde hay enemigos y les dice que se mueva.
    public void accionarEnemigos(Jugador jugador){

        iteradorDeCeldas((CeldaConEnemigos celdaActual, Coordenada coordenada)->{

            if((celdaActual != null) && (coordenada != null)){
                celdaActual.accionarEnemigos(this, jugador, coordenada);
            }
            //Logger.info("La coordenada Actual es:"+coordenada.x()+";"+coordenada.y());
            return true;}
        );
        iteradorDeCeldas((CeldaConEnemigos celdaActual, Coordenada coordenada)->{
            notificarCeldaCambio(celdaActual, coordenada);
            return true;}
        );
    }



    //#### Metodos de ataque

    //Pre: -
    //Post: Desde las defenses se le dice a mapa que quiere atacar a determinada coordenada.
    public boolean atacar(Coordenada coordenada, Defensa defensa){

        if(coordenada.x()<1 || coordenada.x()>this.width|| coordenada.y()<1 || coordenada.y()> height) {
            return true;
        }
        CeldaConEnemigos celda = obtenerCeldaEnemigos(coordenada);
        boolean seguirAtacando = celda.recibirAtaque(defensa, listenerAtaques);

        ArrayList<Enemigo> muertos = celda.popMuertos();

        if(muertos.size() > 0){

            Logger.info("Murieron ",muertos," acreditando...");
            acreditadorMuertos.acreditarMuertos(muertos);
            notificarCeldaCambio(coordenada); // notify observers celda cambio.
        }
        return seguirAtacando;
    }


    //Pre: -
    //Post: (Cuando la lechuza llega al jugador) saca la primera de las defensas creadas.
    public void atacarPrimeraTorre(){

        int indice =0;
        Celda celdaBuscada;

        while (indice < defensas.size()){ // buscas primer torre.
            //REFACTORED-ROCOSO?
            celdaBuscada = obtenerCelda(defensas.get(indice));
            //Logger.info("--------->Defensa preatacada : ... posicion", defensas.get(indice));
            if(celdaBuscada.recibirAtaqueLechuza(listenerAtaques)){
                Logger.info("-------->Defensa atacada... posicion:",defensas.get(indice));
                notificarCeldaCambio(celdaBuscada, defensas.get(indice));
                defensas.remove(indice);
                return; // solo una torre.
            }
            indice+=1;
        }
    }



    //#### Posicionadores, metodos que unicamente cambian habitantes de lugar o remueven/ageegan


    // posicionar de defensas
    public boolean posicionar(Coordenada coordenada, Construccion construccion){
        //REFACTORED-ROCOSO?
    
        Celda celda = obtenerCelda(coordenada);

        if(celda == null){
            return false;
        }

        Logger.info("Posicionando en",coordenada,"(",celda,") a",construccion);
        if(construccion.posicionarEn(celda)){
            defensas.add(coordenada);

            notificarCeldaCambio(coordenada);
            return true;
        }
        return false;
    }

    // posicionar inicial de enemigos.
    public void posicionarInicio(Enemigo enemigo){
        Logger.info("posicionando ",enemigo,"en",caminoTerrestre.get(0));
        enemigo.posicionarEn(obtenerCeldaEnemigos(caminoTerrestre.get(0)));
    }

    // remueve una construccion
    public void removerConstruccion(Coordenada coordenada){
        //REFACTORED-ROCOSO?
        Celda construccionAEliminar = obtenerCelda(coordenada);
        construccionAEliminar.borrarDefensa();
        notificarCeldaCambio(coordenada);
    }




    //Pre: -
    //Post: Actualiza los habitantes de las coordenadas recibidas.
    private void actualizarPosicionEnemigo(Enemigo unidad, Coordenada desde, Coordenada hasta){

        obtenerCeldaEnemigos(desde).sacar(unidad);
        Logger.info("se movio a ",unidad," de",desde,"hasta",hasta);

        if(hasta == posicionFinal()){ // No se posiciona, ya que son "bombas"
            Logger.dbg("Enemigo ",unidad," llego al final.. ",hasta);
            return;
        }
        unidad.posicionarEn(obtenerCeldaEnemigos(hasta));
    }


    //Pre: caminos incializados
    //Post: Obtiene la coordenada en la que te moverias segun el camino y delega el actualizar la coordenada.
    //Removiendo de las coordenadas a tener en cuenta.
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

    // funcion auxiliar para mover en camino terrestre
    private int moverIndex(int index, int cantidad){
        index+= cantidad;
        if(index>=caminoTerrestre.size()){
            index = caminoTerrestre.size()-1;
        }
        return index;
    }
    // funcion de indexado de una coordenada del camino.
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




    //#### Getters


    //Pre: -
    //Post: Le mandamos al iterador(interno) de celdas un contador para que almacene en el el daño de los enemigos.
    public int cantidadDamagePosible(){
        Contador contador = new Contador();
        iteradorDeCeldas(contador);
        return contador.damageTotal;
    }

    // obtiene informacion usada principalmente para la ui
    public CeldaDescriptor obtenerInformacion(Coordenada coordenada){
        return obtenerCeldaEnemigos(coordenada).describe();
    }

    //Pre: -
    //Post: Devuelve una matriz de celdas (El mapa). En string.
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

    //Pre: camino inicializado. Mediante inicio
    //Post: solo es un getter de la posicion final
    public Coordenada posicionFinal(){
        return caminoTerrestre.get(caminoTerrestre.size()-1);
    }


    //#### Setters
    // setters de listener para eventos.
    public void setListenerCambiosCeldas(OnHabitantesChangedListener listenerCambios){
        this.listenerCambios = listenerCambios;
    }

    // setters de listener para eventos.
    public void setListenerAtaques(OnAttackListener listenerAtaques){

        if(listenerAtaques == null){
            listenerAtaques = (AttackDescriptor atk)->{};
        }
        this.listenerAtaques = listenerAtaques;
    }


    //#### notificadores, para los observers
    private void notificarCeldaCambio(CeldaConEnemigos celda, Coordenada posicion){
        //Logger.dbg("MODELO CAMBIO CELDO ",posicion);
        if(listenerCambios != null){
            listenerCambios.cambio(posicion, celda.describe());
        }
    }

    // publico para que alguien externo... defensa avise si termino
    // la construccion
    public void notificarCeldaCambio(Coordenada coordenada){
        notificarCeldaCambio(obtenerCeldaEnemigos(coordenada), coordenada);
    }

    public void notificarInicioCambio(){
        notificarCeldaCambio(caminoTerrestre.get(0));
    }

}
