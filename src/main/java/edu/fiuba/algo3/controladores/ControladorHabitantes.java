package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.vistas.ViewHabitantes;

public class ControladorHabitantes {

    public void mostrarHabitantes(Ventana ventana, Coordenada coordenada) {
        CeldaDescriptor celda= DatosModelo.obtenerTerrenoEn(coordenada.x(),coordenada.y());
        ventana.addPopup(new ViewHabitantes(ventana, celda));
    }
}
