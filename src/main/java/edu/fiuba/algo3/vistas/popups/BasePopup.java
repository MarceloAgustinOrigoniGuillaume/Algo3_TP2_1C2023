package edu.fiuba.algo3.vistas.popups;

import edu.fiuba.algo3.Logger;
import javafx.stage.Popup;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class BasePopup extends Popup {

    public BasePopup(){
        super();
        setAutoHide(true);
        setHideOnEscape(true);
        setConsumeAutoHidingEvents(false);        
    }

    public BasePopup(Parent parent){
        this();
        getContent().add(parent);
    }

    public void show(Scene scene){
        show(scene.getWindow());
    }


    // centras el popup
    public void show(Window window){        
        double pos_x = window.getX();
        double pos_y = window.getY();

        super.show(window, pos_x ,pos_y);        

        setX(pos_x+(window.getWidth()-getWidth())/2);
        setY(pos_y+(window.getHeight()-getHeight())/2);

    }
}
