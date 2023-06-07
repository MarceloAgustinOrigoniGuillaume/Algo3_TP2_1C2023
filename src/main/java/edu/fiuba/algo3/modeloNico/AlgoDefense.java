package edu.fiuba.algo3.modeloNico;

import edu.fiuba.algo3.modelo.moduloMapa.Mapa;
import edu.fiuba.algo3.modeloNico.Estados.EstadoInicial;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJuego;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJugando;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AlgoDefense {
    private EstadoJuego estadoDeJuego;
    private Mapa mapa;

    public AlgoDefense() throws IOException, ParseException {
        this.estadoDeJuego = new EstadoInicial(this);
        estadoDeJuego.ejecutarEstado();
    }

    public void iniciarJuego() {
        this.estadoDeJuego = new EstadoJugando(this);
        estadoDeJuego.ejecutarEstado();
    }



}
