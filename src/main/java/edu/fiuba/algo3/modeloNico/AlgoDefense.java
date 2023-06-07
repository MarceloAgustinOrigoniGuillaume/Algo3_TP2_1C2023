package edu.fiuba.algo3.modeloNico;

import edu.fiuba.algo3.modeloNico.Estados.EstadoInicial;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJuego;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJugando;

public class AlgoDefense {
    private EstadoJuego estadoDeJuego;
    private Mapa mapa;

    public AlgoDefense() {
        this.estadoDeJuego = new EstadoInicial(this);
        estadoDeJuego.ejecutarEstado();
    }

    public void iniciarJuego() {
        this.estadoDeJuego = new EstadoJugando(this);
        estadoDeJuego.ejecutarEstado();
    }



}
