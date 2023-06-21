package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import javafx.scene.control.Label;;

public class DefensaDraggeable extends Label {
    private Defensa defensa;
    public DefensaDraggeable(Defensa defensa){
        super(defensa.toString());
        this.defensa = defensa;

        setLayoutX(0);
        setLayoutY(0);
    }


    public Defensa obtenerDefensa() {
        return defensa;
    }
}
