package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import javafx.scene.image.Image;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.AlgoDefense;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.vistas.celda.CeldaView;
import edu.fiuba.algo3.vistas.celda.DefensaCeldaView;

public class DefensaDraggeable extends DefensaCeldaView {
    private Defensa defensa;
    private Image imagenDefensa = null;
    private Coordenada coordenada = null;
    private CeldaView celdaActual;

    public interface OnPlacedListener{
        void placed();
    }

    private OnPlacedListener onPlaced = null;

    public void setOnPlaced(OnPlacedListener listener){
        onPlaced = listener;
    }



    public DefensaDraggeable(Defensa defensa){
        this.defensa = defensa;

        DefensaDescriptor descriptor = new DefensaDescriptor(defensa.toString(), true);

        updateDefensa(descriptor.rel_image(),CeldaView.TILE_SIZE, CeldaView.TILE_SIZE);
    }

    public String toString(){
        return defensa.toString();
    }

    public Defensa obtenerDefensa() {
        return defensa;
    }

    
    public void placeOn(CeldaView celda){        
        celdaActual = celda;
        coordenada = celda.getCoordenada();
        celdaActual.getChildren().add(this);
    }

    public Coordenada getCoordenada(){
        return coordenada;
    }

    public void removeFrom(CeldaView celda){
        celdaActual.getChildren().remove(this);
    }

    public void reset(){
        if(celdaActual != null){
            removeFrom(celdaActual);
            Logger.info("REMOVIDA DE DEFENSA ACTUAL");
            //celdaActual = null;
        }
    }


    public boolean posicionarEnMapa(AlgoDefense mediatorJuego){

        if(coordenada == null){
            Logger.err("Coordenada WAS NULL AT DefensaDraggeable::posicionarEnMapa");
            return false;
        }
        if(mediatorJuego.colocadorDeDefensas(defensa, coordenada)){
            reset();
            if(onPlaced != null){
                onPlaced.placed();
            }
            return true;
        }  

        return false;
    }

}
