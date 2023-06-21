package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.controladores.ControladorConstruccion;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class MenuConstruir extends VBox {

    public MenuConstruir(Ventana ventana){
        super();
        init(ventana);
    }
    private void moverObjeto(Button boton){

        boton.setOnMousePressed(event -> {
            // Inicia el arrastre del botón
            boton.startFullDrag();
        });

        boton.setOnMouseDragged(event -> {
            // Mueve el botón a la posición del cursor del mouse
            boton.setLayoutX(event.getX() - boton.getWidth() / 2);
            boton.setLayoutY(event.getY() - boton.getHeight() / 2);
        });

        boton.setOnMouseReleased(event -> {
            // Lógica para soltar el botón en el área deseada
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();

            // Realiza la acción deseada con las coordenadas mouseX y mouseY

            //Posiciona la torrer en esa ubicacion
        });
    }

    private void init(Ventana ventana) {

        setAlignment(Pos.CENTER);
        Parent view = Resources.getVista("menu_construir");

        if(view == null){
            Logger.Log("ERROR LOADING ESTRUCTURAS ... view was 'estructuras' null");
            return;
        }
        getChildren().add(view);

        //Button botonDeArrastre = new Button();

        Button button  = (Button) view.lookup("#buttonTorreBlanca");
        button.setOnAction( (ActionEvent event)->{
            new ControladorConstruccion().seleccionarConstruccion("TorreBlanca", ventana);
        });

       // EventHandler<? super MouseDragEvent> eventHandler = null;
        //button.setOnMouseDragOver(eventHandler);

        Button button2  = (Button) view.lookup("#buttonTorrePlateada");
        button.setOnAction( (ActionEvent event)->{
            new ControladorConstruccion().seleccionarConstruccion("TorrePlateada", ventana);

        });

        Button button3  = (Button) view.lookup("#buttonTrampa");
        button.setOnAction( (ActionEvent event)->{
            new ControladorConstruccion().seleccionarConstruccion("Trampa", ventana);
        });



    }
    public Parent obtener(){
        return this;
    }
}
