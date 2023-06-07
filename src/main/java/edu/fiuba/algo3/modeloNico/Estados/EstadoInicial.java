package edu.fiuba.algo3.modeloNico.Estados;

import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloLector.LectorMapa;
import edu.fiuba.algo3.modeloNico.AlgoDefense;
import edu.fiuba.algo3.modeloNico.Estados.EstadoJuego;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class EstadoInicial implements EstadoJuego {
    private AlgoDefense juego;
    private Lector lector = new LectorMapa("resourses\\mapa.json");
    public EstadoInicial(AlgoDefense juego) throws IOException, ParseException {
        this.juego = juego;
    }

    @Override
    public void ejecutarEstado() {
        this.lector.inicializarMapa();
    }
}
