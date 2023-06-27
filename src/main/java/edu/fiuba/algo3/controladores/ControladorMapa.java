package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.vistas.ViewCelda;
//import edu.fiuba.algo3.vistas.Vista;


public class ControladorMapa extends Controlador {

    public interface TileResources{
        ViewCelda tileAt(int x, int y);
    }

}