package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.Logger;

public class DefensaDraggeable{
    private Defensa defensa;
    private Image imagenDefensa = null;
    private DefensaDescriptor descriptor;
    private Coordenada coordenada = null;

    public interface OnPlacedListener{
        void placed();
    }

    private OnPlacedListener onPlaced = null;

    public void setOnPlaced(OnPlacedListener listener){
        onPlaced = listener;
    }



    public DefensaDraggeable(Defensa defensa){
        this.defensa = defensa;

        descriptor = new DefensaDescriptor(defensa.toString(), true);
    }

    public String toString(){
        return defensa.toString();
    }

    public Defensa obtenerDefensa() {
        return defensa;
    }

    private ViewCelda celdaActual;
    public void placeOn(ViewCelda celda){
        
        if (imagenDefensa == null){
            imagenDefensa= celda.loadImageFor(descriptor.rel_image());
            return;
        } 
        celda.setImage(imagenDefensa);
        coordenada = celda.getCoordenada();
        celdaActual = celda;
    }

    public Coordenada getCoordenada(){
        return coordenada;
    }

    public void removeFrom(ViewCelda celda){
        celda.resetImage();
    }

    public void reset(){
        if(celdaActual != null){
            celdaActual.resetImage();
        }
    }


    public boolean posicionarEnMapa(){

        if(coordenada == null){
            Logger.dbg("COOFDENADA WAS NULL AT DefensaDraggeable::posicionarEnMapa");
            return false;
        }
        if(DatosModelo.colocadorDeDefensas(defensa, coordenada)){

            if(onPlaced != null){
                onPlaced.placed();
            }
            return true;
        }  

        return false;
    }

}
