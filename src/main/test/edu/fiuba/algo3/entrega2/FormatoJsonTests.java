package edu.fiuba.algo3.entrega2;

import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.modelo.Lector.Lector;
import edu.fiuba.algo3.modelo.Lector.ConvertidorParcela;
import edu.fiuba.algo3.modelo.Lector.LectorEnemigo;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.fiuba.algo3.modelo.Juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.excepciones.mapa.*;

public class FormatoJsonTests {
    @Test
    public void formatoValidoDeEnemigos() throws Exception {
        

        Lector lector = new LectorEnemigo(Resources.getJsonPath("enemigos"));

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
        
        Lector lector = new LectorMapa(Resources.getJsonPath("mapa"),15,15);
        int cantidad = 0;
        while(lector.haySiguiente()){

        	Object element = lector.siguienteElemento().obtener();
        	cantidad+=1;
        }
	    assertEquals(225,cantidad);
    }

    @Test
    public void formatoValidoDeMapaJuego() throws Exception {
        
        Juego juego = new Juego(Resources.getJsonPath("mapa"),Resources.getJsonPath("enemigos"));

    }
    @Test
    public void pruebaLectorFormatoEnemigosInvalido() {
       assertThrows(Exception.class, ()->{Lector lector = new LectorEnemigo(Resources.getJsonPath("test/formato/enemigosInvalidos"));
           int cantidad = 0;
           while(lector.haySiguiente()){

               Object element = lector.siguienteElemento().obtener();

               cantidad+=1;
           }});


    }
    @Test
    public void pruebaLectorFormatoMapaInvalido() {
        assertThrows(CeldaNoExistia.class, () -> {
            Lector lector = new LectorMapa(Resources.getJsonPath("test/formato/mapaParcelaInvalida"),15,15);
            int cantidad = 0;
            while (lector.haySiguiente()) {

                Object element = lector.siguienteElemento().obtener();

                cantidad += 1;
            }
        });


    }

    @Test
    public void pruebaMapaTamanioInvalidoColumna (){
        assertThrows(TamanioInvalido.class, () -> {
            Lector lector = new LectorMapa(Resources.getJsonPath("test/formato/mapaTamanioInvalidoColumna"),15,15);
            int cantidad = 0;
            while (lector.haySiguiente()) {

                Object element = lector.siguienteElemento().obtener();

                cantidad += 1;
            }
        });
    }
    @Test
    public void pruebaMapaTamanioInvalidoFila (){
        assertThrows(TamanioInvalido.class, () -> {
            Lector lector = new LectorMapa(Resources.getJsonPath("test/formato/mapaTamanioInvalidoFila"),15,15);
            int cantidad = 0;
            while (lector.haySiguiente()) {

                Object element = lector.siguienteElemento().obtener();

                cantidad += 1;
            }
        });
    }

    @Test
    public void pruebaDaCaminableEnLugaresCorrectos () throws Exception{
        Lector lector = new LectorMapa(Resources.getJsonPath("test/mapa_corto"),4,3);
        ConvertidorParcela element;

        int[][] camino = new int[5][2];
        int indice = 0;
        // camino
        camino[0] = new int[]{2,1};
        camino[1] = new int[]{2,2};
        camino[2] = new int[]{2,3};
        camino[3] = new int[]{3,3};
        camino[4] = new int[]{4,3};

        while (lector.haySiguiente()) {

             element= (ConvertidorParcela) lector.siguienteElemento();

            if ( element.esCaminable() ){
                assertEquals(camino[indice][1],element.fila());
                assertEquals(camino[indice][0],element.columna());
                indice += 1;
            }
        }

    }

}
