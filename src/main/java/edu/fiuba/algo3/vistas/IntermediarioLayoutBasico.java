package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Logger;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;

public class IntermediarioLayoutBasico extends StackPane {

    private Parent view;
    private Parent popup;

    public IntermediarioLayoutBasico(){

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
            Logger.info("igual a null");
            this.popup = popup;
            getChildren().add(popup);
        }
        Logger.info("NO igual a null");
    }

    public void clearPopup(){
        if(this.popup != null){
            getChildren().remove(this.popup);
            this.popup = null;
        }
    }
}
