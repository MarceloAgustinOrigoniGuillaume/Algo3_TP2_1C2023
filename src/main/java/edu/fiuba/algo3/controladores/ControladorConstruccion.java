package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Defensas.Defensa;

public class ControladorConstruccion {

    public void seleccionarConstruccion(String tipoDeEstructura, Ventana ventana) {

        Defensa defensa;
        defensa = DatosModelo.instanciador(tipoDeEstructura);

        ventana.removePopUp();
        ventana.iniciarConstruccionDefensa(defensa);
        //Aca se deberia invocar a la construccion seleccionada
    }

    public boolean posicionarConstruccion(Defensa defensa, Coordenada coordenada){

       return DatosModelo.colocadorDeDefensas(defensa, coordenada);

    }
}
