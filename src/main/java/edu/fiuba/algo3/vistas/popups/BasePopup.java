package edu.fiuba.algo3.vistas.popups;

import edu.fiuba.algo3.Logger;
import javafx.stage.Popup;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class BasePopup extends Popup {

    public interface OnHideListener{
        void hided();
    }

    private OnHideListener onHide = null;

    public void setOnHide(OnHideListener listener){
        onHide = listener;
    }

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

    public void hide(){
        if(onHide != null){
            onHide.hided();
        }

        super.hide();
    }

    public void show(Scene scene){
        scene.getRoot().requestFocus();
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
