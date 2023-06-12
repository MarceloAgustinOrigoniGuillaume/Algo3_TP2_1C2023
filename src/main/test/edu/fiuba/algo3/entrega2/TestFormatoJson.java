package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.modelo.Lector.Lector;
import edu.fiuba.algo3.modelo.Lector.LectorEnemigo;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.fiuba.algo3.modelo.Juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFormatoJson {
    @Test
    public void formatoValidoDeEnemigos() throws Exception {
        

        Lector lector = new LectorEnemigo("src/main/resorces/enemigos.json");

        int cantidad = 0;
        while(lector.haySiguiente()){

        	Object element = lector.siguienteElemento().obtener();

            cantidad+=1;
	        //System.out.println("TURNO "+String.valueOf(cantidad)+" got "+element.toString());
        }
	    //assertEquals(225,cantidad);
    }



    @Test
    public void formatoValidoDeMapa() throws Exception {
        
        Lector lector = new LectorMapa("src/main/resorces/mapa.json",15,15);
        int cantidad = 0;
        while(lector.haySiguiente()){

        	Object element = lector.siguienteElemento().obtener();
        	cantidad+=1;
        }
	    assertEquals(225,cantidad);
    }

    @Test
    public void formatoValidoDeMapaJuego() throws IOException, ParseException {
        
        Juego juego = new Juego("src/main/resorces/mapa.json","src/main/resorces/enemigos.json");

    }
    @Test
    public void pruebaLectorFormatoEnemigosInvalido() {
       assertThrows(Exception.class, ()->{Lector lector = new LectorEnemigo("src/main/resorces/enemigosInvalidos.json");
           int cantidad = 0;
           while(lector.haySiguiente()){

               Object element = lector.siguienteElemento().obtener();

               cantidad+=1;
           }});


    }
    @Test
    public void pruebaLectorFormatoMapaInvalido() {
        assertThrows(Exception.class, () -> {
            Lector lector = new LectorMapa("src/main/resorces/mapaParcelaInvalida.json",15,15);
            int cantidad = 0;
            while (lector.haySiguiente()) {

                Object element = lector.siguienteElemento().obtener();

                cantidad += 1;
            }
        });


    }

    @Test
    public void pruebaMapaTamanioInvalidoColumna (){
        assertThrows(Exception.class, () -> {
            Lector lector = new LectorMapa("src/main/resorces/mapaTamanioInvalidoColumna.json",15,15);
            int cantidad = 0;
            while (lector.haySiguiente()) {

                Object element = lector.siguienteElemento().obtener();

                cantidad += 1;
            }
        });
    }
    @Test
    public void pruebaMapaTamanioInvalidoFila (){
        assertThrows(Exception.class, () -> {
            Lector lector = new LectorMapa("src/main/resorces/mapaTamanioInvalidoFila.json",15,15);
            int cantidad = 0;
            while (lector.haySiguiente()) {

                Object element = lector.siguienteElemento().obtener();

                cantidad += 1;
            }
        });
    }

}
