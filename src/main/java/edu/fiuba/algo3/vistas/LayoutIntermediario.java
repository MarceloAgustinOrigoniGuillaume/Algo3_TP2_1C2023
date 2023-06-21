package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.controladores.ControladorConstruccion;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;


public class LayoutIntermediario extends AnchorPane {

    private DefensaDraggeable defensasDrag;
    private Parent view;
    private Parent popup;

    public LayoutIntermediario(){
        this.popup = null;
        this.view = null;
    }
    public void setView(Parent view){
        if(popup == null){
            if(this.view != null){
                getChildren().clear();
            }
            this.view = view;
            getChildren().add(view);
        }
    }
    public void setPopup(Parent popup){
        if(this.popup == null){
            this.popup = popup;
            getChildren().add(popup);

            this.setTopAnchor(popup, 0.0);
            this.setBottomAnchor(popup, 0.0);
            this.setLeftAnchor(popup, 0.0);
            this.setRightAnchor(popup, 0.0);
        }
    }
    public void clearPopup(){
        if(this.popup != null){
            getChildren().remove(this.popup);
            this.popup = null;
        }
    }
    public void instanciarDefensa(Defensa defensa, Ventana ventana) {
        if(this.defensasDrag != null){
            Logger.info("No se puede construir mas de una defensa");
            return;
        }
        this.defensasDrag = new DefensaDraggeable(defensa);
        getChildren().add(this.defensasDrag);
    }

    public void removePopUp() {
        clearPopup();
    }

    public void clickEnCelda(ViewCelda celda) {
        if(this.defensasDrag == null){
            Logger.info("Aca hay una celda de"+celda.toString()+"vacia");
            return;
        }
        boolean pudoConstruir = false;

        pudoConstruir = new ControladorConstruccion().posicionarConstruccion(this.defensasDrag.obtenerDefensa(), celda.getCoordenada());

        if(pudoConstruir == true){
            Logger.info("Se pudo construir");
            getChildren().remove(this.defensasDrag);
            celda.ponerDefensa(new DefensaDescriptor(defensasDrag.toString()));
            this.defensasDrag = null;
        }else{
            Logger.info("NO SE pudo construir");
        }

    }
}
