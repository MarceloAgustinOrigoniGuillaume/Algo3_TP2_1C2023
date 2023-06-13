package edu.fiuba.algo3.entrega2;

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

    @Test
    public void pruebaDaCaminableEnLugaresCorrectos () throws Exception{
        Lector lector = new LectorMapa("src/main/resorces/test/mapa_corto.json",4,3);
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
