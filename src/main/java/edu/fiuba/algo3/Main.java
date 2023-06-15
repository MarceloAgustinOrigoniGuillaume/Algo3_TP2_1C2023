package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Celdas.*;
import javafx.scene.layout.StackPane;
import org.json.simple.parser.ParseException;
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.Controladores.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        App.main(args);
        /*
        Logger.setTestMode(false);

        Ventana ventana = new Ventana();
        ControladorJuego controladorJuego;
        try{
            // inicia juego...
            controladorJuego = new ControladorJuego("src/main/resources/archivos-json/mapa.json","src/main/resources/archivos-json/enemigos.json");

        } catch (Exception e){
            System.out.println("ERROR "+e.toString());
            return;
        }        

        ventana.setVista(controladorJuego.menuInicial());
        ventana.show();
        */
        // de alguna forma despues se lanza el evento
    }
}


