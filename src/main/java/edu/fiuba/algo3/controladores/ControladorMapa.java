package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.vistas.celda.CeldaView;
//import edu.fiuba.algo3.vistas.Vista;


public class ControladorMapa extends Controlador {

    public interface TileResources{
        CeldaView tileAt(int x, int y);
    }

}