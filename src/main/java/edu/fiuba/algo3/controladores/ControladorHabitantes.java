package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.vistas.ViewHabitantes;
import edu.fiuba.algo3.vistas.popups.BasePopup;

public class ControladorHabitantes {

    public void mostrarHabitantes(Ventana ventana, Coordenada coordenada) {
        CeldaDescriptor celda= DatosModelo.obtenerTerrenoEn(coordenada.x(),coordenada.y());

        new BasePopup(new ViewHabitantes(ventana, celda)).show(ventana);
    }
}
